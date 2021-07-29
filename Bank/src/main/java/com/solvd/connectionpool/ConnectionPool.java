package com.solvd.connectionpool;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.*;

public class ConnectionPool {

    private static final int MAX_CONNECTIONS = 5;
    private List<Connection> connectionsPool = new CopyOnWriteArrayList<>();
    private List<Connection> connectionsInUse = new CopyOnWriteArrayList<>();


    public ConnectionPool(String url, String user, String password) throws SQLException {
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            connectionsPool.add(createConnection(url, user, password));
        }
    }

    public Connection getConnection() throws InterruptedException {
        while(this.connectionsPool.isEmpty()){
            this.wait();
        }
        Connection connection = this.connectionsPool.remove(0);
        connectionsInUse.add(connection);
        return connection;
    }

    public boolean releaseConnection(Connection connection) {
        this.connectionsPool.add(connection);
        this.notifyAll();
        return connectionsInUse.remove(connection);
    }

    private static Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}
