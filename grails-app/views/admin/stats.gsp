<%--
  Created by IntelliJ IDEA.
  User: intelligrape
  Date: 19/4/14
  Time: 6:30 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta content="main" name="layout">
</head>

<body>
<table><caption>Total Users</caption>
    <th>Total No of Users</th><th>${noOfUsers}</th>
</table>

<div>
    <table>
        <caption>User and their subscriptions</caption>
        <tr><th>User</th><th>Subscriptions</th></tr>
        <g:each in="${map}" var="entry">
            <tr>
                <td>${entry.key}</td>
                <td>${entry.value}</td>
            </tr>
        </g:each>
    </table>
</div>
</body>
</html>