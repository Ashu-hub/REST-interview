DROP TABLE IF EXISTS user;
 
CREATE TABLE User (
  id INT  PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(150) NOT NULL ,
  mobile VARCHAR(10) NOT NULL
);
 
INSERT INTO User (id, name, email, mobile) VALUES
  (1, 'Ashutosh', 'Ashutosh_ranjan@epam.com', '2087305215'),
  (2, 'Yuvraj', 'yuvraj_singh@epam.com', '2888888888');