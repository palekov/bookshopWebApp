INSERT INTO USERS (name, address, email, phone, role_id, login, password) VALUES
     ('Alex','Minsk,Pobediteley,100','alex_mail@gmail.com','+375351234567',1, 'admin','admin'),
     ('Ivan','Pinsk,Lenina, 55','ivan_mail@yahoo.com','+375255175050',2, 'manager','manna'),
     ('Vasya','Brest,Nezavisimosti, 4','vasya_mail@yandex.com','+375297101020',3, 'customer','vasya_custom'),
     ('Katya','Ushachi,Glavnaya, 1','katya_mail@yandex.com','+375297165678',3, 'customer','katya_custom'),
     ('Dima','Nosachi,Pervaya, 2','dima_mail@yandex.com','+375293555765',3, 'customer','dima_custom');

INSERT INTO BOOKINGS (user_id, product_id, delivery_address, delivery_date, delivery_time, status_id, quantity) VALUES
    (3, 1, 'Delivery address 1', '2023-02-10', '13:05:00', 1, 2 ),
    (4, 2, 'Delivery address 2', '2023-02-12', '10:00:00', 3, 1 ),
    (5, 3, 'Delivery address 3', '2023-02-15', '17:15:00', 5, 3 ),
    (1, 2, 'Delivery address 4', '2023-02-17', '18:30:00', 2, 1 ),
    (2, 3, 'Delivery address 5', '2023-02-20', '19:25:00', 4, 1 );

INSERT INTO PRODUCTS (name, description, author, price, image_path) VALUES
    ('Java 8', 'Book about programming on Java 8', 'Shildt', 57, 'image1.jpg'),
    ('Head fist Andriod', 'Android in 10 steps', 'Blokh', 35, 'image2.jpg'),
    ('Kotlin in action', 'Very interesting book', 'Motlin', 76, 'image3.jpg');

INSERT INTO BOOK_STORE (product_id, available_qty, booked_qty, sold_qty) VALUES
    (1, 5, 3, 2),
    (2, 12, 5, 7),
    (3, 8, 2, 2);

INSERT INTO BOOKING_STATUS (status_id, name) VALUES
    (1, 'SUBMITTED'),
    (2, 'REJECTED'),
    (3, 'APPROVED'),
    (4, 'CANCELLED'),
    (5, 'IN_DELIVERY');

INSERT INTO ROLES (role_id, name) VALUES
    (1, 'ADMIN'),
    (2, 'MANAGER'),
    (3, 'CUSTOMER');

