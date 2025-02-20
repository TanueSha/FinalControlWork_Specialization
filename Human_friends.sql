-- 1. Создание базы данных
CREATE DATABASE IF NOT EXISTS `Human_Friends`;
USE `Human_Friends`;

-- 2. Создание таблиц для домашних животных (Pets)
CREATE TABLE Pets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    birth_date DATE,
    type ENUM('Dog', 'Cat', 'Hamster'),
    commands TEXT
);

-- 3. Создание таблиц для вьючных животных (Pack_Animals)
CREATE TABLE Pack_Animals (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    birth_date DATE,
    type ENUM('Horse', 'Camel', 'Donkey'),
    commands TEXT
);

-- 4. Заполнение таблиц данными
INSERT INTO Pets (name, birth_date, type, commands) VALUES
('Барсик', '2022-03-15', 'Cat', 'Сидеть'),
('Шарик', '2021-06-10', 'Dog', 'Голос, Лежать'),
('Пушистик', '2023-01-20', 'Hamster', 'Бегать по кругу');

INSERT INTO Pack_Animals (name, birth_date, type, commands) VALUES
('Буцефал', '2020-05-02', 'Horse', 'Бег, Прыжок'),
('Гоби', '2019-08-30', 'Camel', 'Идти'),
('Иа', '2021-02-11', 'Donkey', 'Нести груз');

-- 5. Удаление записей о верблюдах
DELETE FROM Pack_Animals WHERE type = 'Camel';

-- 6. Объединение таблиц лошадей и ослов в одну
CREATE TABLE Horses_Donkeys AS
SELECT * FROM Pack_Animals WHERE type IN ('Horse', 'Donkey');

-- 7. Создание новой таблицы для животных 1-3 лет и расчет их возраста
CREATE TABLE Young_Animals AS
SELECT id, name, birth_date, type, TIMESTAMPDIFF(MONTH, birth_date, CURDATE()) AS age_months 
FROM (
    SELECT * FROM Pets
    UNION ALL
    SELECT * FROM Horses_Donkeys
) AS all_animals
WHERE TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) BETWEEN 1 AND 3;

-- 8. Объединение всех таблиц в одну с указанием источника
CREATE TABLE All_Animals AS
SELECT id, name, birth_date, type, commands, 'Pets' AS source FROM Pets
UNION ALL
SELECT id, name, birth_date, type, commands, 'Horses_Donkeys' AS source FROM Horses_Donkeys;
