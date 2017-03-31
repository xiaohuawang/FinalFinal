CREATE TABLE Customer (
<<<<<<< .mine
<<<<<<< .mine
  userId INTEGER REFERENCES XUser(userId),
  firstName VARCHAR(20) NOT NULL,
  lastName VARCHAR(20) NOT NULL,
  emailId VARCHAR(20) NOT NULL,
  phoneNumber INTEGER NOT NULL,
  addressId INTEGER REFERENCES Address(addressId)
||||||| .r125
  userId INTEGER REFERENCES User(userId),
  firstName VARCHAR(20) NOT NULL,
  lastName VARCHAR(20) NOT NULL,
  emailId VARCHAR(20) NOT NULL,
  phoneNumber INTEGER NOT NULL,
  addressId INTEGER REFERENCES Address(addressId)
=======
 	customerId		INTEGER 		REFERENCES User(userId),
||||||| .r136
 	customerId		INTEGER 		REFERENCES User(userId),
=======
 	customerId		INTEGER 		REFERENCES XUsers(userId),
>>>>>>> .r178
 	firstName 		VARCHAR(20) 	NOT NULL,
 	lastName 		VARCHAR(20) 	NOT NULL,
 	emailId 		VARCHAR(20) 	NOT NULL,
 	phoneNumber 	varchar(20)		NOT NULL,
 	addressId 		INTEGER 		REFERENCES Address(addressId)
>>>>>>> .r136
);