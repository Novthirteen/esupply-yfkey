<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="purchaseOrderList.title" /></title>
<meta name="menu" content="AdminMenu" />
</head>

<h2>
	<fmt:message key="purchaseOrderList.heading" />
</h2>

<s:form name="purchaseOrderForm" action="purchaseOrders"
	method="post" validate="true">
	<div class="row-fluid">
		<div class="span3">
			<s:textfield key="purchaseOrder.tt_xpyhmstro_yhdnbr" />
		</div>
		<div class="span3">
			<s:textfield key="purchaseOrder.tt_xpyhmstro_priority" />
		</div>
	</div>
	<div class="row-fluid">
		<div class="span3">
			<s:textfield key="purchaseOrder.tt_xpyhmstro_suppcode" />
		</div>
		<div class="span3">
			<s:textfield key="purchaseOrder.tt_xpyhmstro_creator" />
		</div>
	</div>
	<div class="row-fluid">
		<div class="span3">
			<s:textfield key="purchaseOrder.tt_xpyhmstro_stat" />
		</div>
		<div class="span3">
			<s:textfield key="purchaseOrder.tt_xpyhmstro_shipto" />
		</div>
	</div>
	<div class="row-fluid">
		<div class="span3">
			<s:textfield key="purchaseOrder.tt_xpyhmstro_startdt" />
		</div>
		<div class="span3">
			<s:textfield key="purchaseOrder.tt_xpyhmstro_receptdt" />
		</div>
	</div>
	<div class="row-fluid">
		<div class="span3">
			<s:checkbox key="purchaseOrder.isDetail" />
		</div>
	</div>
	<div class="row-fluid">
		<div class="span3">
			<input type="hidden" name="from" value="list" />
			<s:submit type="button" cssClass="btn btn-primary"
				action="confirmPurchaseOrder" key="button.confirm" theme="simple">
				<i class="icon-plus icon-white"></i>
				<fmt:message key="button.confirm" />
			</s:submit>
			<s:submit type="button" cssClass="btn" action="purchaseOrders"
				key="button.search" theme="simple">
				<i class="icon-search"></i>
				<fmt:message key="button.search" />
			</s:submit>
		</div>
	</div>
</s:form>

<c:choose>
	<c:when test="${!purchaseOrder.isDetail}">
		<display:table name="purchaseOrders" cellspacing="0" cellpadding="0"
			requestURI="purchaseOrders" defaultsort="1" id="purchaseOrders"
			pagesize="25" class="table table-condensed table-striped table-hover"
			export="true">


			<display:column property="tt_xpyhmstro_seq" escapeXml="true"
				sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_seq" />
			<display:column property="tt_xpyhmstro_yhdnbr" escapeXml="true"
				sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_yhdnbr"
				url="/purchaseOrder/editPurchaseOrder?from=list"
				paramId="tt_xpyhmstro_xpyhmstroid" paramProperty="tt_xpyhmstro_xpyhmstroid" />
			<display:column property="tt_xpyhmstro_suppcode" escapeXml="true"
				sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_suppcode" />
			<display:column property="tt_xpyhmstro_shipto" escapeXml="true"
				sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_seq" />
			<display:column property="tt_xpyhmstro_startdt" escapeXml="true"
				sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_startdt" />
			<display:column property="tt_xpyhmstro_receptdt" escapeXml="true"
				sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_receptdt" />
			<display:column property="tt_xpyhmstro_stat" escapeXml="true"
				sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_stat" />
			<display:column property="tt_xpyhmstro_priority" escapeXml="true"
				sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_priority" />
			<display:column property="tt_xpyhmstro_creator" escapeXml="true"
				sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_creator" />


			<display:setProperty name="paging.banner.item_name">
				<fmt:message key="purchaseOrderList.purchaseOrder" />
			</display:setProperty>
			<display:setProperty name="paging.banner.items_name">
				<fmt:message key="purchaseOrderList.purchaseOrders" />
			</display:setProperty>

			<display:setProperty name="export.excel.filename"
				value="PurchaseOrder List.xls" />



		</display:table>
	</c:when>
	<c:otherwise>

		<display:table name="purchaseOrderDetails" cellspacing="0" pagesize="25"  defaultsort="1"
			cellpadding="0" requestURI="purchaseOrders" id="purchaseOrderDetails"
			class="table table-condensed table-striped table-hover" export="true">

			<display:column property="tt_xpyhddeto_seq" escapeXml="true" sortable="true"
				titleKey="purchaseOrderDetail.tt_xpyhddeto_seq" />
			<display:column property="tt_xpyhddeto_yhdnbr" escapeXml="true" sortable="true"
				titleKey="purchaseOrderDetail.tt_xpyhddeto_yhdnbr" />
			<display:column property="tt_xpyhddeto_partnbr" escapeXml="true" sortable="true"
				titleKey="purchaseOrderDetail.tt_xpyhddeto_partnbr" />
			<display:column property="tt_xpyhddeto_partdesc" escapeXml="true" sortable="true"
				titleKey="purchaseOrderDetail.tt_xpyhddeto_partdesc" />
			<display:column property="tt_xpyhddeto_supppart" escapeXml="true" sortable="true"
				titleKey="purchaseOrderDetail.tt_xpyhddeto_supppart" />
			<display:column property="tt_xpyhddeto_uom" escapeXml="true" sortable="true"
				titleKey="purchaseOrderDetail.tt_xpyhddeto_uom" />
			<display:column property="tt_xpyhddeto_spq" escapeXml="true" sortable="true"
				titleKey="purchaseOrderDetail.tt_xpyhddeto_spq" />
			<display:column property="tt_xpyhddeto_reqqty" escapeXml="true" sortable="true"
				titleKey="purchaseOrderDetail.tt_xpyhddeto_reqqty" />
			<display:column property="tt_xpyhddeto_ordqty" escapeXml="true" sortable="true"
				titleKey="purchaseOrderDetail.tt_xpyhddeto_ordqty" />

			<display:setProperty name="paging.banner.item_name">
				<fmt:message key="purchaseOrderList.purchaseOrderDetail" />
			</display:setProperty>
			<display:setProperty name="paging.banner.items_name">
				<fmt:message key="purchaseOrderList.purchaseOrderDetails" />
			</display:setProperty>

			<display:setProperty name="export.excel.filename"
				value="PurchaseOrder List.xls" />
		</display:table>
	</c:otherwise>
</c:choose>