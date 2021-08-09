package com.solvd.booking.dao.mysqldao.jbdc;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.IRoomReservedDAO;
import com.solvd.booking.hotel.RoomReserved;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomReservedDAO extends AbstractDAO implements IRoomReservedDAO {

    private static final Logger log = LogManager.getLogger(RoomReservedDAO.class);
    private static final String GET_ROOM_RESERVED_BY_ID = "SELECT * FROM RoomReserved WHERE id = ?";
    private static final String CREATE_ROOM_RESERVED = "INSERT INTO RoomReserved (Room_id, Reservation_id) VALUES (?,?)";
    private static final String DELETE_ROOM_RESERVED = "DELETE FROM RoomReserved WHERE id = ?";
    private static final String UPDATE_ROOM_RESERVED_PRICE = "UPDATE RoomReserved SET price = ? WHERE id = ?";

    public RoomReservedDAO() throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        super();
    }


    @Override
    public RoomReserved getItemById(int id) throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        try(PreparedStatement ps = connection.prepareStatement(GET_ROOM_RESERVED_BY_ID); ResultSet rs = ps.executeQuery()){
            ps.setInt(1, id);
            if(rs.next()){
                return new RoomReserved(rs.getInt("id"), rs.getInt("Room_id"),
                        rs.getInt("Reservation_id"));
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
    public void createItem(RoomReserved roomReserved) {
        try(PreparedStatement ps = connection.prepareStatement(CREATE_ROOM_RESERVED)) {
            ps.setInt(1, roomReserved.getIdRoom());
            ps.setInt(2, roomReserved.getIdReservation());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void deleteItem(int id) {
        try(PreparedStatement ps = connection.prepareStatement(DELETE_ROOM_RESERVED)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updatePrice(RoomReserved roomReserved) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_ROOM_RESERVED_PRICE)) {
            ps.setDouble(1, roomReserved.getPrice());
            ps.setInt(2, roomReserved.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }
}
