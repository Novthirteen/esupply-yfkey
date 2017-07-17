<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="upload.title" /></title>
<meta name="menu" content="AdminMenu" />
</head>

<div class="col-sm-3">
	<h2>
		<fmt:message key="upload.heading" />
	</h2>
	<p>
		<fmt:message key="upload.message" />
	</p>
</div>
<div class="col-sm-7">
	<s:form action="uploadFile" enctype="multipart/form-data" method="post"
		validate="true" id="uploadForm" cssClass="well">
		<s:textfield name="name" label="%{getText('uploadForm.name')}"
			requiredLabel="true" autofocus="true" cssClass="form-control" />
		<s:file name="file" label="%{getText('uploadForm.file')}"
			requiredLabel="true" />
		<div id="actions" class="form-group">
			<c:if test="${canUploadTest}">
				<s:submit type="button" key="button.upload.Test" name="uploadTest"
					cssClass="btn btn-primary" theme="simple" method="uploadTest">
					<i class="icon-upload icon-white"></i>
					<fmt:message key="button.uploadTest" />
				</s:submit>
			</c:if>
			<c:if test="${canUploadProd}">
				<s:submit type="button" key="button.upload.Prod" name="uploadProd"
					cssClass="btn btn-primary" theme="simple" method="uploadProd">
					<i class="icon-upload icon-white"></i>
					<fmt:message key="button.uploadProd" />
				</s:submit>
			</c:if>
			<c:if test="${canUploadTraining}">
				<s:submit type="button" key="button.upload.Training"
					name="uploadTraining" cssClass="btn btn-primary" theme="simple"
					method="uploadTraining">
					<i class="icon-upload icon-white"></i>
					<fmt:message key="button.uploadTraining" />
				</s:submit>
			</c:if>
			<a class="btn btn-default" href="home"> <i class="icon-remove"></i>
				<fmt:message key="button.cancel" />
			</a>
		</div>
	</s:form>
</div>