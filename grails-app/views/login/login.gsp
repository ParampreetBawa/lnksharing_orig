<%--
  Created by IntelliJ IDEA.
  User: intelligrape
  Date: 19/4/14
  Time: 5:46 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main">
</head>
<body>
<span>${errors}</span>
<g:form controller="login" action="loginHandler">
    <div>UserName : <g:textField name="username"></g:textField></div>
    <div>Password : <g:passwordField name="password"></g:passwordField></div>
    <div><g:submitButton name="Login"></g:submitButton></div>
</g:form>
</body>
</html>