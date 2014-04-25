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

    <g:javascript>

    function markreadunread(checkBox){
        var markRead = checkBox.checked ? true:false;
        var id = checkBox.value;
        var link = "${createLink(controller: 'userResource', action: 'markReadUnread')}";
        $.ajax({
            url:link+'?id='+id+'&markread='+markRead,
            success:function(data){
                    $(function () {
                        $("#dialog").dialog();
                    });
            }
        });
    }
    </g:javascript>
</head>

<body>
<div id="dialog" title="Basic dialog" style="display: none">
    <p>Your resource has been updated</p></div>
<table><tr><td><g:link controller="topic" action="create">Create New Topic</g:link></td></tr></table>
<ls:allTopics allTopics="${allTopics}" subscriptionsOfUser="${subscriptionsOfUser}"></ls:allTopics>
<ls:privateTopics allTopics="${allTopics}" subscriptionsOfUser="${subscriptionsOfUser}"></ls:privateTopics>
</body>
</html>