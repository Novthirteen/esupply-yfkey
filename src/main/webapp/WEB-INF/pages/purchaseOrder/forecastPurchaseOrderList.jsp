<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="forecastPurchaseOrderList.title" /></title>
<meta name="menu" content="PurchaseOrderMenu" />
</head>
<body id="purchaseOrder">
	<h2>
		<fmt:message key="forecastPurchaseOrderList.heading" />
	</h2>

	<s:form name="forecastPurchaseOrderForm"
		action="forecastPurchaseOrders" method="post" validate="true">
		<div class="row">
			<div class="col-xs-4 search-group">
				<label class="control-label"><fmt:message key="purchaseOrder.tt_xpyhmstro_suppcode" /></label>
				<input id="tt_xpyhmstro_suppcode"
					name="purchaseOrder.tt_xpyhmstro_suppcode" type="text"
					value="${purchaseOrder.tt_xpyhmstro_suppcode}"
					class="col-md-12 form-control search-control" placeholder="" autocomplete="off" />
			</div>
			<div class="col-xs-4 search-group">
				<label class="control-label"><fmt:message key="purchaseOrder.tt_xpyhmstro_shipto" /></label>
				<input id="tt_xpyhmstro_shipto"
					name="purchaseOrder.tt_xpyhmstro_shipto" type="text"
					value="${purchaseOrder.tt_xpyhmstro_shipto}"
					class="col-md-12 form-control search-control" placeholder="" autocomplete="off" />
			</div>

			<div class="col-xs-4 search-group">
				<label class="control-label"><fmt:message key="purchaseOrder.tt_xpyhmstro_partnbr" /></label>
				<input id="tt_xpyhmstro_partnbr"
					name="purchaseOrder.tt_xpyhmstro_partnbr" type="text"
					value="${purchaseOrder.tt_xpyhmstro_partnbr}"
					class="col-md-12 form-control search-control" placeholder="" autocomplete="off" />
			</div>

		</div>
		<div class="row">
			<div class="col-xs-4 search-group">
				<s:textfield cssClass="form-control search-control"
					id="tt_xpyhmstro_fromdate"
					key="purchaseOrder.tt_xpyhmstro_fromdate" />
			</div>
			<div class="col-xs-4 search-group">
				<s:textfield cssClass="form-control search-control"
					id="tt_xpyhmstro_enddate" key="purchaseOrder.tt_xpyhmstro_enddate" />
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4 search-group"></div>
			<div class="col-xs-4 search-group layouttrim">
				<input type="hidden" name="from" value="list" />
				<s:submit type="button" cssClass="btn"
					action="forecastPurchaseOrders" key="button.search" theme="simple">
					<i class="icon-search"></i>
					<fmt:message key="button.search" />
				</s:submit>
			</div>
			<div class="col-xs-4 search-group"></div>
		</div>
	</s:form>
	<hr>
	<display:table name="purchaseOrderDetails" cellspacing="0"
		pagesize="25" defaultsort="1" cellpadding="0"
		requestURI="forecastPurchaseOrders" id="purchaseOrderDetails"
		class="table table-condensed table-striped table-hover" export="true">

		<display:column property="tt_xpyhddeto_seq" escapeXml="true"
			sortable="true" titleKey="purchaseOrderDetail.tt_xpyhddeto_seq" />
		<display:column property="tt_xpyhddeto_suppcode" escapeXml="true"
			sortable="true" titleKey="purchaseOrderDetail.tt_xpyhddeto_suppcode" />
		<display:column property="tt_xpyhddeto_shipto" escapeXml="true"
			sortable="true" titleKey="purchaseOrderDetail.tt_xpyhddeto_shipto" />
		<display:column property="tt_xpyhddeto_partnbr" escapeXml="true"
			sortable="true" titleKey="purchaseOrderDetail.tt_xpyhddeto_partnbr" />
		<display:column property="tt_xpyhddeto_partdesc" escapeXml="true"
			sortable="true" titleKey="purchaseOrderDetail.tt_xpyhddeto_partdesc" />
		<display:column property="tt_xpyhddeto_supppart" escapeXml="true"
			sortable="true" titleKey="purchaseOrderDetail.tt_xpyhddeto_supppart" />
		<display:column property="tt_xpyhddeto_receptdt" escapeXml="true"
			sortable="true" titleKey="purchaseOrderDetail.tt_xpyhddeto_receptdt" />
		<display:column property="tt_xpyhddeto_currcy" escapeXml="true"
			sortable="true" titleKey="purchaseOrderDetail.tt_xpyhddeto_currcy" />
		<display:column property="tt_xpyhddeto_uom" escapeXml="true"
			sortable="true" titleKey="purchaseOrderDetail.tt_xpyhddeto_uom" />
		<display:column property="tt_xpyhddeto_innnerqty" escapeXml="true"
			sortable="true" titleKey="purchaseOrderDetail.tt_xpyhddeto_innnerqty" />
		<display:column property="tt_xpyhddeto_externalqty" escapeXml="true"
			sortable="true"
			titleKey="purchaseOrderDetail.tt_xpyhddeto_externalqty" />
		<display:column property="tt_forecast_fcastqty" escapeXml="true"
			sortable="true" titleKey="purchaseOrderDetail.tt_forecast_fcastqty" />

		<display:setProperty name="paging.banner.placement" value="both" />
		<display:setProperty name="paging.banner.item_name">
			<fmt:message key="purchaseOrderList.forecastPurchaseOrderDetail" />
		</display:setProperty>
		<display:setProperty name="paging.banner.items_name">
			<fmt:message key="purchaseOrderList.forecastPurchaseOrderDetails" />
		</display:setProperty>

		<display:setProperty name="export.excel.filename"
			value="ForecastPurchaseOrder List.xls" />

		<display:setProperty name="export.pdf" value="false" />
		<display:setProperty name="export.excel" value="true" />
		<display:setProperty name="export.csv" value="false" />
		<display:setProperty name="export.xml" value="false" />
	</display:table>

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
								triggerLength : 5
							},
							displayField : 'label',
							valueField : 'value'
						//onSelect: displayResult
						});

		$('#tt_xpyhmstro_fromdate').datepicker({
			format : "yyyymmdd",
			language : "${pageContext.response.locale}",
			autoclose : true,
			todayHighlight : true
		});

		$('#tt_xpyhmstro_enddate').datepicker({
			format : "yyyymmdd",
			language : "${pageContext.response.locale}",
			autoclose : true,
			todayHighlight : true
		});
	</script>
</body>



