package steps

import io.gatling.core.Predef._
import io.gatling.core.controller.inject.InjectionStep
import scala.concurrent.duration._

trait InjectionSteps {

  def rampUsers(peakUsers: Int,
                rampUpDuration: Int,
                constantDuration: Int,
                rampDownDuration: Int): Iterable[InjectionStep] = {
    Iterable(rampUsersPerSec(1) to peakUsers during (rampUpDuration seconds),
      constantUsersPerSec(peakUsers) during (constantDuration seconds),
      rampUsersPerSec(peakUsers) to 1 during (rampDownDuration seconds))
  }

  def constantUsers(numberOfUsers: Int,
                    duration: Int): Iterable[InjectionStep] = {
    Iterable(constantUsersPerSec(numberOfUsers) during (duration seconds))
  }

  def spikeUsers(peakUsers: Int,
                 rampUpDuration: Int,
                 constantDuration: Int,
                 rampDownDuration: Int,
                 constantUsers: Int,
                 initialRampUpDuration: Int
                ): Iterable[InjectionStep] = {
    Iterable(rampUsersPerSec(1) to constantUsers during (initialRampUpDuration seconds),
      constantUsersPerSec(constantUsers) during (constantDuration seconds),
      rampUsersPerSec(constantUsers) to peakUsers during (rampUpDuration seconds),
      rampUsersPerSec(peakUsers) to constantUsers during (rampDownDuration seconds),
      constantUsersPerSec(constantUsers) during (constantDuration seconds),
      rampUsersPerSec(constantUsers) to peakUsers during (rampUpDuration seconds),
      rampUsersPerSec(peakUsers) to constantUsers during (rampDownDuration seconds),
      constantUsersPerSec(constantUsers) during (constantDuration seconds),
      rampUsersPerSec(constantUsers) to peakUsers during (rampUpDuration seconds),
      rampUsersPerSec(peakUsers) to constantUsers during (rampDownDuration seconds),
      constantUsersPerSec(constantUsers) during (constantDuration seconds),
      rampUsersPerSec(constantUsers) to peakUsers during (rampUpDuration seconds),
      rampUsersPerSec(peakUsers) to 1 during (rampDownDuration seconds)
    )
  }
}
