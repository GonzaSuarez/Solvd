INSERT INTO mydb.Travel_Company(company_name, City_idCity) VALUES
("Travel Solvd", (SELECT idCity FROM mydb.City WHERE city_name= "Necochea")),
("Travel Quequen", (SELECT idCity FROM mydb.City WHERE city_name= "Quequen")),
("Travel Rio", (SELECT idCity FROM mydb.City WHERE city_name= "Rio de Janeiro")),
("Travel Brazilia", (SELECT idCity FROM mydb.City WHERE city_name= "Brazilia")),
("Travel Miami", (SELECT idCity FROM mydb.City WHERE city_name= "Miami")),
("Travel LA", (SELECT idCity FROM mydb.City WHERE city_name= "Los Angeles")),
("Travel Montevideo", (SELECT idCity FROM mydb.City WHERE city_name= "Montevideo")),
("Travel Bogota", (SELECT idCity FROM mydb.City WHERE city_name= "Bogota")),
("Travel Lima", (SELECT idCity FROM mydb.City WHERE city_name= "Lima")),
("Travel Caracas", (SELECT idCity FROM mydb.City WHERE city_name= "Caracas")),
("Travel Chile", (SELECT idCity FROM mydb.City WHERE city_name= "Santiago de Chile")),
("Travel Ottawa", (SELECT idCity FROM mydb.City WHERE city_name= "Ottawa")),
("Travel Mexico", (SELECT idCity FROM mydb.City WHERE city_name= "Mexico DC")),
("Travel Paz", (SELECT idCity FROM mydb.City WHERE city_name= "La Paz")),
("Travel Quito", (SELECT idCity FROM mydb.City WHERE city_name= "Quito"));
SELECT * FROM mydb.Travel_Company;