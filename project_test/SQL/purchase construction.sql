CREATE TABLE `purchase` (
  `PUR_Sheet_ID` bigint unsigned NOT NULL AUTO_INCREMENT,
  `Sheet_type` varchar(255) NOT NULL DEFAULT 'PUR',
  `Project_ID` bigint unsigned NOT NULL,
  `Module_type` varchar(255) NOT NULL,
  `Vol` int NOT NULL,
  `Unit_price` int NOT NULL,
  `Total_price` int GENERATED ALWAYS AS ((`Vol` * `Unit_price`)) VIRTUAL,
  `ESD` date NOT NULL DEFAULT (date_format((curdate() + interval 30 day),_utf8mb4'%Y-%m-%d')),
  `Date` date NOT NULL DEFAULT (date_format(curdate(),_utf8mb4'%Y-%m-%d')),
  PRIMARY KEY (`PUR_Sheet_ID`,`Module_type`),
  KEY `Project_ID` (`Project_ID`),
  KEY `Module_type` (`Module_type`),
  CONSTRAINT `purchase_ibfk_1` FOREIGN KEY (`Project_ID`) REFERENCES `PROJECT` (`Project_ID`),
  CONSTRAINT `purchase_ibfk_2` FOREIGN KEY (`Module_type`) REFERENCES `PRODUCT` (`Module_type`),
  CONSTRAINT `purchase_ibfk_3` FOREIGN KEY (`Project_ID`) REFERENCES `PROJECT` (`Project_ID`),
  CONSTRAINT `purchase_ibfk_4` FOREIGN KEY (`Module_type`) REFERENCES `PRODUCT` (`Module_type`)
) ENGINE=InnoDB AUTO_INCREMENT=24000069 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
ALTER TABLE test.PURCHASE ADD COLUMN Total_price INT AS ( Vol * Unit_price);
ALTER TABLE test.PURCHASE ADD FOREIGN KEY (Project_ID) REFERENCES PROJECT(Project_ID);
ALTER TABLE test.PURCHASE ADD FOREIGN KEY (Module_type) REFERENCES PRODUCT(Module_type);

SELECT * FROM test.purchase;