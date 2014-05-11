<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' href='<%= org.webjars.AssetLocator.getWebJarPath("css/bootstrap.min.css") %>'>
<link rel='stylesheet' href='<%= org.webjars.AssetLocator.getWebJarPath("css/bootstrap-theme.min.css") %>'>
<script type='text/javascript' src='<%= org.webjars.AssetLocator.getWebJarPath("jquery.min.js") %>'></script>
<script type='text/javascript' src='<%= org.webjars.AssetLocator.getWebJarPath("js/bootstrap.min.js") %>'></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users</title>
</head>
<body>

	<table border='1' >
        <tr>
          <th>Name</th>
          <th>Email</th>
        </tr>
	    <c:forEach var="user" items="${users}">
        	<tr>
              <td><c:out value="${user.name}"/></td>
              <td><c:out value="${user.email}"/></td>
        	</tr>
        </c:forEach>
    </table>
        
	<ul>
  		<li><a href="editUser.htm">new user</a></li>
  		<li><a href="index.jsp">home</a></li>
	</ul>
	
</body>
</html>