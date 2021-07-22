INSERT INTO mydb.Room_Reserved(Room_idRoom,Reservation_idReservation) VALUE
((SELECT idRoom FROM mydb.Room WHERE room_name="Niken Single") , (SELECT idReservation FROM mydb.Reservation WHERE User_idUser = (SELECT idUser FROM mydb.User WHERE first_name = "Gonzalo" and last_name = "Suarez"))),
((SELECT idRoom FROM mydb.Room WHERE room_name="Niken Double") , (SELECT idReservation FROM mydb.Reservation WHERE User_idUser = (SELECT idUser FROM mydb.User WHERE first_name = "Gonzalo" and last_name = "Montiel"))),
((SELECT idRoom FROM mydb.Room WHERE room_name="Miami Presidential Suite") , (SELECT idReservation FROM mydb.Reservation WHERE User_idUser = (SELECT idUser FROM mydb.User WHERE first_name = "Lionel" and last_name = "Messi"))),
((SELECT idRoom FROM mydb.Room WHERE room_name="Real Triple") , (SELECT idReservation FROM mydb.Reservation WHERE User_idUser = (SELECT idUser FROM mydb.User WHERE first_name = "Lautaro" and last_name = "Martinez"))),
((SELECT idRoom FROM mydb.Room WHERE room_name="Real Quad") , (SELECT idReservation FROM mydb.Reservation WHERE User_idUser = (SELECT idUser FROM mydb.User WHERE first_name = "Angel" and last_name = "Di Maria"))),
((SELECT idRoom FROM mydb.Room WHERE room_name="Rio de Janeiro Queen") , (SELECT idReservation FROM mydb.Reservation WHERE User_idUser = (SELECT idUser FROM mydb.User WHERE first_name = "Emiliano" and last_name = "Martinez"))),
((SELECT idRoom FROM mydb.Room WHERE room_name="Rio de Janeiro King") , (SELECT idReservation FROM mydb.Reservation WHERE User_idUser = (SELECT idUser FROM mydb.User WHERE first_name = "Giovani" and last_name = "Lo Celso"))),
((SELECT idRoom FROM mydb.Room WHERE room_name="Brazilia Double-double") , (SELECT idReservation FROM mydb.Reservation WHERE User_idUser = (SELECT idUser FROM mydb.User WHERE first_name = "Nicolas" and last_name = "Otamendi"))),
((SELECT idRoom FROM mydb.Room WHERE room_name="Brazilia Suite") , (SELECT idReservation FROM mydb.Reservation WHERE User_idUser = (SELECT idUser FROM mydb.User WHERE first_name = "Rodrigo" and last_name = "De Paul"))),
((SELECT idRoom FROM mydb.Room WHERE room_name="Niken Single") , (SELECT idReservation FROM mydb.Reservation WHERE User_idUser = (SELECT idUser FROM mydb.User WHERE first_name = "Leandro" and last_name = "Paredes"))),
((SELECT idRoom FROM mydb.Room WHERE room_name="Niken Single") , (SELECT idReservation FROM mydb.Reservation WHERE User_idUser = (SELECT idUser FROM mydb.User WHERE first_name = "Mariano" and last_name = "Suarez"))),
((SELECT idRoom FROM mydb.Room WHERE room_name="Niken Double") , (SELECT idReservation FROM mydb.Reservation WHERE User_idUser = (SELECT idUser FROM mydb.User WHERE first_name = "Cristian" and last_name = "Romero"))),
((SELECT idRoom FROM mydb.Room WHERE room_name="Real Triple") , (SELECT idReservation FROM mydb.Reservation WHERE User_idUser = (SELECT idUser FROM mydb.User WHERE first_name = "Marcos" and last_name = "Acuna"))),
((SELECT idRoom FROM mydb.Room WHERE room_name="Real Quad") , (SELECT idReservation FROM mydb.Reservation WHERE User_idUser = (SELECT idUser FROM mydb.User WHERE first_name = "Richard" and last_name = "Rogers"))),
((SELECT idRoom FROM mydb.Room WHERE room_name="LA Cabin") , (SELECT idReservation FROM mydb.Reservation WHERE User_idUser = (SELECT idUser FROM mydb.User WHERE first_name = "Marrie" and last_name = "Anne")));
SELECT * FROM mydb.Room_Reserved;

