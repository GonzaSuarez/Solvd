package com.solvd.booking.dao.daoclass;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.idao.IUserAccountDAO;
import com.solvd.booking.hotel.User;
import com.solvd.booking.travelcompany.UserAccount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserAccountDAO extends AbstractDAO implements IUserAccountDAO {

    private static final String GET_USER_ACCOUNT_BY_ID = "SELECT * FROM UserAccount WHERE idUser_Account=?";
    private static final String GET_USER_ACCOUNT_BY_TRAVEL_COMPANY_ID = "SELECT * FROM User_Account " +
                                                                            "WHERE Travel_Company_idTravelCompany=?";
    private static final Logger log = LogManager.getLogger(UserAccountDAO.class);

    public UserAccountDAO() throws InterruptedException {}


    @Override
    public UserAccount getItemById(int id) throws InterruptedException {
        try(PreparedStatement ps = connection.prepareStatement(GET_USER_ACCOUNT_BY_ID)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new UserAccount(rs.getInt("idUser_Account"), rs.getString("user_name"),
                       rs.getString("password"));
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
    public List<UserAccount> getUserAccountsByTravelCompanyId(int travelCompanyId) {
        try(PreparedStatement ps = connection.prepareStatement(GET_USER_ACCOUNT_BY_TRAVEL_COMPANY_ID)){
            List<UserAccount> userAccounts = new ArrayList<>();
            ps.setInt(1, travelCompanyId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 userAccounts.add(new UserAccount(rs.getInt("idUser_Account"), rs.getString("user_name"),
                        rs.getString("password")));
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
