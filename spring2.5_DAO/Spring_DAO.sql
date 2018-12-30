CREATE DATABASE spring2_dao DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use spring2_dao;

show tables;

-- ***********************************************************************
  create table if not exists tb_person
        (
		  id int auto_increment,
          name varchar(255),
          sex varchar(10),
		  age int,
          birthday timestamp,
          primary key(id)
        )

-- ***********************************************************************

 select id,name,sex,age,birthday
   from tb_person;

-- ***********************************************************************
 insert into tb_person
      (name,sex,age,birthday)
     values('kevin','M',35,'19780709');

 insert into tb_person
      (name,sex,age,birthday)
     values('自由人','M',35,'19780709');

 insert into tb_person
      (name,sex,age,birthday)
     values('加菲貓','M',35,'19780709');

-- ***********************************************************************

  select name from tb_person
   where id = '2';


-- ***********************************************************************

   select count(*) from tb_person;

-- ***********************************************************************

