package com.solvd.booking.travelcompany;

public class CompanyPlan {

    private int id;
    private int idPlan;
    private int idTravelCompany;

    public CompanyPlan() {
    }

    public CompanyPlan(int id, int idPlan, int idTravelCompany) {
        this.id = id;
        this.idPlan = idPlan;
        this.idTravelCompany = idTravelCompany;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(int idPlan) {
        this.idPlan = idPlan;
    }

    public int getIdTravelCompany() {
        return idTravelCompany;
    }

    public void setIdTravelCompany(int idTravelCompany) {
        this.idTravelCompany = idTravelCompany;
    }
}
