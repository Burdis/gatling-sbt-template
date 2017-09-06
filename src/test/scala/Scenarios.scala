import steps.{InjectionSteps, PerfSteps}
import io.gatling.core.Predef._

class Scenarios extends Simulation with PerfSteps with InjectionSteps {

    val testScenario = scenario("Scenario1")
        .exec(navToGoogle)
        .exec(navToBBC)

    setUp(testScenario.inject(rampUsers(
        peakUsers = 10,
        rampUpDuration = 10,
        constantDuration = 10,
        rampDownDuration = 10)
    )).protocols()

}