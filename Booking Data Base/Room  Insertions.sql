INSERT INTO mydb.Room (room_name, current_price, Hotel_idHotel, Room_Type_idRoom_Type) VALUES
    ( "Niken Single", 100, (SELECT idHotel FROM mydb.Hotel WHERE hotel_name= "Hotel Niken"), (SELECT idRoom_Type FROM mydb.Room_Type WHERE type_name= "Single")), 
    ( "Niken Double", 200, (SELECT idHotel FROM mydb.Hotel WHERE hotel_name= "Hotel Niken"), (SELECT idRoom_Type FROM mydb.Room_Type WHERE type_name= "Double")),
    ( "Real Triple", 300, (SELECT idHotel FROM mydb.Hotel WHERE hotel_name= "Hotel Real"), (SELECT idRoom_Type FROM mydb.Room_Type WHERE type_name= "Triple")),
    ( "Real Quad", 400, (SELECT idHotel FROM mydb.Hotel WHERE hotel_name= "Hotel Real"), (SELECT idRoom_Type FROM mydb.Room_Type WHERE type_name= "Quad")),
    ( "Rio de Janeiro Queen", 500, (SELECT idHotel FROM mydb.Hotel WHERE hotel_name= "Hotel Rio de Janeiro"), (SELECT idRoom_Type FROM mydb.Room_Type WHERE type_name= "Queen")),
    ( "Rio de Janeiro King", 600, (SELECT idHotel FROM mydb.Hotel WHERE hotel_name= "Hotel Rio de Janeiro"), (SELECT idRoom_Type FROM mydb.Room_Type WHERE type_name= "King")),
    ( "Brazilia Double-double", 700, (SELECT idHotel FROM mydb.Hotel WHERE hotel_name= "Hotel Brazilia"), (SELECT idRoom_Type FROM mydb.Room_Type WHERE type_name= "Double-double")),
    ( "Brazilia Suite", 800, (SELECT idHotel FROM mydb.Hotel WHERE hotel_name= "Hotel Brazilia"), (SELECT idRoom_Type FROM mydb.Room_Type WHERE type_name= "Suite")),
    ( "Miami Executive Suite", 900, (SELECT idHotel FROM mydb.Hotel WHERE hotel_name= "Hotel Miami"), (SELECT idRoom_Type FROM mydb.Room_Type WHERE type_name= "Executive Suite")),
    ( "Miami Presidential Suite",1000, (SELECT idHotel FROM mydb.Hotel WHERE hotel_name= "Hotel Miami"), (SELECT idRoom_Type FROM mydb.Room_Type WHERE type_name= "Presidential Suite")),
    ( "LA Apartment", 1100, (SELECT idHotel FROM mydb.Hotel WHERE hotel_name= "Hotel Los Angeles"), (SELECT idRoom_Type FROM mydb.Room_Type WHERE type_name= "Apartment")),
    ( "LA Cabin", 1200, (SELECT idHotel FROM mydb.Hotel WHERE hotel_name= "Hotel Los Angeles"), (SELECT idRoom_Type FROM mydb.Room_Type WHERE type_name= "Cabin"));
SELECT * FROM mydb.Room;