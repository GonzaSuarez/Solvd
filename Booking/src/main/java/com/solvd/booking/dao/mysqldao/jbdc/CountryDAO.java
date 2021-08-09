package com.solvd.booking.dao.mysqldao.jbdc;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.ICountryDAO;
import com.solvd.booking.places.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryDAO extends AbstractDAO implements ICountryDAO {

    private static final Logger log = LogManager.getLogger(CountryDAO.class);
    private static final String GET_COUNTRY_BY_ID = "SELECT * FROM Country WHERE id = ?";
    private static final String CREATE_COUNTRY = "INSERT INTO Country (country_name) VALUES (?)";
    private static final String DELETE_COUNTRY = "DELETE FROM Country WHERE id = ?";
    private static final String UPDATE_COUNTRY_NAME = "UPDATE City SET country_name = ? WHERE id = ?";

    public CountryDAO() throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        super();
    }


    @Override
    public Country getItemById(int id) throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        try(PreparedStatement ps = connection.prepareStatement(GET_COUNTRY_BY_ID); ResultSet rs = ps.executeQuery()){
            ps.setInt(1, id);
            if(rs.next()){
                return new Country(rs.getInt("id"), rs.getString("country_name"));
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
    public void createItem(Country country) {
        try(PreparedStatement ps = connection.prepareStatement(CREATE_COUNTRY)) {
            ps.setString(1, country.getName());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void deleteItem(int id) {
        try(PreparedStatement ps = connection.prepareStatement(DELETE_COUNTRY)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateName(Country country) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_COUNTRY_NAME)) {
            ps.setString(1, country.getName());
            ps.setInt(2,country.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }
}
