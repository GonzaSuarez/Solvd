package com.solvd.booking.dao.daoclass;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.idao.IHotelDAO;
import com.solvd.booking.hotel.Hotel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelDAO extends AbstractDAO implements IHotelDAO {

    private static final String GET_HOTEL_BY_ID = "SELECT * FROM Hotel WHERE idHotel=?";
    private static final Logger log = LogManager.getLogger(HotelDAO.class);

    public HotelDAO() throws InterruptedException {
    }


    @Override
    public Hotel getItemById(int id) throws InterruptedException {

        try(PreparedStatement ps = connection.prepareStatement(GET_HOTEL_BY_ID)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Hotel(rs.getInt("idHotel"), rs.getString("hotel_name"));
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
