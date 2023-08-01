create table servicedb.results(
    id int primary key auto_increment,
    uriMd5 varchar(200) NOT NULL,
    uri text NOT NULL,
    result ENUM('SUCCESS', 'FAIL'));
