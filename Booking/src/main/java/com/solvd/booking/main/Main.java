package com.solvd.booking.main;


import com.solvd.booking.hotel.*;
import com.solvd.booking.parsers.xml.*;
import com.solvd.booking.places.City;
import com.solvd.booking.places.Country;
import com.solvd.booking.travelcompany.*;
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

        RoomParser roomParser = new RoomParser();
        roomParser.serializeFile(rooms);

        List<Reservation> reservations = new ArrayList<>();
        Reservation reservation1 = new Reservation(1, 200, new User(1, "John", "john@gmail.com"));
        Reservation reservation2 = new Reservation(2, 200, new User(1, "Mike", "mike@gmail.com"));
        reservations.add(reservation1); reservations.add(reservation2);
        ReservationParser reservationParser = new ReservationParser();
        reservationParser.serializeFile(reservations);

        List<RoomReserved> roomReserveds = new ArrayList<>();
        RoomReserved roomReserved1 = new RoomReserved(1,1,1);
        RoomReserved roomReserved2 = new RoomReserved(2,2,2);
        roomReserveds.add(roomReserved1); roomReserveds.add(roomReserved2);
        RoomReservedParser roomReservedParser = new RoomReservedParser();
        roomReservedParser.serializeFile(roomReserveds);

        List<User> users = new ArrayList<>();
        User user1 = new User(1,"John", "john@gmail.com");
        User user2 = new User(1,"Mike", "mike@gmail.com");
        users.add(user1); users.add(user2);
        UserParser userParser = new UserParser();
        userParser.serializeFile(users);

        List<City> cities = new ArrayList<>();
        City city1 = new City(1,"quequen", "7631");
        City city2 = new City(2,"necochea", "7630");
        cities.add(city1); cities.add(city2);
        CityParser cityParser = new CityParser();
        cityParser.serializeFile(cities);

        List<Country> countries = new ArrayList<>();
        Country country1 = new Country(1, "Argentina");
        Country country2 = new Country(2, "USA");
        countries.add(country1);countries.add(country2);
        CountryParser countryParser = new CountryParser();
        countryParser.serializeFile(countries);

        List<CompanyPlan> companyPlans = new ArrayList<>();
        CompanyPlan companyPlan = new CompanyPlan(1, 1, 1);
        CompanyPlan companyPlan1 = new CompanyPlan(2,2,2);
        companyPlans.add(companyPlan); companyPlans.add(companyPlan1);
        CompanyPlanParser companyPlanParser = new CompanyPlanParser();
        companyPlanParser.serializeFile(companyPlans);

        List<Plan> plans = new ArrayList<>();
        Plan plan = new Plan(1, "summer", 1, 4);
        Plan plan1 = new Plan(2, "winter", 1, 4);
        plans.add(plan); plans.add(plan1);
        PlanParser planParser = new PlanParser();
        planParser.serializeFile(plans);

        List<Plane> planes = new ArrayList<>();
        Plane plane = new Plane(1, 1, 1);
        Plane plane1 = new Plane(2,  2, 2);
        plans.add(plan); plans.add(plan1);
        PlaneParser planeParser = new PlaneParser();
        planeParser.serializeFile(planes);

        List<TravelCompany> travelCompanies = new ArrayList<>();
        TravelCompany travelCompany = new TravelCompany(1, "Quequen Co.", city1);
        TravelCompany travelCompany1 = new TravelCompany(2, "Necochea CO.", city2);
        travelCompanies.add(travelCompany); travelCompanies.add(travelCompany1);
        TravelCompanyParser travelCompanyParser = new TravelCompanyParser();
        travelCompanyParser.serializeFile(travelCompanies);

        List<UserAccount> userAccounts = new ArrayList<>();
        UserAccount userAccount = new UserAccount(1, "john", "john");
        UserAccount userAccount1 = new UserAccount(2, "mark", "mark");
        userAccounts.add(userAccount); userAccounts.add(userAccount1);
        UserAccountParser userAccountParser = new UserAccountParser();
        userAccountParser.serializeFile(userAccounts);
    }

}
