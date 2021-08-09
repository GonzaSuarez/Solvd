package com.solvd.booking.dao.mysqldao.jbdc;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.IReservationDAO;
import com.solvd.booking.hotel.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class ReservationDAO extends AbstractDAO implements IReservationDAO {

    private static final Logger log = LogManager.getLogger(ReservationDAO.class);
    private static final String GET_RESERVATION_BY_ID = "SELECT * FROM Reservation r LEFT JOIN User u on r.User_id = u.id" +
                                                        " WHERE r.id=?";
    private static final String CREATE_RESERVATION = "INSERT INTO Reservation (start_date, total_price, User_id) VALUES (?,?,?)";
    private static final String DELETE_RESERVATION = "DELETE FROM Reservation WHERE id = ?";
    private static final String UPDATE_RESERVATION_STARTING_DATE = "UPDATE Reservation SET starting_date = ? WHERE id = ?";
    private static final String UPDATE_RESERVATION_ENDING_DATE = "UPDATE Reservation SET ending_date = ? WHERE id = ?";
    private static final String UPDATE_RESERVATION_DISCOUNT = "UPDATE Reservation SET discount = ? WHERE id = ?";
    private static final String UPDATE_RESERVATION_PRICE = "UPDATE Reservation SET price = ? WHERE id = ?";

    public ReservationDAO() throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        super();
    }


    @Override
    public Reservation getItemById(int id) throws InterruptedException, SQLException, ClassNotFoundException, IOException {

        try(PreparedStatement ps = connection.prepareStatement(GET_RESERVATION_BY_ID); ResultSet rs = ps.executeQuery()){
            ps.setInt(1, id);
            if(rs.next()){
                return new Reservation(rs.getInt("id"),
                            rs.getFloat("total_price"),
                                new User(rs.getInt("idUser"), rs.getString("first_name"),
                                        rs.getString("email")));
            }
        }
        catch(SQLException e){
            log.error(e);
        }
        finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return null;
    }

    @Override
    public void createItem(Reservation reservation) {
        try(PreparedStatement ps = connection.prepareStatement(CREATE_RESERVATION)) {
            ps.setDate(1, new Date(reservation.getStartingDate().getTimeInMillis()),reservation.getStartingDate());
            ps.setDouble(2, reservation.getPrice());
            ps.setInt(3, reservation.getClient().getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void deleteItem(int id) {
        try(PreparedStatement ps = connection.prepareStatement(DELETE_RESERVATION)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateStartDate(Reservation reservation) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_RESERVATION_STARTING_DATE)) {
            ps.setDate(1, new Date(reservation.getStartingDate().getTimeInMillis()), reservation.getStartingDate());
            ps.setInt(2, reservation.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateEndDate(Reservation reservation) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_RESERVATION_ENDING_DATE)) {
            ps.setDate(1, new Date(reservation.getEndingDate().getTimeInMillis()), reservation.getEndingDate());
            ps.setInt(2, reservation.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateDiscount(Reservation reservation) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_RESERVATION_DISCOUNT)) {
            ps.setDouble(1, reservation.getDiscount());
            ps.setInt(2, reservation.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateTotalPrice(Reservation reservation) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_RESERVATION_PRICE)) {
            ps.setDouble(1, reservation.getPrice());
            ps.setInt(2, reservation.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }
}
