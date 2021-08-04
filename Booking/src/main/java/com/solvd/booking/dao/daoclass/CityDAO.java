package com.solvd.booking.dao.daoclass;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.idao.ICityDAO;
import com.solvd.booking.places.*;
import com.solvd.booking.travelcompany.TravelCompany;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO extends AbstractDAO implements ICityDAO {

    private static final String GET_CITY_BY_ID = "SELECT * FROM City WHERE idCity=?";
    private static final String GET_CITY_BY_COUNTRY_ID = "SELECT * FROM City WHERE Country_idCountry=?";
    private static final String GET_CITY_BY_TRAVEL_COMPANY_ID = "SELECT * FROM Travel_Company t " +
                                                                    "LEFT JOIN City c on c.idCity = t.City_idCity " +
                                                                        "WHERE idTravelCompany=?";
    private static final Logger log = LogManager.getLogger(CityDAO.class);

    public CityDAO() throws InterruptedException {}


    @Override
    public City getItemById(int id) throws InterruptedException {
        try(PreparedStatement ps = connection.prepareStatement(GET_CITY_BY_ID)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new City(rs.getInt("idCity"), rs.getString("city_name"),
                        rs.getInt("postal_code"));
            }
        }
        catch(SQLException e){
            log.error(e.getMessage());
        }
        finally {
            ConnectionPool.getInstance("jdbc:mysql://localhost:3306", "root", "devintern").
                    releaseConnection(connection);
        }
        return null;
    }

    @Override
    public City getCityByTravelCompanyId(int travelCompanyId) {
        try(PreparedStatement ps = connection.prepareStatement(GET_CITY_BY_TRAVEL_COMPANY_ID)){
            ps.setInt(1, travelCompanyId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new City(rs.getInt("idCity"), rs.getString("city_name"),
                        rs.getInt("postal_code"));
            }
        }
        catch(SQLException e){
            log.error(e.getMessage());
        }
        finally {
            ConnectionPool.getInstance("jdbc:mysql://localhost:3306", "root", "devintern").
                    releaseConnection(connection);
        }
        return null;
    }


    @Override
    public List<City> getCitiesByCountryId(int countryId) {
        try(PreparedStatement ps = connection.prepareStatement(GET_CITY_BY_COUNTRY_ID)){
            List<City> cities = new ArrayList<>();
            ps.setInt(1, countryId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cities.add(new City(rs.getInt("idCity"), rs.getString("city_name"),
                        rs.getInt("postal_code")));
            }
            return cities;
        }
        catch(SQLException e){
            log.error(e.getMessage());
        }
        finally {
            ConnectionPool.getInstance("jdbc:mysql://localhost:3306", "root", "devintern").
                    releaseConnection(connection);
        }
        return null;
    }
}
