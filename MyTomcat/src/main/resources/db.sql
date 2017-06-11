create TABLE account(NAME VARCHAR (30), password VARCHAR (6));
DROP TABLE account;

create TABLE account(
name VARCHAR (30) not NULL,
sex VARCHAR (4) not NULL ,
WORK VARCHAR (30) not NULL ,
number VARCHAR (11) not NULL PRIMARY KEY ,
address VARCHAR (100) not NULL,
password VARCHAR (6) not NULL

) ENGINE=INNODB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;