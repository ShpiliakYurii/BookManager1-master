<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Avtorisation</title>
</head>
<body>
<div>
  <h1>Avtorisation</h1>
  <c:if test = "${!empty books}">
    <table>
        <tr>
            <th>Name</th>
            <th>Genre</th>
        </tr>
        <c:forEach items = "${books}" var = "book">
            <tr>
                <td>${book.name}</td>
                <td>${book.genre}<td>
            </tr>
        </c:forEach>
    </table>
  </c:if>
    <form:form method="POST"  action="/validate">
        Login <input name="login" id="login" type="text"/><br/><form:errors path="login"></form:errors>
        Password <input name="pass" id="pass" type="password"/><br/><form:errors path="pass"></form:errors>
        <input type="submit" value="login">
    </form:form>

</div>
</body>
</html>
