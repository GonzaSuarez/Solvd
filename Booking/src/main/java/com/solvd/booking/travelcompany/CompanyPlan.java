package com.solvd.booking.travelcompany;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="companyplan")
@JsonRootName("companyplan")
public class CompanyPlan {

    @XmlAttribute(name="id")
    private int id;
    @XmlElement(name= "idplan")
    private int idPlan;
    @XmlElement(name= "idtravelcompany")
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
