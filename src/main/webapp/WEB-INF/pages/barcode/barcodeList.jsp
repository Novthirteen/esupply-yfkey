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
			<div class="col-xs-3 search-group">
				<s:textfield cssClass="form-control search-control"
					key="purchaseOrderDetail.tt_xpyhddeto_asn" />
				<input type="hidden" name="cb" value="${cbValue}">
			</div>
			<div class="col-xs-3 search-group">
				<s:textfield cssClass="form-control search-control"
					key="purchaseOrderDetail.tt_xpyhddeto_yhdnbr" />
			</div>
			<div class="col-xs-3 search-group">
				<label class="control-label"><fmt:message
						key="purchaseOrderDetail.tt_xpyhddeto_shipto" /></label> <input
					id="tt_xpyhddeto_shipto"
					name="purchaseOrderDetail.tt_xpyhddeto_shipto" type="text"
					value="${purchaseOrderDetail.tt_xpyhddeto_shipto}"
					class="col-md-12 form-control search-control" placeholder=""
					autocomplete="off" />
			</div>
			<div class="col-xs-3 search-group">
				<label class="control-label"><fmt:message
						key="purchaseOrderDetail.tt_xpyhddeto_partnbr" /></label> <input
					id="tt_xpyhddeto_partnbr"
					name="purchaseOrderDetail.tt_xpyhddeto_partnbr" type="text"
					value="${purchaseOrderDetail.tt_xpyhddeto_partnbr}"
					class="col-md-12 form-control search-control" placeholder=""
					autocomplete="off" />
			</div>

		</div>
		<div class="row">
			<div class="col-xs-3 search-group">
				<label class="control-label"><fmt:message
						key="purchaseOrderDetail.tt_xpyhddeto_suppcode" /></label> <input
					id="tt_xpyhddeto_suppcode"
					name="purchaseOrderDetail.tt_xpyhddeto_suppcode" type="text"
					value="${purchaseOrderDetail.tt_xpyhddeto_suppcode}"
					class="col-md-12 form-control search-control" placeholder=""
					autocomplete="off" />
			</div>
			<div class="col-xs-3 search-group">
				<s:textfield cssClass="form-control search-control"
					key="purchaseOrderDetail.tt_xpyhddeto_supppart" />
			</div>

			<div class="col-xs-6 search-group layouttrim">
				<s:radio key="purchaseOrderDetail.isexternal" listValue="value"
					value="0" listKey="label" list="packageList" />
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 search-group layouttrim">
				<s:submit type="button" cssClass="btn btn-primary" formaction="barcodes"
					key="button.search" theme="simple">
					<i class="icon-search icon-white"></i>
					<fmt:message key="button.search" />
				</s:submit>

				<s:submit type="button" cssClass="btn btn-primary"
					formaction="printBarcode" key="button.print" theme="simple">
					<i class="icon-print icon-white"></i>
					<fmt:message key="button.print" />
				</s:submit>
				
				<s:submit type="button" cssClass="btn btn-primary"
					formaction="printAllBarcode" key="button.printAll" theme="simple">
					<i class="icon-print icon-white"></i>
					<fmt:message key="button.printAll" />
				</s:submit>
				

			</div>
		</div>
		<hr>

		<display:table name="purchaseOrderDetails" cellspacing="0"
			pagesize="25" defaultsort="1" cellpadding="0"
			id="purchaseOrderDetail"
			class="table table-condensed table-striped table-hover"
			requestURI="barcodes" export="false"
			excludedParams="purchaseOrderDetails[0].tt_xpyhddeto_lots purchaseOrderDetails[0].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[0].tt_xpyhddeto_qty purchaseOrderDetails[0].tt_xpyhddeto_partnbr purchaseOrderDetails[0].tt_xpyhddeto_tt_xpyhddeto_oldQty
