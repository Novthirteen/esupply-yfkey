<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="paymentList.title" /></title>
<meta name="menu" content="BillMenu" />
</head>
<body id="payment">
	<h2>
		<fmt:message key="paymentList.heading" />
	</h2>

	<s:form name="paymentForm"
		action="payments" method="post" validate="true">
		<div class="row">
			<div class="col-xs-4 search-group">
				<label class="control-label"><fmt:message
						key="payment.tt_payment_sp" /></label> <input
					id="tt_payment_sp"
					name="payment.tt_payment_sp" type="text"
					value="${payment.tt_payment_sp}"
					class="col-md-12 form-control search-control" placeholder=""
					autocomplete="off" /> <input type="hidden" name="cb"
					value="${cbValue}">
			</div>
			<div class="col-xs-4 search-group">
				<label class="control-label"><fmt:message
						key="payment.tt_payment_status" /></label> <input
					id="tt_payment_type" name="payment.tt_payment_status"
					type="text" value="${payment.tt_payment_status}"
					class="col-md-12 form-control search-control" />
			</div>

			<div class="col-xs-4 search-group">
				<label class="control-label"><fmt:message
						key="payment.tt_payment_curr" /></label> <input
					id="tt_payment_curr" name="payment.tt_payment_curr"
					type="text" value="${payment.tt_payment_curr}"
					class="col-md-12 form-control search-control" />
			</div>

		</div>
		<div class="row">
			<div class="col-xs-4 search-group">
				<s:textfield cssClass="form-control search-control"
					id="tt_payment_fromdate"
					key="payment.tt_payment_fromdate" />
			</div>
			<div class="col-xs-4 search-group">
				<s:textfield cssClass="form-control search-control"
					id="tt_payment_todate" key="payment.tt_payment_todate" />
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4 search-group"></div>
			<div class="col-xs-4 search-group layouttrim">
				<input type="hidden" name="from" value="list" />
				<s:submit type="button" cssClass="btn"
					action="payments" key="button.search" theme="simple">
					<i class="icon-search"></i>
					<fmt:message key="button.search" />
				</s:submit>
			</div>
			<div class="col-xs-4 search-group"></div>
		</div>
	</s:form>
	<hr>
	<display:table name="payments" cellspacing="0"
		pagesize="25" defaultsort="1" cellpadding="0"
		requestURI="payments" id="payment"
		class="table table-condensed table-striped table-hover" export="true">

		<display:column property="tt_payment_sp" escapeXml="true"
			sortable="true" titleKey="payment.tt_payment_sp" />
		<display:column property="tt_payment_payrf" escapeXml="true"
			sortable="true" titleKey="payment.tt_payment_payrf" />
		<display:column property="tt_payment_rf" escapeXml="true"
			sortable="true" titleKey="payment.tt_payment_rf" />
		<display:column property="tt_payment_date" escapeXml="true"
			sortable="true" titleKey="payment.tt_payment_date" />
		<display:column property="tt_payment_orgTC" escapeXml="true"
			sortable="true" titleKey="payment.tt_payment_orgTC" />
		<display:column property="tt_payment_curr" escapeXml="true"
			sortable="true" titleKey="payment.tt_payment_curr" />
		<display:column property="tt_payment_invno" escapeXml="true"
			sortable="true" titleKey="payment.tt_payment_invno" />
		<display:column property="tt_payment_status" escapeXml="true"
			sortable="true" titleKey="payment.tt_payment_status" />
		<display:column property="tt_payment_TC" escapeXml="true"
			sortable="true" titleKey="payment.tt_payment_TC" />
		<display:column property="tt_payment_openTC" escapeXml="true"
			sortable="true" titleKey="payment.tt_payment_openTC" />
		<display:column property="tt_payment_entity" escapeXml="true"
			sortable="true" titleKey="payment.tt_payment_entity" />
	

		<display:setProperty name="paging.banner.placement" value="both" />
		<display:setProperty name="paging.banner.item_name">
			<fmt:message key="paymentList.payment" />
		</display:setProperty>
		<display:setProperty name="paging.banner.items_name">
			<fmt:message key="paymentList.payments" />
		</display:setProperty>

		<display:setProperty name="export.excel.filename"
			value="Invoice List.xls" />

		<display:setProperty name="export.pdf" value="false" />
		<display:setProperty name="export.excel" value="true" />
		<display:setProperty name="export.csv" value="false" />
		<display:setProperty name="export.xml" value="false" />
	</display:table>

	<script>
		$('#tt_payment_sp')
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

	


		$('#tt_payment_fromdate').datepicker({
			format : "yyyymmdd",
			language : "${pageContext.response.locale}",
			autoclose : true,
			todayHighlight : true
		});

		$('#tt_payment_todate').datepicker({
			format : "yyyymmdd",
			language : "${pageContext.response.locale}",
			autoclose : true,
			todayHighlight : true
		});
	</script>
</body>



