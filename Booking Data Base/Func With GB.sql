SELECT count(capacity), capacity
FROM BookingSuarez.Plane
group by capacity;

SELECT count(current_price), current_price
FROM BookingSuarez.Room
group by current_price;

SELECT count(Travel_Company_idTravelCompany), idPlane
FROM BookingSuarez.Plane
group by idPlane;

SELECT count(monthly_price), monthly_price
FROM BookingSuarez.plan
group by monthly_price;

SELECT count(max_room), max_room
FROM BookingSuarez.plan
group by max_room;

SELECT count(total_price), total_price
FROM BookingSuarez.Reservation
group by total_price;

SELECT count(price), idRoom_Reserved
FROM BookingSuarez.Room_Reserved
group by idRoom_Reserved;

