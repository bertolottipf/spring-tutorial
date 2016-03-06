ALTER TABLE authors ADD COLUMN username varchar(30);
ALTER TABLE authors ADD COLUMN password varchar(30);

UPDATE authors SET username = 'admin', password = 'admin';
