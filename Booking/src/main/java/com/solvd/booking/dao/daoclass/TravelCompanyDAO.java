package com.solvd.booking.dao.daoclass;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.idao.ITravelCompanyDAO;
import com.solvd.booking.places.City;
import com.solvd.booking.travelcompany.TravelCompany;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TravelCompanyDAO extends AbstractDAO implements ITravelCompanyDAO {

    private static final String GET_TRAVEL_COMPANY_BY_ID = "SELECT * FROM TravelCompany t LEFT JOIN City c on t.City_idCity = c.idCity" +
                                                            "WHERE idTravelCompany=?";
    private static final Logger log = LogManager.getLogger(TravelCompanyDAO.class);

    public TravelCompanyDAO() throws InterruptedException {}


    @Override
    public TravelCompany getItemById(int id) throws InterruptedException {
        try(PreparedStatement ps = connection.prepareStatement(GET_TRAVEL_COMPANY_BY_ID)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new TravelCompany(rs.getInt("idTravelCompany"), rs.getString("company_name"),
                        new City(rs.getInt("idCity"),rs.getString("city_name"),
                                rs.getInt("postal_code")));
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
