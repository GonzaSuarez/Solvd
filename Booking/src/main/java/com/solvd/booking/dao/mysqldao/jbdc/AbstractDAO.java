package com.solvd.booking.dao.mysqldao.jbdc;

import com.solvd.booking.connectionpool.ConnectionPool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractDAO {

    protected Connection connection = ConnectionPool.getInstance().getConnection();

    protected AbstractDAO() throws InterruptedException, SQLException, ClassNotFoundException, IOException {}

}
