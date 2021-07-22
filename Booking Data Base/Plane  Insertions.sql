INSERT INTO mydb.Plane(capacity,Travel_Company_idTravelCompany) VALUES
(200, (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Solvd")),
(300, (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Solvd")),
(200, (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Quequen")),
(300, (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Quequen")),
(200, (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Miami")),
(300, (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Miami")),
(200, (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel LA")),
(300, (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel LA")),
(200, (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Brazilia")),
(300, (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Brazilia")),
(200, (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Montevideo")),
(300, (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Montevideo")),
(200, (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Ottawa")),
(200, (SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Ottawa"));
SELECT * FROM mydb.Plane;