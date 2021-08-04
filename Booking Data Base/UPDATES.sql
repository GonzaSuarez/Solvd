SET SQL_SAFE_UPDATES = 0;

UPDATE  BookingSuarez.City
SET postal_code = 3076
WHERE city_name = "Necochea";

UPDATE  BookingSuarez.City
SET postal_code = 3176
WHERE city_name = "Quequen";

UPDATE BookingSuarez.Hotel
SET description = "Luxury Hotel near Nechochea's beach"
WHERE hotel_name = "Hotel Niken";

UPDATE BookingSuarez.Hotel
SET description = "Most iconic Hotel from Necochea"
WHERE hotel_name = "Hotel Real";

UPDATE BookingSuarez.plan
SET min_room = 1
WHERE plan_name = "Summer Discount";

UPDATE BookingSuarez.plan
SET details = "Time limited discount for Summer vacations"
WHERE plan_name = "Summer Discount";

UPDATE BookingSuarez.Plane
SET capacity = 400
WHERE idPlane = 1;

UPDATE BookingSuarez.Reservation
SET end_date = STR_TO_DATE("19,7,2021", "%d,%m,%Y")
WHERE idReservation = 1;

UPDATE BookingSuarez.Reservation
SET discount = 0.20
WHERE idReservation = 1;

UPDATE BookingSuarez.Reservation
SET total_price = total_price * discount
where idReservation=1;

UPDATE BookingSuarez.Room
SET description = "The most luxury room in the hotel, including free room service and minibar"
where room_name = "Presidential";

UPDATE BookingSuarez.Room
SET description = "A big room, with jacuzzi and balcony"
where room_name= "Suit";

UPDATE BookingSuarez.Room
SET description = "Most common room"
where room_name= "Marital";

UPDATE BookingSuarez.Travel_Company
SET email = "travelsolvd@gmail.com"
WHERE company_name = "Travel Solvd";

UPDATE BookingSuarez.User
SET last_name = "Suarez"
WHERE first_name = "Gonzalo";

SET SQL_SAFE_UPDATES = 1;