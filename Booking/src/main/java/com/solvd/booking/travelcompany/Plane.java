package com.solvd.booking.travelcompany;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="plane")
@JsonRootName("plane")
public class Plane {

    @XmlAttribute(name="id")
    private int id;
    @XmlElement(name= "capacity")
    private int capacity;
    @XmlElement(name= "travelcompanyid")
    private int travelCompanyId;
    @XmlElement(name= "travelcompanyid")
    private int travelCompanyCityId;

    public Plane() {
    }

    public Plane(int id, int travelCompanyId, int travelCompanyCityId) {
        this.travelCompanyCityId = travelCompanyCityId;
        this.travelCompanyId = travelCompanyId;
        this.id = id;
    }

    public int getTravelCompanyId() {
        return travelCompanyId;
    }

    public void setTravelCompanyId(int travelCompanyId) {
        this.travelCompanyId = travelCompanyId;
    }

    public int getTravelCompanyCityId() {
        return travelCompanyCityId;
    }

    public void setTravelCompanyCityId(int travelCompanyCityId) {
        this.travelCompanyCityId = travelCompanyCityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
