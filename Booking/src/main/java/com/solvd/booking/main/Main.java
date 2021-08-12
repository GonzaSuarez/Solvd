package com.solvd.booking.main;


import com.solvd.booking.hotel.Hotel;
import com.solvd.booking.hotel.Room;
import com.solvd.booking.xmlparser.HotelParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException, SQLException, ClassNotFoundException, IOException, ParserConfigurationException, SAXException {
        List<Hotel> hotels = new ArrayList<>();
        Hotel hotel = new Hotel(1, "hotel", 1);
        Hotel hotel2 = new Hotel(2, "hotel2", 1);
        hotels.add(hotel);
        hotels.add(hotel2);
        List<Room> rooms = new ArrayList<>();
        Room room1 = new Room(1, "room1", 1);
        Room room2 = new Room(2, "room2", 1);
        Room room3 = new Room(3, "room3", 1);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        hotel.setRooms(rooms);
        hotel2.setRooms(rooms);
        hotel.setDescription("description");
        HotelParser hotelParser = new HotelParser();
        hotelParser.serializeFile(hotels);

        hotels = hotelParser.deserializeFile(new File("src/main/resources/hotel.xml"));
        for (Hotel h: hotels) {
            log.info(h.getId());
            log.info(h.getName());
        }
    }

}
