CREATE TABLE tags (
    id SERIAL NOT NULL PRIMARY KEY,
    name varchar(255) NOT NULL
);

CREATE TABLE articles_tags(
  articles_id INT NOT NULL REFERENCES articles(id),
  tags_id INT NOT NULL REFERENCES tags(id)
);
