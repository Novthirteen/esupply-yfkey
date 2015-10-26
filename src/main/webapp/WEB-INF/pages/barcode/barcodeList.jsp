<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="barcodeList.title" /></title>
<meta name="menu" content="BarcodeMenu" />
</head>

<body id="purchaseOrderDetail">
	<h2>
		<fmt:message key="barcodeList.heading" />
	</h2>

	<s:form name="barcodeForm" action="barcodes" method="post"
		validate="true">
		<div class="row">
			<div class="col-xs-4 search-group">
				<s:textfield cssClass="form-control search-control"
					key="purchaseOrderDetail.tt_xpyhddeto_yhdnbr" />
			</div>
			<div class="col-xs-4 search-group">
				<fmt:message key="purchaseOrderDetail.tt_xpyhddeto_shipto" />
				<input id="tt_xpyhddeto_shipto"
					name="purchaseOrderDetail.tt_xpyhddeto_shipto" type="text" value="${purchaseOrderDetail.tt_xpyhddeto_shipto}" 
					class="col-md-12 form-control" placeholder="" autocomplete="off" />
			</div>
			<div class="col-xs-4 search-group">
				<fmt:message key="purchaseOrderDetail.tt_xpyhddeto_partnbr" />
				<input id="tt_xpyhddeto_partnbr"
					name="purchaseOrderDetail.tt_xpyhddeto_partnbr" type="text" value="${purchaseOrderDetail.tt_xpyhddeto_partnbr}" 
					class="col-md-12 form-control" placeholder="" autocomplete="off" />
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4 search-group">
				<fmt:message key="purchaseOrderDetail.tt_xpyhddeto_suppcode" />
				<input id="tt_xpyhddeto_suppcode"
					name="purchaseOrderDetail.tt_xpyhddeto_suppcode" type="text"
					value="${purchaseOrderDetail.tt_xpyhddeto_suppcode}"
					class="col-md-12 form-control" placeholder="" autocomplete="off" />
			</div>
			<div class="col-xs-4 search-group">
				<s:textfield cssClass="form-control search-control"
					key="purchaseOrderDetail.tt_xpyhddeto_supppart" />
			</div>
			<div class="col-xs-4 search-group layouttrim">
				<s:radio key="purchaseOrderDetail.isexternal" listValue="value"
					value="1" listKey="label" list="packageList" />
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4 search-group"></div>
			<div class="col-xs-4 search-group layouttrim">

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
			class="table table-condensed table-striped table-hover"
			export="false">

			<display:column property="tt_xpyhddeto_seq" escapeXml="true"
				titleKey="purchaseOrderDetail.tt_xpyhddeto_seq" />
			<display:column property="tt_xpyhddeto_yhdnbr" escapeXml="true"
				titleKey="purchaseOrderDetail.tt_xpyhddeto_yhdnbr" />
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
					name="purchaseOrderDetails[${purchaseOrderDetail_rowNum - 1}].tt_xpyhddeto_lots"
					value="${purchaseOrderDetail.tt_xpyhddeto_lots}"
					class="text medium" />
				<input type="hidden"
					name="purchaseOrderDetails[${purchaseOrderDetail_rowNum - 1}].tt_xpyhddeto_xpyhddetoid"
					value="${purchaseOrderDetail.tt_xpyhddeto_xpyhddetoid}" />
				<input type="hidden"
					name="purchaseOrderDetails[${purchaseOrderDetail_rowNum - 1}].tt_xpyhddeto_partnbr"
					value="${purchaseOrderDetail.tt_xpyhddeto_partnbr}" />
				<input type="hidden"
					name="purchaseOrderDetails[${purchaseOrderDetail_rowNum- 1}].tt_xpyhddeto_partdesc"
					value="${purchaseOrderDetail.tt_xpyhddeto_partdesc}" />

			</display:column>
			<display:column titleKey="purchaseOrderDetail.tt_xpyhddeto_qty">
				<input type="text" style="margin: 0px; width: 100px;"
					name="purchaseOrderDetails[${purchaseOrderDetail_rowNum- 1}].tt_xpyhddeto_qty"
					value="${purchaseOrderDetail.tt_xpyhddeto_qty}" class="text medium" />
			</display:column>
		</display:table>
	</s:form>

	<script>
		$('#tt_xpyhddeto_shipto')
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

		$('#tt_xpyhddeto_partnbr')
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

		$('#tt_xpyhddeto_suppcode')
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
	</script>

</body>

