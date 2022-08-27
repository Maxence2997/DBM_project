CREATE USER 'projectManager'@'localhost' IDENTIFIED BY 'projectManager';

GRANT ALL PRIVILEGES ON * . * TO 'projectManager'@'localhost';

ALTER USER 'projectManager'@'localhost' IDENTIFIED WITH mysql_native_password BY 'projectManager';