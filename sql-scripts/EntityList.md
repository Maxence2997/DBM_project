# List

## Entities

- [ ] Definition
- [ ] BaseEntity
- [ ] Employee
  - [ ] SubordinateList
  - [ ] RequisitionList
  - [ ] ProjectList
- [ ] Supplier
  - [ ] ProductList
  - [ ] RfqList
  - [ ] QuotationList
  - [ ] PurchaseList
  - [ ] ExaminationList
  - [ ] ReceiptList
- [ ] Project
  - [ ] InventoryList
  - [ ] RequisitionList
  - [ ] RfqList
  - [ ] QuotationList
  - [ ] PurchaseList
  - [ ] ExaminationList
  - [ ] ReceiptList
- [ ] Product
- [ ] Inventory
- [ ] Requisition
- [ ] Rfq
- [ ] Quotation
- [ ] Purchase
- [ ] Examination
- [ ] Receipt

<http://www.java2s.com/Tutorial/Java/0355__JPA/AbstractClassAsMappedSuperclass.htm>

## To do idea

- [ ] 實作uuid (UUID.randomUUID())
- [ ] 實作新增一張table`definition`用來記錄各table中各自ID的最新值
- [ ] 在每一張table實作trigger機制，當新增資料的時候抄寫至`definition`
- [ ] 拿掉project裡的est_date
- [ ] add uuid into each table
- [ ] 修正資料庫設計 id都改成varchar
- [ ] refactor sheets structure, combine 6 sheets into 1 table
- [ ] revise `ESD DATE` to `Esd_date`
- [ ] add `Yield`(Decimal) into `Examination`
- [ ] revise `Result` in `Examination` from `TinyINT` to `Boolean`

## Learning url

1. [Hibernate Inheritance Mapping](https://www.baeldung.com/hibernate-inheritance)
2. [How To Use UUIDs With Hibernate And MySQL](https://phauer.com/2016/uuids-hibernate-mysql/)
3. [JPA 2.2 Support for Java 8 Date/Time Types](https://www.baeldung.com/jpa-java-time)
