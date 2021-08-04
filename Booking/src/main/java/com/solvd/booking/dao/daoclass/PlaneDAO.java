package com.solvd.booking.dao.daoclass;

import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.dao.idao.IPlaneDAO;
import com.solvd.booking.travelcompany.Plane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaneDAO extends AbstractDAO implements IPlaneDAO {

    private static final String GET_PLANE_BY_ID = "SELECT * FROM Plane WHERE idPlane=?";
    private static final String GET_PLANE_BY_TRAVEL_COMPANY_ID = "SELECT * FROM Plane WHERE Travel_Company_idTravelCompany=?";
    private static final Logger log = LogManager.getLogger(PlaneDAO.class);

    public PlaneDAO() throws InterruptedException {}


    @Override
    public Plane getItemById(int id) throws InterruptedException {
        try(PreparedStatement ps = connection.prepareStatement(GET_PLANE_BY_ID)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Plane(rs.getInt("idPlane"), rs.getInt("capacity"));
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
    public List<Plane> getPlanesByTravelCompanyId(int travelCompanyId) {
        try(PreparedStatement ps = connection.prepareStatement(GET_PLANE_BY_TRAVEL_COMPANY_ID)){
            List<Plane> planes = new ArrayList<>();
            ps.setInt(1, travelCompanyId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                planes.add(new Plane(rs.getInt("idPlane"), rs.getInt("capacity")));
            }
            return planes;
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
