<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="purchaseOrder.title" /></title>
<meta name="menu" content="PurchaseOrderMenu" />
</head>

<h2>
	<fmt:message key="purchaseOrder.heading" />
</h2>

<s:form name="purchaseOrderForm" action="editPurchaseOrder"
	method="post" validate="true" cssClass="well form-horizontal"
	autocomplete="off">
	<input type="hidden" name="from" value="${param.from}" />
	<div class="row">
		<div class="col-xs-4">
			<s:label key="purchaseOrder.tt_xpyhmstro_yhdnbr"
				cssClass="form-control" />
			<s:hidden key="purchaseOrder.tt_xpyhmstro_xpyhmstroid" />
			<s:hidden key="purchaseOrder.tt_xpyhmstro_stat" />
		</div>
		<div class="col-xs-4">
			<s:label key="purchaseOrder.tt_xpyhmstro_priority_desc"
				cssClass="form-control" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4">
			<s:label key="purchaseOrder.tt_xpyhmstro_startdt"
				cssClass="form-control" />
		</div>
		<div class="col-xs-4">
			<s:label key="purchaseOrder.tt_xpyhmstro_receptdt"
				cssClass="form-control" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4">
			<s:label key="purchaseOrder.tt_xpyhmstro_suppcode"
				cssClass="form-control" />
		</div>
		<div class="col-xs-4">
			<s:label key="purchaseOrder.tt_xpyhmstro_shipto"
				cssClass="form-control" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4">
			<s:label key="purchaseOrder.tt_xpyhmstro_stat_desc"
				cssClass="form-control" />
		</div>

	</div>
	<div class="row">
		<div class="col-xs-8">
			<s:label key="purchaseOrder.remark" cssClass="form-control" />
		</div>
	</div>


	<div id="actions" class="form-actions">
		<c:if test="${purchaseOrder.tt_xpyhmstro_stat.equals('2')}">
			<s:submit type="button" cssClass="btn btn-primary" method="confirm"
				key="button.confirm" theme="simple">
				<i class="icon-ok icon-white"></i>
				<fmt:message key="button.confirm" />
			</s:submit>
		</c:if>
		<c:if test="${purchaseOrder.tt_xpyhmstro_stat.equals('3') || purchaseOrder.tt_xpyhmstro_stat.equals('4') }">
			<s:submit type="button" cssClass="btn btn-primary" method="close"
				key="button.close" theme="simple">
				<i class="icon-off icon-white"></i>
				<fmt:message key="button.close" />
			</s:submit>
		</c:if>
		<c:if test="${purchaseOrder.tt_xpyhmstro_stat.equals('2')}">

			<s:submit type="button" cssClass="btn" method="delete"
				key="button.cancel" theme="simple">
				<i class="icon-remove"></i>
				<fmt:message key="button.cancel" />
			</s:submit>
		</c:if>

		<s:submit type="button" cssClass="btn btn-primary"
			action="printPurchaseOder" key="button.print" theme="simple">
			<i class="icon-print icon-white"></i>
			<fmt:message key="button.print" />
		</s:submit>

		<s:submit type="button" cssClass="btn" method="cancel"
			key="button.back" theme="simple">
			<i class=" icon-arrow-left"></i>
			<fmt:message key="button.back" />
		</s:submit>

	</div>


	<display:table name="purchaseOrderDetails" cellspacing="0"
		cellpadding="0" requestURI="editPurchaseOrder"
		id="purchaseOrderDetails"
		class="table table-condensed table-striped table-hover" export="true">

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
		<display:setProperty name="export.pdf" value="false" />
		<display:setProperty name="export.excel" value="true" />
		<display:setProperty name="export.csv" value="false" />
		<display:setProperty name="export.xml" value="false" />
	</display:table>
</s:form>

<script type="text/javascript">
	$(document).ready(
			function() {
				$("input[type='text']:visible:enabled:first",
						document.forms['purchaseOrderForm']).focus();
			});
</script>
