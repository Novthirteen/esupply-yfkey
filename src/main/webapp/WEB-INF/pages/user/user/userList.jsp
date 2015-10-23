<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="userList.title" /></title>
<meta name="menu" content="ViewUsers" />
</head>


<h2>
	<fmt:message key="userList.heading" />
</h2>

<s:form name="userForm" action="users" method="post"
	cssClass="form-horizontal">

	<div class="row">
		<div class="col-xs-4 search-group">
			<s:textfield cssClass="form-control search-control"
				key="user.username" />
		</div>
		<div class="col-xs-4 search-group">
			<s:textfield cssClass="form-control search-control"
				key="user.firstName" />
		</div>
		<div class="col-xs-4 search-group">
			<s:textfield cssClass="form-control search-control"
				key="user.lastName" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4 search-group"></div>
		<div class="col-xs-4 search-group layouttrim">
			<input type="hidden" name="from" value="list" />
			<s:submit type="button" cssClass="btn btn-default btn-sm"
				action="users" key="button.search" theme="simple">
				<i class="icon-search"></i>
				<fmt:message key="button.search" />
			</s:submit>
			<s:submit type="button" cssClass="btn btn-primary btn-sm"
				action="editUser" key="button.add" theme="simple">
				<i class="icon-plus icon-white"></i>
				<fmt:message key="button.add" />
			</s:submit>
		</div>
		<div class="col-xs-4 search-group"></div>
	</div>
	<%-- 	<div class="row">
			<div class="col-xs-3">
				<s:textfield key="user.username" cssClass="form-control" />
			</div>
			<div class="col-xs-3">
				<s:textfield key="user.firstName" cssClass="form-control" />
			</div>
			<div class="col-xs-3">
				<s:textfield key="user.lastName" cssClass="form-control" />
			</div>
			<div class="col-xs-3">
				<input type="hidden" name="from" value="list" />
				<s:submit type="button" cssClass="btn btn-default btn-sm"
					action="users" key="button.search" theme="simple">
					<i class="icon-search"></i>
					<fmt:message key="button.search" />
				</s:submit>
				<s:submit type="button" cssClass="btn btn-primary btn-sm"
					action="editUser" key="button.add" theme="simple">
					<i class="icon-plus icon-white"></i>
					<fmt:message key="button.add" />
				</s:submit>
			</div>
		</div> --%>
</s:form>

<display:table name="users" cellspacing="0" cellpadding="0"
	requestURI="users" defaultsort="1" id="users" pagesize="25"
	class="table table-condensed table-striped table-hover" export="true">

	<display:column property="username" escapeXml="true" sortable="true"
		titleKey="user.username" url="/user/editUser?from=list"
		paramId="username" paramProperty="username" />
	<display:column property="fullName" escapeXml="true" sortable="true"
		titleKey="user.fullName" url="/user/editUser?from=list"
		paramId="username" paramProperty="username" />
	<display:column property="email" escapeXml="true" sortable="true"
		titleKey="user.email" url="/user/editUser?from=list"
		paramId="username" paramProperty="username" />
	<display:column property="address" escapeXml="true" sortable="true"
		titleKey="user.address" url="/user/editUser?from=list"
		paramId="username" paramProperty="username" />
	<display:column property="phoneNumber" escapeXml="true" sortable="true"
		titleKey="user.phoneNumber" url="/user/editUser?from=list"
		paramId="username" paramProperty="username" />
	<display:column property="mobilephone" escapeXml="true" sortable="true"
		titleKey="user.mobilephone" url="/user/editUser?from=list"
		paramId="username" paramProperty="username" />
	<display:column sortProperty="enabled" sortable="true" media="html"
		titleKey="user.enabled">
		<input type="checkbox" disabled="disabled"
			<c:if test="${users.enabled}">checked="checked"</c:if> />
	</display:column>

	<display:setProperty name="paging.banner.placement" value="both" />
	<display:setProperty name="paging.banner.item_name">
		<fmt:message key="roleList.role" />
	</display:setProperty>
	<display:setProperty name="paging.banner.items_name">
		<fmt:message key="roleList.roles" />
	</display:setProperty>

	<display:setProperty name="export.excel.filename" value="User List.xls" />
	<display:setProperty name="export.pdf" value="false" />
	<display:setProperty name="export.excel" value="true" />
	<display:setProperty name="export.csv" value="false" />
	<display:setProperty name="export.xml" value="false" />
</display:table>

