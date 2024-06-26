package com.keyin.http.client;

import com.keyin.domain.Aircraft;
import com.keyin.domain.Airports;
import com.keyin.domain.Cities;
import com.keyin.domain.Passengers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RESTClientTest {
    @Test
    public void testBuildAirportListFromResponse() throws Exception {
        String jsonResponse = "[\n{\n\"id\": 1,\n\"name\": \"St. John's\",\n\"code\": \"YYT\"\n},\n" +
                "{\n\"id\": 2,\n\"name\": \"Deer Lake\",\n\"code\": \"YDF\"\n}\n]";

        RESTClient restClientUnderTest = new RESTClient();

        List<Airports> airportList = restClientUnderTest.buildAirportListFromResponse(jsonResponse);

        Assertions.assertTrue(airportList.contains(new Airports("YYT")));
    }

    @Test
    public void testBuildAircraftListFromResponse() throws Exception {
        String jsonResponse = "[\n{\n\"id\": 123,\n\"type\": \"Boeing\",\n\"airlineName\": \"WestJet\",\n\"numberOfPassengers\": 150\n}\n]";

        RESTClient restClientUnderTest = new RESTClient();

        List<Aircraft> aircraftList = restClientUnderTest.buildAircraftListFromResponse(jsonResponse);

        Assertions.assertTrue(aircraftList.contains(new Aircraft("Boeing")));
    }

    @Test
    public void testBuildPassengerListFromResponse() throws Exception {
        String jsonResponse = "[\n{\n\"id\": \"js5555\",\n\"firstName\": \"Julia\",\n\"lastName\": \"Smith\",\n\"phoneNumber\": \"709-555-5555\"\n}\n]";

        RESTClient restClientUnderTest = new RESTClient();

        List<Passengers> passengerList = restClientUnderTest.buildPassengerListFromResponse(jsonResponse);

        Assertions.assertTrue(passengerList.contains(new Passengers("Smith")));
    }

    @Test
    public void testBuildCitiesListFromResponse() throws Exception {
        String jsonResponse = "[\n{\n\"id\": \"1\",\n\"name\": \"St. John's\",\n\"state\": \"NL\",\n\"populatio\": 200000\n}\n]";

        RESTClient restClientUnderTest = new RESTClient();

        List<Cities> cityList = restClientUnderTest.buildCitiesListFromResponse(jsonResponse);

        Assertions.assertTrue(cityList.contains(new Cities("NL")));
    }
}
