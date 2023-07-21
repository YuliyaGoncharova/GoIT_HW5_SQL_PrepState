INSERT INTO worker (name, birthday, level, salary) 
VALUES 
('Anton Ivanchenko', '1977-12-17', 'Middle', 65700),
('Elen Kirilova', '1983-11-10', 'Middle', 19000),
('Anastasiya Nalyvayko', '1993-10-08', 'Senior', 76000),
('Yegor Gnedash', '2000-05-03', 'Senior', 100000),
('Weronika Kirilova', '1966-11-22', 'Trainee', 12899),
('Elzbeta Pyrek', '1983-11-23', 'Middle', 50000),
('Katrin Bocholnik', '1983-11-25', 'Junior', 21600),
('Nikita Vorchun', '1990-08-23', 'Middle', 59099),
('Albert Liutvort', '1992-11-23', 'Senior', 72345),
('Malgozhata Sygnarska', '1984-02-29', 'Senior', 78787),
('Erik Shabanov', '1972-11-12', 'Middle', 77777),
('Joanna Pietryk', '2002-12-10', 'Trainee', 100),
('Saveliy Zablotskyi', '1987-09-13', 'Senior', 99999),
('Aleksandra Gayduk', '1983-11-10', 'Middle', 55000),
('Elza Holovashchenko', '1984-11-10', 'Senior', 89000),
('Anton Bytko', '1978-06-17', 'Middle', 111),
('Anton Zbytko', '1999-06-17', 'Middle', 11111),
('Noname Noname', '1991-07-17', 'Junior', 900);


INSERT INTO client (name) 
VALUES 
('Ev'),
('Lorenco'),
('Grawe'),
('Piknik'),
('Spilka Pocinovuvachiv tvorchosti Liudmyly Gorovoi'),
('Star Broker, LLC'),
('Rocket'),
('Oleksandr Fomenko');


INSERT INTO project (client_id, start_date, finish_date) 
VALUES 
(8,'2023-02-21', '2023-10-21'),
(3,'2022-07-22', '2022-08-22'),
(7,'2021-12-26', '2022-06-26'),
(3,'2021-05-02', '2021-11-02'),
(2,'2021-10-06', '2022-06-06'),
(4,'2023-01-24', '2023-03-24'),
(5,'2021-05-20', '2021-12-24'),
(6,'2022-06-12', '2022-12-12'),
(5,'2023-04-18', '2023-08-20'),
(4,'2022-08-13', '2023-01-15'),
(6,'2022-08-04', '2023-01-14'),
(1,'2017-02-24', '2025-06-23');



INSERT INTO project_worker (project_id, worker_id) 
VALUES 
(10, 4),
(1, 1),
(1, 2),
(1, 17),
(1, 18),
(9, 12),
(2, 3),
(3, 1),
(3, 11),
(4, 15),
(6, 3),
(4, 10),
(5, 16),
(6, 6),
(7, 17), 
(7, 12), 
(7, 7),
(8, 7),
(9, 14),
(9, 8),
(11, 9),
(4, 5),
(11, 18),
(12, 13),
(1, 4);
