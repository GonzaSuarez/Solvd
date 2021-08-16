package com.solvd.booking.places;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name= "city")
public class City {

    @XmlAttribute(name= "id")
    private int id;
    @XmlElement(name= "city_name")
    private String name;
    @XmlElement(name= "postal_code")
    private String postalCode;
    @XmlElement(name= "countryid")
    private int countryId;

    public City() {
    }

    public City(int id, String name, String postalCode) {
        this.id = id;
        this.name = name;
        this.postalCode = postalCode;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
