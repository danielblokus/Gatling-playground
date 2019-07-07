package io.github.danielblokus

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class TwoUsersSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://computer-database.gatling.io")

  val theScenarioBuilder = scenario("Scenario2")
    .exec(
      http("myRequest1").get("/")
    )

  setUp(
    theScenarioBuilder.inject(atOnceUsers(2))
  ).protocols(httpProtocol)
}