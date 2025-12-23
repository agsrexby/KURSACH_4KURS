-- Active: 1766495679616@@localhost@5432@computer
-- =========================
-- Очистка таблиц (если уже есть данные)
-- =========================
DELETE FROM bookings;
DELETE FROM computers;
DELETE FROM users;

-- =========================
-- Пользователи
-- =========================
INSERT INTO users (name, phone) VALUES
('Иван Иванов', '+7-900-111-11-11'),
('Петр Петров', '+7-900-222-22-22'),
('Алексей Смирнов', '+7-900-333-33-33');

-- =========================
-- Компьютеры
-- =========================
INSERT INTO computers (name, description, active) VALUES
('PC-1', 'Игровой компьютер (RTX 3060)', true),
('PC-2', 'Игровой компьютер (RTX 3070)', true),
('PC-3', 'Игровой компьютер (RTX 3080)', true),
('PC-4', 'Офисный компьютер', false);

-- =========================
-- Бронирования
-- =========================
INSERT INTO bookings (user_id, computer_id, start_time, end_time) VALUES
(1, 1, '2025-12-23 10:00:00', '2025-12-23 12:00:00'),
(2, 2, '2025-12-23 13:00:00', '2025-12-23 15:00:00'),
(3, 3, '2025-12-24 16:00:00', '2025-12-24 18:00:00');

-- =========================
-- Синхронизация sequence (ВАЖНО для PostgreSQL)
-- =========================
SELECT setval('users_id_seq', (SELECT MAX(id) FROM users));
SELECT setval('computers_id_seq', (SELECT MAX(id) FROM computers));
SELECT setval('bookings_id_seq', (SELECT MAX(id) FROM bookings));
