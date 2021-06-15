CREATE TABLE `QUOTATION` (
  `QUO_Sheet_ID` bigint unsigned NOT NULL AUTO_INCREMENT,
  `Sheet_type` varchar(255) NOT NULL,
  `Project_ID` bigint unsigned NOT NULL,
  `Inquiring_product` varchar(255) NOT NULL,
  `Supplier_ID` varchar(255) NOT NULL,
  `Vol` int NOT NULL,
  `Unit_price` int NOT NULL,
  `ESD` date NOT NULL DEFAULT (date_format((curdate() + interval 30 day),_utf8mb4'%Y-%m-%d')),
  `Date` date NOT NULL DEFAULT (date_format(curdate(),_utf8mb4'%Y-%m-%d')),
  `Total_price` text GENERATED ALWAYS AS ((`Vol` * `Unit_price`)) VIRTUAL,
  PRIMARY KEY (`QUO_Sheet_ID`,`Inquiring_product`),
  KEY `Project_ID` (`Project_ID`),
  KEY `Supplier_ID` (`Supplier_ID`),
  CONSTRAINT `quotation_ibfk_1` FOREIGN KEY (`Project_ID`) REFERENCES `PROJECT` (`Project_ID`),
  CONSTRAINT `quotation_ibfk_2` FOREIGN KEY (`Supplier_ID`) REFERENCES `SUPPLIER` (`Supplier_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22000090 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


ALTER TABLE test.QUOTATION ADD COLUMN Total_price Text AS ( Vol * Unit_price);
ALTER TABLE test.QUOTATION ADD FOREIGN KEY (Project_ID) REFERENCES PROJECT(Project_ID);
ALTER TABLE test.QUOTATION ADD FOREIGN KEY (Supplier_ID) REFERENCES SUPPLIER(Supplier_ID);
SELECT * FROM test.quotation;