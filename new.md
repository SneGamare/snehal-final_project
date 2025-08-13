mvn archetype:generate \
  -DarchetypeGroupId=org.apache.nifi \
  -DarchetypeArtifactId=nifi-processor-bundle-archetype \
  -DarchetypeVersion=1.27.0 \
  -DgroupId=com.kotak.nifi \
  -DartifactId=transform-engine-nifi \
  -Dversion=1.0-SNAPSHOT \
  -Dpackage=com.kotak.nifi




<dependencies>
  <!-- NiFi SPI -->
  <dependency>
    <groupId>org.apache.nifi</groupId>
    <artifactId>nifi-api</artifactId>
    <version>${nifi.version}</version>
    <scope>provided</scope>
  </dependency>
  <dependency>
    <groupId>org.apache.nifi</groupId>
    <artifactId>nifi-processor-utils</artifactId>
    <version>${nifi.version}</version>
    <scope>provided</scope>
  </dependency>

  <!-- JSON -->
  <dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.1</version>
  </dependency>

  <!-- Avro -->
  <dependency>
    <groupId>org.apache.avro</groupId>
    <artifactId>avro</artifactId>
    <version>1.11.3</version>
  </dependency>
</dependencies>

