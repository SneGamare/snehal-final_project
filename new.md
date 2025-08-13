mkdir camel-transform && cd camel-transform
mkdir -p src/main/java/com/example/transform
mkdir -p src/main/resources/xslt
mkdir -p src/test/resources




<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.example</groupId>
  <artifactId>camel-transform</artifactId>
  <version>1.0.0</version>
  <name>camel-transform</name>

  <properties>
    <java.version>17</java.version>
    <spring-boot.version>3.3.2</spring-boot.version>
    <camel.springboot.version>4.6.0</camel.springboot.version>
  </properties>

  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>${spring-boot.version}</version>
  </parent>

  <dependencyManagement>
    <dependencies>
      <dependency>
        <groupId>org.apache.camel.springboot</groupId>
        <artifactId>camel-spring-boot-dependencies</artifactId>
        <version>${camel.springboot.version}</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>
    </dependencies>
  </dependencyManagement>

  <dependencies>
    <!-- Spring Boot base -->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter</artifactId>
    </dependency>

    <!-- Camel + Spring Boot -->
    <dependency>
      <groupId>org.apache.camel.springboot</groupId>
      <artifactId>camel-spring-boot-starter</artifactId>
    </dependency>

    <!-- HTTP REST via Camel platform-http -->
    <dependency>
      <groupId>org.apache.camel.springboot</groupId>
      <artifactId>camel-platform-http-starter</artifactId>
    </dependency>

    <!-- JSON marshalling (useful later) -->
    <dependency>
      <groupId>org.apache.camel.springboot</groupId>
      <artifactId>camel-jackson-starter</artifactId>
    </dependency>

    <!-- XSLT component -->
    <dependency>
      <groupId>org.apache.camel.springboot</groupId>
      <artifactId>camel-xslt-starter</artifactId>
    </dependency>

    <!-- Saxon HE so we can use transformerFactoryClass for XSLT 2.0/3.0 -->
    <dependency>
      <groupId>net.sf.saxon</groupId>
      <artifactId>Saxon-HE</artifactId>
      <version>12.4</version>
    </dependency>

    <!-- Test -->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-test</artifactId>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <configuration>
          <release>${java.version}</release>
        </configuration>
      </plugin>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <executions>
          <execution>
            <goals><goal>repackage</goal></goals>
          </execution>
        </executions>
      </plugin>
    </plugins>



/application.properties:

server.port=8080
camel.rest.component=platform-http

# dev logging
logging.level.org.apache.camel=INFO
logging.level.com.example.transform=DEBUG




package com.example.transform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransformApplication {
  public static void main(String[] args) {
    SpringApplication.run(TransformApplication.class, args);
  }
}




package com.example.transform;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class TransformRoutes extends RouteBuilder {

  @Override
  public void configure() {

    // Global error handler -> JSON error body
    onException(Exception.class)
        .handled(true)
        .log(LoggingLevel.ERROR, "${exception.class}: ${exception.message}")
        .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400))
        .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
        .setBody(simple("{\"error\":\"${exception.message}\"}"));

    // REST setup
    restConfiguration()
        .component("platform-http")
        .bindingMode(RestBindingMode.off) // we’ll handle raw body
        .contextPath("")
        .port(8080);

    // Health
    rest("/")
      .get("ping").produces("text/plain")
        .route()
          .setBody(constant("pong"))
        .endRest();

    // camt XML -> JSON using XSLT (Saxon)
    rest("/transform")
      .post("/camt-to-json")
        .consumes("application/xml")
        .produces("application/json")
        .route()
          .routeId("camt-to-json")
          .log(LoggingLevel.INFO, "Incoming camt payload")
          .to("xslt:classpath:xslt/camt53-to-json.xsl"
             + "?transformerFactoryClass=net.sf.saxon.TransformerFactoryImpl"
             + "&contentCache=false")
          .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
        .endRest();

    // simple passthrough for quick tests
    rest("/transform")
      .post("/passthrough")
        .consumes("*/*").produces("*/*")
        .route()
          .routeId("passthrough")
          .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200))
        .endRest();
  }
}



/resources/xslt/camt53-to-json.xsl (minimal starter):

<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <!-- We output JSON as text -->
  <xsl:output method="text" encoding="UTF-8"/>

  <xsl:template match="/">
    <xsl:variable name="stmt" select="//*[local-name()='BkToCstmrStmt']/*[local-name()='Stmt'][1]"/>
    <xsl:variable name="acct" select="$stmt/*[local-name()='Acct']"/>

    {
      "statementId": "<xsl:value-of select="$stmt/*[local-name()='Id']"/>",
      "account": {
        "iban": "<xsl:value-of select="$acct/*[local-name()='Id']/*[local-name()='IBAN']"/>",
        "currency": "<xsl:value-of select="$acct/*[local-name()='Ccy']"/>"
      },
      "balanceDate": "<xsl:value-of select="$stmt/*[local-name()='FrToDt']/*[local-name()='ToDt']"/>",
      "entries": [
        <xsl:for-each select="$stmt/*[local-name()='Ntry']">
          {"amount": "<xsl:value-of select="normalize-space(./*[local-name()='Amt'])"/>",
           "currency": "<xsl:value-of select="./*[local-name()='Amt']/@Ccy"/>",
           "creditDebit": "<xsl:value-of select="./*[local-name()='CdtDbtInd']"/>",
           "bookingDate": "<xsl:value-of select="./*[local-name()='BookgDt']/*[local-name()='Dt'] | ./*[local-name()='BookgDt']/*[local-name()='DtTm']"/>",
           "remittance": "<xsl:value-of select="./*[local-name()='AddtlNtryInf']"/>"}
          <xsl:if test="position() != last()">,</xsl:if>
        </xsl:for-each>
      ]
    }
  </xsl:template>
</xsl:stylesheet>




src/test/resources/sample-camt53.xml:



<?xml version="1.0" encoding="UTF-8"?>
<Document xmlns="urn:iso:std:iso:20022:tech:xsd:camt.053.001.08">
  <BkToCstmrStmt>
    <Stmt>
      <Id>STATEMENT-123</Id>
      <FrToDt>
        <FrDt>2025-08-01</FrDt>
        <ToDt>2025-08-12</ToDt>
      </FrToDt>
      <Acct>
        <Id><IBAN>IN0012345678900000000000001</IBAN></Id>
        <Ccy>INR</Ccy>
      </Acct>
      <Ntry>
        <Amt Ccy="INR">2500.00</Amt>
        <CdtDbtInd>CRDT</CdtDbtInd>
        <BookgDt><Dt>2025-08-11</Dt></BookgDt>
        <AddtlNtryInf>Salary</AddtlNtryInf>
      </Ntry>
      <Ntry>
        <Amt Ccy="INR">-450.00</Amt>
        <CdtDbtInd>DBIT</CdtDbtInd>
        <BookgDt><Dt>2025-08-12</Dt></BookgDt>
        <AddtlNtryInf>Electricity bill</AddtlNtryInf>
      </Ntry>
    </Stmt>
  </BkToCstmrStmt>
</Document>



curl -s -X POST \
  -H "Content-Type: application/xml" \
  --data-binary @src/test/resources/sample-camt53.xml \
  http://localhost:8080/transform/camt-to-json | jq .


  </build>
</project>
