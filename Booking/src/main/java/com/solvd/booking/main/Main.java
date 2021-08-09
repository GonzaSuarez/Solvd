package com.solvd.booking.main;

import com.solvd.booking.dao.mysqldao.jbdc.UserDAO;
import com.solvd.booking.hotel.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        UserDAO userDAO = new UserDAO();
        User user = new User();
        try {
             user = userDAO.getItemById(1);
        } catch (InterruptedException e) {
            log.error(e);
        }
        log.info(user.getId());
    }

}
