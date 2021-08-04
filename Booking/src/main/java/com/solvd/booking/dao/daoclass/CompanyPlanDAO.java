package com.solvd.booking.dao.daoclass;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.idao.ICompanyPlanDAO;
import com.solvd.booking.hotel.Room;
import com.solvd.booking.travelcompany.CompanyPlan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyPlanDAO extends AbstractDAO implements ICompanyPlanDAO {


    private static final String GET_COMPANY_PLAN_BY_ID = "SELECT * FROM companyplan WHERE idCompany_plan=?";
    private static final Logger log = LogManager.getLogger(CompanyPlanDAO.class);

    public CompanyPlanDAO() throws InterruptedException {}


    @Override
    public CompanyPlan getItemById(int id) throws InterruptedException {
        try(PreparedStatement ps = connection.prepareStatement(GET_COMPANY_PLAN_BY_ID)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new CompanyPlan(rs.getInt("idCompany_plan"), rs.getInt("plan_idplan"),
                        rs.getInt("Travel_Company_idTravelCompany"));
            }
        }
        catch(SQLException e){
            log.error(e.getMessage());
        }
        finally {
            ConnectionPool.getInstance("jdbc:mysql://localhost:3306", "root", "devintern").releaseConnection(connection);
        }
        return null;
    }


}
