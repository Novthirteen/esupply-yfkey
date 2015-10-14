<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="userProfile.title"/></title>
    <meta name="menu" content="UserMenu"/>
</head>

<s:form name="userForm" action="saveUser" method="post" validate="false"
	cssClass="well" autocomplete="off">
	<input type="hidden" name="from" value="${param.from}" />
	<div class="row">
		<div class="col-xs-6">
			<c:choose>
				<c:when test="${user.version != 0}">
					<s:hidden key="user.username" />
					<s:hidden key="user.version" />
					<s:hidden key="user.enforce_password" />
					<s:hidden key="user.enabled" />
					<s:hidden key="user.accountExpired" />
					<s:hidden key="user.accountLocked" />
					<s:hidden key="user.credentialsExpired" />
					<s:label key="user.username" cssClass="form-control" />
				</c:when>
				<c:otherwise>
					<s:textfield key="user.username" required="true"
						cssClass="form-control" />
				</c:otherwise>
			</c:choose>
		</div>
		<div class="col-xs-6"></div>
	</div>
	<div class="row">
		<div class="col-xs-6">
			<s:password key="user.password" showPassword="true" required="true"
				onchange="passwordChanged(this)" cssClass="form-control" />
		</div>
		<div class="col-xs-6">
			<s:password key="user.confirmPassword" required="true"
				cssClass="form-control" showPassword="true"
				onchange="passwordChanged(this)" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-6">
			<s:textfield key="user.lastName" required="true"
				cssClass="form-control" />
		</div>
		<div class="col-xs-6">
			<s:textfield key="user.firstName" required="true"
				cssClass="form-control" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-6">
			<s:textfield key="user.mobilephone" cssClass="form-control" />
		</div>
		<div class="col-xs-6">
			<s:radio key="user.gender" listValue="value" listKey="label"
				list="genderList" required="true" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-6">
			<s:textfield key="user.email" cssClass="form-control" />
		</div>
		<div class="col-xs-6">
			<s:textfield key="user.phoneNumber" cssClass="form-control" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<s:textfield key="user.website" cssClass="form-control" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<s:textfield key="user.address" cssClass="form-control" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<label class="control-label"> <fmt:message
					key="userProfile.accountSettings" />
			</label>
		</div>
	</div>

	<div id="actions" class="form-group form-actions">
		<s:submit type="button" cssClass="btn btn-primary" method="save"
			key="button.save" theme="simple">
			<i class="icon-ok icon-white"></i>
			<fmt:message key="button.save" />
		</s:submit>
	</div>
</s:form>

