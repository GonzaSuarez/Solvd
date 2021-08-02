package com.solvd.connectionpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.*;

public class ConnectionPool {

    private static final Logger log = LogManager.getLogger(ConnectionPool.class);;
    private static final int MAX_CONNECTIONS = 5;
    private static  ConnectionPool instance;
    private static BlockingQueue<Connection> connectionsPool = new ArrayBlockingQueue<>(MAX_CONNECTIONS);
    private String url;
    private String user;
    private String password;


    private ConnectionPool(String url, String user, String password){
        try {
            createConnection(url, user, password);
        } catch (SQLException throwables) {
            log.error(throwables);
        }
    }

    public static ConnectionPool getInstance(){
        if(instance == null){
            instance = new ConnectionPool(getInstance().getUrl(), getInstance().getUser(), getInstance().getPassword());
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
