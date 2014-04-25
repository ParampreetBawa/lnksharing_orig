<%--
  Created by IntelliJ IDEA.
  User: intelligrape
  Date: 25/4/14
  Time: 10:18 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main">
</head>

<body>
<div id="forgot-pass" class="content scaffold-create" role="main">
    <form id="forgotPass" action="${createLink(controller: 'user', action: 'resetPassword')}" method="post">
        <fieldset class="form">
            <div class="fieldcontain">
                UserName:<g:textField name="username"></g:textField>
            </div>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="Reset Password"></g:submitButton>
        </fieldset>
    </form>
</div>
</body>
</html>