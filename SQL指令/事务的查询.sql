show databases;

use newsdb_6;

CREATE table account(
	id int not null primary key,
	accountNo VARCHAR(25) not null,
	balance DECIMAL(11,2) not null
);

BEGIN ;
  INSERT into account VALUES(1,'张三',30000.99);
	INSERT into account VALUES(2,'李四',29000.88);
	INSERT into account VALUES(3,'王五',31000.89);
COMMIT

select * from account;