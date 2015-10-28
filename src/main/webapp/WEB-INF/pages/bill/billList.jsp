<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="billList.title" /></title>
<meta name="menu" content="BillMenu" />
</head>

<h2>
	<fmt:message key="billList.heading" />
</h2>
<body id="bill">
	<s:form name="billForm" action="bills" method="post" validate="true">
		<div class="row">
			<div class="col-xs-4 search-group">
				<s:textfield cssClass="form-control search-control"
					key="bill.tt_xprcmstro_voucher" />
			</div>
			<div class="col-xs-4 search-group">
				<s:textfield cssClass="form-control search-control" id="tt_xprcmstri_fromdate" key="bill.tt_xprcmstri_fromdate" />
			</div>
			<div class="col-xs-4 search-group">
				<s:textfield cssClass="form-control search-control" id="tt_xprcmstri_todate" key="bill.tt_xprcmstri_todate" />
			</div>
		</div>

		<div class="row">
			<div class="col-xs-4 search-group">
				<fmt:message key="bill.tt_xprcmstro_suppcode" />
				<input id="tt_xprcmstro_suppcode" name="bill.tt_xprcmstro_suppcode"
					value="${bill.tt_xprcmstro_suppcode}" type="text"
					class="col-md-12 form-control" placeholder="" autocomplete="off" />
			</div>
			<div class="col-xs-4 search-group">

				<s:select key="bill.tt_xprcmstro_stat"
					list="billStatusList" listKey="label" listValue="value"
					cssClass="form-control" />

			</div>
			<div class="col-xs-4 search-group layouttrim" >
				<input type="hidden" name="from" value="list" />
				<s:submit type="button" cssClass="btn" action="bills"
					key="button.search" theme="simple">
					<i class="icon-search"></i>
					<fmt:message key="button.search" />
				</s:submit>
			</div>
		</div>
	</s:form>

	<display:table name="bills" cellspacing="0" cellpadding="0"
		requestURI="bills" defaultsort="1" id="bills" pagesize="25"
		class="table table-condensed table-striped table-hover" export="true">
		<display:column property="tt_xprcmstro_seq" escapeXml="true"
			sortable="true" titleKey="bill.tt_xprcmstro_seq" />
		<display:column property="tt_xprcmstro_voucher" escapeXml="true"
			sortable="true" titleKey="bill.tt_xprcmstro_voucher"
			url="/bill/editBill?from=list" paramId="tt_xprcmstro_xprcmstroid"
			paramProperty="tt_xprcmstro_xprcmstroid" />
		<display:column property="tt_xprcmstro_suppcode" escapeXml="true"
			sortable="true" titleKey="bill.tt_xprcmstro_suppcode" />
		<display:column property="tt_xprcmstro_invdate" escapeXml="true"
			sortable="true" titleKey="bill.tt_xprcmstro_invdate" />
		<display:column property="tt_xprcmstro_totalamt" escapeXml="true"
			sortable="true" titleKey="bill.tt_xprcmstro_totalamt" />
	
		<display:column titleKey="bill.tt_xprcmstro_printed" escapeXml="true"
		sortable="true">
		<c:choose>
			<c:when test="${bill.tt_xprcmstro_printed eq '0'}">
				<fmt:message key="common.no" />
			</c:when>
			<c:otherwise>
				<fmt:message key="common.yes" />
			</c:otherwise>
		</c:choose>
	</display:column>	
		
		<display:column property="tt_xprcmstro_stat_desc" escapeXml="true"
			sortable="true" titleKey="bill.tt_xprcmstro_stat_desc" />

		<display:setProperty name="paging.banner.placement" value="both" />
		<display:setProperty name="paging.banner.item_name">
			<fmt:message key="billList.bill" />
		</display:setProperty>
		<display:setProperty name="paging.banner.items_name">
			<fmt:message key="billList.bills" />
		</display:setProperty>

		<display:setProperty name="export.excel.filename"
			value="Bill List.xls" />

		<display:setProperty name="export.pdf" value="false" />
		<display:setProperty name="export.excel" value="true" />
		<display:setProperty name="export.csv" value="false" />
		<display:setProperty name="export.xml" value="false" />

	</display:table>

	<script>
		$('#tt_xprcmstro_suppcode')
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
		
		$('#tt_xprcmstri_fromdate').datepicker({
		    format: "yyyymmdd",
		    language:  "${pageContext.response.locale}",
		    autoclose: true,
		    todayHighlight: true
		});
		
		$('#tt_xprcmstri_todate').datepicker({
		    format: "yyyymmdd",
		    language:  "${pageContext.response.locale}",
		    autoclose: true,
		    todayHighlight: true
		});
	</script>
</body>
