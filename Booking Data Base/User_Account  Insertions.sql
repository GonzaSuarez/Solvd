INSERT INTO mydb.User_Account(first_name, user_name, password, Travel_Company_idTravelCompany) VALUES
("Gonzalo", "GonzaSuarez", "password", (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Solvd")),
("Mariano", "MSuarez", "password", (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Quequen")),
("Richard", "RRogers", "password", (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Rio")),
("Marrie", "Anne", "MAnne", (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Brazilia")),
("Angel", "Di Maria", "ADMaria", (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Miami")),
("Lionel", "Messi", "TheGOAT", (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Montevideo")),
("Rodrigo", "De Paul", "RDPaul", (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Bogota")),
("Emiliano", "Martinez", "EMartinez", (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Lima")),
("Lautaro", "Martinez", "LMartinez", (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Caracas")),
("Leandro", "Paredes", "LParedes", (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Chile")),
("Giovani", "Lo Celso", "GLCelso", (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Ottawa")),
("Nicolas", "Otamendi", "NOtamendi", (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Mexico")),
("Gonzalo", "Montiel", "GMontiel", (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Paz")),
("Cristian", "Romero", "CRomero", (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Quito"));
SELECT * from mydb.User_Account;