package com.solvd.booking.dao.daoclass;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.idao.IUserAccountDAO;
import com.solvd.booking.travelcompany.UserAccount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAccountDAO extends AbstractDAO implements IUserAccountDAO {

    private static final String GET_USER_ACCOUNT_BY_ID = "SELECT * FROM UserAccount WHERE idUser_Account=?";
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


}
