
CREATE TABLE PACKAGE (
  PACKAGEID  INT(11) PRIMARY KEY,
  NAME  VARCHAR(255) NOT NULL
);

CREATE TABLE CHANNEL (
  CHANNELID  INT(11) PRIMARY KEY,
  NAME VARCHAR(255) NOT NULL,
  LANGUAGE VARCHAR(255) NOT NULL DEFAULT '',
  PACKAGEID INT(11) NOT NULL,
  CONSTRAINT FK_PACKAGE FOREIGN KEY(PACKAGEID) REFERENCES PACKAGE(PACKAGEID) ON DELETE CASCADE
);

