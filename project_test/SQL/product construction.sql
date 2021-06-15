CREATE TABLE `product` (
  `Module_type` varchar(255) NOT NULL,
  `Item_name` varchar(255) NOT NULL,
  `Supplier_ID` varchar(255) NOT NULL,
  PRIMARY KEY (`Module_type`),
  KEY `Supplier_ID` (`Supplier_ID`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`Supplier_ID`) REFERENCES `SUPPLIER` (`Supplier_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
ALTER TABLE test.PRODUCT ADD FOREIGN KEY (Supplier_ID) REFERENCES SUPPLIER(Supplier_ID);

SELECT * FROM test.product;