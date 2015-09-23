<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="shipPurchaseOrderList.title" /></title>
<meta name="menu" content="PurchaseOrderMenu" />
</head>

<h2>
	<fmt:message key="shipPurchaseOrderList.heading" />
</h2>

<s:form name="purchaseOrderForm" action="shipPurchaseOrders"
	method="post" validate="true">
	<div class="row">
		<div class="col-xs-4 search-group">
			<s:textfield cssClass="form-control search-control"
				key="purchaseOrder.tt_xpyhmstro_yhdnbr" />
		</div>

		<div class="col-xs-4 search-group">
			<s:textfield cssClass="form-control search-control"
				key="purchaseOrder.tt_xpyhmstro_shipto" />
		</div>
	</div>

	<div class="row">
		<div class="col-xs-4 search-group">
			<input type="hidden" name="from" value="list" />
			<s:submit type="button" cssClass="btn" action="shipPurchaseOrders"
				key="button.search" theme="simple">
				<i class="icon-search"></i>
				<fmt:message key="button.search" />
			</s:submit>
		</div>
	</div>
</s:form>


<display:table name="purchaseOrders" cellspacing="0" cellpadding="0"
	requestURI="purchaseOrders" defaultsort="1" id="purchaseOrders"
	pagesize="25" class="table table-condensed table-striped table-hover"
	export="false">



	<display:column property="tt_xpyhmstro_yhdnbr" escapeXml="true"
		sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_yhdnbr"
		url="/purchaseOrder/editShipPurchaseOrder?from=list"
		paramId="tt_xpyhddeti_xpyhmstroid"
		paramProperty="tt_xpyhmstro_xpyhmstroid" />
	<display:column property="tt_xpyhmstro_startdt" escapeXml="true"
		sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_startdt" />
	<display:column property="tt_xpyhmstro_receptdt" escapeXml="true"
		sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_receptdt" />
	<display:column property="tt_xpyhmstro_shipto" escapeXml="true"
		sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_shipto" />
	<display:column property="tt_xpyhmstro_priority" escapeXml="true"
		sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_priority" />


	<display:column property="tt_xpyhmstro_conf" escapeXml="true"
		sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_conf" />

	<display:column property="tt_xpyhmstro_print" escapeXml="true"
		sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_print" />

	<display:setProperty name="paging.banner.item_name">
		<fmt:message key="purchaseOrderList.purchaseOrder" />
	</display:setProperty>
	<display:setProperty name="paging.banner.items_name">
		<fmt:message key="purchaseOrderList.purchaseOrders" />
	</display:setProperty>


</display:table>
