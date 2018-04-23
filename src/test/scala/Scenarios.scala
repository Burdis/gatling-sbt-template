import steps.{InjectionSteps, PerfSteps}
import io.gatling.core.Predef._

class Scenarios extends Simulation with PerfSteps with InjectionSteps {

  val testScenario = scenario("Scenario1").feed(feeder)
    .exec(navToGoogle)
      setUp(testScenario.inject(rampUsers(
          peakUsers = 10,
          rampUpDuration = 200,
          constantDuration = 200,
          rampDownDuration = 200)
      )).protocols()
}