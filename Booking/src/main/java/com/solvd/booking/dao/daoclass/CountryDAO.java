package com.solvd.booking.dao.daoclass;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.idao.ICountryDAO;
import com.solvd.booking.places.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryDAO extends AbstractDAO implements ICountryDAO {

    private static final String GET_COUNTRY_BY_ID = "SELECT * FROM Country WHERE idCountry=?";
    private static final Logger log = LogManager.getLogger(CountryDAO.class);

    public CountryDAO() throws InterruptedException {}


    @Override
    public Country getItemById(int id) throws InterruptedException {
        try(PreparedStatement ps = connection.prepareStatement(GET_COUNTRY_BY_ID)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Country(rs.getInt("idCountry"), rs.getString("country_name"));
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
