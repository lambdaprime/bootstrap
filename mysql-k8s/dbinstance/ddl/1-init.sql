create database servicedb;

create user 'service-user'@'%';
grant index, insert, select, update, delete, execute, create temporary tables on servicedb.* to 'service-user';
