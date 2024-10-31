INSERT INTO comment (id, comment, kodik_id, user_id, user_nickname, adding_time)
VALUES ('6cb321de-d6e3-46f3-993d-fe3f7f30d630', 'коммент 1', 'serial-0001', 'user', 'animeLover1', '2003-04-12 04:05:06'),
       ('6cb321de-d6e3-46f3-993d-fe3f7f30d632', 'коммент 3', 'serial-0001', 'user', 'animeLover1', '2022-04-12 04:05:06'),
       ('6cb321de-d6e3-46f3-993d-fe3f7f30d631', 'коммент 2', 'serial-0002', 'user', 'animeLover2', '2003-04-12 04:05:06');

INSERT INTO likes (id, comment_id, user_id)
VALUES ('263c6a56-4e35-42a1-8ada-9199c7c5fbc1', '6cb321de-d6e3-46f3-993d-fe3f7f30d630', 'user1'),
       ('263c6a56-4e35-42a1-8ada-9199c7c5fbc2', '6cb321de-d6e3-46f3-993d-fe3f7f30d630', 'user2'),
       ('263c6a56-4e35-42a1-8ada-9199c7c5fbc3', '6cb321de-d6e3-46f3-993d-fe3f7f30d630', 'user3'),
       ('263c6a56-4e35-42a1-8ada-9199c7c5fbc4', '6cb321de-d6e3-46f3-993d-fe3f7f30d631', 'user2');