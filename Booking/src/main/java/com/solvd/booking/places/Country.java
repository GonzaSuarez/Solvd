package com.solvd.booking.places;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="country")
public class Country {

    @XmlAttribute(name="id")
    private int id;
    @XmlElement(name= "country_name")
    private String name;
    @XmlElement(name= "cities")
    private List<City> cities;

    public Country() {
    }

    public Country(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public boolean addCity(List<City> city){
        return this.cities.addAll(city);
    }

    public boolean removeCity(City city){
        return this.cities.remove(city);
    }
}
