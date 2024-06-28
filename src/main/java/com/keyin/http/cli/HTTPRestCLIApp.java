package com.keyin.http.cli;

import com.keyin.domain.Aircraft;
import com.keyin.domain.Airports;
import com.keyin.domain.Cities;
import com.keyin.domain.Passengers;
import com.keyin.http.client.RESTClient;

import java.util.List;
import java.util.Scanner;

public class HTTPRestCLIApp {
    private RESTClient restClient;

    public String generateAirportReport() {
        List<Airports> airports = getRestClient().getAllAirports();

        StringBuffer report = new StringBuffer();

        for (Airports airport : airports) {
            report.append(airport.getId());
            report.append(" - ");
            report.append(airport.getName());
            report.append(" - ");
            report.append(airport.getCode());

            if (airports.indexOf(airport) != (airports.size() - 1)) {
                report.append("\n");
            }
        }

        System.out.println(report.toString());

        return report.toString();
    }

    public String generateAircraftAirportsReport() {
        List<Aircraft> aircrafts = getRestClient().getAllAircraft();

        StringBuffer report = new StringBuffer();

        for (Aircraft aircraft : aircrafts) {
            report.append(aircraft.getId());
            report.append(" - ");
            report.append(aircraft.getType());
            report.append(" - ");
            report.append(aircraft.getAirlineName());
            report.append(" - ");
            report.append(aircraft.getNumberOfPassengers());
            report.append("\n");
            for (Airports airport: aircraft.getAirportsTakeOff()) {
                report.append("   Take-off: ");
                report.append(airport.toString());
                report.append("\n");
            }
            for (Airports airport: aircraft.getAirportsLand()) {
                report.append("   Land: ");
                report.append(airport.toString());
                report.append("\n");
            }
            if (aircrafts.indexOf(aircraft) != (aircrafts.size() - 1)) {
                report.append("\n");
            }
        }

        System.out.println(report.toString());

        return report.toString();
    }

    public RESTClient getRestClient() {
        if (restClient == null) {
            restClient = new RESTClient();
        }

        return restClient;
    }

    public String generatePassengerAirportReport() {
        List<Passengers> passengers = getRestClient().getAllPassengers();

        StringBuffer report = new StringBuffer();

        for (Passengers passenger : passengers) {
            report.append(passenger.getId());
            report.append(" - ");
            report.append(passenger.getFirstName());
            report.append(" - ");
            report.append(passenger.getLastName());
            report.append(" - ");
            report.append(passenger.getPhoneNumber());
            report.append("\n");

            for (Airports airport: passenger.getAirports()) {
                report.append(" ");
                report.append(airport.toString());
                report.append("\n");
            }

            if (passengers.indexOf(passenger) != (passengers.size() - 1)) {
                report.append("\n");
            }
        }

        System.out.println(report.toString());

        return report.toString();
    }

    public String generatePassengerAircraftReport() {
        List<Passengers> passengers = getRestClient().getAllPassengers();

        StringBuffer report = new StringBuffer();

        for (Passengers passenger : passengers) {
            report.append(passenger.getId());
            report.append(" - ");
            report.append(passenger.getFirstName());
            report.append(" - ");
            report.append(passenger.getLastName());
            report.append(" - ");
            report.append(passenger.getPhoneNumber());
            report.append("\n");


            for (Aircraft aircraft: passenger.getAircraft()) {
                report.append(" ");
                report.append(aircraft.toString());
                report.append("\n");
            }

            if (passengers.indexOf(passenger) != (passengers.size() - 1)) {
                report.append("\n");
            }
        }

        System.out.println(report.toString());

        return report.toString();
    }

    public String generateCitiesAirportsReport() {
        List<Cities> cities = getRestClient().getAllCities();

        StringBuffer report = new StringBuffer();

        for (Cities city : cities) {
            report.append(city.getId());
            report.append(" - ");
            report.append(city.getName());
            report.append(" - ");
            report.append(city.getState());
            report.append(" - ");
            report.append(city.getPopulation());
            report.append("\n");

            for (Airports airport: city.getAirports()) {
                report.append(" ");
                report.append(airport.toString());
                report.append("\n");
            }

            if (cities.indexOf(city) != (cities.size() - 1)) {
                report.append("\n");
            }
        }

        System.out.println(report.toString());

        return report.toString();
    }

    public void setRestClient(RESTClient restClient) {
        this.restClient = restClient;
    }

    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }

        HTTPRestCLIApp cliApp = new HTTPRestCLIApp();

        String serverURL = args[0];

        if (serverURL != null && !serverURL.isEmpty()) {

            RESTClient restClient = new RESTClient();
            restClient.setServerURL(serverURL);

            cliApp.setRestClient(restClient);

//            //Change url to 'http://localhost:8080/aircraft'
//            System.out.println("Aircraft/airport report:");
//            cliApp.generateAircraftAirportsReport();

//            //Change url to 'http://localhost:8080/passenger'
//            System.out.println("Passenger/aircraft report:");
//            cliApp.generatePassengerAircraftReport();

//            System.out.println("Passenger/airport report:");
//            cliApp.generatePassengerAirportReport();
//
            //Change url to 'http://localhost:8080/cities'
            System.out.println("Cities/airport report:");
            cliApp.generateCitiesAirportsReport();
        }

    }
}
