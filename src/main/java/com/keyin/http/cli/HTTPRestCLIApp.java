package com.keyin.http.cli;

import com.keyin.domain.Aircraft;
import com.keyin.domain.Airports;
import com.keyin.domain.Cities;
import com.keyin.domain.Passengers;
import com.keyin.http.client.RESTClient;

import java.util.List;

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
                report.append(",");
            }
        }

        System.out.println(report.toString());

        return report.toString();
    }

    public String generateAircraftReport() {
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

            if (aircrafts.indexOf(aircraft) != (aircrafts.size() - 1)) {
                report.append(",");
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

    public String generatePassengerReport() {
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

            if (passengers.indexOf(passenger) != (passengers.size() - 1)) {
                report.append(",");
            }
        }

        System.out.println(report.toString());

        return report.toString();
    }

    public String generateCitiesReport() {
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

            if (cities.indexOf(city) != (cities.size() - 1)) {
                report.append(",");
            }
        }

        System.out.println(report.toString());

        return report.toString();
    }

    public void setRestClient(RESTClient restClient) {
        this.restClient = restClient;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide the server URL as a command-line argument.");
            return;
        }

        for (String arg : args) {
            System.out.println(arg);
        }

        HTTPRestCLIApp cliApp = new HTTPRestCLIApp();

        String serverURL = args[0];

        if (serverURL != null && !serverURL.isEmpty()) {

            RESTClient restClient = new RESTClient();
            restClient.setServerURL(serverURL);

            cliApp.setRestClient(restClient);

            cliApp.generateAirportReport();
            cliApp.generateAircraftReport();
            cliApp.generatePassengerReport();
            cliApp.generateCitiesReport();

        }

    }
}
