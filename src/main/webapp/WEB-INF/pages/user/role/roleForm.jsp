<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="role.title" /></title>
<meta name="menu" content="UserMenu" />
</head>

<div class="col-xs-10">
	<h2>
		<fmt:message key="role.heading" />
	</h2>

	<c:choose>
		<c:when test="${role.version == 0}">
			<%@ include file="roleBasic.jsp"%>
		</c:when>
		<c:otherwise>
			<ul id="roleTab" class="nav nav-tabs">
				<li class="active"><a href="#basic" data-toggle="tab"><fmt:message
							key="role.tab.basic" /></a></li>
				<li><a href="#assignPermission" data-toggle="tab"><fmt:message
							key="role.tab.assignPermission" /></a></li>
				<li><a href="#assignUser" data-toggle="tab"><fmt:message
							key="role.tab.assignUser" /></a></li>
			</ul>
			<div id="roleTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="basic">
					<%@ include file="roleBasic.jsp"%>
				</div>
				<div class="tab-pane fade" id="assignPermission">
					<%@ include file="assignPermission.jsp"%>
				</div>
				<div class="tab-pane fade" id="assignUser">
					<%@ include file="assignUser.jsp"%>
				</div>
			</div>

			<c:if test="${param.tab != null}">
				<script type="text/javascript">
					$('#roleTab li:eq(${param.tab}) a').tab('show');
				</script>
			</c:if>

		</c:otherwise>
	</c:choose>
</div>