CREATE VIEW VIEW_SUPPLIER_PRODUCT(Supplier_ID, Supplier_name, Item_name, Module_type) AS

SELECT s.Supplier_ID, s.Supplier_name, pd.Item_name, pd.Module_type FROM test.supplier AS s 
LEFT JOIN test.Product AS pd ON pd.Supplier_ID=s.Supplier_ID;

SELECT * FROM VIEW_SUPPLIER_PRODUCT;