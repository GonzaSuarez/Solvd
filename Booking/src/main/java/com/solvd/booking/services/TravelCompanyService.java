package com.solvd.booking.services;

import com.solvd.booking.dao.daoclass.*;
import com.solvd.booking.dao.idao.*;
import com.solvd.booking.hotel.Hotel;
import com.solvd.booking.places.City;
import com.solvd.booking.travelcompany.TravelCompany;
import com.solvd.booking.travelcompany.UserAccount;

import java.util.List;

public class TravelCompanyService {

    private ICityDAO cityDAO = new CityDAO();
    private ITravelCompanyDAO travelCompanyDAO = new TravelCompanyDAO();
    private IPlaneDAO planeDAO = new PlaneDAO();
    private IUserAccountDAO userAccountDAO = new UserAccountDAO();
    private IHotelDAO hotelDAO = new HotelDAO();

    public TravelCompanyService() throws InterruptedException {
    }

    public ICityDAO getCityDAO() {
        return cityDAO;
    }

    public void setCityDAO(ICityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    public ITravelCompanyDAO getTravelCompanyDAO() {
        return travelCompanyDAO;
    }

    public void setTravelCompanyDAO(ITravelCompanyDAO travelCompanyDAO) {
        this.travelCompanyDAO = travelCompanyDAO;
    }

    public TravelCompany getTravelCompany(int travelCompanyId) throws InterruptedException {
        TravelCompany travelCompany = travelCompanyDAO.getItemById(travelCompanyId);
        travelCompany.setCity(cityDAO.getCityByTravelCompanyId(travelCompanyId));
        travelCompany.setPlanes(planeDAO.getPlanesByTravelCompanyId(travelCompanyId));
        travelCompany.setUserAccounts(userAccountDAO.getUserAccountsByTravelCompanyId(travelCompanyId));
        travelCompany.setHotels(hotelDAO.getHotelsByTravelCompanyId(travelCompanyId));
        return travelCompany;
    }
}
