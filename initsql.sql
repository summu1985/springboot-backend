create database db_example;

create USER 'debezium'@'%' IDENTIFIED WITH mysql_native_password BY 'debezium'; 

GRANT SELECT, RELOAD, SHOW DATABASES, REPLICATION SLAVE, REPLICATION CLIENT  ON *.* TO 'debezium';

GRANT ALL PRIVILEGES ON db_example.* TO 'debezium'@'%';

FLUSH PRIVILEGES;
