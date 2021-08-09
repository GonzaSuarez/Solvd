package com.solvd.booking.travelcompany;

public class Plane {

    private int id;
    private int capacity;
    private int travelCompanyId;
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
