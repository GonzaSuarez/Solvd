package com.solvd.booking.dao.mysqldao.jbdc;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.IHotelDAO;
import com.solvd.booking.hotel.Hotel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO extends AbstractDAO implements IHotelDAO {

    private static final Logger log = LogManager.getLogger(HotelDAO.class);
    private static final String GET_HOTEL_BY_ID = "SELECT * FROM Hotel WHERE id = ?";
    private static final String CREATE_HOTEL = "INSERT INTO Hotel (hotel_name, City_id) VALUES (?,?)";
    private static final String DELETE_HOTEL = "DELETE FROM Hotel WHERE id = ?";
    private static final String UPDATE_HOTEL_NAME = "UPDATE Hotel SET hotel_name = ? WHERE id = ?";
    private static final String UPDATE_HOTEL_DESCRIPTION = "UPDATE Hotel SET description = ? WHERE id = ?";

    public HotelDAO() throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        super();
    }


    @Override
    public Hotel getItemById(int id) throws InterruptedException, SQLException, ClassNotFoundException, IOException {

        try(PreparedStatement ps = connection.prepareStatement(GET_HOTEL_BY_ID); ResultSet rs = ps.executeQuery()){
            ps.setInt(1, id);
            if(rs.next()){
                return new Hotel(rs.getInt("id"), rs.getString("hotel_name"),
                        rs.getInt("City_id"));
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
    public List<Hotel> getHotelsByTravelCompanyId(int travelCompanyId) throws SQLException, ClassNotFoundException, IOException {

        try(PreparedStatement ps = connection.prepareStatement(GET_HOTEL_BY_ID); ResultSet rs = ps.executeQuery()){
            List<Hotel> hotels = new ArrayList<>();
            ps.setInt(1, travelCompanyId);
            while(rs.next()){
                 hotels.add(new Hotel(rs.getInt("id"), rs.getString("hotel_name"),
                         rs.getInt("City_id")));
            }
            return hotels;
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
    public void createItem(Hotel hotel) {
        try(PreparedStatement ps = connection.prepareStatement(CREATE_HOTEL)) {
            ps.setString(1, hotel.getName());
            ps.setInt(2, hotel.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void deleteItem(int id) {
        try(PreparedStatement ps = connection.prepareStatement(DELETE_HOTEL)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateName(Hotel hotel) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_HOTEL_NAME)) {
            ps.setString(1, hotel.getName());
            ps.setInt(2, hotel.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateDetails(Hotel hotel) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_HOTEL_DESCRIPTION)) {
            ps.setString(1, hotel.getDescription());
            ps.setInt(2, hotel.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }
}
