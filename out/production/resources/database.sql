SELECT * FROM movie_database.movie;

SELECT * FROM movie_database.movie_type;

INSERT INTO  movie_database.movie_type ( movie_type_name)
VALUES ("Thriller");

DELETE FROM movie_database.movie
WHERE movie.id=2;

DELETE FROM movie_database.movie
WHERE movie.id=3;


ALTER TABLE movie_database.movie
ADD CONSTRAINT FK_MovieType
FOREIGN KEY (movie_type) REFERENCES movie_database.movie_type(id);


DROP TABLE movie_database.movie;

DROP TABLE movie_database.movie_type;

CREATE TABLE movie_database.movie_type(
  movie_type_id INT NOT NULL AUTO_INCREMENT,
  movie_type VARCHAR(255),
  created_date DATETIME,
  updated_date DATETIME,
  PRIMARY KEY (movie_type_id));

CREATE TABLE movie_database.movie(
  movie_id INT NOT NULL AUTO_INCREMENT,
  movie_name VARCHAR(255),
  movie_type_id INT NOT NULL,
  created_date DATETIME,
  updated_date DATETIME,
  PRIMARY KEY (movie_id),
  FOREIGN KEY (movie_type_id) REFERENCES movie_database.movie_type(movie_type_id)
);