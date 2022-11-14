select s.name from SalesPerson s where s.sales_id not in
(select o.sales_id from company c, orders o where c.com_id = o.com_id and c.name = 'RED')