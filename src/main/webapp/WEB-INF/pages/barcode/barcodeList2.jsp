<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="barcodeList2.title" /></title>
<meta name="menu" content="BarcodeMenu" />
</head>

<body id="barcode">
	<h2>
		<fmt:message key="barcodeList.heading" />
	</h2>

	<s:form name="barcodeForm" action="printByItem" method="post"
		validate="true">
		<div class="row">
			<div class="col-xs-3 search-group">
				<label class="control-label"><fmt:message
						key="barcode.tt_bcdeto_suppcode" /></label> <input
					id="tt_bcdeto_suppcode"
					name="barcode.tt_bcdeto_suppcode" type="text"
					value="${barcode.tt_bcdeto_suppcode}"
					class="col-md-12 form-control search-control" placeholder=""
					autocomplete="off" />
			</div>
			<div class="col-xs-3 search-group">
					<label class="control-label"><fmt:message
						key="barcode.tt_bcdeto_partnbr" /></label> <input
					id="tt_bcdeto_partnbr"
					name="barcode.tt_bcdeto_partnbr" type="text"
					value="${barcode.tt_bcdeto_partnbr}"
					class="col-md-12 form-control search-control" placeholder=""
					autocomplete="off" />
				<input type="hidden" name="cb" value="${cbValue}">
			</div>
			<div class="col-xs-3 search-group">
				<s:textfield cssClass="form-control search-control"
					key="barcode.tt_bcdeto_lots" />
			</div>
			<div class="col-xs-3 search-group">
				<s:textfield cssClass="form-control search-control"
					key="barcode.tt_bcdeto_vend_lots" />
			</div>
			<div class="col-xs-3 search-group">
			<s:textfield cssClass="form-control search-control"
					key="barcode.printQty" />
			</div>
			<div class="col-xs-6 search-group layouttrim">
				<s:radio key="barcode.isexternal" listValue="value"
					value="0" listKey="label" list="packageList" />
			</div>
		</div>
	
		<div class="row">
			<div class="col-xs-12 search-group layouttrim">
			

				<s:submit type="button" cssClass="btn btn-primary"
					formaction="printBarcode2" key="button.print" theme="simple">
					<i class="icon-print icon-white"></i>
					<fmt:message key="button.print" />
				</s:submit>

			
			</div>
		</div>
		<hr>

	
	</s:form>

	<script>
		$('#tt_bcdeto_partnbr')
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

						});
		
		$('#tt_bcdeto_suppcode')
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

