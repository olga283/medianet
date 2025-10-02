CREATE SEQUENCE IF NOT EXISTS profile_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 999999999
    NO CYCLE;

CREATE TABLE profile
(
    id          BIGINT PRIMARY KEY DEFAULT nextval('profile_seq'),
    user_id     VARCHAR(255) NOT NULL,
    first_name  VARCHAR(255) NOT NULL,
    second_name VARCHAR(255) NOT NULL,
    birthdate   DATE    NOT NULL,
    biography   TEXT,
    city        VARCHAR(255)
);