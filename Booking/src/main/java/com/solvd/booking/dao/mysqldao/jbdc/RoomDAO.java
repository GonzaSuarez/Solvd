package com.solvd.booking.dao.mysqldao.jbdc;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.IRoomDAO;
import com.solvd.booking.hotel.Room;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO extends AbstractDAO implements IRoomDAO {

    private static final Logger log = LogManager.getLogger(RoomDAO.class);
    private static final String GET_ROOM_BY_ID = "SELECT * FROM Room WHERE id = ?";
    private static final String GET_ROOM_BY_HOTEL_ID = "SELECT * FROM Room WHERE Hotel_id = ?";
    private static final String CREATE_ROOM = "INSERT INTO Room (room_name, current_price, Hotel_id) VALUES (?,?,?)";
    private static final String DELETE_ROOM = "DELETE FROM Room WHERE id = ?";
    private static final String UPDATE_ROOM_NAME = "UPDATE Room SET room_name = ? WHERE id = ?";
    private static final String UPDATE_ROOM_DESCRIPTION = "UPDATE Room SET description = ? WHERE id = ?";
    private static final String UPDATE_ROOM_PRICE = "UPDATE Room SET current_price = ? WHERE id = ?";

    public RoomDAO() throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        super();
    }


    @Override
    public Room getItemById(int id) throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        try(PreparedStatement ps = connection.prepareStatement(GET_ROOM_BY_ID); ResultSet rs = ps.executeQuery()){
            ps.setInt(1, id);
            if(rs.next()){
                return new Room(rs.getInt("id"), rs.getString("room_name"),
                        rs.getInt("Hotel_id"));
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
    public List<Room> getRoomsByHotelId(int hotelId) throws SQLException, ClassNotFoundException, IOException {
        try(PreparedStatement ps = connection.prepareStatement(GET_ROOM_BY_HOTEL_ID); ResultSet rs = ps.executeQuery()){
            List<Room> rooms = new ArrayList<>();
            ps.setInt(1, hotelId);
            while(rs.next()){
                 rooms.add(new Room(rs.getInt("id"), rs.getString("room_name"),
                        rs.getInt("Hotel_id")));
            }
            return rooms;
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
    public void createItem(Room room) {
        try(PreparedStatement ps = connection.prepareStatement(CREATE_ROOM)) {
            ps.setString(1, room.getRoomName());
            ps.setDouble(2, room.getPrice());
            ps.setInt(3, room.getIdHotel());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void deleteItem(int id) {
        try(PreparedStatement ps = connection.prepareStatement(DELETE_ROOM)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateName(Room room) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_ROOM_NAME)) {
            ps.setString(1, room.getRoomName());
            ps.setInt(2, room.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateDescription(Room room) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_ROOM_DESCRIPTION)) {
            ps.setString(1, room.getDescription());
            ps.setInt(2, room.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updatePrice(Room room) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_ROOM_PRICE)) {
            ps.setDouble(1, room.getPrice());
            ps.setInt(2, room.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }
}
