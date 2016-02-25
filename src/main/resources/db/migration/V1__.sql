CREATE TABLE articles (
    id SERIAL NOT NULL PRIMARY KEY,
    title varchar(255) NOT NULL,
    summary varchar(5000),
    date timestamp
);