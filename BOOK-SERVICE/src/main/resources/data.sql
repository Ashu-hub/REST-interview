DROP TABLE IF EXISTS book;
 
CREATE TABLE book (
  id INT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  author VARCHAR(100) NOT NULL,
  category VARCHAR(100) NOT NULL,
  description VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO book (id, name, author, category, description) VALUES
  (1, 'Two states', 'Chetan', 'Fiction', 'Love story'),
  (2, 'Midnights children', 'Chetan', 'Fiction', 'Love story'),
  (3, 'Alchemist', 'Chetan', 'Fiction', 'Love story');