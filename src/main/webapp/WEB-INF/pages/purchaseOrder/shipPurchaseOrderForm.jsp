<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="shipPurchaseOrder.title" /></title>
<meta name="menu" content="PurchaseOrderMenu" />
</head>

<h2>
	<fmt:message key="shipPurchaseOrder.heading" />
</h2>

<s:form name="purchaseOrderForm" action="editPurchaseOrder"
	method="post" validate="true" cssClass="well form-horizontal"
	autocomplete="off">
	
	<input type="hidden" name="from" value="${param.from}" />
	<div class="row">
			<div class="col-xs-4 search-group">
			<s:textfield key="purchaseOrder.tt_xpyhmstro_yhdnbr"
				cssClass="form-control" readonly="true" />
		</div>
			<div class="col-xs-4 search-group"></div>
	</div>
	<div class="row">
		<div class="col-xs-4 search-group">
			<s:textfield key="purchaseOrder.tt_xpyhmstro_suppcode"
				cssClass="form-control" readonly="true" />
		</div>
			<div class="col-xs-4 search-group">
			<s:textfield key="purchaseOrder.tt_xpyhmstro_suppname"
				cssClass="form-control" readonly="true" />
		</div>
	</div>
	<div class="row">
			<div class="col-xs-4 search-group">
			<s:textfield key="purchaseOrder.tt_xpyhmstro_shipfrom"
				cssClass="form-control" readonly="true" />
		</div>
			<div class="col-xs-4 search-group">
			<s:textfield key="purchaseOrder.tt_xpyhmstro_shipto"
				cssClass="form-control" readonly="true" />
		</div>
	</div>
	<div class="row">
			<div class="col-xs-4 search-group">
			<s:textfield key="purchaseOrder.tt_xpyhmstro_carrier"
				cssClass="form-control" readonly="true" />
		</div>
			<div class="col-xs-4 search-group">
			<s:textfield key="purchaseOrder.tt_xpyhmstro_dock"
				cssClass="form-control" readonly="true" />
		</div>

	</div>
	<div class="row">
		<div class="col-xs-8 search-group">
			<s:textarea key="purchaseOrder.remark" cols="120" rows="6" />
		</div>
	</div>

	<hr>
	<div id="actions" class="form-actions">
		<s:submit type="button" cssClass="btn btn-primary"
			action="shipPurchaseOder" key="button.confirm" theme="simple">
			<i class="icon-ok icon-white"></i>
			<fmt:message key="button.ship" />
		</s:submit>
			
		<s:submit type="button" cssClass="btn" method="cancel"
			key="button.back" theme="simple">
			<i class=" icon-arrow-left"></i>
			<fmt:message key="button.back" />
		</s:submit>
	</div>
	<hr>
	
	<display:table name="purchaseOrderDetails" cellspacing="0"
		cellpadding="0"  id="purchaseOrderDetail"
		class="table table-condensed table-striped table-hover" export="false">
		

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
		<display:column property="tt_xpyhddeto_toloc" escapeXml="true"
			titleKey="purchaseOrderDetail.tt_xpyhddeto_toloc" />
		<display:column property="tt_xpyhddeto_openqty" escapeXml="true"
			titleKey="purchaseOrderDetail.tt_xpyhddeto_openqty" />
		<display:column titleKey="purchaseOrderDetail.tt_xpyhddeto_delvqty">
			
			<input type="text" style="margin: 0px; width: 100px;"
				name="purchaseOrderDetails[${purchaseOrderDetail_rowNum - 1}].tt_xpyhddeto_delvqty"
				value="${purchaseOrderDetail.tt_xpyhddeto_delvqty}" class="text medium" />
			<input type="hidden"
				name="purchaseOrderDetails[${purchaseOrderDetail_rowNum - 1}].tt_xpyhddeto_xpyhddetoid"
				value="${purchaseOrderDetail.tt_xpyhddeto_xpyhddetoid}" />
		</display:column>
		
		<display:column titleKey="purchaseOrderDetail.line_remark">
		
		<input type="text" style="margin: 0px; width: 100px;"
				name="purchaseOrderDetails[${purchaseOrderDetail_rowNum - 1}].line_remark"
				value="${purchaseOrderDetail.line_remark}" class="text medium" />
				</display:column>
	</display:table>
</s:form>

<script type="text/javascript">
	$(document).ready(
			function() {
				$("input[type='text']:visible:enabled:first",
						document.forms['purchaseOrderForm']).focus();
			});
</script>
