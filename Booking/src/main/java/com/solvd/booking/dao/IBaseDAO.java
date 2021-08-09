package com.solvd.booking.dao;

import com.solvd.booking.travelcompany.Plane;

import java.io.IOException;
import java.sql.SQLException;

public interface IBaseDAO<T> {

    T getItemById(int id) throws InterruptedException, SQLException, ClassNotFoundException, IOException;
    void createItem(T item);
    void deleteItem(int id);

}
