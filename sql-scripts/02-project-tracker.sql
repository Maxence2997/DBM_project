CREATE SCHEMA  IF NOT EXISTS `project_tracker`;
USE `project_tracker`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `Employee`;
CREATE TABLE `Employee` (
  `Emp_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `First_name` varchar(128) NOT NULL,
  `Last_name` varchar(128) NOT NULL,
  `Address` varchar(128) DEFAULT NULL,
  `Phone_number` varchar(15) DEFAULT NULL,
  `Supervisor_ID` int unsigned DEFAULT NULL,
  `Performance` varchar(3) NOT NULL,
  PRIMARY KEY (`Emp_ID`),
  KEY `FK_Supervisor_ID` (`Supervisor_ID`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`Supervisor_ID`) REFERENCES `Employee` (`Emp_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `Project`;
CREATE TABLE `Project` (
  `Project_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `Emp_ID` int unsigned NOT NULL,
  `Established_date` varchar(128) NOT NULL,
  `Project_status` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`Project_ID`),
  KEY `Emp_ID` (`Emp_ID`),
  CONSTRAINT `project_ibfk_1` FOREIGN KEY (`Emp_ID`) REFERENCES `Employee` (`Emp_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `Supplier`;
CREATE TABLE `Supplier` (
  `Supplier_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `Supplier_name` varchar(128) NOT NULL,
  `Supplier_address` varchar(128) NOT NULL,
  `Contact_name` varchar(128) NOT NULL,
  `Contact_mobile` varchar(15) NOT NULL,
  `Contact_email` varchar(128) NOT NULL,
  PRIMARY KEY (`Supplier_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `Product`;
CREATE TABLE `Product` (
  `Module_type` varchar(128) NOT NULL,
  `Item_name` varchar(128) NOT NULL,
  `Supplier_ID` int unsigned NOT NULL,
  PRIMARY KEY (`Module_type`),
  KEY `Supplier_ID` (`Supplier_ID`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`Supplier_ID`) REFERENCES `Supplier` (`Supplier_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `Examination`;
CREATE TABLE `Examination` (
  `EX_Sheet_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `Sheet_type` varchar(15) NOT NULL DEFAULT 'Examination',
  `Project_ID` int  unsigned NOT NULL,
  `Supplier_ID` int unsigned NOT NULL,
  `Module_type` varchar(128) NOT NULL,
  `Vol` int unsigned NOT NULL,
  `Result` boolean NOT NULL DEFAULT false,
  `Date` date NOT NULL DEFAULT (date_format(curdate(),_utf8mb4'%Y-%m-%d')),
  PRIMARY KEY (`EX_Sheet_ID`,`Supplier_ID`,`Project_ID`),
  KEY `FK_Project_ID` (`Project_ID`),
  CONSTRAINT `FK_Examination_1` FOREIGN KEY (`Project_ID`) REFERENCES `Project` (`Project_ID`),
  KEY `Supplier_ID` (`Supplier_ID`),
  CONSTRAINT `FK_Examination_2` FOREIGN KEY (`Supplier_ID`) REFERENCES `SUPPLIER` (`Supplier_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `Purchase`;
CREATE TABLE `purchase` (
  `PUR_Sheet_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `Sheet_type` varchar(15) NOT NULL DEFAULT 'Purchase',
  `Project_ID` int unsigned NOT NULL,
  `Supplier_ID` int unsigned NOT NULL,
  `Module_type` varchar(128) NOT NULL,
  `Vol` int NOT NULL,
  `Unit_price` int unsigned NOT NULL,
  `Total_price` int GENERATED ALWAYS AS ((`Vol` * `Unit_price`)) VIRTUAL,
  `ESD` date NOT NULL DEFAULT (date_format((curdate() + interval 30 day),_utf8mb4'%Y-%m-%d')),
  `Date` date NOT NULL DEFAULT (date_format(curdate(),_utf8mb4'%Y-%m-%d')),
  PRIMARY KEY (`PUR_Sheet_ID`,`Supplier_ID`,`Project_ID`),
  KEY `Project_ID` (`Project_ID`),
  CONSTRAINT `purchase_ibfk_1` FOREIGN KEY (`Project_ID`) REFERENCES `PROJECT` (`Project_ID`),
  KEY `Supplier_ID` (`Supplier_ID`),
  CONSTRAINT `purchase_ibfk_2` FOREIGN KEY (`Supplier_ID`) REFERENCES `SUPPLIER` (`Supplier_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `Quotation`;
CREATE TABLE `Quotation` (
  `QUO_Sheet_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `Sheet_type` varchar(15) NOT NULL DEFAULT 'Quotation',
  `Project_ID` int unsigned NOT NULL,
  `Inquiring_product` varchar(128) NOT NULL,
  `Supplier_ID` int unsigned NOT NULL,
  `Vol` int unsigned NOT NULL,
  `Unit_price` int unsigned NOT NULL,
  `ESD` date NOT NULL DEFAULT (date_format((curdate() + interval 30 day),_utf8mb4'%Y-%m-%d')),
  `Date` date NOT NULL DEFAULT (date_format(curdate(),_utf8mb4'%Y-%m-%d')),
  `Total_price` int GENERATED ALWAYS AS ((`Vol` * `Unit_price`)) VIRTUAL,
  PRIMARY KEY (`QUO_Sheet_ID`,`Project_ID`,`Supplier_ID`),
  KEY `Project_ID` (`Project_ID`),
  CONSTRAINT `quotation_ibfk_1` FOREIGN KEY (`Project_ID`) REFERENCES `PROJECT` (`Project_ID`),
  KEY `Supplier_ID` (`Supplier_ID`),
  CONSTRAINT `quotation_ibfk_2` FOREIGN KEY (`Supplier_ID`) REFERENCES `SUPPLIER` (`Supplier_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `Receipt`;
CREATE TABLE `Receipt` (
  `REC_Sheet_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `Sheet_type` varchar(15) NOT NULL DEFAULT 'Receipt',
  `Project_ID`int unsigned NOT NULL,
  `Supplier_ID` int unsigned NOT NULL,
  `Module_type` varchar(128) NOT NULL,
  `Vol` int unsigned NOT NULL,
  `Date` date NOT NULL DEFAULT (date_format(curdate(),_utf8mb4'%Y-%m-%d')),
  PRIMARY KEY (`REC_Sheet_ID`,`Project_ID`,`Supplier_ID`),
  KEY `Project_ID` (`Project_ID`),
  CONSTRAINT `receipt_ibfk_1` FOREIGN KEY (`Project_ID`) REFERENCES `PROJECT` (`Project_ID`),
  KEY `Supplier_ID` (`Supplier_ID`),
  CONSTRAINT `receipt_ibfk_2` FOREIGN KEY (`Supplier_ID`) REFERENCES `SUPPLIER` (`Supplier_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `Requisition`;
CREATE TABLE `Requisition` (
  `REQ_Sheet_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `Sheet_type` varchar(15) NOT NULL DEFAULT 'Requisition',
  `Project_ID`int unsigned NOT NULL,
  `Inquiring_product` varchar(128) NOT NULL,
  `Item_name` varchar(128) NOT NULL,
  `Supplier_ID` int unsigned NOT NULL,
  `Vol` int unsigned NOT NULL,
  `Unit_price` int unsigned NOT NULL,
  `Total_price` int GENERATED ALWAYS AS ((`Vol` * `Unit_price`)) VIRTUAL,
  `Signature` boolean NOT NULL DEFAULT false,
  `Supervisor_ID` int unsigned NOT NULL,
  `Date` date NOT NULL DEFAULT (date_format(curdate(),_utf8mb4'%Y-%m-%d')),
  PRIMARY KEY (`REQ_Sheet_ID`),
  KEY `Project_ID` (`Project_ID`),
  CONSTRAINT `requisition_ibfk_1` FOREIGN KEY (`Project_ID`) REFERENCES `PROJECT` (`Project_ID`),
  KEY `Supervisor_ID` (`Supervisor_ID`),
  CONSTRAINT `requisition_ibfk_2` FOREIGN KEY (`Supervisor_ID`) REFERENCES `EMPLOYEE` (`Emp_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `RFQ`;
CREATE TABLE `RFQ` (
  `RFQ_Sheet_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `Sheet_type` varchar(15) NOT NULL DEFAULT 'RFQ',
  `Project_ID` int unsigned NOT NULL,
  `Supplier_ID` int unsigned NOT NULL,
  `Inquiring_product` varchar(128) NOT NULL,
  `Vol` int unsigned NOT NULL,
  `Date` date NOT NULL DEFAULT (date_format(curdate(),_utf8mb4'%Y-%m-%d')),
  PRIMARY KEY (`RFQ_Sheet_ID`,`Project_ID`,`Inquiring_product`),
  KEY `Project_ID` (`Project_ID`),
  CONSTRAINT `rfq_ibfk_1` FOREIGN KEY (`Project_ID`) REFERENCES `project` (`Project_ID`),
  KEY `Supplier_ID` (`Supplier_ID`),
  CONSTRAINT `rfq_ibfk_2` FOREIGN KEY (`Supplier_ID`) REFERENCES `SUPPLIER` (`Supplier_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `Inventory`;
CREATE TABLE `Inventory` (
  `Inventory_ID`  int unsigned NOT NULL AUTO_INCREMENT,
  `Project_ID`  int unsigned NOT NULL,
  `Item_name` varchar(128) NOT NULL,
  `Module_type` varchar(128) NOT NULL,
  PRIMARY KEY (`Inventory_ID`),
  KEY `Project_ID` (`Project_ID`),
  CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`Project_ID`) REFERENCES `Project` (`Project_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;