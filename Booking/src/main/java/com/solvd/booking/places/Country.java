package com.solvd.booking.places;

import java.util.ArrayList;
import java.util.List;

public class Country {

    private String name;
    private List<City> cities;

    public Country() {
    }

    public Country(String name) {
        this.name = name;
        this.cities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public boolean addCity(City city){
        return this.cities.add(city);
    }

    public boolean removeCity(City city){
        return this.cities.remove(city);
    }
}
