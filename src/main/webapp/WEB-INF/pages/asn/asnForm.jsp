<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="asn.title" /></title>
<meta name="menu" content="AdminMenu" />
</head>

<h2>
	<fmt:message key="asn.heading" />
</h2>

<s:form name="asnForm" action="editAsn" method="post"
	validate="true" cssClass="well form-horizontal" autocomplete="off">
	<input type="hidden" name="from" value="${param.from}" />
	<div class="row-fluid">
		<div class="span4">
			<s:label key="asn.tt_xasnmstro_asnnbr" />
		</div>
		<div class="span4">
			<s:label key="asn.tt_xasnmstro_stat" />
		</div>
	</div>
	<div class="row-fluid">
		<div class="span4">
			<s:label key="asn.tt_xasnmstro_suppcode" />
		</div>
		<div class="span4">
			<s:label key="asn.tt_xasnmstro_shipto" />
		</div>
	</div>
	<div class="row-fluid">
		<div class="span4">
			<s:label key="asn.tt_xasnmstro_startdt" />
		</div>
		<div class="span4">
			<s:label key="asn.tt_xasnmstro_creator" />
		</div>
	</div>


	<div id="actions" class="form-actions">

		<s:submit type="button" cssClass="btn btn-primary" action="printAsn" 
			key="button.print" theme="simple">
			<i class="icon-print icon-white"></i>
			<fmt:message key="button.print" />
		</s:submit>

	
		<s:submit type="button" cssClass="btn" method="cancel"
			key="button.back" theme="simple">
			<i class=" icon-arrow-left"></i>
			<fmt:message key="button.back" />
		</s:submit>
	</div>
</s:form>


<display:table name="asnDetails" cellspacing="0" cellpadding="0"
	requestURI="/asnDetails"  id="asnDetails" 
	class="table table-condensed table-striped table-hover"
	export="true">
	<display:column property="tt_xasndeto_yhdnbr" escapeXml="true" 
		titleKey="asnDetail.tt_xasndeto_yhdnbr" />
	<display:column property="tt_xasndeto_seq" escapeXml="true"
		titleKey="asnDetail.tt_xasndeto_seq" />
	<display:column property="tt_xasndeto_partnbr" escapeXml="true" 
		titleKey="asnDetail.tt_xasndeto_partnbr" />
	<display:column property="tt_xasndeto_partdesc" escapeXml="true" 
		titleKey="asnDetail.tt_xasndeto_partdesc" />
	<display:column property="tt_xasndeto_supppart" escapeXml="true" 
		titleKey="asnDetail.tt_xasndeto_supppart" />
	<display:column property="tt_xasndeto_uom" escapeXml="true" 
		titleKey="asnDetail.tt_xasndeto_uom" />		
	<display:column property="tt_xasndeto_spq" escapeXml="true" 
		titleKey="asnDetail.tt_xasndeto_spq" />
	<display:column property="tt_xasndeto_asnqty" escapeXml="true" 
		titleKey="asnDetail.tt_xasndeto_asnqty" />

	<display:setProperty name="export.excel.filename"
				value="AsnDetail List.xls" />
</display:table>

<script type="text/javascript">
	$(document).ready(
			function() {
				$("input[type='text']:visible:enabled:first",
						document.forms['asnForm']).focus();
			});
</script>