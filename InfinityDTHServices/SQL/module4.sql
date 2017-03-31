--MODULE 4
--------------------------------Distributor TABLE/6.1---------------------------
CREATE TABLE Distributor(
  distributorId INTEGER PRIMARY KEY,
  distributorName VARCHAR(30) NOT NULL,
  ContactNo1 VARCHAR(30) NOT NULL,
  ContactNo2 VARCHAR(30),
  AddressId INTEGER REFERENCES Address(AddressId),
  zone VARCHAR(5) NOT NULL CHECK(zone ='East' OR zone='West' OR zone='North' OR zone='South'),
  --Set Top Box Limit
  STBL VARCHAR(30) NOT NULL,
  creditLimit NUMBER DEFAULT '0',
  retailerList VARCHAR(100) NOT NULL,
  inventoryList VARCHAR(100) NOT NULL,
  totalCostOfInventory NUMBER DEFAULT '0'
);

CREATE SEQUENCE Distributor_Sequences
	START WITH 1
	INCREMENT BY 1
	NOMAXVALUE
	NOCACHE
	NOCYCLE;


SELECT * FROM XUSERS;

SELECT * FROM distributor;
DROP TABLE DISTRIBUTOR;
DROP SEQUENCE Distributor_Sequences;

------------------------------Video On Demand TABLE/6.2-------------------------
CREATE TABLE videoDemand(
  videoDemandId INTEGER PRIMARY KEY,
  vname VARCHAR(30) NOT NULL,
  vCategory VARCHAR(11) NOT NULL CHECK(vCategory='Cartoons' OR vCategory='Movie'
    OR vCategory='Songs' OR vCategory='Educational' OR vCategory='Devotional'),
  vDuration INTEGER NOT NULL,
  vFrequency VARCHAR(15) NOT NULL CHECK(vFrequency='One Time' OR vFrequency='Daily'
    OR vFrequency='Weekends' OR vFrequency='Continuous loop'),
  --START/END TIME OUTPUT FORMAT: '08:00 PM'
  vStartTime VARCHAR(8),
  vEndTime VARCHAR(8),
  vCost NUMBER NOT NULL,
  vPreview VARCHAR(100) NOT NULL
);

SELECT * FROM videoDemand;
DROP TABLE videoDemand;

----------------------------A-la-Carte Package TABLE/6.3------------------------
CREATE TABLE CartePackage(
  cartePackageId INTEGER PRIMARY KEY,
  customerName VARCHAR(30) NOT NULL,
  channelName VARCHAR(50) NOT NULL,
  cCharge NUMBER DEFAULT '0',
  cBillingType VARCHAR(30) NOT NULL,
  cTransmissionType VARCHAR(30) NOT NULL,
  cChargeType VARCHAR(30) NOT NULL,
  cPurchaseDate DATE NOT NULL,
  totalCost NUMBER NOT NULL,
  --Ala-Carte Selection Charges
  selectionCharges NUMBER DEFAULT '0',
  discount NUMBER DEFAULT '0',
  tax NUMBER DEFAULT '0',
  --Total Amount Payable
  totalAmount NUMBER NOT NULL
);

SELECT * FROM CartePackage;
