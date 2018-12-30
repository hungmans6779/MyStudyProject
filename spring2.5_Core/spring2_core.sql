/*
  MySQL 中文亂碼處理方式
  參考網址 
  http://avrilnote.pixnet.net/blog/post/4652705-mysql%E4%B8%AD%E6%96%87%E4%BA%82%E7%A2%BC%E7%9A%84%E5%8E%9F%E5%9B%A0


  DateBase 設定：
  Connection URL： jdbc:mysql://localhost:3306/spring2_core?characterEncoding=UTF-8
  Driver Class： com.mysql.jdbc.Driver

*/

-- *********************************************************************************************************

use spring2_core;

alter database spring2_core character set utf8;



show variables like '%character%';

-- *********************************************************************************************************


use spring2_core;


show tables;
  

-- *********************************************************************************************************



