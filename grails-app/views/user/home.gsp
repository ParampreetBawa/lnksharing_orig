<%--
  Created by IntelliJ IDEA.
  User: intelligrape
  Date: 19/4/14
  Time: 7:09 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main">
</head>

<body>
<g:render template="showReadingItems"></g:render>
<table><caption>Subscribed topics</caption><tr><th>Topic</th><th>Owner By Me</th></tr>
    <g:each in="${topics}" var="topic">
        <tr>
            <td>${topic.name}</td>
            <td>${topic.createdBy.email.equals(session.user) ? "Yes" : "No"}</td></tr>
    </g:each>
</table>
</body>
</html>