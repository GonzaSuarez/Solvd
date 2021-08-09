package com.solvd.booking.dao.mysqldao.jbdc;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.IUserAccountDAO;
import com.solvd.booking.travelcompany.UserAccount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserAccountDAO extends AbstractDAO implements IUserAccountDAO {

    private static final Logger log = LogManager.getLogger(UserAccountDAO.class);
    private static final String GET_USER_ACCOUNT_BY_ID = "SELECT * FROM UserAccount WHERE id = ?";
    private static final String GET_USER_ACCOUNT_BY_TRAVEL_COMPANY_ID = "SELECT * FROM User_Account " +
                                                                            "WHERE Travel_Company_id = ?";
    private static final String CREATE_USER_ACCOUNT = "INSERT INTO UserAccount (first_name, user_name, password, Travel_Company_id) " +
                                                        "VALUES (?,?,?,?)";
    private static final String DELETE_USER_ACCOUNT = "DELETE FROM UserAccount WHERE id = ?";
    private static final String UPDATE_USER_ACCOUNT_FIRST_NAME = "UPDATE UserAccount SET first_name = ? WHERE id = ?";
    private static final String UPDATE_USER_ACCOUNT_LAST_NAME = "UPDATE UserAccount SET last_name = ? WHERE id = ?";
    private static final String UPDATE_USER_ACCOUNT_EMAIL = "UPDATE UserAccount SET email = ? WHERE id = ?";
    private static final String UPDATE_USER_ACCOUNT_USER = "UPDATE UserAccount SET user_name = ? WHERE id = ?";
    private static final String UPDATE_USER_ACCOUNT_PASSWORD = "UPDATE UserAccount SET password = ? WHERE id = ?";

    public UserAccountDAO() throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        super();
    }


    @Override
    public UserAccount getItemById(int id) throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        try(PreparedStatement ps = connection.prepareStatement(GET_USER_ACCOUNT_BY_ID); ResultSet rs = ps.executeQuery()){
            ps.setInt(1, id);
            if(rs.next()){
                return new UserAccount(rs.getInt("id"), rs.getString("user_name"),
                       rs.getString("password"));
            }
        }
        catch(SQLException e){
            log.error(e.getMessage());
        }
        finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return null;
    }

    @Override
    public List<UserAccount> getUserAccountsByTravelCompanyId(int travelCompanyId) throws SQLException, ClassNotFoundException, IOException {
        try(PreparedStatement ps = connection.prepareStatement(GET_USER_ACCOUNT_BY_TRAVEL_COMPANY_ID); ResultSet rs = ps.executeQuery()){
            List<UserAccount> userAccounts = new ArrayList<>();
            ps.setInt(1, travelCompanyId);
            while(rs.next()){
                 userAccounts.add(new UserAccount(rs.getInt("id"), rs.getString("user_name"),
                        rs.getString("password")));
            }
        }
        catch(SQLException e){
            log.error(e.getMessage());
        }
        finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return null;
    }

    @Override
    public void createItem(UserAccount userAccount) {
        try(PreparedStatement ps = connection.prepareStatement(CREATE_USER_ACCOUNT)) {
            ps.setString(1, userAccount.getFirstName());
            ps.setString(2, userAccount.getUser());
            ps.setString(3, userAccount.getPassword());
            ps.setInt(4, userAccount.getIdCompany());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void deleteItem(int id) {
        try(PreparedStatement ps = connection.prepareStatement(DELETE_USER_ACCOUNT)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateFirstName(UserAccount userAccount) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_USER_ACCOUNT_FIRST_NAME)) {
            ps.setString(1, userAccount.getFirstName());
            ps.setInt(2, userAccount.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateLastName(UserAccount userAccount) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_USER_ACCOUNT_LAST_NAME)) {
            ps.setString(1, userAccount.getLastName());
            ps.setInt(2, userAccount.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateEmail(UserAccount userAccount) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_USER_ACCOUNT_EMAIL)) {
            ps.setString(1, userAccount.getEmail());
            ps.setInt(2, userAccount.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateUserName(UserAccount userAccount) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_USER_ACCOUNT_USER)) {
            ps.setString(1, userAccount.getUser());
            ps.setInt(2, userAccount.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updatePassword(UserAccount userAccount) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_USER_ACCOUNT_PASSWORD)) {
            ps.setString(1, userAccount.getPassword());
            ps.setInt(2, userAccount.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }

    }
}
