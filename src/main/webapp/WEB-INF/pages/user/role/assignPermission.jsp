<%@ include file="/common/taglibs.jsp"%>

<p>
	<fmt:message key="role.assignRolePermissionMessage" />
</p>

<s:form id="assignRolePermissionForm" action="editRole" method="post"
	validate="true" cssClass="well form-horizontal">
	<input type="hidden" name="from" value="${param.from}" />
	<input type="hidden" name="code" value="${role.code}" />
	<input type="hidden" name="tab" value="1" />
	<div class="row">
		<div class="col-xs-4">
			<s:select key="role.permissionType" id="permissionType"
				name="permissionType" list="permissionTypeList" listKey="label"
				listValue="value" cssClass="form-control" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-10">
			<s:select key="role.assignRolePermission" id="availablePermissions"
				name="assignedPermissions" list="availablePermissions"
				listValue="label" listKey="value" multiple="true" size="10">
			</s:select>
		</div>
	</div>
	<hr>
	<div id="actions" class="form-group form-actions">
		<s:submit type="button" cssClass="btn btn-primary"
			action="saveRolePermission" key="button.save" theme="simple">
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
<c:if test="${param.permissionType != null}">
	$('#permissionType').find('option[value="${param.permissionType}"]').attr('selected', true);
</c:if>
	
	$("#permissionType").change(function(e) {
		$("#assignRolePermissionForm").submit();
	});
	
	 var assignedPermissions = $('select[name="assignedPermissions"]').bootstrapDualListbox({
		 selectedListLabel:'<fmt:message key="role.assignedPermissions" />',
		 nonSelectedListLabel:'<fmt:message key="role.availablePermissions" />',
		 selectorMinimalHeight:200,
		 infoText:false,
       });
</script>