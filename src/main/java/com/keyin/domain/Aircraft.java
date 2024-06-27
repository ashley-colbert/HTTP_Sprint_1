package com.keyin.domain;

import java.util.ArrayList;
import java.util.Objects;

public class Aircraft {
    private String id;
    private String type;
    private String airlineName;
    private int numberOfPassengers;
    private ArrayList<Airports> airportsTakeOff;
    private ArrayList<Airports> airportsLand;

    public Aircraft() {

    }

    public Aircraft(String id, String type, String airlineName, int numberOfPassengers, ArrayList<Airports> airports) {
        this.id = id;
        this.type = type;
        this.airlineName = airlineName;
        this.numberOfPassengers = numberOfPassengers;
        this.airportsTakeOff = airportsTakeOff;
        this.airportsLand = airportsLand;
    }

    public Aircraft(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public ArrayList<Airports> getAirportsLand() {
        return airportsLand;
    }

    public void setAirportsLand(ArrayList<Airports> airportsLand) {
        this.airportsLand = airportsLand;
    }

    public ArrayList<Airports> getAirportsTakeOff() {
        return airportsTakeOff;
    }

    public void setAirportsTakeOff(ArrayList<Airports> airportsTakeOff) {
        this.airportsTakeOff = airportsTakeOff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return Objects.equals(type, aircraft.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "Aircraft ID='" + id + '\'' +
                ", Type:'" + type + '\'' +
                ", Airline Name:'" + airlineName + '\'' +
                ", Number of Passengers:'" + numberOfPassengers + '\'';
    }

}
