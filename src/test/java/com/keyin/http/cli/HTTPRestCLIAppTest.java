package com.keyin.http.cli;

import com.keyin.domain.Airports;
import com.keyin.http.cli.HTTPRestCLIApp;
import com.keyin.http.client.RESTClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class HTTPRestCLIAppTest {
    @Mock
    private RESTClient mockRESTClient;

    private HTTPRestCLIApp httpRestCLIAppUnderTest;

    @Test
    public void testGenerateAirportsReport() {
        HTTPRestCLIApp httpRestCLIApplicationUnderTest = new HTTPRestCLIApp();

        Airports stJohnsAirport = new Airports();
        stJohnsAirport.setCode("YYT");
        stJohnsAirport.setName("St. John's Airport");
        stJohnsAirport.setId("1");

        List<Airports> airportList = new ArrayList<Airports>();
        airportList.add(stJohnsAirport);

        Mockito.when(mockRESTClient.getAllAirports()).thenReturn(airportList);

        httpRestCLIApplicationUnderTest.setRestClient(mockRESTClient);

        Assertions.assertTrue(httpRestCLIApplicationUnderTest.generateAirportReport().contains("YYT"));

    }
}
