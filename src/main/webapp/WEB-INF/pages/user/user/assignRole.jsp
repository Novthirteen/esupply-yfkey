<%@ include file="/common/taglibs.jsp"%>

<p>
	<fmt:message key="user.assignUserUserMessage" />
</p>

<s:form id="assignUserUserForm" action="editUser" method="post"
	validate="true" cssClass="well form-horizontal">
	<input type="hidden" name="from" value="${param.from}" />
	<input type="hidden" name="username" value="${user.username}" />
	<input type="hidden" name="tab" value="2" />
	<div class="row">
		<div class="col-xs-12">
			<s:select key="user.assignUserRole" id="availableRoles"
				name="assignedRoles" list="availableRoles" listValue="label"
				listKey="value" multiple="true" size="10">
			</s:select>
		</div>
	</div>
	<hr>
	<div id="actions" class="form-group form-actions">
		<s:submit type="button" cssClass="btn btn-primary"
			action="saveUserRole" key="button.save" theme="simple">
			<i class="icon-ok icon-white"></i>
			<fmt:message key="button.save" />
		</s:submit>

		<s:submit type="button" cssClass="btn" method="cancel"
			key="button.cancel" theme="simple">
			<i class="icon-remove"></i>
			<fmt:message key="button.cancel" />
		</s:submit>
	</div>
</s:form>

<script type="text/javascript">
	var assignedUsers = $('select[name="assignedRoles"]')
			.bootstrapDualListbox(
					{
						selectedListLabel : '<fmt:message key="user.assignedRoles" />',
						nonSelectedListLabel : '<fmt:message key="user.availableRoles" />',
						selectorMinimalHeight : 200,
						infoText : false,
					});
</script>