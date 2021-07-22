INSERT INTO mydb.company_plan (plan_idplan, Travel_Company_idTravelCompany) VALUES
((SELECT idplan FROM mydb.plan WHERE plan_name= "Summer Discount"),(SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Solvd")),
((SELECT idplan FROM mydb.plan WHERE plan_name= "Winter Discount"),(SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Quequen")),
((SELECT idplan FROM mydb.plan WHERE plan_name= "Easters Discount"),(SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Quequen")),
((SELECT idplan FROM mydb.plan WHERE plan_name= "New Year Discount"),(SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Solvd")),
((SELECT idplan FROM mydb.plan WHERE plan_name= "Chistmas Discount"),(SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Miami")),
((SELECT idplan FROM mydb.plan WHERE plan_name= "Autum Discount"),(SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel Miami")),
((SELECT idplan FROM mydb.plan WHERE plan_name= "Spring Discount"),(SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel LA")),
((SELECT idplan FROM mydb.plan WHERE plan_name= "Holiday Discount"),(SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel LA")),
((SELECT idplan FROM mydb.plan WHERE plan_name= "Thanks Giving Discount"),(SELECT idTravelCompany FROM mydb.Travel_Company WHERE company_name = "Travel LA"));

SELECT * FROM mydb.company_plan;