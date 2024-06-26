package com.keyin.http.cli;

import com.keyin.domain.Aircraft;
import com.keyin.domain.Airports;
import com.keyin.domain.Cities;
import com.keyin.domain.Passengers;
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
        HTTPRestCLIApp httpRestCLIAppUnderTest = new HTTPRestCLIApp();

        Airports stJohnsAirport = new Airports();
        stJohnsAirport.setCode("YYT");
        stJohnsAirport.setName("St. John's Airport");
        stJohnsAirport.setId("1");

        List<Airports> airportList = new ArrayList<Airports>();
        airportList.add(stJohnsAirport);

        Mockito.when(mockRESTClient.getAllAirports()).thenReturn(airportList);

        httpRestCLIAppUnderTest.setRestClient(mockRESTClient);

        Assertions.assertTrue(httpRestCLIAppUnderTest.generateAirportReport().contains("YYT"));

    }

    @Test
    public void testGenerateAircraftReport() {
        HTTPRestCLIApp httpRestCLIAppUnderTest = new HTTPRestCLIApp();

        Aircraft aircraft1 = new Aircraft();
        aircraft1.setType("Boeing");
        aircraft1.setAirlineName("West Jet");
        aircraft1.setNumberOfPassengers(150);
        aircraft1.setId("WJ123");

        List<Aircraft> aircraftList = new ArrayList<Aircraft>();
        aircraftList.add(aircraft1);

        Mockito.when(mockRESTClient.getAllAircraft()).thenReturn(aircraftList);

        httpRestCLIAppUnderTest.setRestClient(mockRESTClient);

        Assertions.assertTrue(httpRestCLIAppUnderTest.generateAircraftReport().contains("Boeing"));

    }

    @Test
    public void testGeneratePassengerReport() {
        HTTPRestCLIApp httpRestCLIAppUnderTest = new HTTPRestCLIApp();

        Passengers passenger1 = new Passengers();
        passenger1.setFirstName("Julie");
        passenger1.setLastName("Smith");
        passenger1.setPhoneNumber("709-555-5555");
        passenger1.setId("js5555");

        List<Passengers> passengersList = new ArrayList<Passengers>();
        passengersList.add(passenger1);

        Mockito.when(mockRESTClient.getAllPassengers()).thenReturn(passengersList);

        httpRestCLIAppUnderTest.setRestClient(mockRESTClient);

        Assertions.assertTrue(httpRestCLIAppUnderTest.generatePassengerReport().contains("Smith"));

    }

    @Test
    public void testGenerateCityReport() {
        HTTPRestCLIApp httpRestCLIAppUnderTest = new HTTPRestCLIApp();

        Cities city1 = new Cities();
        city1.setName("St. John's");
        city1.setState("NL");
        city1.setPopulation (200000);
        city1.setId("1");

        List<Cities> cityList = new ArrayList<Cities>();
        cityList.add(city1);

        Mockito.when(mockRESTClient.getAllCities()).thenReturn(cityList);

        httpRestCLIAppUnderTest.setRestClient(mockRESTClient);

        Assertions.assertTrue(httpRestCLIAppUnderTest.generateCitiesReport().contains("NL"));

    }
}
