package steps

import io.gatling.core.Predef._
import io.gatling.core.controller.inject.InjectionStep
import scala.concurrent.duration._

trait InjectionSteps {

    def rampUsers(peakUsers: Int, rampUpDuration: Int, constantDuration: Int, rampDownDuration: Int): Iterable[InjectionStep] =
        Iterable(rampUsersPerSec(1) to peakUsers during (rampUpDuration seconds),
        constantUsersPerSec(peakUsers) during (constantDuration seconds),
        rampUsersPerSec(peakUsers) to 1 during (rampDownDuration seconds)
    )
}