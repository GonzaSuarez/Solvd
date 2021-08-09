package com.solvd.booking.dao.mysqldao.jbdc;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.IPlaneDAO;
import com.solvd.booking.travelcompany.Plane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaneDAO extends AbstractDAO implements IPlaneDAO {

    private static final Logger log = LogManager.getLogger(PlaneDAO.class);
    private static final String GET_PLANE_BY_ID = "SELECT * FROM Plane WHERE id = ?";
    private static final String GET_PLANE_BY_TRAVEL_COMPANY_ID = "SELECT * FROM Plane WHERE Travel_Company_id = ?";
    private static final String CREATE_PLANE = "INSERT INTO Plane (capacity ,Travel_Company_id, Travel_Company_City_id) " +
                                                "VALUES (?,?,?)";
    private static final String DELETE_PLANE = "DELETE FROM Plane WHERE id = ?";
    private static final String UPDATE_PLANE_CAPACITY = "UPDATE Plane SET capacity = ? WHERE id = ?";

    public PlaneDAO() throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        super();
    }


    @Override
    public Plane getItemById(int id) throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        try(PreparedStatement ps = connection.prepareStatement(GET_PLANE_BY_ID); ResultSet rs = ps.executeQuery()){
            ps.setInt(1, id);
            if(rs.next()){
                return new Plane(rs.getInt("id"), rs.getInt("Travel_Company_id"),
                        rs.getInt("Travel_Company_City_idCity"));
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
    public List<Plane> getPlanesByTravelCompanyId(int travelCompanyId) throws SQLException, ClassNotFoundException, IOException {
        try(PreparedStatement ps = connection.prepareStatement(GET_PLANE_BY_TRAVEL_COMPANY_ID); ResultSet rs = ps.executeQuery()){
            List<Plane> planes = new ArrayList<>();
            ps.setInt(1, travelCompanyId);
            while(rs.next()){
                planes.add(new Plane(rs.getInt("id"), rs.getInt("Travel_Company_id"),
                        rs.getInt("Travel_Company_City_id")));
            }
            return planes;
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
    public void createItem(Plane plane) {
        try(PreparedStatement ps = connection.prepareStatement(CREATE_PLANE)) {
            ps.setDouble(1, plane.getCapacity());
            ps.setInt(2, plane.getTravelCompanyId());
            ps.setInt(3, plane.getTravelCompanyCityId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void deleteItem(int id) {
        try(PreparedStatement ps = connection.prepareStatement(DELETE_PLANE)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }

    @Override
    public void updateCapacity(Plane plane) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_PLANE_CAPACITY)) {
            ps.setInt(1, plane.getCapacity());
            ps.setInt(2, plane.getId());
            ps.execute();
        } catch (SQLException throwables) {
            log.error(throwables.getMessage());
        }
    }
}
