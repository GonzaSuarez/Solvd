package com.solvd.booking.dao.daoclass;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.idao.IUserDAO;
import com.solvd.booking.hotel.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends AbstractDAO implements IUserDAO {

    private static final String GET_USER_BY_ID = "SELECT * FROM User WHERE idUser=?";
    private static final String GET_USER_BY_RESERVATION_ID = "SELECT * FROM Reservation r LEFT JOIN User u on r.User_idUser = u.idUser " +
                                                             "WHERE idReservation=?";
    private static final Logger log = LogManager.getLogger(UserDAO.class);

    public UserDAO() throws InterruptedException {}


    @Override
    public User getItemById(int id) throws InterruptedException {
        try(PreparedStatement ps = connection.prepareStatement(GET_USER_BY_ID)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new User(rs.getInt("idUser"), rs.getString("first_name"),
                        rs.getString("email"));
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
    public User getUserByReservationId(int id) {
        try(PreparedStatement ps = connection.prepareStatement(GET_USER_BY_RESERVATION_ID)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new User(rs.getInt("idUser"), rs.getString("first_name"),
                        rs.getString("email"));
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