purchaseOrderDetails[1].tt_xpyhddeto_lots purchaseOrderDetails[1].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[1].tt_xpyhddeto_qty purchaseOrderDetails[1].tt_xpyhddeto_partnbr purchaseOrderDetails[1].tt_xpyhddeto_tt_xpyhddeto_oldQty
purchaseOrderDetails[2].tt_xpyhddeto_lots purchaseOrderDetails[2].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[2].tt_xpyhddeto_qty purchaseOrderDetails[2].tt_xpyhddeto_partnbr purchaseOrderDetails[2].tt_xpyhddeto_tt_xpyhddeto_oldQty
purchaseOrderDetails[3].tt_xpyhddeto_lots purchaseOrderDetails[3].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[3].tt_xpyhddeto_qty purchaseOrderDetails[3].tt_xpyhddeto_partnbr purchaseOrderDetails[3].tt_xpyhddeto_tt_xpyhddeto_oldQty
purchaseOrderDetails[4].tt_xpyhddeto_lots purchaseOrderDetails[4].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[4].tt_xpyhddeto_qty purchaseOrderDetails[4].tt_xpyhddeto_partnbr purchaseOrderDetails[4].tt_xpyhddeto_tt_xpyhddeto_oldQty
purchaseOrderDetails[5].tt_xpyhddeto_lots purchaseOrderDetails[5].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[5].tt_xpyhddeto_qty purchaseOrderDetails[5].tt_xpyhddeto_partnbr purchaseOrderDetails[5].tt_xpyhddeto_tt_xpyhddeto_oldQty
purchaseOrderDetails[6].tt_xpyhddeto_lots purchaseOrderDetails[6].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[6].tt_xpyhddeto_qty purchaseOrderDetails[6].tt_xpyhddeto_partnbr purchaseOrderDetails[6].tt_xpyhddeto_tt_xpyhddeto_oldQty
purchaseOrderDetails[7].tt_xpyhddeto_lots purchaseOrderDetails[7].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[7].tt_xpyhddeto_qty purchaseOrderDetails[7].tt_xpyhddeto_partnbr purchaseOrderDetails[7].tt_xpyhddeto_tt_xpyhddeto_oldQty
purchaseOrderDetails[8].tt_xpyhddeto_lots purchaseOrderDetails[8].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[8].tt_xpyhddeto_qty purchaseOrderDetails[8].tt_xpyhddeto_partnbr purchaseOrderDetails[8].tt_xpyhddeto_tt_xpyhddeto_oldQty
purchaseOrderDetails[9].tt_xpyhddeto_lots purchaseOrderDetails[9].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[9].tt_xpyhddeto_qty purchaseOrderDetails[9].tt_xpyhddeto_partnbr purchaseOrderDetails[9].tt_xpyhddeto_tt_xpyhddeto_oldQty
purchaseOrderDetails[10].tt_xpyhddeto_lots purchaseOrderDetails[10].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[10].tt_xpyhddeto_qty purchaseOrderDetails[10].tt_xpyhddeto_partnbr purchaseOrderDetails[10].tt_xpyhddeto_tt_xpyhddeto_oldQty
purchaseOrderDetails[11].tt_xpyhddeto_lots purchaseOrderDetails[11].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[11].tt_xpyhddeto_qty purchaseOrderDetails[11].tt_xpyhddeto_partnbr purchaseOrderDetails[11].tt_xpyhddeto_tt_xpyhddeto_oldQty
purchaseOrderDetails[12].tt_xpyhddeto_lots purchaseOrderDetails[12].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[12].tt_xpyhddeto_qty purchaseOrderDetails[12].tt_xpyhddeto_partnbr purchaseOrderDetails[12].tt_xpyhddeto_tt_xpyhddeto_oldQty
purchaseOrderDetails[13].tt_xpyhddeto_lots purchaseOrderDetails[13].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[13].tt_xpyhddeto_qty purchaseOrderDetails[13].tt_xpyhddeto_partnbr purchaseOrderDetails[13].tt_xpyhddeto_tt_xpyhddeto_oldQty
purchaseOrderDetails[14].tt_xpyhddeto_lots purchaseOrderDetails[14].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[14].tt_xpyhddeto_qty purchaseOrderDetails[14].tt_xpyhddeto_partnbr purchaseOrderDetails[14].tt_xpyhddeto_tt_xpyhddeto_oldQty
purchaseOrderDetails[15].tt_xpyhddeto_lots purchaseOrderDetails[15].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[15].tt_xpyhddeto_qty purchaseOrderDetails[15].tt_xpyhddeto_partnbr purchaseOrderDetails[15].tt_xpyhddeto_tt_xpyhddeto_oldQty
purchaseOrderDetails[16].tt_xpyhddeto_lots purchaseOrderDetails[16].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[16].tt_xpyhddeto_qty purchaseOrderDetails[16].tt_xpyhddeto_partnbr purchaseOrderDetails[16].tt_xpyhddeto_tt_xpyhddeto_oldQty
purchaseOrderDetails[17].tt_xpyhddeto_lots purchaseOrderDetails[17].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[17].tt_xpyhddeto_qty purchaseOrderDetails[17].tt_xpyhddeto_partnbr purchaseOrderDetails[17].tt_xpyhddeto_tt_xpyhddeto_oldQty
purchaseOrderDetails[18].tt_xpyhddeto_lots purchaseOrderDetails[18].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[18].tt_xpyhddeto_qty purchaseOrderDetails[18].tt_xpyhddeto_partnbr purchaseOrderDetails[18].tt_xpyhddeto_tt_xpyhddeto_oldQty
purchaseOrderDetails[19].tt_xpyhddeto_lots purchaseOrderDetails[19].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[19].tt_xpyhddeto_qty purchaseOrderDetails[19].tt_xpyhddeto_partnbr purchaseOrderDetails[19].tt_xpyhddeto_tt_xpyhddeto_oldQty
purchaseOrderDetails[20].tt_xpyhddeto_lots purchaseOrderDetails[20].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[20].tt_xpyhddeto_qty purchaseOrderDetails[20].tt_xpyhddeto_partnbr purchaseOrderDetails[20].tt_xpyhddeto_tt_xpyhddeto_oldQty
purchaseOrderDetails[21].tt_xpyhddeto_lots purchaseOrderDetails[21].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[21].tt_xpyhddeto_qty purchaseOrderDetails[21].tt_xpyhddeto_partnbr purchaseOrderDetails[21].tt_xpyhddeto_tt_xpyhddeto_oldQty
purchaseOrderDetails[22].tt_xpyhddeto_lots purchaseOrderDetails[22].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[22].tt_xpyhddeto_qty purchaseOrderDetails[22].tt_xpyhddeto_partnbr purchaseOrderDetails[22].tt_xpyhddeto_tt_xpyhddeto_oldQty
purchaseOrderDetails[23].tt_xpyhddeto_lots purchaseOrderDetails[23].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[23].tt_xpyhddeto_qty purchaseOrderDetails[23].tt_xpyhddeto_partnbr purchaseOrderDetails[23].tt_xpyhddeto_tt_xpyhddeto_oldQty
purchaseOrderDetails[24].tt_xpyhddeto_lots purchaseOrderDetails[24].tt_xpyhddeto_xpyhddetoid purchaseOrderDetails[24].tt_xpyhddeto_qty purchaseOrderDetails[24].tt_xpyhddeto_partnbr purchaseOrderDetails[24].tt_xpyhddeto_tt_xpyhddeto_oldQty">

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


			</display:column>
			<display:column titleKey="purchaseOrderDetail.tt_xpyhddeto_qty">
				<input type="text" style="margin: 0px; width: 100px;"
					name="purchaseOrderDetails[${purchaseOrderDetail_rowNum- 1}].tt_xpyhddeto_qty"
					value="${purchaseOrderDetail.tt_xpyhddeto_qty}" class="text medium" />
				<input type="hidden"
					name="purchaseOrderDetails[${purchaseOrderDetail_rowNum - 1}].tt_xpyhddeto_oldQty"
					value="${purchaseOrderDetail.tt_xpyhddeto_qty}" />
			</display:column>

			<display:setProperty name="paging.banner.placement" value="both" />
			<display:setProperty name="paging.banner.item_name">
				<fmt:message key="purchaseOrderList.purchaseOrderDetail" />
			</display:setProperty>
			<display:setProperty name="paging.banner.items_name">
				<fmt:message key="purchaseOrderList.purchaseOrderDetails" />
			</display:setProperty>
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
								triggerLength : 5
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

