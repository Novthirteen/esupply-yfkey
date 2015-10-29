<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="receipt.title" /></title>
<meta name="menu" content="ReceiptMenu" />
</head>

<h2>
	<fmt:message key="receipt.heading" />
</h2>

<s:form name="receiptForm" action="editReceipt" method="post"
	validate="true" cssClass="well form-horizontal" autocomplete="off">
	<input type="hidden" name="from" value="${param.from}" />
	<div class="row">
		<div class="col-xs-4 search-group">
			<s:textfield key="receipt.tt_prhmstro_receiver"
				cssClass="form-control" readonly="true" />
			<s:hidden key="receipt.tt_prhmstro_receiver" />
		</div>
		<div class="col-xs-4 search-group">
			<s:textfield key="receipt.tt_prhmstro_asnnbr" cssClass="form-control"
				readonly="true" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4 search-group">
			<s:textfield key="receipt.tt_prhmstro_suppcode"
				cssClass="form-control" readonly="true" />
		</div>
		<div class="col-xs-4 search-group">
			<s:textfield key="receipt.tt_prhmstro_shipto" cssClass="form-control"
				readonly="true" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4 search-group">
			<s:textfield key="receipt.tt_prhmstro_rcdate" cssClass="form-control"
				readonly="true" />
		</div>
		<div class="col-xs-4 search-group">
			<s:textfield key="receipt.tt_prhmstro_rcuserid"
				cssClass="form-control" readonly="true" />
		</div>
	</div>

	<hr>
	<div id="actions" class="form-actions">

		<s:submit type="button" cssClass="btn btn-primary"
			action="printReceipt" key="button.print" theme="simple">
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


<display:table name="receiptDetails" cellspacing="0" cellpadding="0"
	requestURI="/receiptDetails" id="receiptDetail"
	class="table table-condensed table-striped table-hover" export="false">
	<display:column property="tt_prhdeto_seq" escapeXml="false"
		titleKey="receiptDetail.tt_prhdeto_seq" />
	<display:column property="tt_prhdeto_yhdnbr" escapeXml="true"
		titleKey="receiptDetail.tt_prhdeto_yhdnbr" />
	<display:column property="tt_prhdeto_partnbr" escapeXml="true"
		titleKey="receiptDetail.tt_prhdeto_partnbr" />
	<display:column property="tt_prhdeto_partdesc" escapeXml="true"
		titleKey="receiptDetail.tt_prhdeto_partdesc" />
	<display:column property="tt_prhdeto_supppart" escapeXml="true"
		titleKey="receiptDetail.tt_prhdeto_supppart" />
	<display:column property="tt_prhdeto_uom" escapeXml="true"
		titleKey="receiptDetail.tt_prhdeto_uom" />
	<display:column property="tt_prhdeto_spq" escapeXml="true"
		titleKey="receiptDetail.tt_prhdeto_spq" />
	<display:column property="tt_prhdeto_toloc" escapeXml="true"
		titleKey="receiptDetail.tt_prhdeto_toloc" />
	<display:column property="tt_prhdeto_delvqty" escapeXml="true"
		titleKey="receiptDetail.tt_prhdeto_delvqty" />
	<display:column property="tt_prhdeto_revdqty" escapeXml="true"
		titleKey="receiptDetail.tt_prhdeto_revdqty" />

</display:table>

<script type="text/javascript">
	$(document).ready(
			function() {
				$("input[type='text']:visible:enabled:first",
						document.forms['receiptForm']).focus();
			});
</script>
