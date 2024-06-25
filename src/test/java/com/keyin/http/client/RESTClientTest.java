package com.keyin.http.client;

import com.keyin.domain.Airports;
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
}
