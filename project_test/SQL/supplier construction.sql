CREATE TABLE `supplier` (
  `Supplier_ID` varchar(255) NOT NULL,
  `Supplier_name` varchar(255) NOT NULL,
  `Supplier_address` varchar(255) NOT NULL,
  `Contact_name` varchar(255) NOT NULL,
  `Contact_mobile` varchar(255) NOT NULL,
  `Contact_email` varchar(255) NOT NULL,
  PRIMARY KEY (`Supplier_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


SELECT * FROM test.SUPPLIER;