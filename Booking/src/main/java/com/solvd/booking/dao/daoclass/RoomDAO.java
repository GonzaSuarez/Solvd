package com.solvd.booking.dao.daoclass;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.idao.IRoomDAO;
import com.solvd.booking.hotel.Room;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomDAO extends AbstractDAO implements IRoomDAO {

    private static final String GET_ROOM_BY_ID = "SELECT * FROM Room WHERE idRoom=?";
    private static final Logger log = LogManager.getLogger(RoomDAO.class);

    public RoomDAO() throws InterruptedException {}


    @Override
    public Room getItemById(int id) throws InterruptedException {
        try(PreparedStatement ps = connection.prepareStatement(GET_ROOM_BY_ID)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Room(rs.getInt("idRoom"), rs.getString("room_name"),
                        rs.getInt("Hotel_idHotel"));
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


}
