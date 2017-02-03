<!-- <?xml version="1.0" encoding="UTF-8"?> -->
<%-- <%@ page contentType="text/html; charset=utf-8" session="true" pageEncoding="utf-8"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- isELIgnored we can use ${pageContext.request.contextPath} --%>
<%@ page isELIgnored="false" %>
<%-- To get user login information --%>
<sec:authentication var="session" property="principal" />