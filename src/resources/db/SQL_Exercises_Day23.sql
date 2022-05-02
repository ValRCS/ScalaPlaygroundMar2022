
-- SELECT ALL non USA customers
SELECT * FROM customers c
WHERE Country != 'USA' ;

-- SELECT ONLY German customers
SELECT * FROM customers c 
WHERE Country = 'Germany' ; 

-- SELECT employees (different table) who are sales agents

SELECT * FROM employees e 
WHERE Title LIKE "%SALES%AGENT%";

-- SELECT unique billing countries from invoices table

SELECT DISTINCT BillingCountry 
FROM invoices i
ORDER BY BillingCountry ASC; 

SELECT * FROM customers;


SELECT * FROM tracks t 
ORDER BY Name DESC
LIMIT 25
OFFSET 10;
