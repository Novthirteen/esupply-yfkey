<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="invoiceList.title" /></title>
<meta name="menu" content="BillMenu" />
</head>
<body id="invoice">
	<h2>
		<fmt:message key="invoiceList.heading" />
	</h2>

	<s:form name="invoiceForm"
		action="invoices" method="post" validate="true">
		<div class="row">
			<div class="col-xs-4 search-group">
				<label class="control-label"><fmt:message
						key="invoice.tt_cinvoice_sp" /></label> <input
					id="tt_cinvoice_sp"
					name="invoice.tt_cinvoice_sp" type="text"
					value="${invoice.tt_cinvoice_sp}"
					class="col-md-12 form-control search-control" placeholder=""
					autocomplete="off" /> <input type="hidden" name="cb"
					value="${cbValue}">
			</div>
			<div class="col-xs-4 search-group">
				<label class="control-label"><fmt:message
						key="invoice.tt_cinvoice_type" /></label> <input
					id="tt_cinvoice_type" name="invoice.tt_cinvoice_type"
					type="text" value="${invoice.tt_cinvoice_type}"
					class="col-md-12 form-control search-control" placeholder=""
					autocomplete="off"/>
			</div>

			<div class="col-xs-4 search-group">
				<label class="control-label"><fmt:message
						key="invoice.tt_cinvoice_curr" /></label> <input
					id="tt_cinvoice_curr" name="invoice.tt_cinvoice_curr"
					type="text" value="${invoice.tt_cinvoice_curr}"
					class="col-md-12 form-control search-control" />
			</div>

		</div>
		<div class="row">
			<div class="col-xs-4 search-group">
				<s:textfield cssClass="form-control search-control"
					id="tt_cinvoice_fromdate"
					key="invoice.tt_cinvoice_fromdate" />
			</div>
			<div class="col-xs-4 search-group">
				<s:textfield cssClass="form-control search-control"
					id="tt_cinvoice_todate" key="invoice.tt_cinvoice_todate" />
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4 search-group"></div>
			<div class="col-xs-4 search-group layouttrim">
				<input type="hidden" name="from" value="list" />
				<s:submit type="button" cssClass="btn"
					action="invoices" key="button.search" theme="simple">
					<i class="icon-search"></i>
					<fmt:message key="button.search" />
				</s:submit>
			</div>
			<div class="col-xs-4 search-group"></div>
		</div>
	</s:form>
	<hr>
	<display:table name="invoices" cellspacing="0"
		pagesize="25" defaultsort="1" cellpadding="0"
		requestURI="invoices" id="invoice"
		class="table table-condensed table-striped table-hover" export="true">

		<display:column property="tt_cinvoice_sp" escapeXml="true"
			sortable="true" titleKey="invoice.tt_cinvoice_sp" />
		<display:column property="tt_cinvoice_br" escapeXml="true"
			sortable="true" titleKey="invoice.tt_cinvoice_br" />
		<display:column property="tt_cinvoice_invdate" escapeXml="true"
			sortable="true" titleKey="invoice.tt_cinvoice_invdate" />
		<display:column property="tt_cinvoice_rf" escapeXml="true"
			sortable="true" titleKey="invoice.tt_cinvoice_rf" />
		<display:column property="tt_cinvoice_duedate" escapeXml="true"
			sortable="true" titleKey="invoice.tt_cinvoice_duedate" />
		<display:column property="tt_cinvoice_tb" escapeXml="true"
			sortable="true" titleKey="invoice.tt_cinvoice_tb" />
		<display:column property="tt_cinvoice_curr" escapeXml="true"
			sortable="true" titleKey="invoice.tt_cinvoice_curr" />
		<display:column property="tt_cinvoice_tbcr" escapeXml="true"
			sortable="true" titleKey="invoice.tt_cinvoice_tbcr" />
		<display:column property="tt_cinvoice_tbdr" escapeXml="true"
			sortable="true" titleKey="invoice.tt_cinvoice_tbdr" />
		<display:column property="tt_cinvoice_type" escapeXml="true"
			sortable="true" titleKey="invoice.tt_cinvoice_type" />
		<display:column property="tt_cinvoice_hold" escapeXml="true"
			sortable="true"
			titleKey="invoice.tt_cinvoice_hold" />
		<display:column property="tt_cinvoice_brname" escapeXml="true"
			sortable="true" titleKey="invoice.tt_cinvoice_brname" />
		<display:column property="tt_cinvoice_term" escapeXml="true"
			sortable="true" titleKey="invoice.tt_cinvoice_term" />

		<display:setProperty name="paging.banner.placement" value="both" />
		<display:setProperty name="paging.banner.item_name">
			<fmt:message key="invoiceList.invoice" />
		</display:setProperty>
		<display:setProperty name="paging.banner.items_name">
			<fmt:message key="invoiceList.invoices" />
		</display:setProperty>

		<display:setProperty name="export.excel.filename"
			value="Invoice List.xls" />

		<display:setProperty name="export.pdf" value="false" />
		<display:setProperty name="export.excel" value="true" />
		<display:setProperty name="export.csv" value="false" />
		<display:setProperty name="export.xml" value="false" />
	</display:table>

	<script>
		$('#tt_cinvoice_sp')
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

		$('#tt_cinvoice_type')
		.typeahead(
				{
					ajax : {
						url : "<c:url value="/services/api/supplys/getInvoiceTypeData.json"/>",
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


		$('#tt_cinvoice_fromdate').datepicker({
			format : "yyyymmdd",
			language : "${pageContext.response.locale}",
			autoclose : true,
			todayHighlight : true
		});

		$('#tt_cinvoice_todate').datepicker({
			format : "yyyymmdd",
			language : "${pageContext.response.locale}",
			autoclose : true,
			todayHighlight : true
		});
	</script>
</body>



