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
4. [Derived Query Methods in Spring Data JPA Repositories](https://www.baeldung.com/spring-data-derived-queries)
5. [Working with Spring Data Repositories](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories)
6. [HQL Tutorial](https://tw.gitbook.net/hibernate/hibernate_query_language.html)
7. [Hibernate Session javadoc](https://docs.jboss.org/hibernate/orm/3.5/javadocs/org/hibernate/Session.html)
8. [Java 8 Optional Guide](https://www.baeldung.com/java-optional)
9. [java 8 Optional-orElse() vs orElseGet()](https://www.baeldung.com/java-optional-or-else-vs-or-else-get)
10. [Optional simple guide](http://blog.tonycube.com/2015/10/java-java8-4-optional.html)


## Note

1. 徒手query DB的話建議用`JDBC Template`