--MODULE 1
---------------------------------USER TABLE/1.1---------------------------------
CREATE TABLE Users_0123 (
  UserId Integer Primary Key,
  Email VARCHAR(20) Not Null,
  UPassword VARCHAR(20) Not Null
);


SELECT * FROM XUSERS;
--------------------------------ROLE TABLE/1.2----------------------------------

CREATE TABLE Role_0123 (
  RoleId Integer Primary Key,
  RoleName VARCHAR(20) Not Null
);

SELECT * FROM RolE;
DELETE FROM ROLE WHERE ROLEID='86';

------------------------------USER/ROLE TABLE/2.1-------------------------------

Create Table XUserS_Role (
  UserId Integer REFERENCES XUSERS(UserId),
  RoleId Integer REFERENCES Role(RoleId)
);

SELECT * FROM USER_ROLE;
DROP TABLE XUSERS_ROLE;

------------------------------Address TABLE/2.2---------------------------------
CREATE TABLE Address_0123 (
  AddressId Integer Primary Key,
  Address1 Varchar(30) Not Null,
  Address2 Varchar(30),
  LandMark Varchar(30) Not Null,
  Pincode Varchar(30) Not Null,
  City Varchar(10) Not Null,
  State Varchar(10) Not Null
);

Select * From Address;

------------------------------Operator TABLE/3.1--------------------------------
CREATE TABLE OPERATOR(
  operatorId INTEGER REFERENCES XUSERS(UserId),
  firstName VARCHAR(20) NOT NULL,
  lastName VARCHAR(20) NOT NULL,
  emailId VARCHAR(20) NOT NULL,
  phoneNumber INTEGER NOT NULL,
  --Shift Time Start
  shiftTimeStart DATE,
  --Shift Time End
  shiftTimeEnd DATE,
  --Max.no.of Customer to be managed
  maxCustomer INTEGER NOT NULL,
  creationDate DATE NOT NULL
);

Select * from OPERATOR;
DROP TABLE OPERATOR;
------------------------------CUSTOMER TABLE/3.2--------------------------------
CREATE TABLE Customer (
  customerId Integer References XUSERS(UserId),
  FirstName Varchar(20) Not Null,
  LastName Varchar(20) Not Null,
  EmailId Varchar(20) Not Null,
  PhoneNumber Integer Not Null,
  AddressId Integer REFERENCES Address(AddressId),
  creationDate DATE NOT NULL
);

Select * From Customer;
Drop table Customer;

------------------------------Retailer TABLE/3.3--------------------------------
Create Table Retailer(
  UserId Integer References Users_0123(UserId),
  RName Varchar(30) Not Null,
  ContactNo1 Varchar(30) Not Null,
  ContactNo2 Varchar(30),
  AddressId Integer REFERENCES Address_0123(AddressId),
  --Set Top Box Limit
  STBL Varchar(30) Not Null,
  CreditLimit Varchar(30) Not Null,
  --Commission percentage on sale of goods
  CPSG Varchar(30) Not Null,
  ServiceCharge Varchar(30) Not Null,
  InventoryList Varchar(30) Not Null,
  --Retailer Creation Date
  RCD date Not Null,
  --Total Cost of Inventory
  TCI Integer Not Null
);

Select * From Retailer;
Drop Table Retailer;
