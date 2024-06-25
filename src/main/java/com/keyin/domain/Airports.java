package com.keyin.domain;

import java.util.Objects;

public class Airports {
    private String id;
    private String name;
    private String code;

    public Airports() {
    }

    public Airports(String code) {
        this.code = code;
    }

    public Airports(String id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airports airports = (Airports) o;
        return Objects.equals(code, airports.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }


}
