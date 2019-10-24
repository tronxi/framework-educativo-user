CREATE TABLE IF NOT EXISTS SUBJECT (
ID_SUBJECT int(10) NOT NULL AUTO_INCREMENT,
NAME VARCHAR(255),
YEAR VARCHAR(255),
CONSTRAINT PK_SUBJECT PRIMARY KEY
(ID_SUBJECT)
);

CREATE TABLE IF NOT EXISTS USER(
ID_USER int(10) NOT NULL AUTO_INCREMENT,
IDENT VARCHAR(255) UNIQUE NOT NULL ,
NAME VARCHAR(255),
SURNAMES VARCHAR(255),
PASSWORD VARCHAR(255),
EMAIL VARCHAR(255) UNIQUE NOT NULL ,
IS_CHANGED BOOLEAN,
CONSTRAINT PK_USER PRIMARY KEY
(ID_USER)
);

CREATE TABLE IF NOT EXISTS ROLE(
ID_ROLE int(10) NOT NULL AUTO_INCREMENT,
DESCRIPTION VARCHAR(255),
CONSTRAINT PK_ROLE PRIMARY KEY
(ID_ROLE)
);

CREATE TABLE IF NOT EXISTS ACTIVITY(
ID_ACTIVITY int(10) NOT NULL AUTO_INCREMENT,
DESCRIPTION VARCHAR(255),
ID_SUBJECT VARCHAR(255),
DATE VARCHAR(255),
MAX_PERSON NUMERIC(10),
ATTEMPTS NUMERIC(10),
FILE_TYPE VARCHAR(255),
CONSTRAINT PK_ACTIVITY PRIMARY KEY
(ID_ACTIVITY)
);

CREATE TABLE IF NOT EXISTS USER_ROLE(
ID_USER int(10) NOT NULL,
ID_ROLE int(10) NOT NULL,
CONSTRAINT PK_USER_ROLE PRIMARY KEY
(ID_USER, ID_ROLE)
);

CREATE TABLE IF NOT EXISTS TEAM(
ID_TEAM int(10) NOT NULL AUTO_INCREMENT,
NAME VARCHAR(255),
CURRENT_ATTEMPTS NUMERIC(10),
ASSESSMENT_RESULT BOOLEAN,
GRADE NUMERIC(5),
CONSTRAINT PK_TEAM PRIMARY KEY
(ID_TEAM)
);

CREATE TABLE IF NOT EXISTS GROUPS_ACTIVITY(
ID_GROUP int(10) NOT NULL,
ID_ACTIVITY int(10) NOT NULL,
CONSTRAINT PK_GROUPS_ACTIVITY PRIMARY KEY
(ID_GROUP, ID_ACTIVITY)
);

CREATE TABLE IF NOT EXISTS ACTIVITY_USER(
ID_USER int(10) NOT NULL,
ID_ACTIVITY int(10) NOT NULL,
ID_TEAM int(10) NOT NULL,
CONSTRAINT PK_ACTIVITY_USER PRIMARY KEY
(ID_ACTIVITY, ID_USER)
);

CREATE TABLE IF NOT EXISTS SUBJECT_USER(
ID_SUBJECT int(10) NOT NULL,
ID_USER int(10) NOT NULL,
CONSTRAINT PK_SUBJECT_USER PRIMARY KEY
(ID_SUBJECT, ID_USER)
);


CREATE TABLE IF NOT EXISTS USER_GROUP(
ID_GROUP int(10) NOT NULL,
ID_USER int(10) NOT NULL,
CONSTRAINT PK_USER_GROUP PRIMARY KEY
(ID_GROUP, ID_USER)
);

CREATE TABLE IF NOT EXISTS GROUPS(
ID_GROUP int(10) NOT NULL AUTO_INCREMENT,
ID_SUBJECT int(10) NOT NULL,
NAME_GROUP VARCHAR(255),
CONSTRAINT PK_GROUP PRIMARY KEY
(ID_GROUP)
);
