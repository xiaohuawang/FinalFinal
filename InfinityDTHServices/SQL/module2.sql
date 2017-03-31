
--MODULE 2
-------------------------Set Top Box Types TABLE/4.1----------------------------
CREATE TABLE setTopBox(
  setTopBoxId INTEGER PRIMARY KEY,
  setTopBoxType VARCHAR(8) CHECK (setTopBoxType= 'Standard' OR setTopBoxType='HD' OR
    setTopBoxType='HD+' OR setTopBoxType='IPTV') NOT NULL,
  setTopBoxFeatures VARCHAR(100) NOT NULL,
  boxLength NUMBER NOT NULL,
  boxBreadth NUMBER NOT NULL,
  boxWidth NUMBER NOT NULL,
  price NUMBER NOT NULL,
  installationCharge NUMBER  DEFAULT '0',
  upgradationCharge NUMBER  DEFAULT '0',
  discount NUMBER  DEFAULT '0' CHECK (discount BETWEEN 0 AND 1),
  billingType VARCHAR(10) NOT NULL CHECK (billingType='Prepaid' OR billingType='Post Paid'),
  refundableDepositAmount NUMBER DEFAULT '0',
  serialNumber INTEGER NOT NULL UNIQUE,
  macId INTEGER NOT NULL UNIQUE,
  --remote control
  rcAssetId INTEGER NOT NULL UNIQUE,
  --dish
  dAssetId INTEGER NOT NULL UNIQUE,
  setTopBoxStatus VARCHAR(100) DEFAULT 'Unassigned'
);

CREATE SEQUENCE setTopBox_Sequences
	START WITH 1
	INCREMENT BY 1
	NOMAXVALUE
	NOCACHE
	NOCYCLE;

---------------------------Extra T FOR 4.1 TABLE/4.1.1--------------------------
CREATE TABLE setTopBoxInventory(
  macId INTEGER REFERENCES setTopBox(macId),
  userId INTEGER REFERENCES XUSERS(userId)
);

SELECT * FROM XUSERS;
SELECT * FROM setTopBox;
SELECT * FROM setTopBoxInventory;
DROP TABLE setTopBoxTypes;
DROP TABLE setTopBoxInventory;
------------------------------Channels TABLE/4.2--------------------------------
CREATE TABLE Channels (
  channelsId INTEGER PRIMARY KEY,
  channelName VARCHAR(30) NOT NULL,
  videoFrequencey NUMBER NOT NULL CHECK (videoFrequencey BETWEEN 40 AND 225),
  audioFrequencey NUMBER NOT NULL CHECK (audioFrequencey BETWEEN 45 AND 230),
  --FTAL Free to Air
  chargeType VARCHAR(4) NOT NULL CHECK (chargeType='FTA' OR chargeType='Paid'),
  transmissionType VARCHAR(8) NOT NULL CHECK (transmissionType='Standard' OR transmissionType='HD'),
  charge NUMBER DEFAULT '0'
);

CREATE SEQUENCE Channels_Sequences
	START WITH 1
	INCREMENT BY 1
	NOMAXVALUE
	NOCACHE
	NOCYCLE;

SELECT * FROM Channels;
DROP TABLE Channels;
DROP SEQUENCE Channels_Sequences;

--------------------------Channels Package TABLE/4.3----------------------------
CREATE TABLE ChannelsPackage (
  channelPackageId INTEGER PRIMARY KEY,
  packageCategory VARCHAR(100) NOT NULL,
  chargingType VARCHAR(7) NOT NULL CHECK(chargingType='Default' OR chargingType='FTA'),
  transmission VARCHAR(8) NOT NULL CHECK(transmission='HD' OR transmission='Standard'),
  addChanels VARCHAR(100) NOT NULL,
  packageCost NUMBER NOT NULL,
  fromDate DATE NOT NULL,
  toDate DATE NOT NULL,
  defaultValue VARCHAR(1) NOT NULL CHECK(defaultValue='Y' OR defaultValue='N')
);

CREATE SEQUENCE ChannelsPackage_Sequences
	START WITH 1
	INCREMENT BY 1
	NOMAXVALUE
	NOCACHE
	NOCYCLE;

SELECT * FROM ChannelsPackage;
DROP TABLE ChannelsPackage;