

CREATE TABLE user(
  user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  active INT NOT NULL,
  email VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  first_name VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
)ENGINE = InnoDB;

CREATE TABLE role(
  role_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  role_name VARCHAR(255) NOT NULL
)ENGINE = InnoDB;

CREATE TABLE user_role(
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES user(user_id),
  FOREIGN KEY (role_id) REFERENCES role(role_id),

  UNIQUE (user_id,role_id)
)ENGINE = InnoDB;
