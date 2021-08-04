package com.solvd.booking.dao.idao;

import com.solvd.booking.travelcompany.Plane;

import java.util.List;

public interface IPlaneDAO extends IBaseDAO<Plane> {
    List<Plane> getPlanesByTravelCompanyId(int travelCompanyId);
}
