<%@ include file="/common/taglibs.jsp"%>

<c:set var="delObject" scope="request">
	<fmt:message key="userList.user" />
</c:set>
<script type="text/javascript">
	var msgDelConfirm = "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<c:choose>
	<c:when test="${user.version == 0}">
		<p>
			<fmt:message key="user.newMessage" />
		</p>
	</c:when>
	<c:otherwise>
		<p>
			<fmt:message key="user.updateMessage" />
		</p>
	</c:otherwise>
</c:choose>

<s:form name="userForm" action="saveUser" method="post" validate="false"
	cssClass="well" autocomplete="off">
	<input type="hidden" name="from" value="${param.from}" />
	<div class="row">
		<div class="col-xs-6">
			<c:choose>
				<c:when test="${user.version != 0}">
					<s:hidden key="user.username" />
					<s:hidden key="user.version" />
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
			<s:textfield key="user.firstName" required="true"
				cssClass="form-control" />
		</div>
		<div class="col-xs-6">
			<s:textfield key="user.lastName" required="true"
				cssClass="form-control" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-6">
			<s:textfield key="user.mobilePhone" cssClass="form-control" />
		</div>
		<div class="col-xs-6">
			<s:radio key="user.gender" listValue="value" listKey="label"
				list="genderList" />
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
			<fieldset class="form-group">
				<label class="control-label"> <fmt:message
						key="userProfile.accountSettings" />
				</label> <label class="checkbox inline"> <s:checkbox
						key="user.enabled" id="user.enabled" theme="simple"
						fieldValue="true" /> <fmt:message key="user.enabled" />
				</label> <label class="checkbox inline"> <s:checkbox
						key="user.accountExpired" id="user.accountExpired" theme="simple"
						fieldValue="true" /> <fmt:message key="user.accountExpired" />
				</label> <label class="checkbox inline"> <s:checkbox
						key="user.accountLocked" id="user.accountLocked" theme="simple"
						fieldValue="true" /> <fmt:message key="user.accountLocked" />
				</label> <label class="checkbox inline"> <s:checkbox
						key="user.credentialsExpired" id="user.credentialsExpired"
						theme="simple" fieldValue="true" /> <fmt:message
						key="user.credentialsExpired" />
				</label>
			</fieldset>
		</div>
	</div>
	<hr>
	<div id="actions" class="form-group form-actions">
		<s:submit type="button" cssClass="btn btn-primary" method="save"
			key="button.save" theme="simple">
			<i class="icon-ok icon-white"></i>
			<fmt:message key="button.save" />
		</s:submit>

		<c:if test="${user.version != 0}">
			<s:submit type="button" cssClass="btn btn-danger" method="delete"
				key="button.delete" onclick="return confirmMessage(msgDelConfirm)"
				theme="simple">
				<i class="icon-trash"></i>
				<fmt:message key="button.delete" />
			</s:submit>
		</c:if>

		<s:submit type="button" cssClass="btn" method="cancel"
			key="button.cancel" theme="simple">
			<i class="icon-remove"></i>
			<fmt:message key="button.cancel" />
		</s:submit>
	</div>
</s:form>

<script type="text/javascript">
	$(document).ready(
			function() {
				$("input[type='text']:visible:enabled:first",
						document.forms['userForm']).focus();
			});
</script>