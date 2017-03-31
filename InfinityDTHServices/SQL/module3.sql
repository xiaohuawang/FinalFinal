--MODULE 3
-------------------Customer Package and Charging TABLE/5.1----------------------
CREATE TABLE CustomerPackageCharging (
  customerPCId INTEGER PRIMARY KEY,
  customerName VARCHAR(30) NOT NULL,
  stbType VARCHAR(30) NOT NULL,
  stbMacId INTEGER NOT NULL UNIQUE,
  stbSerialNumber INTEGER NOT NULL UNIQUE,
  stbPrice NUMBER NOT NULL,
  installationCharge NUMBER DEFAULT '0',
  deposit NUMBER DEFAULT '0',
  discount NUMBER DEFAULT '0',
  tax  NUMBER DEFAULT '0',
  amountPayable NUMBER NOT NULL
);

SELECT * FROM customerPackageCharging;
DROP TABLE customerPackageCharging;

----------------------Purchase Channel Package TABLE/5.2------------------------
CREATE TABLE PurchaseChannelPackage (
  purchaseCPId INTEGER PRIMARY KEY,
  customerName VARCHAR(30) NOT NULL,
  packageDetails VARCHAR(100) NOT NULL,
  packageName VARCHAR(30) NOT NULL,
  channelName VARCHAR(30) NOT NULL,
  channelCharge NUMBER DEFAULT '0',
  packagePurchaseDate DATE NOT NULL,
  totalPackageCost NUMBER NOT NULL,
  totalAmount NUMBER NOT NULL
);

DROP TABLE purchaseChannelPackage;
SELECT * FROM purchaseChannelPackage;

--------------------------Customer Charging TABLE/5.3---------------------------
CREATE TABLE CustomerCharging (
  customerChargingId INTEGER PRIMARY KEY,
  customerName VARCHAR(30) NOT NULL,
  stbType VARCHAR(30) NOT NULL,
  packageName VARCHAR(30) NOT NULL,
  packageCost NUMBER NOT NULL,
  extraCharges NUMBER DEFAULT '0',
  tax NUMBER DEFAULT '0',
  totalAmount NUMBER NOT NULL,
  --Bill Generation Date
  generationDate DATE NOT NULL,
  --Bill Payment Date  
  paymentDate DATE NOT NULL
);

SELECT * FROM customerCharging;
DROP TABLE customerCharging;
