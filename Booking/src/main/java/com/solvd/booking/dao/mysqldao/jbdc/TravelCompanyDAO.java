package com.solvd.booking.dao.mysqldao.jbdc;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.ITravelCompanyDAO;
import com.solvd.booking.places.City;
import com.solvd.booking.travelcompany.TravelCompany;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TravelCompanyDAO extends AbstractDAO implements ITravelCompanyDAO {

    private static final Logger log = LogManager.getLogger(TravelCompanyDAO.class);
    private static final String GET_TRAVEL_COMPANY_BY_ID = "SELECT * FROM TravelCompany t LEFT JOIN City c on t.City_id = c.id" +
                                                            "WHERE t.id = ?";
    private static final String CREATE_TRAVEL_COMPANY = "INSERT INTO TravelCompany (company_name, City_id) VALUES (?,?)";
    private static final String DELETE_TRAVEL_COMPANY = "DELETE FROM TravelCompany WHERE id = ?";
    private static final String UPDATE_TRAVEL_COMPANY_NAME = "UPDATE TravelCompany SET company_name = ? WHERE id = ?";
    private static final String UPDATE_TRAVEL_COMPANY_EMAIL = "UPDATE TravelCompany SET email = ? WHERE id = ?";

    public TravelCompanyDAO() throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        super();
    }


    @Override
    public TravelCompany getItemById(int id) throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        try(PreparedStatement ps = connection.prepareStatement(GET_TRAVEL_COMPANY_BY_ID); ResultSet rs = ps.executeQuery()){
            ps.setInt(1, id);
            if(rs.next()){
                return new TravelCompany(rs.getInt("id"), rs.getString("company_name"),
                        new City(rs.getInt("City_id"),rs.getString("city_name"),
                                rs.getString("postal_code")));
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
    public void createItem(TravelCompany travelCompany) {
        try(PreparedStatement ps = connection.prepareStatement(CREATE_TRAVEL_COMPANY)) {
            ps.setString(1, travelCompany.getName());
            ps.setInt(2, travelCompany.getCity().getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void deleteItem(int id) {
        try(PreparedStatement ps = connection.prepareStatement(DELETE_TRAVEL_COMPANY)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateName(TravelCompany travelCompany) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_TRAVEL_COMPANY_NAME)) {
            ps.setString(1, travelCompany.getName());
            ps.setInt(2, travelCompany.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateEmail(TravelCompany travelCompany) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_TRAVEL_COMPANY_EMAIL)) {
            ps.setString(1, travelCompany.getEmail());
            ps.setInt(2, travelCompany.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }
}
