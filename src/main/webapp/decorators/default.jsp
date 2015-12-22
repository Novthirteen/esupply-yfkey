
<%
	try {
%>
<!DOCTYPE html>
<%@ include file="/common/taglibs.jsp"%>
<html lang="en">
<head>
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="<c:url value="/images/favicon.ico"/>" />
<title><decorator:title /> | <fmt:message key="webapp.name" /></title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/styles/lib/bootstrap-duallistbox.min.css'/>" />
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/styles/lib/bootstrap-datepicker3.min.css'/>" />
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/styles/style.css'/>" />
<decorator:head />

<script type="text/javascript"
	src="<c:url value='/scripts/lib/jquery-2.1.4.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/scripts/lib/bootstrap.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/scripts/lib/plugins/jquery.cookie.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/scripts/lib/jquery.bootstrap-duallistbox.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/script.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/scripts/lib/bootstrap3-typeahead.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/scripts/lib/bootstrap-datepicker.min.js'/>"></script>
<script type="text/javascript" charset="UTF-8"
	src="<c:url value='/scripts/lib/locales/bootstrap-datepicker.zh_CN.min.js'/>"></script>
<script>
	var themes = {
		"default" : "<c:url value='/styles/lib/bootstrap.min.css'/>",
		"cerulean" : "<c:url value='/styles/lib/cerulean.min.css'/>",
		"cosmo" : "<c:url value='/styles/lib/cosmo.min.css'/>",
		"cyborg" : "<c:url value='/styles/lib/cyborg.min.css'/>",
		"united" : "<c:url value='/styles/lib/united.min.css'/>"
	}

	<c:choose>
	<c:when test="${not empty sessionScope.theme}">
	var themesheet = $('<link rel="stylesheet" type="text/css" media="all" href="' + themes["${sessionScope.theme}"] + '" />');
	</c:when>
	<c:otherwise>
	var themesheet = $('<link rel="stylesheet" type="text/css" media="all" href="' + themes["default"] + '" />');
	</c:otherwise>
	</c:choose>
	themesheet.appendTo('head');
</script>
</head>
<body class="main"
	<decorator:getProperty property="body.id" writeEntireProperty="true"/>
	<decorator:getProperty property="body.class" writeEntireProperty="true"/>>
	<c:set var="currentMenu" scope="request">
		<decorator:getProperty property="meta.menu" />
	</c:set>


	<div class="container" id="content">
		<div class="navbar navbar-default" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value='/'/>"></a>
				<%-- <a class="navbar-brand" href="<c:url value='/'/>"><fmt:message
						key="webapp.name" /></a> --%>
			</div>

			<div class="navbar-collapse collapse pull-right">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a id="themeSelect" href="#"
						class="dropdown-toggle" data-toggle="dropdown"><fmt:message
								key="login.Theme" /> <b class="caret"></b></a>
						<ul class="dropdown-menu dropdown-menu-right">
							<li><a href="#" data-theme="default" class="theme-link">Default</a></li>
							<li><a href="#" data-theme="cerulean" class="theme-link">Cerulean</a></li>
							<li><a href="#" data-theme="cosmo" class="theme-link">Cosmo</a></li>
							<li><a href="#" data-theme="cyborg" class="theme-link">Cyborg</a></li>
							<li><a href="#" data-theme="united" class="theme-link">United</a></li>
						</ul></li>
				</ul>
			</div>

			<div class="navbar-collapse collapse pull-right">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a id="languageSelect" href="#"
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-expanded="false"> <fmt:message key="login.language" /><b
							class="caret"></b>
					</a>
						<ul class="dropdown-menu dropdown-menu-right">
							<li><a href="#" data-language="zh_CN" class="language-link">
									<fmt:message key="login.language.zh_CN" />
							</a></li>
							<li><a href="#" data-language="en" class="language-link">
									<fmt:message key="login.language.en" />
							</a></li>
						</ul></li>
				</ul>
			</div>

			<c:if
				test="${not empty sessionScope.selectedUserPlant and not empty sessionScope.availableUserPlants}">
				<div class="navbar-collapse collapse pull-right">
					<ul class="nav navbar-nav">
						<li class="dropdown"><a id="userPlantSelect" href="#"
							class="dropdown-toggle" data-toggle="dropdown"><fmt:message
									key="login.userPlant" /> <b class="caret"></b></a>
							<ul class="dropdown-menu dropdown-menu-right">
								<c:forEach items="${sessionScope.availableUserPlants}"
									var="plant">
									<li><a href="#" data-plant="${plant.value}"
										class="plant-link">${plant.label}</a></li>
								</c:forEach>
							</ul></li>
					</ul>
				</div>
			</c:if>
			<c:if test="${pageContext.request.remoteUser != null}">
			<div class="navbar-collapse collapse pull-right">
				<ul class="nav navbar-nav">
					<li class="dropdown">
						<a id="currentUser" href="#" class="dropdown-toggle" data-toggle="dropdown">
							<fmt:message key="login.currentUser" />${pageContext.request.remoteUser}</a>
					</li>
				</ul>
			</div>
			</c:if>
		</div>

		<c:if test="${empty sessionScope.forceChangePassword}">
			<%@ include file="/common/messages.jsp"%>
		</c:if>
		<div class="row">
			<c:if test="${pageContext.request.remoteUser != null}">
				<%@ include file="/common/menu.jsp"%>
			</c:if>
			<c:choose>
				<c:when test="${pageContext.request.remoteUser != null}">
					<div class="col-sm-10 col-md-10">
						<decorator:body />
					</div>
				</c:when>
				<c:otherwise>
					<div class="col-sm-12 col-md-12">
						<decorator:body />
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<c:if
			test="${empty sessionScope.selectedUserPlant and not empty sessionScope.availableUserPlants}">
			<%@ include file="/common/selectUserPlant.jsp"%>
		</c:if>

	</div>

	<div id="footer" class="container navbar-fixed-bottom">
		<span class="col-xs-6 text-left"><fmt:message
				key="webapp.version" /> <c:if
				test="${pageContext.request.remoteUser != null}">
            | <fmt:message key="user.status" /> ${pageContext.request.remoteUser}
            </c:if> </span> <span class="col-xs-6 text-right"> <a
			href="<fmt:message key="company.url"/>"><fmt:message
					key="company.name" /></a>
		</span>
	</div>
	<%=(request.getAttribute("scripts") != null) ? request.getAttribute("scripts") : ""%>

	<script>
		var themes = {
			"default" : "<c:url value='/styles/lib/bootstrap.min.css'/>",
			"cerulean" : "<c:url value='/styles/lib/theme/cerulean.min.css'/>",
			"cosmo" : "<c:url value='/styles/lib/theme/cosmo.min.css'/>",
			"cyborg" : "<c:url value='/styles/lib/theme/cyborg.min.css'/>",
			"united" : "<c:url value='/styles/lib/theme/united.min.css'/>"
		}

		$(function() {
			$(".theme-link").click(function() {
				var theme = $(this).attr("data-theme");
				location.href = "<c:url value='/home?theme='/>" + theme;
			});

			$(".language-link").click(function() {
				var language = $(this).attr("data-language");
				location.href = "<c:url value='/home?locale='/>" + language;
			});

			$(".plant-link")
					.click(
							function() {
								var plant = $(this).attr("data-plant");
								location.href = "<c:url value='/selectUserPlant?plantCode='/>"
										+ plant;
							});

			<c:choose>
			<c:when test="${not empty sessionScope.theme}">
			$("#themeSelect")
					.html(
							"<fmt:message key="login.Theme" /> ["
									+ $(
											'.theme-link[data-theme="${sessionScope.theme}"]')
											.text() + "]<b class='caret'></b>");
			</c:when>
			<c:otherwise>
			$("#themeSelect").html(
					"<fmt:message key="login.Theme" /> ["
							+ $(".theme-link").first().text()
							+ "]<b class='caret'></b>");
			</c:otherwise>
			</c:choose>

			$("#languageSelect")
					.html(
							"<fmt:message key="login.language" /> ["
									+ $(
											'.language-link[data-language="${pageContext.response.locale}"]')
											.text() + "]<b class='caret'></b>");

			<c:if test="${not empty sessionScope.selectedUserPlant and not empty sessionScope.availableUserPlants}">
			$("#userPlantSelect")
					.html(
							"<fmt:message key="login.userPlant" /> ["
									+ $(
											'.plant-link[data-plant="${sessionScope.selectedUserPlant}"]')
											.text() + "]<b class='caret'></b>");
			</c:if>
		});
	</script>
</body>
</html>
<%
	} catch (Exception ex) {
		ex.printStackTrace();
	}
%>
