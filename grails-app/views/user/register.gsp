<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
    <g:javascript>
        $(document).ready(function () {
            $("#date").datepicker();
            $("#registeruser").validate({
                        rules: {
                            email: {
                                required: true,
                                email: true,
                                remote: {
                                    url: "${validateEmail}",
                                    type: 'post'
                                }
                            },
                            confirmPassword:{
                                equalTo:"#password"
                            }
                        },
                        messages: {
                            email: {
                                required: "Username required",
                                email: "Please enter valid email",
                                remote: "Email already exists in our records"
                            },
                            confirmPassword:{
                                equalTo:"Password not matched"
                            }
                        }
                    }
            )
        });
    </g:javascript>
</head>

<body>
<a href="#create-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                             default="Skip to content&hellip;"/></a>

%{--<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
    </ul>
</div>--}%

<div id="create-user" class="content scaffold-create" role="main">
    <h1><g:message code="user.register.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${userInstance}">
        <ul class="errors" role="alert">
            <g:eachError bean="${userInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                        error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>

    <form id="registeruser" method="post" action="${createLink(controller: 'user', action: 'registerHandler')}"
    <fieldset class="form">
        <g:render template="form"/>
    </fieldset>
    <fieldset class="buttons">
        <g:submitButton name="create" class="save"
                        value="${message(code: 'default.button.create.label', default: 'Create')}"/>
        <g:link controller="login" action="index"><g:message code="user.login.alreadyregister.login" default="Already Register"></g:message></g:link>
    </fieldset>
</form>
</div>
</body>
</html>
