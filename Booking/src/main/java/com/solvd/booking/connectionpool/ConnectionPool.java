package com.solvd.booking.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ConnectionPool {

    private static final Logger log = LogManager.getLogger(ConnectionPool.class);
    private static final int MAX_CONNECTIONS = 5;
    private static  ConnectionPool instance;
    private static BlockingQueue<Connection> connectionsPool = new ArrayBlockingQueue<>(MAX_CONNECTIONS);


    private ConnectionPool(String url, String user, String password){
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            try {
                connectionsPool.add(createConnection(url, user, password));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static ConnectionPool getInstance(String url, String user, String password){
        if(instance == null){
            instance = new ConnectionPool(url, user, password);
        }
        return instance;
    }

    public Connection getConnection() throws InterruptedException {
        return connectionsPool.remove();
    }

    public void releaseConnection(Connection connection) {
        this.connectionsPool.add(connection);
    }

    private static Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }


}

