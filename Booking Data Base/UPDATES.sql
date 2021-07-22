SET SQL_SAFE_UPDATES = 0;

UPDATE  mydb.City
SET postal_code = 3076
WHERE city_name = "Necochea";

UPDATE  mydb.City
SET postal_code = 3176
WHERE city_name = "Quequen";

UPDATE mydb.Hotel
SET description = "Luxury Hotel near Nechochea's beach"
WHERE hotel_name = "Hotel Niken";

UPDATE mydb.Hotel
SET description = "Most iconic Hotel from Necochea"
WHERE hotel_name = "Hotel Real";

UPDATE mydb.plan
SET min_room = 1
WHERE plan_name = "Summer Discount";

UPDATE mydb.plan
SET details = "Time limited discount for Summer vacations"
WHERE plan_name = "Summer Discount";

UPDATE mydb.Plane
SET capacity = 400
WHERE idPlane = 1;

UPDATE mydb.Reservation
SET end_date = STR_TO_DATE("19,7,2021", "%d,%m,%Y")
WHERE idReservation = 1;

UPDATE mydb.Reservation
SET discount = 0.20
WHERE idReservation = 1;

UPDATE mydb.Reservation
SET total_price = total_price * discount
where idReservation=1;

UPDATE mydb.Room
SET description = "The most luxury room in the hotel, including free room service and minibar"
where room_name = "Presidential";

UPDATE mydb.Room
SET description = "A big room, with jacuzzi and balcony"
where room_name= "Suit";

UPDATE mydb.Room
SET description = "Most common room"
where room_name= "Marital";

UPDATE mydb.Travel_Company
SET email = "travelsolvd@gmail.com"
WHERE company_name = "Travel Solvd";

UPDATE mydb.User
SET last_name = "Suarez"
WHERE first_name = "Gonzalo";

SET SQL_SAFE_UPDATES = 1;