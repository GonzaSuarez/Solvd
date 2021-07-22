INSERT INTO mydb.City (city_name, postal_code, Country_idCountry) VALUES
("Necochea", 7630, (SELECT idCountry FROM mydb.Country WHERE country_name = "Argentina")),
("Quequen", 7631, (SELECT idCountry FROM mydb.Country WHERE country_name = "Argentina")),
("Rio de Janeiro", 22050000, (SELECT idCountry FROM mydb.Country WHERE country_name = "Brazil")),
("Brazilia", 70040, (SELECT idCountry FROM mydb.Country WHERE country_name = "Brazil")),
("Miami", 33101, (SELECT idCountry FROM mydb.Country WHERE country_name = "USA")),
("Los Angeles", 90001, (SELECT idCountry FROM mydb.Country WHERE country_name = "USA")),
("Santiago de Chile", 1030000, (SELECT idCountry FROM mydb.Country WHERE country_name = "Chile")),
("Montevideo", 10129, (SELECT idCountry FROM mydb.Country WHERE country_name = "Uruguay")),
("Lima", 07001, (SELECT idCountry FROM mydb.Country WHERE country_name = "Peru")),
("Bogota", 110111, (SELECT idCountry FROM mydb.Country WHERE country_name = "Colombia")),
("La Paz", 02010220, (SELECT idCountry FROM mydb.Country WHERE country_name = "Bolivia")),
("Quito", 170102, (SELECT idCountry FROM mydb.Country WHERE country_name = "Ecuador")),
("Caracas", 1000, (SELECT idCountry FROM mydb.Country WHERE country_name = "Venezuela")),
("Mexico DC", 00810, (SELECT idCountry FROM mydb.Country WHERE country_name = "Mexico")),
("Ottawa", 19441, (SELECT idCountry FROM mydb.Country WHERE country_name = "Canada"));
SELECT * FROM mydb.City;