CREATE TABLE `project` (
  `Project_ID` bigint unsigned NOT NULL AUTO_INCREMENT,
  `Emp_ID` bigint unsigned NOT NULL,
  `Established_date` varchar(255) NOT NULL,
  `Project_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Project_ID`),
  UNIQUE KEY `Project_ID_UNIQUE` (`Project_ID`),
  KEY `Emp_ID` (`Emp_ID`),
  CONSTRAINT `project_ibfk_1` FOREIGN KEY (`Emp_ID`) REFERENCES `employee` (`Emp_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=90000102 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
ALTER TABLE test.project ADD FOREIGN KEY (Emp_ID) REFERENCES employee(Emp_ID);
SELECT * FROM test.project;