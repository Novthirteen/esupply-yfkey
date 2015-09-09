<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="purchaseOrder.title" /></title>
<meta name="menu" content="AdminMenu" />
</head>

<h2>
	<fmt:message key="purchaseOrder.heading" />
</h2>

<s:form name="purchaseOrderForm" action="editPurchaseOrder" method="post"
	validate="true" cssClass="well form-horizontal" autocomplete="off">
	<input type="hidden" name="from" value="${param.from}" />
	<div class="row-fluid">
		<div class="span4">
			<s:label key="purchaseOrder.tt_xpyhmstro_yhdnbr" />
		</div>
		<div class="span4">
			<s:label key="purchaseOrder.tt_xpyhmstro_priority" />
		</div>
	</div>
	<div class="row-fluid">
		<div class="span4">
			<s:label key="purchaseOrder.tt_xpyhmstro_startdt" />
		</div>
		<div class="span4">
			<s:label key="purchaseOrder.tt_xpyhmstro_receptdt" />
		</div>
	</div>
	<div class="row-fluid">
		<div class="span4">
			<s:label key="purchaseOrder.tt_xpyhmstro_suppcode" />
		</div>
		<div class="span4">
			<s:label key="purchaseOrder.tt_xpyhmstro_shipto" />
		</div>
	</div>
	<div class="row-fluid">
		<div class="span4">
			<s:label key="purchaseOrder.tt_xpyhmstro_stat" />
		</div>

	</div>
	<div class="row-fluid">
		<div class="span8">
			<s:label key="purchaseOrder.remark" />
		</div>
	</div>


	<div id="actions" class="form-actions">
		<s:submit type="button" cssClass="btn btn-primary" method="confirm"
			key="button.confirm" theme="simple">
			<i class="icon-ok icon-white"></i>
			<fmt:message key="button.confirm" />
		</s:submit>

		<s:submit type="button" cssClass="btn btn-primary" method="close"
			key="button.close" theme="simple">
			<i class="icon-off icon-white"></i>
			<fmt:message key="button.close" />
		</s:submit>
		<s:submit type="button" cssClass="btn btn-primary" action="printPurchaseOder" 
			key="button.print" theme="simple">
			<i class="icon-print icon-white"></i>
			<fmt:message key="button.print" />
		</s:submit>

		<s:submit type="button" cssClass="btn" method="delete"
			key="button.cancel" theme="simple">
			<i class="icon-remove"></i>
			<fmt:message key="button.cancel" />
		</s:submit>
		<s:submit type="button" cssClass="btn" method="cancel"
			key="button.back" theme="simple">
			<i class=" icon-arrow-left"></i>
			<fmt:message key="button.back" />
		</s:submit>
	</div>
</s:form>

<display:table name="purchaseOrderDetails" cellspacing="0" cellpadding="0"
	requestURI="/purchaseOrderDetails"  id="purchaseOrderDetails" 
	class="table table-condensed table-striped table-hover"
	export="true">

	<display:column property="tt_xpyhddeto_seq" escapeXml="true"
		titleKey="purchaseOrderDetail.tt_xpyhddeto_seq" />
	<display:column property="tt_xpyhddeto_partnbr" escapeXml="true" 
		titleKey="purchaseOrderDetail.tt_xpyhddeto_partnbr" />
	<display:column property="tt_xpyhddeto_partdesc" escapeXml="true" 
		titleKey="purchaseOrderDetail.tt_xpyhddeto_partdesc" />
	<display:column property="tt_xpyhddeto_supppart" escapeXml="true" 
		titleKey="purchaseOrderDetail.tt_xpyhddeto_supppart" />
	<display:column property="tt_xpyhddeto_uom" escapeXml="true" 
		titleKey="purchaseOrderDetail.tt_xpyhddeto_uom" />
	<display:column property="tt_xpyhddeto_spq" escapeXml="true" 
		titleKey="purchaseOrderDetail.tt_xpyhddeto_spq" />		
	<display:column property="tt_xpyhddeto_reqqty" escapeXml="true" 
		titleKey="purchaseOrderDetail.tt_xpyhddeto_reqqty" />
	<display:column property="tt_xpyhddeto_ordqty" escapeXml="true" 
		titleKey="purchaseOrderDetail.tt_xpyhddeto_ordqty" />

	<display:setProperty name="export.excel.filename"
				value="PurchaseOrderDetail List.xls" />
</display:table>

<script type="text/javascript">
	$(document).ready(
			function() {
				$("input[type='text']:visible:enabled:first",
						document.forms['purchaseOrderForm']).focus();
			});
</script>
