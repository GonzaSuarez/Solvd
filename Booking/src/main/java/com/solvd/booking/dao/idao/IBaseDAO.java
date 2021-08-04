package com.solvd.booking.dao.idao;

import com.solvd.booking.travelcompany.Plane;

public interface IBaseDAO<T> {

    T getItemById(int id) throws InterruptedException;

}
