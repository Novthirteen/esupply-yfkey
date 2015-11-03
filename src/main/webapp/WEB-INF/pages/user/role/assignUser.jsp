<%@ include file="/common/taglibs.jsp"%>

<p>
	<fmt:message key="role.assignRoleUserMessage" />
</p>

<s:form id="assignRoleUserForm" action="editRole" method="post"
	validate="true" cssClass="well form-horizontal">
	<input type="hidden" name="from" value="${param.from}" />
	<input type="hidden" name="code" value="${role.code}" />
	<input type="hidden" name="tab" value="2" />
	<div class="row">
		<div class="col-xs-10">
			<s:select key="role.assignRoleUser" id="availableUsers"
				name="assignedUsers" list="availableUsers" listValue="label"
				listKey="value" multiple="true" size="10">
			</s:select>
		</div>
	</div>
	<hr>
	<div id="actions" class="form-group form-actions">
		<c:if test="${canAssignRoleUser}">
			<s:submit type="button" cssClass="btn btn-primary"
				action="saveRoleUser" key="button.save" theme="simple">
				<i class="icon-ok icon-white"></i>
				<fmt:message key="button.save" />
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
	var assignedUsers = $('select[name="assignedUsers"]')
			.bootstrapDualListbox(
					{
						selectedListLabel : '<fmt:message key="role.assignedUsers" />',
						nonSelectedListLabel : '<fmt:message key="role.availableUsers" />',
						selectorMinimalHeight : 200,
						infoText : false,
					});
</script>