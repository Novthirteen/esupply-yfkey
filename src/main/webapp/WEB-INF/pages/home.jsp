<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="home.title" /></title>
<meta name="menu" content="Home" />
</head>
<body class="home">

	<h2>
		<fmt:message key="home.heading" />
	</h2>
	<p>
		<fmt:message key="home.message" />
	</p>

<ul class="glassList">
    <li>
        <a href="<c:url value='user/editProfile'/>"><fmt:message key="menu.user"/></a>
    </li>
<!--       <li> -->
<%--         <a href="<c:url value='/uploadFile'/>"><fmt:message key="menu.selectFile"/></a> --%>
<!--     </li> -->
</ul>
	<ul class="glassList">
		<li><a href="<c:url value='/user/editProfile'/>"><fmt:message
					key="menu.user" /></a></li>
	</ul>

	<c:if test="${not empty sessionScope.forceChangePassword}">
		<div class="modal fade" id="changePasswordModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h2>
							<fmt:message key="user.changePassword" />
						</h2>
					</div>
					<div class="modal-body">
						<%@ include file="/common/messages.jsp"%>
						<s:form name="userForm" action="savePassword" method="post"
							validate="false" cssClass="well" autocomplete="off">
							<input type="hidden" name="username" value="${pageContext.request.remoteUser}" />
							<div class="row">
								<div class="col-xs-6">
									<s:password key="user.password" showPassword="true"
										required="true" onchange="passwordChanged(this)"
										cssClass="form-control" value=""/>
								</div>
								<div class="col-xs-6">
									<s:password key="user.confirmPassword" required="true"
										cssClass="form-control" showPassword="true"
										onchange="passwordChanged(this)" value=""/>
								</div>
							</div>

							<hr>
							<div id="actions" class="form-group form-actions">
								<s:submit type="button" cssClass="btn btn-primary"
									key="button.save" theme="simple">
									<i class="icon-ok icon-white"></i>
									<fmt:message key="button.save" />
								</s:submit>
							</div>
						</s:form>
					</div>
				</div>
			</div>
		</div>

		<script type="text/javascript">
			$(window).load(function() {
				$('#changePasswordModal').modal({
					keyboard : false,
					backdrop : 'static',
					show : true
				});
			});

			$(document).ready(
					function() {
						$("input[type='text']:visible:enabled:first",
								document.forms['userForm']).focus();
					});
		</script>
	</c:if>
</body>