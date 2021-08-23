package com.solvd.booking.connectionpool;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ConnectionPool {

    private static final Logger log = LogManager.getLogger(ConnectionPool.class);
    private static final int MAX_CONNECTIONS = 5;
    private static ConnectionPool instance;
    private static BlockingQueue<Connection> connectionsPool = new ArrayBlockingQueue<>(MAX_CONNECTIONS);
    private static String url;
    private static String user;
    private static String password;


    private ConnectionPool() throws ClassNotFoundException, IOException {
        Properties properties = new Properties();
        String dbSettingsPropertyFile = "src/main/resources/JDBCSettings.properties";
        FileReader fReader;
        try {
            fReader = new FileReader(dbSettingsPropertyFile);
            properties.load(fReader);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
        }

        String dbDriverClass = properties.getProperty("db.driver.class");

        url = properties.getProperty("db.conn.url");

        user = properties.getProperty("db.username");

        password = properties.getProperty("db.password");

        if (!"".equals(dbDriverClass) && !"".equals(url)) {
            Class.forName(dbDriverClass);

            for (int i = 0; i < MAX_CONNECTIONS; i++) {
                try {
                    connectionsPool.add(createConnection(url, user, password));
                } catch (SQLException e) {
                    log.error(e.getMessage());
                }
            }

        }
    }

    public static ConnectionPool getInstance() throws SQLException, ClassNotFoundException, IOException {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public Connection getConnection() {
        return connectionsPool.remove();
    }

    public void releaseConnection (Connection connection){
        connectionsPool.add(connection);
    }

    private static Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }


}


