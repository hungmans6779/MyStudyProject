<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>spring mvc 模組 listCat.jsp </title>
	<style type="text/css">
	  body, td, th, input {font-size: 12px; }
	  table {border-collapse: collapse; border: 1px solid #000000; }
	  th, td {border-collapse: collapse; border: 1px solid #000000; padding: 4px; }
	</style>
  </head>
  
  <body>
   <table align='center' >
	  <tr>
		<th>id 編號</th>
		<th>名稱</th>
		<th>建立日期</th>
	  </tr>
	  <c:forEach var="cat" items="${catList}" >
        <tr>
          <td>${cat.id}</td>
          <td>${cat.name}</td>
          <td>${cat.createDate}</td>
        </tr>
      </c:forEach>
	</table>
  </body>
</html>
