package com.solvd.booking.dao.daoclass;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.idao.IReservationDAO;
import com.solvd.booking.hotel.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationDAO extends AbstractDAO implements IReservationDAO {

    private static final String GET_RESERVATION_BY_ID = "SELECT * FROM Reservation r LEFT JOIN User u on r.User_idUser = u.idUser" +
                                                        " WHERE idReservation=?";
    private static final Logger log = LogManager.getLogger(ReservationDAO.class);

    public ReservationDAO() throws InterruptedException {}


    @Override
    public Reservation getItemById(int id) throws InterruptedException {

        try(PreparedStatement ps = connection.prepareStatement(GET_RESERVATION_BY_ID)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Reservation(rs.getInt("idReservation"),
                            rs.getFloat("total_price"),
                                new User(rs.getInt("idUser"), rs.getString("first_name"),
                                        rs.getString("email")));
            }
        }
        catch(SQLException e){
            log.error(e);
        }
        finally {
            ConnectionPool.getInstance("jdbc:mysql://localhost:3306", "root", "devintern").
                    releaseConnection(connection);
        }
        return null;
    }
}
