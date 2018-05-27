CREATE TABLE t_role (
  id          INT(11)     NOT NULL AUTO_INCREMENT,
  role_name   VARCHAR(60) NOT NULL,
  create_data DATETIME    NOT NULL DEFAULT current_timestamp,
  note        VARCHAR(512)         DEFAULT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE t_user (
  id INT(11) NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(60) NOT NULL,
  birthday DATE NOT NULL,
  sex VARCHAR(2) NOT NULL,
  mobile VARCHAR(20) NOT NULL,
  email VARCHAR(60) DEFAULT NULL,
  note VARCHAR(512) DEFAULT NULL,
  PRIMARY KEY (id)
);
