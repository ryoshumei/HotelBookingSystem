# HotelBookingSystem

## 1. Environment
### IDE : Intellij idea 2022.1.1
### jdk 16.0.2.7-hotpot
### MySQL 8.0
### File Encoding : UTF-8

## 2. RUN

Make sure you have MySQL on your environment and import  my_hotel_guests.sql or my_hotel_blank_guests.sql
 to your MySQL . (my_hotel_guests.sql includes some test_data but my_hotel_blank_guests.sql doesn't. Both of them include "Create Schema "query)

Replace DATABASE Connection Information in src/DatabaseAccInfo.java. This includes "URL", "USERNAME" , "PASSWORD".
These information depend on your environment and which .sql file you imported.

Make sure "LGoodDatePicker-11.2.1.jar" and "mysql-connector-j-8.0.31.jar" have been added to your project Dependencies

Build and run Admin file which include main method.

## 3. Features

### Check room information by date

You can check room_information on the center and click a date from the Calendar on the right to check if rooms are Available.
![This is an image](/imgaes_for_README/feature1_1.png)

### Book a room with guest information 
Click an "Available room" to book a room.
![This is an image](/imgaes_for_README/feature2_1.png)

Enter guest information and click submit then the room will be booked and guest information will be added to the database.
![This is an image](/imgaes_for_README/feature2_2.png)

### Click a "X" room to check guest information
![This is an image](/imgaes_for_README/feature3_1.png)

### Delete guests who have canceled reservation.
Select a guest on the bottom list and click button "Delete". Then the guest will be deleted from the database and the GUI frame will show the latest information.


![This is an image](/imgaes_for_README/feature4_1.png)





