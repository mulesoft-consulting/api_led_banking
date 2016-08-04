create database b2_test_db;

USE b2_test_db;
DROP TABLE IF EXISTS customer_demographics;
DROP TABLE IF EXISTS customer_accounts;
CREATE TABLE customer_demographics (cust_id VARCHAR(1024), first_name VARCHAR(512), last_name VARCHAR(512), address VARCHAR(1024),city VARCHAR(512),
	province VARCHAR(512),country VARCHAR(512), age INT, married VARCHAR(5));
CREATE TABLE customer_accounts(cust_id VARCHAR(1024), acct_num VARCHAR(512), acct_type VARCHAR(512), acct_balance float,acct_interest_rate float,currency VARCHAR(512));


insert into customer_demographics(cust_id,first_name,last_name,address,city,province,country,age,married) values('123','John','Smith','123 Main St.','Toronto','ON','Canada',33,'YES');
insert into customer_demographics(cust_id,first_name,last_name,address,city,province,country,age,married) values('125','Jane','Doe','333 Avenue Rd.','Toronto','ON','Canada',33,'YES');

insert into customer_accounts(cust_id,acct_num,acct_type,acct_balance,acct_interest_rate,currency) values('123','12345-sv','Savings',999999.00,0.5,'CAD');
insert into customer_accounts(cust_id,acct_num,acct_type,acct_balance,acct_interest_rate,currency) values('123','12345-cq','Chequing',2000.00,1.0,'CAD');
insert into customer_accounts(cust_id,acct_num,acct_type,acct_balance,acct_interest_rate,currency) values('125','12346-sv','Savings',35000.00,0.5,'USD');
insert into customer_accounts(cust_id,acct_num,acct_type,acct_balance,acct_interest_rate,currency) values('126','12347-cq','Chequing',33000.00,1.0,'USD');


commit;




