<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<h2 align="center">well come home </h2>
	
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
					        <sec:authorize access="hasRole('ADMIN')">
								<th>Activities</th>
							</sec:authorize>
					      </tr>
					    </thead>
					    <tbody>
					    <c:forEach var="row" items="${pro}">
					    	 <tr>
						        <td><c:out value="${row.pro_id}"/></td>
						        <td><c:out value="${row.pro_name}"/></td>
						        <td><c:out value="${row.pro_description}"/></td>
						        <sec:authorize access="hasRole('ADMIN')">
						        	<td><a href="${pageContext.request.contextPath}/delete-${row.pro_id}">Delete</a></td>
						        </sec:authorize>
						      </tr>
					    </c:forEach> 
					     
					      
					    </tbody>
					  </table>
				
				</div>  
			</div>
		</div>
	</div>
</body>
</html>