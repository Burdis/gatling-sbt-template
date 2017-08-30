package steps

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class PerfSteps extends Simulation{

  val googleURL = "http://www.google.co.uk/"
  val bbcURL = "http://www.bbc.co.uk/news"

  val navToGoogle = exec(
    http("Go to google")
      .get(googleURL)
      .check(status.is(200))
      .check(currentLocation.is("http://www.google.co.uk/"))
  )

  val navToBBC = exec(
    http("Go to BBC")
      .get(bbcURL)
      .check(status.is(200))
      .check(currentLocation.is("http://www.bbc.co.uk/news"))
  )

  val testScenario = scenario("Scenario1").exec(navToGoogle).exec(navToBBC)

  setUp(testScenario.inject(
      rampUsersPerSec(1) to 10 during(10 seconds),
      constantUsersPerSec(10) during(15 seconds) randomized,
      rampUsersPerSec(10) to 1 during(10 seconds)
    )
  ).protocols()

}
