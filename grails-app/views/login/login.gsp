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
    <g:javascript>
        $(document).ready(function(){
            $("#loginform").validate();
            var message = "${flash.get('message')}";
            if(null != message && "" != message)
                 alert(message);
        });
    </g:javascript>
</head>

<body>
<span>${errors}</span>
<span></span>
<div id="login-user" class="content scaffold-create" role="main">
    <form action="${createLink(controller:'login', action:'loginHandler')}" id="loginform">
        <fieldset class="form">
            <div class="fieldcontain">
                UserName : <g:textField name="username" class="required email"></g:textField></div>

            <div class="fieldcontain">Password : <g:passwordField name="password" class="required"></g:passwordField></div>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="Login" class="save"></g:submitButton>
            <g:link controller="user" action="register"><g:message code="user.new.register.label"></g:message></g:link>
            <g:link controller="user" action="forgotPassword"><g:message code="user.forgotpass.label" default="Forgot Password"></g:message></g:link>
        </fieldset>
    </form>

    <div id="create-user" class="content scaffold-create" role="main">
</body>
</html>