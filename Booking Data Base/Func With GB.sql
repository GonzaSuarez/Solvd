SELECT count(capacity), capacity
FROM mydb.Plane
group by capacity;

SELECT count(current_price), current_price
FROM mydb.Room
group by current_price;

SELECT count(Travel_Company_idTravelCompany), idPlane
FROM mydb.Plane
group by idPlane;

SELECT count(monthly_price), monthly_price
FROM mydb.plan
group by monthly_price;

SELECT count(max_room), max_room
FROM mydb.plan
group by max_room;

SELECT count(total_price), total_price
FROM mydb.Reservation
group by total_price;

SELECT count(price), idRoom_Reserved
FROM mydb.Room_Reserved
group by idRoom_Reserved;

