<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="login.title"/></title>
    <meta name="menu" content="Login"/>
</head>
<body id="login">

<form method="post" id="loginForm" action="<c:url value='/j_security_check'/>"
    onsubmit="saveUsername(this);return validateForm(this)" class="form-signin" autocomplete="off">

    
<c:if test="${param.error != null}">
    <div class="alert alert-danger alert-dismissable">
        <fmt:message key="errors.password.mismatch"/>
    </div>
</c:if>


<div class="login_boder">
  <div class="login_padding" id="login_model">
  	<div class="login_logo"><img src="./images/logo_lite.png" width="72" height="50"><fmt:message key="webapp.name" /></div>
  	
	<div class="form-group">
		<input type="text" class="form-control" name="j_username" id="j_username" class="form-control"
          		placeholder="<fmt:message key="label.username"/>" required tabindex="1">
	</div>
	<div class="form-group">
		<input type="password" class="form-control" name="j_password" id="j_password" tabindex="2"
          		placeholder="<fmt:message key="label.password"/>" required>
	</div>
		<%-- 		<input type="text" name="j_username" id="j_username" class="form-control"
           placeholder="<fmt:message key="label.username"/>" required tabindex="1">
    <br />
    <input type="password" class="form-control" name="j_password" id="j_password" tabindex="2"
           placeholder="<fmt:message key="label.password"/>" required> --%>

<c:if test="${appConfig['rememberMeEnabled']}">
    <label for="rememberMe" class="checkbox">
        <input type="checkbox" name="_spring_security_remember_me" id="rememberMe" tabindex="3"/>
        <fmt:message key="login.rememberMe"/></label>
</c:if>
	<br />
    <button type="submit" class="btn btn-lg btn-primary btn-block" name="login" tabindex="4">
        <fmt:message key='button.login'/>
    </button>
  </div>
</div>
</form>

<%-- <p id="ppp1">
    <fmt:message key="login.signup">
        <fmt:param><c:url value="/signup"/></fmt:param>
    </fmt:message>
</p>
 --%>
<c:set var="scripts" scope="request">
<%@ include file="/scripts/login.js"%>
</c:set>

<%-- <p id="ppp2"><fmt:message key="login.passwordHint"/></p> --%>
</body>