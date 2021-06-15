CREATE TABLE `receipt` (
  `REC_Sheet_ID` bigint unsigned NOT NULL AUTO_INCREMENT,
  `Sheet_type` varchar(255) NOT NULL DEFAULT 'RCPT',
  `Project_ID` bigint unsigned NOT NULL,
  `Module_type` varchar(255) NOT NULL,
  `Vol` int unsigned NOT NULL,
  `Date` date NOT NULL DEFAULT (date_format(curdate(),_utf8mb4'%Y-%m-%d')),
  PRIMARY KEY (`REC_Sheet_ID`,`Project_ID`,`Module_type`),
  KEY `Project_ID` (`Project_ID`),
  KEY `Module_type` (`Module_type`),
  CONSTRAINT `receipt_ibfk_1` FOREIGN KEY (`Project_ID`) REFERENCES `PROJECT` (`Project_ID`),
  CONSTRAINT `receipt_ibfk_2` FOREIGN KEY (`Module_type`) REFERENCES `PRODUCT` (`Module_type`)
) ENGINE=InnoDB AUTO_INCREMENT=26000058 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE test.RECEIPT ADD FOREIGN KEY (Module_type) REFERENCES PRODUCT(Module_type);
ALTER TABLE test.RECEIPT ADD FOREIGN KEY (Project_ID) REFERENCES PROJECT(Project_ID);
SELECT * FROM test.receipt;