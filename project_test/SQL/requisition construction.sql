CREATE TABLE `REQUISITION` (
  `REQ_Sheet_ID` bigint unsigned NOT NULL AUTO_INCREMENT,
  `Sheet_type` varchar(255) NOT NULL,
  `Project_ID` bigint unsigned NOT NULL,
  `Inquiring_product` varchar(255) NOT NULL,
  `Item_name` varchar(255) NOT NULL,
  `Vol` int unsigned NOT NULL,
  `Unit_price` int unsigned NOT NULL,
  `Total_price` int GENERATED ALWAYS AS ((`Vol` * `Unit_price`)) VIRTUAL,
  `Signature` varchar(255) NOT NULL DEFAULT 'False',
  `Supervisor_ID` bigint unsigned NOT NULL,
  `Date` date NOT NULL DEFAULT (date_format(curdate(),_utf8mb4'%Y-%m-%d')),
  PRIMARY KEY (`REQ_Sheet_ID`,`Inquiring_product`),
  KEY `Project_ID` (`Project_ID`),
  KEY `Supervisor_ID` (`Supervisor_ID`),
  CONSTRAINT `requisition_ibfk_1` FOREIGN KEY (`Project_ID`) REFERENCES `PROJECT` (`Project_ID`),
  CONSTRAINT `requisition_ibfk_2` FOREIGN KEY (`Supervisor_ID`) REFERENCES `EMPLOYEE` (`Supervisor_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23000082 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE test.REQUISITION DROP COLUMN Total_price;
ALTER TABLE test.REQUISITION ADD COLUMN Total_price BIGINT AS ( Vol * Unit_price);
ALTER TABLE test.REQUISITION ADD FOREIGN KEY (Project_ID) REFERENCES PROJECT(Project_ID);
ALTER TABLE test.REQUISITION ADD FOREIGN KEY (Supervisor_ID) REFERENCES EMPLOYEE(Supervisor_ID);

SELECT * FROM test.requisition;