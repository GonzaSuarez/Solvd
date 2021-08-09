package com.solvd.booking.dao.mysqldao.jbdc;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.ICityDAO;
import com.solvd.booking.places.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO extends AbstractDAO implements ICityDAO {

    private static final Logger log = LogManager.getLogger(CityDAO.class);
    private static final String GET_CITY_BY_ID = "SELECT * FROM City WHERE id = ?";
    private static final String GET_CITY_BY_COUNTRY_ID = "SELECT * FROM City WHERE Country_id = ?";
    private static final String GET_CITY_BY_TRAVEL_COMPANY_ID = "SELECT * FROM Travel_Company t " +
                                                                    "LEFT JOIN City c on c.id = t.City_idC " +
                                                                        "WHERE t.id = ?";
    private static final String INSERT_CITY = "INSERT INTO City (city_name, postal_code, Country_id) VALUES (?,?,?)";
    private static final String UPDATE_CITY_NAME = "UPDATE City SET city_name = ? WHERE id = ?";
    private static final String UPDATE_CITY_POSTAL_CODE = "UPDATE City SET postal_code = ? WHERE id = ?";
    private static final String DELETE_CITY = "DELETE FROM City WHERE id = ?";



    public CityDAO() throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        super();
    }


    @Override
    public City getItemById(int id) throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        try(PreparedStatement ps = connection.prepareStatement(GET_CITY_BY_ID); ResultSet rs = ps.executeQuery()){
            ps.setInt(1, id);
            if(rs.next()){
                return new City(rs.getInt("id"), rs.getString("city_name"),
                        rs.getString("postal_code"));
            }
        }
        catch(SQLException e){
            log.error(e.getMessage());
        }
        finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return null;
    }

    @Override
    public City getCityByTravelCompanyId(int travelCompanyId) throws SQLException, ClassNotFoundException, IOException {
        try(PreparedStatement ps = connection.prepareStatement(GET_CITY_BY_TRAVEL_COMPANY_ID); ResultSet rs = ps.executeQuery()){
            ps.setInt(1, travelCompanyId);
            if(rs.next()){
                return new City(rs.getInt("id"), rs.getString("city_name"),
                        rs.getString("postal_code"));
            }
        }
        catch(SQLException e){
            log.error(e.getMessage());
        }
        finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return null;
    }


    @Override
    public List<City> getCitiesByCountryId(int countryId) throws SQLException, ClassNotFoundException, IOException {
        try(PreparedStatement ps = connection.prepareStatement(GET_CITY_BY_COUNTRY_ID); ResultSet rs = ps.executeQuery()){
            List<City> cities = new ArrayList<>();
            ps.setInt(1, countryId);
            while(rs.next()){
                cities.add(new City(rs.getInt("id"), rs.getString("city_name"),
                        rs.getString("postal_code")));
            }
            return cities;
        }
        catch(SQLException e){
            log.error(e.getMessage());
        }
        finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return null;
    }

    @Override
    public void createItem(City item) {
        try(PreparedStatement ps = connection.prepareStatement(INSERT_CITY)) {
            ps.setString(1, item.getName());
            ps.setString(2,item.getPostalCode());
            ps.setInt(3, item.getCountryId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateName(City city) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_CITY_NAME)) {
            ps.setString(1, city.getName());
            ps.setInt(2, city.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updatePostalCode(City city) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_CITY_POSTAL_CODE)) {
            ps.setString(1, city.getPostalCode());
            ps.setInt(2, city.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void deleteItem(int id) {
        try(PreparedStatement ps = connection.prepareStatement(DELETE_CITY)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }
}
