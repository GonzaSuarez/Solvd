package com.solvd.booking.dao.daoclass;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.idao.IRoomReservedDAO;
import com.solvd.booking.hotel.Room;
import com.solvd.booking.hotel.RoomReserved;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomReservedDAO extends AbstractDAO implements IRoomReservedDAO {

    private static final String GET_ROOM_RESERVED_BY_ID = "SELECT * FROM RoomReserved WHERE idRoom_Reserved=?";
    private static final Logger log = LogManager.getLogger(RoomReservedDAO.class);

    public RoomReservedDAO() throws InterruptedException {}


    @Override
    public RoomReserved getItemById(int id) throws InterruptedException {
        try(PreparedStatement ps = connection.prepareStatement(GET_ROOM_RESERVED_BY_ID)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new RoomReserved(rs.getInt("idRoom_Reserved"), rs.getInt("Room_idRoom"),
                        rs.getInt("Reservation_idReservation"));
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
