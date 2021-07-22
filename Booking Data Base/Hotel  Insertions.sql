INSERT INTO mydb.Hotel (hotel_name, City_idCity) VALUES
("Hotel Niken", (SELECT idCity FROM mydb.City WHERE city_name= "Necochea")),
("Hotel Real", (SELECT idCity FROM mydb.City WHERE city_name= "Necochea")),
("Hotel Rio de Janeiro", (SELECT idCity FROM mydb.City WHERE city_name= "Rio de Janeiro")),
("Hotel Brazilia", (SELECT idCity FROM mydb.City WHERE city_name= "Brazilia")),
("Hotel Miami", (SELECT idCity FROM mydb.City WHERE city_name= "Miami")),
("Hotel Los Angeles", (SELECT idCity FROM mydb.City WHERE city_name= "Los Angeles")),
("Hotel Santiago de Chile", (SELECT idCity FROM mydb.City WHERE city_name= "Santiago de Chile")),
("Hotel Montevideo", (SELECT idCity FROM mydb.City WHERE city_name= "Montevideo")),
("Hotel Lima", (SELECT idCity FROM mydb.City WHERE city_name= "Lima")),
("Hotel Bogota", (SELECT idCity FROM mydb.City WHERE city_name= "Bogota")),
("Hotel La Paz", (SELECT idCity FROM mydb.City WHERE city_name= "La Paz")),
("Hotel Quito", (SELECT idCity FROM mydb.City WHERE city_name= "Quito")),
("Hotel Caracas", (SELECT idCity FROM mydb.City WHERE city_name= "Caracas")),
("Hotel Mexico DC", (SELECT idCity FROM mydb.City WHERE city_name= "Mexico DC")),
("Hotel Ottawa", (SELECT idCity FROM mydb.City WHERE city_name= "Ottawa"));
SELECT * FROM mydb.Hotel;