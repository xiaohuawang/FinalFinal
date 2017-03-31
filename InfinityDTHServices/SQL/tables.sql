CREATE TABLE Role (
 	roleId 		INTEGER 	PRIMARY KEY,
 	roleName 	VARCHAR(20) NOT NULL
);

CREATE TABLE XUsers (
 	userId 		INTEGER 		PRIMARY KEY,
 	username	VARCHAR(20) 	NOT NULL,
 	pwd 		VARCHAR(20) 	NOT NULL,
 	roleId		INTEGER			REFERENCES Role(roleId)
);

CREATE SEQUENCE XUsers_Sequence
	START WITH 1
	INCREMENT BY 1
	NOMAXVALUE
	NOCACHE
	NOCYCLE;

CREATE TABLE Address (
 	addressId 	INTEGER 		PRIMARY KEY,
 	address1 	VARCHAR(30) 	NOT NULL,
 	address2 	VARCHAR(30)		NULL,
 	landMark 	VARCHAR(30) 	NOT NULL,
 	pincode 	VARCHAR(30) 	NOT NULL,
 	city 		VARCHAR(10) 	NOT NULL,
 	state 		VARCHAR(10)		NOT NULL
);

CREATE SEQUENCE Address_Sequence
	START WITH 1
	INCREMENT BY 1
	NOMAXVALUE
	NOCACHE
	NOCYCLE;
	
CREATE TABLE Operator (
 	operatorId			INTEGER 		REFERENCES XUsers(userId),
 	firstName 			VARCHAR(20) 	NOT NULL,
 	lastName 			VARCHAR(20) 	NOT NULL,
 	emailId 			VARCHAR(30) 	NOT NULL,
 	phoneNumber 		varchar(10)		NOT NULL,
 	--Shift Time Start
 	sts 				DATE 			NOT NULL,
 	--Shift Time End
 	ste 				DATE 			NOT NULL,
 	--Max.no.of Customer to be managed
 	mcm 				INTEGER 		NOT NULL,
 	creationDate		DATE			NOT NULL
);

CREATE TABLE Retailer (
 	retailerId		INTEGER 		REFERENCES XUsers(userId),
 	name 			VARCHAR(30) 	NOT NULL,
 	contactNo1 		VARCHAR(30) 	NOT NULL,
 	contactNo2 		VARCHAR(30)		NULL,
 	addressId 		INTEGER 		REFERENCES Address(addressId),
  	--Set Top Box Limit
 	STBL 			VARCHAR(30) 	NOT NULL,
 	creditLimit 	VARCHAR(30) 	NOT NULL,
 	--Commission percentage on sale of goods
 	CPSG 			VARCHAR(30) 	NOT NULL,
 	serviceCharge 	VARCHAR(30) 	NOT NULL,
 	--Retailer Creation Date
 	creationDate	DATE 			NOT NULL,
 	--Total Cost of Inventory
 	TCI 			DECIMAL 		NOT NULL
);

CREATE TABLE Customer (
 	customerId		INTEGER 		REFERENCES XUsers(userId),
 	firstName 		VARCHAR(20) 	NOT NULL,
 	lastName 		VARCHAR(20) 	NOT NULL,
 	emailId 		VARCHAR(20) 	NOT NULL,
 	phoneNumber 	varchar(20)		NOT NULL,
 	addressId 		INTEGER 		REFERENCES Address(addressId)
);

insert into Role values(1, 'Admin');
insert into Role values(2, 'Operator');
insert into Role values(3, 'Retailer');
insert into Role values(4, 'Customer');

insert into XUsers values(1, 'admin', 'admin', 1);

