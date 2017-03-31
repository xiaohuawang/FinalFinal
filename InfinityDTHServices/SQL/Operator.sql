<<<<<<< .mine
<<<<<<< .mine
CREATE TABLE Operator (
  userId INTEGER REFERENCES XUser(userId),
  firstName VARCHAR(20) NOT NULL,
  lastName VARCHAR(20) NOT NULL,
  emailId VARCHAR(20) NOT NULL,
  phoneNumber INTEGER NOT NULL,
  --Shift Time Start
  sts DATE NOT NULL,
  --Shift Time End
  ste DATE NOT NULL,
  --Max.no.of Customer to be managed
  mcm INTEGER NOT NULL
||||||| .r125
CREATE TABLE OPERATOR(
  userId INTEGER REFERENCES User(userId),
  firstName VARCHAR(20) NOT NULL,
  lastName VARCHAR(20) NOT NULL,
  emailId VARCHAR(20) NOT NULL,
  phoneNumber INTEGER NOT NULL,
  --Shift Time Start
  sts DATE NOT NULL,
  --Shift Time End
  ste DATE NOT NULL,
  --Max.no.of Customer to be managed
  mcm INTEGER NOT NULL
=======
CREATE TABLE OPERATOR(
 	operatorId			INTEGER 		REFERENCES User(userId),
||||||| .r136
CREATE TABLE OPERATOR(
 	operatorId			INTEGER 		REFERENCES User(userId),
=======
CREATE TABLE Operator (
 	operatorId			INTEGER 		REFERENCES XUsers(userId),
>>>>>>> .r178
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
>>>>>>> .r136
);
