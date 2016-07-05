create database b2_test_db;

USE b2_test_db;
DROP TABLE IF EXISTS customer_demographics;
CREATE TABLE customer_demographics (cust_id VARCHAR(1024), first_name VARCHAR(512), last_name VARCHAR(512), address VARCHAR(1024),city VARCHAR(512),
	province VARCHAR(512),country VARCHAR(512), age INT, married VARCHAR(5));

insert into customer_demographics(cust_id,first_name,last_name,address,city,province,country,age,married) values('123','John','Smith','123 Main St.','Toronto','ON','Canada',33,'YES');
insert into customer_demographics(cust_id,first_name,last_name,address,city,province,country,age,married) values('125','Jane','Doe','333 Avenue Rd.','Toronto','ON','Canada',33,'YES');

commit;




