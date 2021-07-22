INSERT INTO mydb.Reservation (start_date, total_price, User_idUser) VALUES
(STR_TO_DATE("10,7,2021", "%d,%m,%Y"), 1000, (SELECT idUser FROM mydb.User WHERE first_name = "Gonzalo" and last_name = "Suarez")), 
(STR_TO_DATE("9,7,2021", "%d,%m,%Y"), 1000, (SELECT idUser FROM mydb.User WHERE first_name = "Gonzalo" and last_name = "Montiel")), 
(STR_TO_DATE("8,7,2021", "%d,%m,%Y"), 1000, (SELECT idUser FROM mydb.User WHERE first_name = "Lionel" and last_name = "Messi")), 
(STR_TO_DATE("7,7,2021", "%d,%m,%Y"), 1000, (SELECT idUser FROM mydb.User WHERE first_name = "Angel" and last_name = "Di Maria")), 
(STR_TO_DATE("6,7,2021", "%d,%m,%Y"), 1000, (SELECT idUser FROM mydb.User WHERE first_name = "Giovani" and last_name = "Lo Celso")), 
(STR_TO_DATE("5,7,2021", "%d,%m,%Y"), 1000, (SELECT idUser FROM mydb.User WHERE first_name = "Nicolas" and last_name = "Otamendi")), 
(STR_TO_DATE("4,7,2021", "%d,%m,%Y"), 1000, (SELECT idUser FROM mydb.User WHERE first_name = "Mariano" and last_name = "Suarez")), 
(STR_TO_DATE("3,7,2021", "%d,%m,%Y"), 1000, (SELECT idUser FROM mydb.User WHERE first_name = "Lautaro" and last_name = "Martinez")), 
(STR_TO_DATE("2,7,2021", "%d,%m,%Y"), 1000, (SELECT idUser FROM mydb.User WHERE first_name = "Emiliano" and last_name = "Martinez")), 
(STR_TO_DATE("1,7,2021", "%d,%m,%Y"), 1000, (SELECT idUser FROM mydb.User WHERE first_name = "Leandro" and last_name = "Paredes")), 
(STR_TO_DATE("11,7,2021", "%d,%m,%Y"), 1000, (SELECT idUser FROM mydb.User WHERE first_name = "Cristian" and last_name = "Romero")), 
(STR_TO_DATE("12,7,2021", "%d,%m,%Y"), 1000, (SELECT idUser FROM mydb.User WHERE first_name = "Marcos" and last_name = "Acuna")), 
(STR_TO_DATE("13,7,2021", "%d,%m,%Y"), 1000, (SELECT idUser FROM mydb.User WHERE first_name = "Richard" and last_name = "Rogers")), 
(STR_TO_DATE("14,7,2021", "%d,%m,%Y"), 1000, (SELECT idUser FROM mydb.User WHERE first_name = "Marrie" and last_name = "Anne")),
(STR_TO_DATE("14,7,2021", "%d,%m,%Y"), 1000, (SELECT idUser FROM mydb.User WHERE first_name = "Rodrigo" and last_name = "De Paul"));

SELECT * FROM mydb.Reservation;