name := "gatling-sbt-template"

version := "0.1"

scalaVersion := "2.11.0"

enablePlugins(GatlingPlugin)

libraryDependencies ++= Seq("io.gatling.highcharts"     % "gatling-charts-highcharts" % "2.2.2" % "test",
                            "io.gatling"                % "gatling-test-framework"    % "2.2.2" % "test")
