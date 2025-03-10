-- Sample Data for Users
INSERT INTO users (name, email, phone, password, role) VALUES
('Alice Johnson', 'alice@example.com', '1234567890', 'password123', 'customer'),
('Bob Smith', 'bob@example.com', '9876543210', 'securepass', 'admin'),
('Charlie Brown', 'charlie@example.com', '1122334455', 'charliepass', 'customer'),
('David Wilson', 'david@example.com', '2233445566', 'davidpass', 'customer'),
('Emma Davis', 'emma@example.com', '3344556677', 'emmapass', 'customer'),
('Frank Miller', 'frank@example.com', '4455667788', 'frankpass', 'admin'),
('Grace Lee', 'grace@example.com', '5566778899', 'gracepass', 'customer');

-- Sample Data for Cars
INSERT INTO cars (brand, model, year, type, price_per_hour, price_per_day, price_per_week, fuel_type, transmission) VALUES
('Toyota', 'Camry', 2022, 'Sedan', 15.00, 100.00, 600.00, 'Petrol', 'Automatic'),
('Ford', 'Explorer', 2021, 'SUV', 20.00, 120.00, 750.00, 'Diesel', 'Automatic'),
('Honda', 'Civic', 2023, 'Sedan', 14.00, 90.00, 550.00, 'Hybrid', 'Manual'),
('Tesla', 'Model 3', 2022, 'Sedan', 25.00, 150.00, 900.00, 'Electric', 'Automatic'),
('Harley-Davidson', 'Street 750', 2020, 'TwoWheeler', 10.00, 60.00, 350.00, 'Petrol', 'Manual'),
('BMW', 'Z4', 2021, 'Convertible', 30.00, 200.00, 1200.00, 'Petrol', 'Automatic'),
('Chevrolet', 'Silverado', 2020, 'Truck', 22.00, 140.00, 850.00, 'Diesel', 'Manual');

-- Sample Data for Reservations
INSERT INTO reservations (user_id, car_id, start_datetime, end_datetime, status, total_price) VALUES
(1, 1, '2025-03-10 09:00:00', '2025-03-12 18:00:00', 'Confirmed', 200.00),
(2, 2, '2025-03-15 10:00:00', '2025-03-18 20:00:00', 'Pending', 360.00),
(3, 3, '2025-04-01 12:00:00', '2025-04-05 14:00:00', 'Cancelled', 0.00),
(4, 4, '2025-04-10 08:00:00', '2025-04-12 16:00:00', 'Completed', 300.00),
(5, 5, '2025-04-15 09:30:00', '2025-04-17 19:00:00', 'Confirmed', 120.00),
(6, 6, '2025-05-01 07:00:00', '2025-05-03 20:00:00', 'Pending', 400.00),
(7, 7, '2025-05-05 10:30:00', '2025-05-07 18:30:00', 'Completed', 280.00);

-- Sample Data for Payments
INSERT INTO payments (user_id, reservation_id, amount, payment_method, payment_status, transaction_id) VALUES
(1, 1, 200.00, 'Credit Card', 'Completed', 'TXN0001A'),
(2, 2, 360.00, 'Google Pay', 'Pending', 'TXN0002B'),
(3, 3, 0.00, 'UPI', 'Failed', NULL),
(4, 4, 300.00, 'PayPal', 'Completed', 'TXN0003C'),
(5, 5, 120.00, 'Debit Card', 'Completed', 'TXN0004D'),
(6, 6, 400.00, 'Razorpay', 'Pending', 'TXN0005E'),
(7, 7, 280.00, 'Stripe', 'Completed', 'TXN0006F');
