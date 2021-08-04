SELECT count(capacity), capacity
FROM BookingSuarez.Plane
group by capacity
having capacity > 200;

SELECT count(current_price), current_price
FROM BookingSuarez.Room
group by current_price
having current_price < 1000;

SELECT count(Travel_Company_idTravelCompany), idPlane
FROM BookingSuarez.Plane
group by idPlane
having idPlane = 2;

SELECT count(monthly_price), monthly_price
FROM BookingSuarez.plan
group by monthly_price
having monthly_price = 500;

SELECT count(max_room), max_room
FROM BookingSuarez.plan
group by max_room
having max_room > 2;

SELECT count(total_price), total_price
FROM BookingSuarez.Reservation
group by total_price
having total_price = 1000;

SELECT count(price), idRoom_Reserved
FROM BookingSuarez.Room_Reserved
group by idRoom_Reserved
having idRoom_Reserved != 0;

