package com.solvd.booking.dao.daoclass;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.idao.IPlanDAO;
import com.solvd.booking.travelcompany.Plan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanDAO extends AbstractDAO implements IPlanDAO {

    private static final String GET_PLAN_BY_ID = "SELECT * FROM Plan WHERE idPlan=?";
    private static final Logger log = LogManager.getLogger(PlanDAO.class);

    public PlanDAO() throws InterruptedException {}


    @Override
    public Plan getItemById(int id) throws InterruptedException {
        try(PreparedStatement ps = connection.prepareStatement(GET_PLAN_BY_ID)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Plan(rs.getInt("idPlan"), rs.getString("plan_name"),
                        rs.getInt("min_room"), rs.getInt("max_room"));
            }
        }
        catch(SQLException e){
            log.error(e.getMessage());
        }
        finally {
            ConnectionPool.getInstance("jdbc:mysql://localhost:3306", "root", "devintern")
                    .releaseConnection(connection);
        }
        return null;
    }


}
