CREATE TABLE authors (
    id SERIAL NOT NULL PRIMARY KEY,
    name varchar(255) NOT NULL,
    surname varchar(255) NOT NULL,
);

ALTER TABLE articles ADD COLUMN author_id INT;
ALTER TABLE articles ADD FOREIGN KEY (author_id) REFERENCES authors(id);

INSERT INTO authors(name, surname) VALUES ('Default', 'Author');

UPDATE articles SET author_id = 1;

ALTER TABLE articles ALTER COLUMN author_id SET NOT NULL;