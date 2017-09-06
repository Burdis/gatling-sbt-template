package steps

import io.gatling.core.Predef._
import io.gatling.http.Predef._

trait PerfSteps extends Simulation {

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
}
