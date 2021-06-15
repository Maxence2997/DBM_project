CREATE TABLE `examination` (
  `EX_Sheet_ID` bigint unsigned NOT NULL AUTO_INCREMENT,
  `Sheet_type` varchar(255) NOT NULL DEFAULT 'EXAM',
  `Project_ID` bigint unsigned NOT NULL,
  `Module_type` varchar(255) NOT NULL,
  `Vol` int NOT NULL,
  `Result` varchar(255) NOT NULL DEFAULT 'False',
  `Date` date NOT NULL DEFAULT (date_format(curdate(),_utf8mb4'%Y-%m-%d')),
  PRIMARY KEY (`EX_Sheet_ID`,`Module_type`,`Project_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=25000059 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
ALTER TABLE test.EXAMINATION ADD FOREIGN KEY (Project_ID) REFERENCES PROJECT(Project_ID);
ALTER TABLE test.EXAMINATION ADD FOREIGN KEY (Module_type) REFERENCES PRODUCT(Module_type);
SELECT * FROM test.examination;