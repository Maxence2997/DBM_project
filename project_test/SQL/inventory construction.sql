CREATE TABLE `INVENTORY` (
  `Inv_ID` bigint unsigned NOT NULL AUTO_INCREMENT,
  `Project_ID` bigint unsigned NOT NULL,
  `Item_name` varchar(255) NOT NULL,
  `Module_type` varchar(255) NOT NULL,
  PRIMARY KEY (`Inv_ID`),
  KEY `Project_ID` (`Project_ID`),
  CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`Project_ID`) REFERENCES `PROJECT` (`Project_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=27000116 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE test.INVENTORY ADD FOREIGN KEY (Project_ID) REFERENCES PROJECT(Project_ID);
SELECT * FROM test.inventory;