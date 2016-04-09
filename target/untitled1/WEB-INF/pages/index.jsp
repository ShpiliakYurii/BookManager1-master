<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Авторизація</title>
    <link href="<c:url value="/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css"/>" rel="stylesheet" media="screen">
    <link href="<c:url value="/resources/c/css.css"/>" rel="stylesheet" media="screen">
    <link href="<c:url value="/resources/c/select.css"/>" rel="stylesheet" media="screen">
    <script src="<c:url value="/resources/s/select.js"/>"></script>
</head>
<body>
<div class="container">
    <t:head/>
    <t:menu/>
    <div class="row content">
        <div class="col-md-12 avtorisation">
            <h1>Авторизація</h1>
            <form:form method="POST"  action="/validate">
                Login <br> <input name="login" id="login" type="text" class="input-text"/><br/><form:errors path="login"></form:errors>
                Password <br> <input name="pass" id="pass" type="password" class="input-text"/><br/><form:errors path="pass"></form:errors>
                <div class="col-sm-5"></div><input type="submit" value="login" class="button col-sm-2">
            </form:form>
        </div>
    </div>
</div>
</body>
</html>

