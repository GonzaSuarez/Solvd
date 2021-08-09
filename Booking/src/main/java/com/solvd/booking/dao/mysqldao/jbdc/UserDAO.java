package com.solvd.booking.dao.mysqldao.jbdc;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.IUserDAO;
import com.solvd.booking.hotel.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends AbstractDAO implements IUserDAO {

    private static final Logger log = LogManager.getLogger(UserDAO.class);
    private static final String GET_USER_BY_ID = "SELECT * FROM User WHERE id = ?";
    private static final String GET_USER_BY_RESERVATION_ID = "SELECT * FROM Reservation r LEFT JOIN User u on r.User_id = u.id " +
                                                             "WHERE r.id = ?";
    private static final String CREATE_USER = "INSERT INTO User (first_name, last_name, email, phone, address) VALUES (?,?,?,?,?)";
    private static final String DELETE_USER = "DELETE FROM User WHERE id = ?";
    private static final String UPDATE_USER_FIRST_NAME = "UPDATE User SET first_name = ? WHERE id = ?";
    private static final String UPDATE_USER_LAST_NAME = "UPDATE User SET last_name = ? WHERE id = ?";
    private static final String UPDATE_USER_EMAIL = "UPDATE User SET email = ? WHERE id = ?";
    private static final String UPDATE_USER_PHONE = "UPDATE User SET phone = ? WHERE id = ?";
    private static final String UPDATE_USER_ADDRESS = "UPDATE User SET address = ? WHERE id = ?";
    private static final String UPDATE_USER_DETAILS = "UPDATE User SET details = ? WHERE id = ?";

    public UserDAO() throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        super();
    }


    @Override
    public User getItemById(int id) throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        try(PreparedStatement ps = connection.prepareStatement(GET_USER_BY_ID); ResultSet rs = ps.executeQuery()){
            ps.setInt(1, id);
            if(rs.next()){
                return new User(rs.getInt("id"), rs.getString("first_name"),
                        rs.getString("email"));
            }
        }
        catch(SQLException e){
            log.error(e.getMessage());
        }
        finally {
            ConnectionPool.getInstance().
                    releaseConnection(connection);
        }
        return null;
    }

    @Override
    public User getUserByReservationId(int id) throws SQLException, ClassNotFoundException, IOException {
        try(PreparedStatement ps = connection.prepareStatement(GET_USER_BY_RESERVATION_ID); ResultSet rs = ps.executeQuery()){
            ps.setInt(1, id);
            if(rs.next()){
                return new User(rs.getInt("id"), rs.getString("first_name"),
                        rs.getString("email"));
            }
        }
        catch(SQLException e){
            log.error(e.getMessage());
        }
        finally {
            ConnectionPool.getInstance().
                    releaseConnection(connection);
        }
        return null;
    }

    @Override
    public void createItem(User user) {
        try(PreparedStatement ps = connection.prepareStatement(CREATE_USER)) {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getPhone());
            ps.setString(5, user.getAddress());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void deleteItem(int id) {
        try(PreparedStatement ps = connection.prepareStatement(DELETE_USER)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateFirstName(User user) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_USER_FIRST_NAME)) {
            ps.setString(1, user.getFirstName());
            ps.setInt(2, user.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateLastName(User user) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_USER_LAST_NAME)) {
            ps.setString(1, user.getLastName());
            ps.setInt(2, user.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateEmail(User user) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_USER_EMAIL)) {
            ps.setString(1, user.getEmail());
            ps.setInt(2, user.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updatePhone(User user) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_USER_PHONE)) {
            ps.setInt(1, user.getPhone());
            ps.setInt(2, user.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateAddress(User user) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_USER_ADDRESS)) {
            ps.setString(1, user.getAddress());
            ps.setInt(2, user.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateDetails(User user) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_USER_DETAILS)) {
            ps.setString(1, user.getDetails());
            ps.setInt(2, user.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }
}
