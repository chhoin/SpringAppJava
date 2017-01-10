<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta content="" name="description" />
    <meta content="" name="author" />

    <!-- CORE CSS FRAMEWORK - START -->
    <link href="<%= request.getContextPath()%>/assetAdmin/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/assetAdmin/plugins/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/assetAdmin/fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/assetAdmin/css/animate.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/assetAdmin/plugins/perfect-scrollbar/perfect-scrollbar.min.css" rel="stylesheet" type="text/css"/>
    <!-- CORE CSS FRAMEWORK - END -->
</head>
<body>
hello
Web Application Context Path = <%= request.getContextPath()%>

</body>
</html>