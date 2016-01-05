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
		<div class="col-xs-4 search-group">
			<s:textfield key="purchaseOrder.tt_xpyhmstro_yhdnbr"
				cssClass="form-control" readonly="true" />
			<s:hidden key="purchaseOrder.tt_xpyhmstro_xpyhmstroid" />
			<s:hidden key="purchaseOrder.tt_xpyhmstro_stat" />
		</div>
		<div class="col-xs-4 search-group">
			<s:textfield key="purchaseOrder.tt_xpyhmstro_priority_desc"
				cssClass="form-control" readonly="true" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4 search-group">
			<s:textfield key="purchaseOrder.tt_xpyhmstro_startdt"
				cssClass="form-control" readonly="true" />
		</div>
		<div class="col-xs-4 search-group">
			<s:textfield key="purchaseOrder.tt_xpyhmstro_receptdt"
				cssClass="form-control" readonly="true" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4 search-group">
			<s:textfield key="purchaseOrder.tt_xpyhmstro_suppcode"
				cssClass="form-control" readonly="true" />
		</div>
		<div class="col-xs-4 search-group">
			<s:textfield key="purchaseOrder.tt_xpyhmstro_shipto"
				cssClass="form-control" readonly="true" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4 search-group">
			<s:textfield key="purchaseOrder.tt_xpyhmstro_stat_desc"
				cssClass="form-control" readonly="true" />
		</div>

	</div>
	<div class="row">
		<div class="col-xs-8 search-group">
			<s:textfield key="purchaseOrder.remark" cssClass="form-control"
				readonly="true" />
		</div>
	</div>

	<hr>
	<div id="actions" class="form-group form-actions">
		<c:if test="${canConfirmOrder}">
			<c:if test="${purchaseOrder.tt_xpyhmstro_stat  eq '2'}">
				<s:submit type="button" cssClass="btn btn-primary" action="confirmPurchaseOder"
					key="button.confirm" theme="simple">
					<i class="icon-ok icon-white"></i>
					<fmt:message key="button.confirm" />
				</s:submit>
			</c:if>
		</c:if>
		<c:if test="${canCloseOrder}">
			<c:if
				test="${purchaseOrder.tt_xpyhmstro_stat eq '3' || purchaseOrder.tt_xpyhmstro_stat eq '4' }">
				<s:submit type="button" cssClass="btn btn-primary" action="closePurchaseOder"
					key="button.close" theme="simple">
					<i class="icon-off icon-white"></i>
					<fmt:message key="button.close" />
				</s:submit>
			</c:if>
		</c:if>
		<c:if test="${canCancelOrder}">
			<c:if test="${purchaseOrder.tt_xpyhmstro_stat  eq '2'}">
				<s:submit type="button" cssClass="btn" action="deletePurchaseOder"
					key="button.cancel" theme="simple">
					<i class="icon-remove"></i>
					<fmt:message key="button.cancel" />
				</s:submit>
			</c:if>
		</c:if>
<%-- 		<s:submit type="button" cssClass="btn btn-primary" --%>
<%-- 			action="printPurchaseOder" key="button.print" theme="simple"> --%>
<!-- 			<i class="icon-print icon-white"></i> -->
<%-- 			<fmt:message key="button.print" /> --%>
<%-- 		</s:submit> --%>

		<s:submit type="button" cssClass="btn" method="cancel"
			key="button.back" theme="simple">
			<i class=" icon-arrow-left"></i>
			<fmt:message key="button.back" />
		</s:submit>

	</div>
	<hr>

	<display:table name="purchaseOrderDetails" cellspacing="0"
		cellpadding="0" requestURI="editPurchaseOrder"
		id="purchaseOrderDetails" pagesize="25" 
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

		<display:setProperty name="paging.banner.placement" value="both" />
		<display:setProperty name="paging.banner.item_name">
			<fmt:message key="purchaseOrder.purchaseOrderDetail" />
		</display:setProperty>
		<display:setProperty name="paging.banner.items_name">
			<fmt:message key="purchaseOrder.purchaseOrderDetails" />
		</display:setProperty>
		
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
