<!DOCTYPE html>
<%@ include file="/common/taglibs.jsp"%>
<html lang="en">
<head>
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="<c:url value="/images/favicon.ico"/>" />
<title><decorator:title /> | <fmt:message key="webapp.name" /></title>
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/styles/lib/bootstrap.min.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/styles/lib/bootstrap-duallistbox.min.css'/>" />
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/styles/style.css'/>" />
<decorator:head />

<script type="text/javascript"
	src="<c:url value='/scripts/lib/jquery-2.1.4.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/scripts/lib/bootstrap.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/scripts/lib/plugins/jquery.cookie.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/scripts/lib/jquery.bootstrap-duallistbox.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/script.js'/>"></script>
</head>
<body
	<decorator:getProperty property="body.id" writeEntireProperty="true"/>
	<decorator:getProperty property="body.class" writeEntireProperty="true"/>>
	<c:set var="currentMenu" scope="request">
		<decorator:getProperty property="meta.menu" />
	</c:set>

	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#navbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value='/'/>"><fmt:message
					key="webapp.name" /></a>
		</div>

		<div class="navbar-collapse collapse pull-right">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><fmt:message key="login.Theme" /> <b
						class="caret"></b></a>
					<ul class="dropdown-menu dropdown-menu-right">
						<li><a href="#" data-theme="default" class="theme-link">Default</a></li>
						<li><a href="#" data-theme="cerulean" class="theme-link">Cerulean</a></li>
						<li><a href="#" data-theme="cosmo" class="theme-link">Cosmo</a></li>
						<li><a href="#" data-theme="cyborg" class="theme-link">Cyborg</a></li>
						<li><a href="#" data-theme="flatly" class="theme-link">Flatly</a></li>
						<li><a href="#" data-theme="journal" class="theme-link">Journal</a></li>
						<li><a href="#" data-theme="readable" class="theme-link">Readable</a></li>
						<li><a href="#" data-theme="simplex" class="theme-link">Simplex</a></li>
						<li><a href="#" data-theme="slate" class="theme-link">Slate</a></li>
						<li><a href="#" data-theme="spacelab" class="theme-link">Spacelab</a></li>
						<li><a href="#" data-theme="united" class="theme-link">United</a></li>
					</ul></li>
			</ul>
		</div>

		<div class="navbar-collapse collapse pull-right">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false"> <fmt:message
							key="login.language" /><b class="caret"></b>
				</a>
					<ul class="dropdown-menu dropdown-menu-right">
						<li><a href="#" data-language="zh" class="language-link">
								<fmt:message key="login.language.zh" />
						</a></li>
						<li><a href="#" data-language="en" class="language-link">
								<fmt:message key="login.language.en" />
						</a></li>
					</ul></li>
			</ul>
		</div>
	</div>

	<div class="container" id="content">
		<%@ include file="/common/messages.jsp"%>
		<div class="row">
			<decorator:body />

			<c:if test="${currentMenu == 'AdminMenu'}">
				<div class="col-sm-2">
					<menu:useMenuDisplayer name="Velocity" config="navlistMenu.vm"
						permissions="rolesAdapter">
						<menu:displayMenu name="AdminMenu" />
					</menu:useMenuDisplayer>
				</div>
			</c:if>
		</div>
	</div>

	<div id="footer" class="container navbar-fixed-bottom">
		<span class="col-sm-6 text-left"><fmt:message
				key="webapp.version" /> <c:if
				test="${pageContext.request.remoteUser != null}">
            | <fmt:message key="user.status" /> ${pageContext.request.remoteUser}
            </c:if> </span> <span class="col-sm-6 text-right"> &copy; <fmt:message
				key="copyright.year" /> <a href="<fmt:message key="company.url"/>"><fmt:message
					key="company.name" /></a>
		</span>
	</div>
	<%=(request.getAttribute("scripts") != null) ? request.getAttribute("scripts") : ""%>
</body>
</html>
