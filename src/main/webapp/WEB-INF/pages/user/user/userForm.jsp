<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="user.title" /></title>
<meta name="menu" content="ViewUsers" />
</head>

<div class="col-xs-10">
	<h2>
		<fmt:message key="user.heading" />
	</h2>

	<c:choose>
		<c:when test="${user.version == 0}">
			<%@ include file="userBasic.jsp"%>
		</c:when>
		<c:otherwise>
			<ul id="userTab" class="nav nav-tabs">
				<li class="active"><a href="#basic" data-toggle="tab"><fmt:message
							key="user.tab.basic" /></a></li>
				<li><a href="#assignPermission" data-toggle="tab"><fmt:message
							key="user.tab.assignPermission" /></a></li>
				<li><a href="#assignUser" data-toggle="tab"><fmt:message
							key="user.tab.assignRole" /></a></li>
			</ul>
			<div id="userTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="basic">
					<%@ include file="userBasic.jsp"%>
				</div>
				<div class="tab-pane fade" id="assignPermission">
					<%@ include file="assignPermission.jsp"%>
				</div>
				<div class="tab-pane fade" id="assignUser">
					<%@ include file="assignRole.jsp"%>
				</div>
			</div>

			<c:if test="${param.tab != null}">
				<script type="text/javascript">
					$('#userTab li:eq(${param.tab}) a').tab('show');
				</script>
			</c:if>

		</c:otherwise>
	</c:choose>
</div>