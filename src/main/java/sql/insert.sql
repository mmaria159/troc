INSERT INTO users
VALUES (1, '2019-07-12 03:00:00.000000', 'maria1@gmail.com', 'user1', 'f', 'userov1',
        '$2a$12$2W6jS9fT2s1KodsFwDadMO/luhIqvSoHxw4RUTuFGk6HuN7ktdMYm', 'user1', 2),
       (2, '2019-07-12 03:00:00.000000', 'maria2@gmail.com', 'user2', 'f', 'userov2',
        '$2a$12$2W6jS9fT2s1KodsFwDadMO/luhIqvSoHxw4RUTuFGk6HuN7ktdMYm', 'user2', 1),
       (3, '2019-07-12 03:00:00.000000', 'maria3@gmail.com', 'user3', 'f', 'userov3',
        '$2a$12$2W6jS9fT2s1KodsFwDadMO/luhIqvSoHxw4RUTuFGk6HuN7ktdMYm', 'user3', 5),
       (4, '2019-07-12 03:00:00.000000', 'maria4@gmail.com', 'user4', 'f', 'userov4',
        '$2a$12$2W6jS9fT2s1KodsFwDadMO/luhIqvSoHxw4RUTuFGk6HuN7ktdMYm', 'user4', 3),
       (5, '2019-07-12 03:00:00.000000', 'maria5@gmail.com', 'user5', 'f', 'userov5',
        '$2a$12$2W6jS9fT2s1KodsFwDadMO/luhIqvSoHxw4RUTuFGk6HuN7ktdMYm', 'user5', 4);

INSERT INTO products
VALUES (1, '2019-07-12 03:00:00.000000', '2019-07-12 03:00:00.000000', 'description1', 'name1', null, 1),
       (2, '2019-07-12 03:00:00.000000', '2019-07-12 03:00:00.000000', 'description2', 'name2', null, 2),
       (3, '2019-07-12 03:00:00.000000', '2019-07-12 03:00:00.000000', 'description3', 'name3', null, 3),
       (4, '2019-07-12 03:00:00.000000', '2019-07-12 03:00:00.000000', 'description4', 'name4', null, 4),
       (5, '2019-07-12 03:00:00.000000', '2019-07-12 03:00:00.000000', 'description5', 'name5', null, 5);

INSERT INTO contacts
VALUES (1, 'maria@gmail.com', 'facebook1', 11111, 1),
       (2, 'ion@gmail.com', 'facebook2', 22222, 2),
       (3, 'vania@gmail.com', 'facebook3', 33333, 3),
       (4, 'elena@gmail.com', 'facebook4', 44444, 4),
       (5, 'diia@gmail.com', 'facebook5', 55555, 3);

INSERT INTO address
VALUES (1, 'MD', 200, 'Crangului', 200, 'Chisinau', 'Chisinau'),
       (2, 'MD', 200, 'Crangului', 200, 'Chisinau', 'Chisinau'),
       (3, 'MD', 200, 'Crangului', 200, 'Chisinau', 'Chisinau'),
       (4, 'MD', 200, 'Crangului', 200, 'Chisinau', 'Chisinau'),
       (5, 'MD', 200, 'Crangului', 200, 'Chisinau', 'Chisinau');

INSERT INTO roles
VALUES (1, 'ROLE_USER'),
       (2, 'ROLE_ADMIN');

INSERT INTO user_roles
VALUES (1, 2),
       (2, 2),
       (3, 2),
       (4, 2),
       (5, 2);

INSERT INTO categories
VALUES (1, 'JUCARII'),
       (2, 'CARTI'),
       (3, 'HAINE'),
       (4, 'INCALTAMINTE'),
       (5, 'MOBILIER'),
       (6, 'SPORT'),
       (7, 'ACCESORII'),
       (8, 'INSTRUMENTE_MUZICALE'),
       (9, 'JOCURI_VIDEO');

INSERT INTO regions
VALUES  (1, 'CHISINAU'),
        (2, 'ANENII_NOI'),
        (3, 'BASARABEASCA'),
        (4, 'BRICENI'),
        (5, 'CAHUL'),
        (6, 'CANTEMIR'),
        (7, 'CALARASI'),
        (8, 'CAUSENI'),
        (9, 'CIMISLIA'),
        (10, 'CRIULENI'),
        (11, 'DONDUSENI'),
        (12, 'DROCHIA'),
        (13, 'DUBASARI'),
        (14, 'EDINET'),
        (15, 'FALESTI'),
        (16, 'FLORESTI'),
        (17, 'GLODENI'),
        (18, 'HINCESTI'),
        (19, 'IALOVENI'),
        (20, 'LEOVA'),
        (21, 'NISPORENI'),
        (22, 'OCNITA'),
        (23, 'ORHEI'),
        (24, 'REZINA'),
        (25, 'RISCANI'),
        (26, 'SINGEREI'),
        (27, 'SOROCA'),
        (28, 'STRASENI'),
        (29, 'SOLDANESTI'),
        (30, 'STEFAN_VODA'),
        (31, 'TARACLIA'),
        (32, 'TELENESTI'),
        (33, 'UNGHENI');