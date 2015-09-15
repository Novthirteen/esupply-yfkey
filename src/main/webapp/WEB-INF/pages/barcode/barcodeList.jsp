<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="barcodeList.title" /></title>
<meta name="menu" content="AdminMenu" />
</head>

<h2>
	<fmt:message key="barcodeList.heading" />
</h2>

<s:form name="barcodeForm" action="barcodes" method="post"
	validate="true">
	<div class="row-fluid">
		<div class="span3">
			<s:textfield key="purchaseOrderDetail.tt_xpyhddeto_yhdnbr" />
		</div>
		<div class="span3">
			<s:textfield key="purchaseOrderDetail.tt_xpyhddeto_shipto" />
		</div>
	</div>
	<div class="span3">

		<s:textfield key="purchaseOrderDetail.tt_xpyhddeto_suppcode" />
	</div>
	<div class="span3">
		<s:textfield key="purchaseOrderDetail.tt_xpyhddeto_partnbr" />
	</div>
	<div class="row-fluid">
		<div class="span3">
			<s:textfield key="purchaseOrderDetail.tt_xpyhddeto_supppart" />
		</div>
		<div class="span3">
			<s:checkbox key="purchaseOrderDetail.isexternal" />
		</div>
	</div>
	<div class="row-fluid">
		<div class="span3">
			<s:submit type="button" cssClass="btn btn-primary" action="barcodes"
				key="button.search" theme="simple">
				<i class="icon-search icon-white"></i>
				<fmt:message key="button.search" />
			</s:submit>

			<s:submit type="button" cssClass="btn btn-primary"
				action="printBarcode" key="button.print" theme="simple">
				<i class="icon-print icon-white"></i>
				<fmt:message key="button.print" />
			</s:submit>

		</div>
	</div>

	<display:table name="purchaseOrderDetails" cellspacing="0"
		cellpadding="0" id="purchaseOrderDetail"
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
		<display:column property="tt_xpyhddeto_innnerqty" escapeXml="true"
			titleKey="purchaseOrderDetail.tt_xpyhddeto_innnerqty" />
		<display:column property="tt_xpyhddeto_externalqty" escapeXml="true"
			titleKey="purchaseOrderDetail.tt_xpyhddeto_externalqty" />
		<display:column titleKey="purchaseOrderDetail.tt_xpyhddeto_lots">
			<input type="text" style="margin: 0px; width: 100px;"
				name="purchaseOrderDetails[${purchaseOrderDetail_rowNum}].tt_xpyhddeto_lots"
				value="${purchaseOrderDetail.tt_xpyhddeto_lots}" class="text medium" />
			<input type="hidden"
				name="purchaseOrderDetails[${purchaseOrderDetail_rowNum}].tt_xpyhddeto_partnbr"
				value="${purchaseOrderDetail.tt_xpyhddeto_partnbr}" />
			<input type="hidden"
				name="purchaseOrderDetails[${purchaseOrderDetail_rowNum}].tt_xpyhddeto_partdesc"
				value="${purchaseOrderDetail.tt_xpyhddeto_partdesc}" />

		</display:column>
		<display:column titleKey="purchaseOrderDetail.tt_xpyhddeto_qty">
			<input type="text" style="margin: 0px; width: 100px;"
				name="purchaseOrderDetails[${purchaseOrderDetail_rowNum}].tt_xpyhddeto_qty"
				value="${purchaseOrderDetail.tt_xpyhddeto_qty}" class="text medium" />
		</display:column>
	</display:table>
</s:form>

