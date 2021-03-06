<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="roleList.title" /></title>
<meta name="menu" content="ViewRoles" />
</head>

<h4>
	<fmt:message key="roleList.heading" />
</h4>

<s:form name="roleForm" action="roles" method="post"
	cssClass="form-horizontal">

	<div class="row">
		<div class="col-xs-3 search-group">
			<s:textfield cssClass="form-control search-control" key="role.code" />
			<input type="hidden" name="cb" value="${cbValue}"> 
		</div>
		<div class="col-xs-3 search-group">
			<s:textfield cssClass="form-control search-control" key="role.name" />
		</div>
		<div class="col-xs-3 search-group layouttrim">
			<input type="hidden" name="from" value="list" />
			<s:submit type="button" cssClass="btn btn-default btn-sm"
				formaction="roles" key="button.search" theme="simple">
				<i class="icon-search"></i>
				<fmt:message key="button.search" />
			</s:submit>
			<s:submit type="button" cssClass="btn btn-primary btn-sm"
				formaction="editRole" key="button.add" theme="simple">
				<i class="icon-plus icon-white"></i>
				<fmt:message key="button.add" />
			</s:submit>
		</div>
	</div>

	<%-- 		<div class="row">
			<div class="col-xs-3">
				<s:textfield key="role.code" cssClass="form-control" />
			</div>
			<div class="col-xs-3">
				<s:textfield key="role.name" cssClass="form-control" />
			</div>
			<div class="col-xs-3">
				<input type="hidden" name="from" value="list" />
				<s:submit type="button" cssClass="btn btn-default btn-sm"
					action="roles" key="button.search" theme="simple">
					<i class="icon-search"></i>
					<fmt:message key="button.search" />
				</s:submit>
				<s:submit type="button" cssClass="btn btn-primary btn-sm"
					action="editRole" key="button.add" theme="simple">
					<i class="icon-plus icon-white"></i>
					<fmt:message key="button.add" />
				</s:submit>
			</div>
		</div> --%>
</s:form>

<display:table name="roles" cellspacing="0" cellpadding="0"
	requestURI="roles" defaultsort="1" id="roles" pagesize="25"
	class="table table-condensed table-striped table-hover" export="true">

	<display:column property="code" escapeXml="true" sortable="true"
		titleKey="role.code" url="/user/editRole?from=list&cb=${cbValue}" paramId="code"
		paramProperty="code" />
	<display:column property="name" escapeXml="true" sortable="true"
		titleKey="role.name" url="/user/editRole?from=list&cb=${cbValue}" paramId="code"
		paramProperty="code" />

	<display:setProperty name="paging.banner.placement" value="both" />
	<display:setProperty name="paging.banner.item_name">
		<fmt:message key="roleList.role" />
	</display:setProperty>
	<display:setProperty name="paging.banner.items_name">
		<fmt:message key="roleList.roles" />
	</display:setProperty>

	<display:setProperty name="export.excel.filename" value="Role List.xls" />


	<display:setProperty name="export.pdf" value="false" />
	<display:setProperty name="export.excel" value="true" />
	<display:setProperty name="export.csv" value="false" />
	<display:setProperty name="export.xml" value="false" />
</display:table>

