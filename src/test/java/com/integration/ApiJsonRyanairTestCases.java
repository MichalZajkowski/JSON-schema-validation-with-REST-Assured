package com.integration;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.jayway.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

class ApiJsonRyanairTestCases {

    @Test
    void testGoogleFlightResponse_isCorrect() {
        get(prepareFlightsRequest()).then().
                statusCode(200).
                body(matchesJsonSchemaInClasspath("ryanair/flightsRyanairSchema.json"));
    }


    private String prepareFlightsRequest() {
        String baseUrl = "https://desktopapps.ryanair.com/v4/pl-pl/availability?ADT=1&CHD=0&DateOut=";
        String flightDate = LocalDate.now().plusMonths(1).toString();
        String queryString = "&Destination=STN&FlexDaysOut=2&INF=0&IncludeConnectingFlights=true&Origin=WRO&RoundTrip=false&TEEN=0&ToUs=AGREED&exists=false&promoCode=";

        return baseUrl + flightDate + queryString;
    }
}
