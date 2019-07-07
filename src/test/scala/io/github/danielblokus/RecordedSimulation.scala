package io.github.danielblokus

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class RecordedSimulation extends Simulation {

      val httpProtocol = http
        .baseUrl("http://computer-database.gatling.io")
        .inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
        .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
        .acceptEncodingHeader("gzip, deflate")
        .acceptLanguageHeader("en-US,en;q=0.5")
        .upgradeInsecureRequestsHeader("1")
        .userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:67.0) Gecko/20100101 Firefox/67.0")

      val scn = scenario("RecordedSimulation")
        .exec(http("request_0")
          .get("/"))
        .pause(16)
        .exec(http("request_1")
          .get("/computers?f=amstrad"))
        .pause(5)
        .exec(http("request_2")
          .get("/computers/412"))
        .pause(4)
        .exec(http("request_3")
          .get("/"))
        .pause(5)
        .exec(http("request_4")
          .get("/computers?p=1")
          .resources(http("request_5")
            .get("/computers?p=2"),
                http("request_6")
                  .get("/computers?p=3"),
                http("request_7")
                  .get("/computers?p=4"),
                http("request_8")
                  .get("/computers?p=5"),
                http("request_9")
                  .get("/computers?p=6"),
                http("request_10")
                  .get("/computers?p=7"),
                http("request_11")
                  .get("/computers?p=8"),
                http("request_12")
                  .get("/computers?p=9"),
                http("request_13")
                  .get("/computers?p=10"),
                http("request_14")
                  .get("/computers?p=11"),
                http("request_15")
                  .get("/computers?p=12"),
                http("request_16")
                  .get("/computers?p=13"),
                http("request_17")
                  .get("/computers?p=14"),
                http("request_18")
                  .get("/computers?p=15")))

      setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}