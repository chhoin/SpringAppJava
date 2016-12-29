<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>This is Admin</center>
	<div class="container">
		<!-- Table -->
		<div class="row" >
			<div class="panel panel-primary">
			  <div class="panel-heading ">List Article</div>
				<div class="panel-body">
					  <table class="table table-hover">
					    <thead>
					      <tr>
					        <th>ID</th>
					        <th>Title</th>
					        <th>Description</th>
					      
					      </tr>
					    </thead>
					    <tbody>
					    	 <tr>
						        <td><c:out value="${user.id}"/></td>
						        <td><c:out value="${user.username}"/></td>
						        <td><c:out value="${user.email}"/></td>
						      </tr>
					    </tbody>
					  </table>
				
				</div>  
			</div>
		</div>
	</div>
</body>
</html>