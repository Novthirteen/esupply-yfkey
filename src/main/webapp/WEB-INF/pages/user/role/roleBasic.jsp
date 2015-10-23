<%@ include file="/common/taglibs.jsp"%>

<c:set var="delObject" scope="request">
	<fmt:message key="roleList.role" />
</c:set>
<script type="text/javascript">
	var msgDelConfirm = "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<c:choose>
	<c:when test="${role.version == 0}">
		<p>
			<fmt:message key="role.newMessage" />
		</p>
	</c:when>
	<c:otherwise>
		<p>
			<fmt:message key="role.updateMessage" />
		</p>
	</c:otherwise>
</c:choose>

<s:form name="roleForm" action="saveRole" method="post" validate="false"
	cssClass="well" autocomplete="off">
	<input type="hidden" name="from" value="${param.from}" />
	<div class="row">
		<div class="col-xs-4">
			<c:choose>
				<c:when test="${role.version != 0}">
					<input type="hidden" name="code" value="${role.code}" />
					<s:hidden key="role.code" />
					<s:hidden key="role.version" />
					<s:label key="role.code" cssClass="form-control" />
				</c:when>
				<c:otherwise>
					<s:textfield key="role.code" required="true" cssClass="form-control" />
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4">
			<s:textfield key="role.name" required="true" cssClass="form-control" />
		</div>
	</div>
	<hr>
	<div id="actions" class="form-group form-actions">
		<s:submit type="button" cssClass="btn btn-primary" method="save"
			key="button.save" theme="simple">
			<i class="icon-ok icon-white"></i>
			<fmt:message key="button.save" />
		</s:submit>

		<c:if test="${role.version != 0}">
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
						document.forms['roleForm']).focus();
			});
</script>