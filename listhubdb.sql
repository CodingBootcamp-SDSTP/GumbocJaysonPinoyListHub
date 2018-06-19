DROP TABLE IF EXISTS tblperson;
CREATE TABLE tblperson (
	id VARCHAR(25) NOT NULL,
	specialty VARCHAR(25) NOT NULL,
	firstname  VARCHAR(25) NOT NULL,
	lastname  VARCHAR(25) NOT NULL,
	licensenumber VARCHAR(11) NOT NULL,
	contactdetails VARCHAR(25) NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO tblperson (id, specialty, firstname, lastname, licensenumber, contactdetails) VALUES 
						("2018-001", "consultant", "Eleven", "Seven", "0000001", "n/a");
INSERT INTO tblperson (id, specialty, firstname, lastname, licensenumber, contactdetails) VALUES 
						("2018-002", "consultant", "Imee", "Bee", "0000002", "n/a");
INSERT INTO tblperson (id, specialty, firstname, lastname, licensenumber, contactdetails) VALUES 
						("2018-003", "broker", "Queen", "Elizabeth", "0000003", "n/a");
INSERT INTO tblperson (id, specialty, firstname, lastname, licensenumber, contactdetails) VALUES 
						("2018-004", "broker", "Bowie", "Manilow", "0000004", "n/a");
INSERT INTO tblperson (id, specialty, firstname, lastname, licensenumber, contactdetails) VALUES 
						("2018-005", "appraiser", "Jason", "Borne", "0000005", "n/a");

DROP TABLE IF EXISTS tbllocation;
CREATE TABLE tbllocation (
	id VARCHAR(25) NOT NULL,
	street VARCHAR(50) NOT NULL,
	barangay VARCHAR(25) NOT NULL,
	city VARCHAR(25) NOT NULL,
	country VARCHAR(50) NOT NULL,
	code VARCHAR(25) NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO tbllocation (id, street, barangay, city, country, code) VALUES 
						  ("2001", "No. 34 Recto Boulevard", "Brgy. Legarda", "Manila City", "Philippines", "98343");
INSERT INTO tbllocation (id, street, barangay, city, country, code) VALUES 
						  ("2002", "No. 26 Burgos St.", "Brgy. Poblacion", "Makati City", "Philippines", "45665");
INSERT INTO tbllocation (id, street, barangay,  city, country, code) VALUES 
						  ("2003", "No. 302 Regalado Street", "Brgy. Fairview", "Quezon City", "Philippines", "36765");

DROP TABLE IF EXISTS tblproperty;
CREATE TABLE tblproperty(
	id INTEGER AUTO_INCREMENT,
	price  INTEGER(11) NOT NULL,
	propertyname  VARCHAR(25) NOT NULL,
	propertytype  VARCHAR(25) NOT NULL,
	floorarea INTEGER(11) NOT NULL,
	lotsize INTEGER(11) NOT NULL,
	roomnumber  INTEGER(11) NOT NULL,
	otherdetails VARCHAR(25) NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO tblproperty (price, propertyname, propertytype, floorarea, lotsize, roomnumber, otherdetails) VALUES 
						(2600000, "Student Towers", "Residential", 26, 00, 1, "window view");
INSERT INTO tblproperty (price, propertyname, propertytype, floorarea, lotsize, roomnumber, otherdetails) VALUES 
						(2500000, "Student Towers", "Residential", 23, 00, 1, "pool view");
INSERT INTO tblproperty (price, propertyname, propertytype, floorarea, lotsize, roomnumber, otherdetails) VALUES 
						(2600000, "Student Towers", "Residential", 26, 00, 1, "rent-to-own, with balcony");

