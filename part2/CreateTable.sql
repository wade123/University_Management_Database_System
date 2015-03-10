DROP TABLE IF EXISTS `course`;
CREATE TABLE course(
	CourseID VARCHAR(10),
	Title VARCHAR(50),
	Credit INT,
	ProfUIN INT,
	PRIMARY KEY (CourseID)
);

DROP TABLE IF EXISTS `department`;
CREATE TABLE deparment(
	Abbreviation VARCHAR(10),
	Name VARCHAR(50),
	FoundDate DATE,
	Website VARCHAR(50),
	PRIMARY KEY(Abbreviation)
);

DROP TABLE IF EXISTS `professor`;
CREATE TABLE professor(
	UIN INT,
	Name VARCHAR(20),
	Title VARCHAR(20),
	Nationality VARCHAR(20),
	Interest VARCHAR(50),
	Phone	FLOAT,
	Webpage VARCHAR(50),
	PRIMARY KEY(UIN)
);

DROP TABLE IF EXISTS `student`;
CREATE TABLE student(
	UIN INT,
	Name VARCHAR(20),
	BirthYear INT,
	Gender CHAR(1),
	Phone FLOAT,
	Major VARCHAR(20),
	ProfUIN INT,
	PRIMARY KEY(UIN)
);

DROP TABLE IF EXISTS `facultyof`;
CREATE TABLE `facultyof` (
  `Prof_UIN` int(11) NOT NULL DEFAULT '0',
  `Department` varchar(10) NOT NULL DEFAULT '',
  `Start_Date` VARCHAR(20),
  `End_Date` VARCHAR(20),
  `Salary` double DEFAULT NULL,
  PRIMARY KEY (`Prof_UIN`,`Department`)
);

DROP TABLE IF EXISTS `groupleader`;
CREATE TABLE `groupleader` (
  `Prof_UIN` int(11) NOT NULL DEFAULT '0',
  `Title` varchar(20) DEFAULT NULL,
  `JobSummary` varchar(100) DEFAULT NULL,
  `StartDate` date DEFAULT NULL,
  PRIMARY KEY (`Prof_UIN`)
);

DROP TABLE IF EXISTS `registerin`;
CREATE TABLE `registerin` (
  `ClubName` varchar(20) NOT NULL DEFAULT '',
  `StudentUIN` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ClubName`,`StudentUIN`)
);

DROP TABLE IF EXISTS `club`;
CREATE TABLE `club` (
  `Name` varchar(20) NOT NULL DEFAULT '',
  `ChairName` varchar(20) DEFAULT NULL,
  `FoundDate` date DEFAULT NULL,
  `Website` varchar(50) DEFAULT NULL,
  `Capacity` int(11) DEFAULT NULL,
  `AnnualFee` double DEFAULT NULL,
  PRIMARY KEY (`Name`)
);

DROP TABLE IF EXISTS `studyof`;
CREATE TABLE `studyof` (
  `CourseID` VARCHAR(10),
  `UIN` int(11) NOT NULL DEFAULT '0',
  `Score` double DEFAULT NULL,
  PRIMARY KEY (`CourseID`,`UIN`)
);

DROP TABLE IF EXISTS `committegroup`;
CREATE TABLE `committegroup` (
  `StudUIN` int(11) NOT NULL DEFAULT '0',
  `ChairUIN` int(11) NOT NULL DEFAULT '0',
  `CochairUIN` int(11) NOT NULL DEFAULT '0',
  `DefenseDate` VARCHAR(10),
  `Passed` char(1) DEFAULT NULL,
  PRIMARY KEY (`StudUIN`,`ChairUIN`,`CochairUIN`)
);