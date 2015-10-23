<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="purchaseOrderList.title" /></title>
<meta name="menu" content="PurchaseOrderMenu" />
</head>
<body id="purchaseOrder">
	<h2>
		<fmt:message key="purchaseOrderList.heading" />
	</h2>


	<s:form name="purchaseOrderForm" action="purchaseOrders" method="post"
		validate="true">
		<div class="row">
			<div class="col-xs-4 search-group">
				<s:textfield cssClass="form-control search-control"
					key="purchaseOrder.tt_xpyhmstro_yhdnbr" />
			</div>
			<div class="col-xs-4 search-group">
				<s:select key="purchaseOrder.tt_xpyhmstro_priority"
					list="purchaseOrderPriorityList" listKey="label" listValue="value"
					cssClass="form-control" />
			</div>
			<div class="col-xs-4 search-group">
				<fmt:message key="purchaseOrder.tt_xpyhmstro_suppcode" />
				<input id="tt_xpyhmstro_suppcode"
					name="purchaseOrder.tt_xpyhmstro_suppcode" type="text"
					class="col-md-12 form-control" placeholder="" autocomplete="off" />


			</div>
		</div>
		<div class="row">
			<div class="col-xs-4 search-group">
				<s:textfield cssClass="form-control search-control"
					key="purchaseOrder.tt_xpyhmstro_creator" />
			</div>
			<div class="col-xs-4 search-group">

				<s:select key="purchaseOrder.tt_xpyhmstro_stat"
					list="purchaseOrderStatusList" listKey="label" listValue="value"
					cssClass="form-control" />

			</div>
			<div class="col-xs-4 search-group">
				<fmt:message key="purchaseOrder.tt_xpyhmstro_shipto" />
				<input id="tt_xpyhmstro_shipto"
					name="purchaseOrder.tt_xpyhmstro_shipto" type="text"
					class="col-md-12 form-control" placeholder="" autocomplete="off" />
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4 search-group">
				<s:textfield cssClass="form-control search-control"
					key="purchaseOrder.tt_xpyhmstro_startdt" />
			</div>
			<div class="col-xs-4 search-group">
				<s:textfield cssClass="form-control search-control"
					key="purchaseOrder.tt_xpyhmstro_receptdt" />
			</div>
			<div class="col-xs-4 search-group">
				<fmt:message key="purchaseOrder.tt_xpyhmstro_partnbr" />
				<input id="tt_xpyhmstro_partnbr"
					name="purchaseOrder.tt_xpyhmstro_partnbr" type="text"
					class="col-md-12 form-control" placeholder="" autocomplete="off" />
			</div>

		</div>
		<div class="row">
			<div class="col-xs-4 search-group layouttrim">
				<s:checkbox key="purchaseOrder.isDetail" />
			</div>
			<div class="col-xs-4 search-group layouttrim">
				<input type="hidden" name="from" value="list" />
				<s:submit type="button" cssClass="btn" action="purchaseOrders"
					key="button.search" theme="simple">
					<i class="icon-search"></i>
					<fmt:message key="button.search" />
				</s:submit>
			</div>
			<div class="col-xs-4 search-group"></div>
		</div>
	</s:form>

	<c:choose>
		<c:when test="${!purchaseOrder.isDetail}">
			<display:table name="purchaseOrders" cellspacing="0" cellpadding="0"
				requestURI="purchaseOrders" defaultsort="1" id="purchaseOrders"
				pagesize="25"
				class="table table-condensed table-striped table-hover"
				export="true">


				<display:column property="tt_xpyhmstro_seq" escapeXml="true"
					sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_seq" />
				<display:column property="tt_xpyhmstro_yhdnbr" escapeXml="true"
					sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_yhdnbr"
					url="/purchaseOrder/editPurchaseOrder?from=list"
					paramId="tt_xpyhmstro_xpyhmstroid"
					paramProperty="tt_xpyhmstro_xpyhmstroid" />
				<display:column property="tt_xpyhmstro_suppcode" escapeXml="true"
					sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_suppcode" />
				<display:column property="tt_xpyhmstro_shipto" escapeXml="true"
					sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_shipto" />
				<display:column property="tt_xpyhmstro_startdt" escapeXml="true"
					sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_startdt" />
				<display:column property="tt_xpyhmstro_receptdt" escapeXml="true"
					sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_receptdt" />
				<display:column property="tt_xpyhmstro_recepttm" escapeXml="true"
					sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_recepttm" />
				<display:column property="tt_xpyhmstro_stat_desc" escapeXml="true"
					sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_stat_desc" />
				<display:column property="tt_xpyhmstro_priority_desc"
					escapeXml="true" sortable="true"
					titleKey="purchaseOrder.tt_xpyhmstro_priority_desc" />
				<display:column property="tt_xpyhmstro_creator" escapeXml="true"
					sortable="true" titleKey="purchaseOrder.tt_xpyhmstro_creator" />

				<display:setProperty name="paging.banner.placement" value="both" />
				<display:setProperty name="paging.banner.item_name">
					<fmt:message key="purchaseOrderList.purchaseOrder" />
				</display:setProperty>
				<display:setProperty name="paging.banner.items_name">
					<fmt:message key="purchaseOrderList.purchaseOrders" />
				</display:setProperty>

				<display:setProperty name="export.excel.filename"
					value="PurchaseOrder List.xls" />

				<display:setProperty name="export.pdf" value="false" />
				<display:setProperty name="export.excel" value="true" />
				<display:setProperty name="export.csv" value="false" />
				<display:setProperty name="export.xml" value="false" />

			</display:table>
		</c:when>
		<c:otherwise>

			<display:table name="purchaseOrderDetails" cellspacing="0"
				pagesize="25" defaultsort="1" cellpadding="0"
				requestURI="purchaseOrders" id="purchaseOrderDetails"
				class="table table-condensed table-striped table-hover"
				export="true">

				<display:column property="tt_xpyhddeto_seq" escapeXml="true"
					sortable="true" titleKey="purchaseOrderDetail.tt_xpyhddeto_seq" />
				<display:column property="tt_xpyhddeto_yhdnbr" escapeXml="true"
					sortable="true" titleKey="purchaseOrderDetail.tt_xpyhddeto_yhdnbr" />
				<display:column property="tt_xpyhddeto_partnbr" escapeXml="true"
					sortable="true" titleKey="purchaseOrderDetail.tt_xpyhddeto_partnbr" />
				<display:column property="tt_xpyhddeto_partdesc" escapeXml="true"
					sortable="true"
					titleKey="purchaseOrderDetail.tt_xpyhddeto_partdesc" />
				<display:column property="tt_xpyhddeto_supppart" escapeXml="true"
					sortable="true"
					titleKey="purchaseOrderDetail.tt_xpyhddeto_supppart" />
				<display:column property="tt_xpyhddeto_uom" escapeXml="true"
					sortable="true" titleKey="purchaseOrderDetail.tt_xpyhddeto_uom" />
				<display:column property="tt_xpyhddeto_spq" escapeXml="true"
					sortable="true" titleKey="purchaseOrderDetail.tt_xpyhddeto_spq" />
				<display:column property="tt_xpyhddeto_reqqty" escapeXml="true"
					sortable="true" titleKey="purchaseOrderDetail.tt_xpyhddeto_reqqty" />
				<display:column property="tt_xpyhddeto_ordqty" escapeXml="true"
					sortable="true" titleKey="purchaseOrderDetail.tt_xpyhddeto_ordqty" />

				<display:setProperty name="paging.banner.placement" value="both" />
				<display:setProperty name="paging.banner.item_name">
					<fmt:message key="purchaseOrderList.purchaseOrderDetail" />
				</display:setProperty>
				<display:setProperty name="paging.banner.items_name">
					<fmt:message key="purchaseOrderList.purchaseOrderDetails" />
				</display:setProperty>

				<display:setProperty name="export.excel.filename"
					value="PurchaseOrder List.xls" />

				<display:setProperty name="export.pdf" value="false" />
				<display:setProperty name="export.excel" value="true" />
				<display:setProperty name="export.csv" value="false" />
				<display:setProperty name="export.xml" value="false" />
			</display:table>
		</c:otherwise>
	</c:choose>

	<script>
		$('#tt_xpyhmstro_suppcode')
				.typeahead(
						{
							ajax : {
								url : "<c:url value="/services/api/supplys/getSupplyData.json"/>",
								method : 'get',
								preDispatch : function(e) {
									return {
										domain : "${sessionScope.selectedUserPlant}",
										usercode : "${pageContext.request.remoteUser}",
										query : e
									}
								},
								triggerLength : 1
							},
							displayField : 'label',
							valueField : 'value'
						//onSelect: displayResult
						});

		$('#tt_xpyhmstro_shipto')
				.typeahead(
						{
							ajax : {
								url : "<c:url value="/services/api/supplys/getShiptoData.json"/>",
								method : 'get',
								preDispatch : function(e) {
									return {
										domain : "${sessionScope.selectedUserPlant}",
										query : e
									}
								},
								triggerLength : 1
							},
							displayField : 'label',
							valueField : 'value'
						//onSelect: displayResult
						});

		$('#tt_xpyhmstro_partnbr')
				.typeahead(
						{
							ajax : {
								url : "<c:url value="/services/api/supplys/getItemData.json"/>",
								method : 'get',
								preDispatch : function(e) {
									return {
										domain : "${sessionScope.selectedUserPlant}",
										query : e
									}
								},
								triggerLength : 1
							},
							displayField : 'label',
							valueField : 'value'
						//onSelect: displayResult
						});
	</script>
</body>



