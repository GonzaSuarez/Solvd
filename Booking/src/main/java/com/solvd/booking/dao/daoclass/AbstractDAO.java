package com.solvd.booking.dao.daoclass;

import com.solvd.booking.connectionpool.ConnectionPool;

import java.sql.Connection;

public abstract class AbstractDAO {

    protected Connection connection = ConnectionPool.getInstance("jdbc:mysql://52.59.193.212:3306/BookingSuarez", "root",
            "devintern").getConnection();

    protected AbstractDAO() throws InterruptedException {}

}
