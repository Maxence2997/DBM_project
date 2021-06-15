CREATE TABLE `RFQ` (
  `RFQ_Sheet_ID` bigint unsigned NOT NULL AUTO_INCREMENT,
  `Sheet_type` varchar(255) NOT NULL DEFAULT 'RFQ',
  `Project_ID` bigint unsigned NOT NULL,
  `Supplier_ID` varchar(255) NOT NULL,
  `Inquiring_product` varchar(255) NOT NULL,
  `Vol` int NOT NULL,
  `Date` date NOT NULL DEFAULT (date_format(curdate(),_utf8mb4'%Y-%m-%d')),
  PRIMARY KEY (`RFQ_Sheet_ID`,`Inquiring_product`),
  KEY `Project_ID` (`Project_ID`),
  KEY `Supplier_ID` (`Supplier_ID`),
  CONSTRAINT `rfq_ibfk_1` FOREIGN KEY (`Project_ID`) REFERENCES `project` (`Project_ID`),
  CONSTRAINT `rfq_ibfk_2` FOREIGN KEY (`Supplier_ID`) REFERENCES `SUPPLIER` (`Supplier_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21000100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci