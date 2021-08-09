package com.solvd.booking.dao.mysqldao.jbdc;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.IPlanDAO;
import com.solvd.booking.travelcompany.Plan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanDAO extends AbstractDAO implements IPlanDAO {

    private static final Logger log = LogManager.getLogger(PlanDAO.class);
    private static final String GET_PLAN_BY_ID = "SELECT * FROM Plan WHERE id = ?";
    private static final String CREATE_PLAN = "INSERT INTO Plan (plan_name, max_room, monthly_price) VALUES (?,?,?)";
    private static final String DELETE_PLAN = "DELETE FROM Plan WHERE id = ?";
    private static final String UPDATE_PLAN_NAME = "UPDATE Plan SET plan_name = ? WHERE id = ?";
    private static final String UPDATE_PLAN_DETAILS = "UPDATE Plan SET details = ? WHERE id = ?";
    private static final String UPDATE_PLAN_MAX_ROOM = "UPDATE Plan SET max_room = ? WHERE id = ?";
    private static final String UPDATE_PLAN_MIN_ROOM = "UPDATE Plan SET min_room = ? WHERE id = ?";
    private static final String UPDATE_PLAN_MONTHLY_PRICE = "UPDATE Plan SET monthly_price = ? WHERE id = ?";

    public PlanDAO() throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        super();
    }


    @Override
    public Plan getItemById(int id) throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        try(PreparedStatement ps = connection.prepareStatement(GET_PLAN_BY_ID); ResultSet rs = ps.executeQuery()){
            ps.setInt(1, id);
            if(rs.next()){
                return new Plan(rs.getInt("id"), rs.getString("plan_name"),
                        rs.getInt("min_room"), rs.getInt("max_room"));
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
    public void createItem(Plan plan) {
        try(PreparedStatement ps = connection.prepareStatement(CREATE_PLAN)) {
            ps.setString(1, plan.getName());
            ps.setInt(2, plan.getMaxRoom());
            ps.setInt(3, plan.getMonthlyPrice());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void deleteItem(int id) {
        try(PreparedStatement ps = connection.prepareStatement(DELETE_PLAN)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateName(Plan plan) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_PLAN_NAME)) {
            ps.setString(1, plan.getName());
            ps.setInt(2, plan.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateDetails(Plan plan) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_PLAN_DETAILS)) {
            ps.setString(1, plan.getDetails());
            ps.setInt(2, plan.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateMaxRoom(Plan plan) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_PLAN_MAX_ROOM)) {
            ps.setInt(1, plan.getMaxRoom());
            ps.setInt(2, plan.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateMinRoom(Plan plan) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_PLAN_MIN_ROOM)) {
            ps.setInt(1, plan.getMinRoom());
            ps.setInt(2, plan.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateMonthlyPrice(Plan plan) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_PLAN_MONTHLY_PRICE)) {
            ps.setInt(1, plan.getMonthlyPrice());
            ps.setInt(2, plan.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }
}
