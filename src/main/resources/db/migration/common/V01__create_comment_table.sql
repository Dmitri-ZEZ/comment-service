CREATE TABLE comment(
    id uuid,
    comment varchar(500),
    kodik_id varchar,
    user_id varchar,
    user_nickname varchar(50),
    user_avatar varchar(1000),
    adding_time timestamp
);