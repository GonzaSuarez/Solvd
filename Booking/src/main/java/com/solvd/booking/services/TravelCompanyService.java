package com.solvd.booking.services;

import com.solvd.booking.dao.*;
import com.solvd.booking.dao.mysqldao.jbdc.*;
import com.solvd.booking.travelcompany.TravelCompany;

import java.io.IOException;
import java.sql.SQLException;

public class TravelCompanyService {

    private ICityDAO cityDAO = new CityDAO();
    private ITravelCompanyDAO travelCompanyDAO = new TravelCompanyDAO();
    private IPlaneDAO planeDAO = new PlaneDAO();
    private IUserAccountDAO userAccountDAO = new UserAccountDAO();
    private IHotelDAO hotelDAO = new HotelDAO();

    public TravelCompanyService() throws InterruptedException, SQLException, ClassNotFoundException, IOException {
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

    public TravelCompany getTravelCompany(int travelCompanyId) throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        TravelCompany travelCompany = travelCompanyDAO.getItemById(travelCompanyId);
        travelCompany.setCity(cityDAO.getCityByTravelCompanyId(travelCompanyId));
        travelCompany.setPlanes(planeDAO.getPlanesByTravelCompanyId(travelCompanyId));
        travelCompany.setUserAccounts(userAccountDAO.getUserAccountsByTravelCompanyId(travelCompanyId));
        travelCompany.setHotels(hotelDAO.getHotelsByTravelCompanyId(travelCompanyId));
        return travelCompany;
    }
}
