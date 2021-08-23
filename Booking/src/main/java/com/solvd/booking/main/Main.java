package com.solvd.booking.main;


import com.solvd.booking.connectionpool.ConnectionPool;
import com.solvd.booking.hotel.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {

    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException, SQLException, ClassNotFoundException, IOException, ParserConfigurationException, SAXException {

        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        mapper.setDateFormat(simpleDateFormat);
        List<User> us = mapper.readValue(new File("src/main/resources/JSON Files/user.json"), new TypeReference<List<User>>(){});
        for(User u : us){
            log.error(u.getId());
        }

    }

}
