

CREATE TABLE `employee` (
  `Emp_ID` bigint unsigned NOT NULL AUTO_INCREMENT,
  `First_name` varchar(255) NOT NULL,
  `Last_name` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Phone_number` varchar(255) NOT NULL,
  `Supervisor_ID` bigint unsigned DEFAULT NULL,
  `Performance` varchar(255) NOT NULL,
  PRIMARY KEY (`Emp_ID`),
  UNIQUE KEY `Emp_ID_UNIQUE` (`Emp_ID`),
  KEY `Supervisor_ID` (`Supervisor_ID`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`Supervisor_ID`) REFERENCES `EMPLOYEE` (`Emp_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11047655 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE test.EMPLOYEE ADD FOREIGN KEY (Supervisor_ID) REFERENCES EMPLOYEE(Emp_ID);
SELECT * FROM test.EMPLOYEE;