package com.solvd.booking.dao.mysqldao.jbdc;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.ICompanyPlanDAO;
import com.solvd.booking.travelcompany.CompanyPlan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyPlanDAO extends AbstractDAO implements ICompanyPlanDAO {


    private static final Logger log = LogManager.getLogger(CompanyPlanDAO.class);
    private static final String GET_COMPANY_PLAN_BY_ID = "SELECT * FROM companyplan WHERE id = ?";
    private static final String CREATE_COMPANY_PLAN = "INSERT INTO companyplan (plan_id, Travel_Company_id) VALUES (?,?)";
    private static final String DELETE_COMPANY_PLAN = "DELETE FROM companyplan WHERE id = ?";

    public CompanyPlanDAO() throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        super();
    }


    @Override
    public CompanyPlan getItemById(int id) throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        try(PreparedStatement ps = connection.prepareStatement(GET_COMPANY_PLAN_BY_ID); ResultSet rs = ps.executeQuery()){
            ps.setInt(1, id);
            if(rs.next()){
                return new CompanyPlan(rs.getInt("id"), rs.getInt("plan_id"),
                        rs.getInt("Travel_Company_id"));
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
    public void createItem(CompanyPlan companyPlan) {
        try(PreparedStatement ps = connection.prepareStatement(CREATE_COMPANY_PLAN)) {
            ps.setInt(1, companyPlan.getIdPlan());
            ps.setInt(1, companyPlan.getIdTravelCompany());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void deleteItem(int id) {
        try(PreparedStatement ps = connection.prepareStatement(DELETE_COMPANY_PLAN)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }
}
