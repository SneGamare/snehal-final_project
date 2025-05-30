[INFO] About to generate Cucumber report.
May 30, 2025 12:39:18 PM net.masterthought.cucumber.ReportBuilder generateErrorPage
INFO: Unexpected error
net.masterthought.cucumber.ValidationException: None report file was added!
        at net.masterthought.cucumber.ReportParser.parseJsonFiles(ReportParser.java:61)
        at net.masterthought.cucumber.ReportBuilder.generateReports(ReportBuilder.java:97)
        at net.masterthought.cucumber.CucumberReportGeneratorMojo.execute(CucumberReportGeneratorMojo.java:236)
        at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo(DefaultBuildPluginManager.java:137)
        at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:210)
        at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:156)
        at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:148)
        at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:117)
        at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:81)
        at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build(SingleThreadedBuilder.java:56)
        at org.apache.maven.lifecycle.internal.LifecycleStarter.execute(LifecycleStarter.java:128)
        at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:305)
        at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:192)
        at org.apache.maven.DefaultMaven.execute(DefaultMaven.java:105)
        at org.apache.maven.cli.MavenCli.execute(MavenCli.java:957)
        at org.apache.maven.cli.MavenCli.doMain(MavenCli.java:289)
        at org.apache.maven.cli.MavenCli.main(MavenCli.java:193)
        at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
        at java.base/java.lang.reflect.Method.invoke(Method.java:580)
        at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced(Launcher.java:282)
        at org.codehaus.plexus.classworlds.launcher.Launcher.launch(Launcher.java:225)
        at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode(Launcher.java:406)
        at org.codehaus.plexus.classworlds.launcher.Launcher.main(Launcher.java:347)

[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  8.570 s
[INFO] Finished at: 2025-05-30T12:39:18+05:30
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal net.masterthought:maven-cucumber-reporting:5.7.0:generate (generate-cucumber-html-report) on project orchestrator-service: Error Found:: BUILD FAILED - Check Report For Details -> [Help 1]
[ERROR] 
