<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="receiptList.title" /></title>
<meta name="menu" content="ReceiptMenu" />
</head>

<h4>
	<fmt:message key="receiptList.heading" />
</h4>

<s:form name="receiptForm" action="receipts" method="post"
	validate="true">
	<div class="row">
		<div class="col-xs-3 search-group">
			<s:textfield cssClass="form-control search-control"
				key="receipt.tt_prhmstro_receiver" />
		</div>
		<div class="col-xs-3 search-group">
			<s:textfield cssClass="form-control search-control"
				key="receipt.tt_prhmstri_yhdnbr" />
		</div>
		<div class="col-xs-3 search-group">
			<label class="control-label"><fmt:message
					key="receipt.tt_prhmstro_suppcode" /></label> <input
				id="tt_prhmstro_suppcode" name="receipt.tt_prhmstro_suppcode"
				value="${receipt.tt_prhmstro_suppcode}" type="text"
				class="col-md-12 form-control search-control" placeholder=""
				autocomplete="off" />
		</div>
		<div class="col-xs-3 search-group">
			<s:textfield cssClass="form-control search-control"
				id="tt_prhmstri_fromdate" key="receipt.tt_prhmstri_fromdate" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-3 search-group">
			<s:textfield cssClass="form-control search-control"
				id="tt_prhmstri_todate" key="receipt.tt_prhmstri_todate" />
		</div>
		<div class="col-xs-3 search-group">
			<label class="control-label"><fmt:message
					key="receipt.tt_prhmstri_partnbr" /></label> <input
				id="tt_prhmstri_partnbr" name="receipt.tt_prhmstri_partnbr"
				value="${receipt.tt_prhmstri_partnbr}" type="text"
				class="col-md-12 form-control search-control" placeholder=""
				autocomplete="off" />
		</div>
		<div class="col-xs-3 search-group layouttrim">
			<s:checkbox key="receipt.isDetail" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-3 search-group"></div>
		<div class="col-xs-3 search-group layouttrim">
			<input type="hidden" name="from" value="list" />
			<s:submit type="button" cssClass="btn" action="receipts"
				key="button.search" theme="simple">
				<i class="icon-search"></i>
				<fmt:message key="button.search" />
			</s:submit>
		</div>
	</div>
</s:form>
<hr>
<c:choose>
	<c:when test="${!receipt.isDetail}">
		<display:table name="receipts" cellspacing="0" cellpadding="0"
			requestURI="receipts" defaultsort="1" id="receipts" pagesize="25"
			class="table table-condensed table-striped table-hover" export="true">
			<display:column property="tt_prhmstro_seq" escapeXml="true"
				sortable="true" titleKey="receipt.tt_prhmstro_seq" />

			<display:column property="tt_prhmstro_receiver" escapeXml="true"
				sortable="true" titleKey="receipt.tt_prhmstro_receiver"
				url="/receipt/editReceipt?from=list" paramId="tt_prhmstri_receiver"
				paramProperty="tt_prhmstro_receiver" />

			<display:column property="tt_prhmstro_suppcode" escapeXml="true"
				sortable="true" titleKey="receipt.tt_prhmstro_suppcode" />
			<display:column property="tt_prhmstro_asnnbr" escapeXml="true"
				sortable="true" titleKey="receipt.tt_prhmstro_asnnbr" />
			<display:column property="tt_prhmstro_shipto" escapeXml="true"
				sortable="true" titleKey="receipt.tt_prhmstro_shipto" />
			<display:column property="tt_prhmstro_rcdate" escapeXml="true"
				sortable="true" titleKey="receipt.tt_prhmstro_rcdate" />
			<display:column property="tt_prhmstro_rcuserid" escapeXml="true"
				sortable="true" titleKey="receipt.tt_prhmstro_rcuserid" />

			<display:setProperty name="paging.banner.placement" value="both" />
			<display:setProperty name="paging.banner.item_name">
				<fmt:message key="receiptList.receipt" />
			</display:setProperty>
			<display:setProperty name="paging.banner.items_name">
				<fmt:message key="receiptList.receipts" />
			</display:setProperty>

			<display:setProperty name="export.excel.filename"
				value="Receipt List.xls" />

			<display:setProperty name="export.pdf" value="false" />
			<display:setProperty name="export.excel" value="true" />
			<display:setProperty name="export.csv" value="false" />
			<display:setProperty name="export.xml" value="false" />

		</display:table>
	</c:when>
	<c:otherwise>

		<display:table name="receiptDetails" cellspacing="0" pagesize="25"
			defaultsort="1" cellpadding="0" requestURI="receiptDetails"
			id="receiptDetail"
			class="table table-condensed table-striped table-hover" export="true">

			<display:column property="tt_prhdeto_seq" escapeXml="true"
				sortable="true" titleKey="receiptDetail.tt_prhdeto_seq" />
			<display:column property="tt_prhdeto_receiver" escapeXml="true"
				sortable="true" titleKey="receiptDetail.tt_prhdeto_receiver" />
			<display:column property="tt_prhdeto_yhdnbr" escapeXml="true"
				sortable="true" titleKey="receiptDetail.tt_prhdeto_yhdnbr" />
			<display:column property="tt_prhdeto_partnbr" escapeXml="true"
				sortable="true" titleKey="receiptDetail.tt_prhdeto_partnbr" />
			<display:column property="tt_prhdeto_partdesc" escapeXml="true"
				sortable="true" titleKey="receiptDetail.tt_prhdeto_partdesc" />
			<display:column property="tt_prhdeto_supppart" escapeXml="true"
				sortable="true" titleKey="receiptDetail.tt_prhdeto_supppart" />
			<display:column property="tt_prhdeto_uom" escapeXml="true"
				sortable="true" titleKey="receiptDetail.tt_prhdeto_uom" />
			<display:column property="tt_prhdeto_spq" escapeXml="true"
				sortable="true" titleKey="receiptDetail.tt_prhdeto_spq" />
			<display:column property="tt_prhdeto_toloc" escapeXml="true"
				sortable="true" titleKey="receiptDetail.tt_prhdeto_toloc" />
			<display:column property="tt_prhdeto_delvqty" escapeXml="true"
				sortable="true" titleKey="receiptDetail.tt_prhdeto_delvqty" />
			<display:column property="tt_prhdeto_revdqty" escapeXml="true"
				sortable="true" titleKey="receiptDetail.tt_prhdeto_revdqty" />

			<display:setProperty name="paging.banner.placement" value="both" />
			<display:setProperty name="paging.banner.item_name">
				<fmt:message key="receiptList.receiptDetail" />
			</display:setProperty>
			<display:setProperty name="paging.banner.items_name">
				<fmt:message key="receiptList.receiptDetails" />
			</display:setProperty>

			<display:setProperty name="export.excel.filename"
				value="Receipt List.xls" />
			<display:setProperty name="export.pdf" value="false" />
			<display:setProperty name="export.excel" value="true" />
			<display:setProperty name="export.csv" value="false" />
			<display:setProperty name="export.xml" value="false" />
		</display:table>
	</c:otherwise>
</c:choose>

<script>
	$('#tt_prhmstri_partnbr').typeahead({
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
	$('#tt_prhmstro_suppcode').typeahead({
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

	$('#tt_prhmstri_fromdate').datepicker({
		format : "yyyymmdd",
		language : "${pageContext.response.locale}",
		autoclose : true,
		todayHighlight : true
	});

	$('#tt_prhmstri_todate').datepicker({
		format : "yyyymmdd",
		language : "${pageContext.response.locale}",
		autoclose : true,
		todayHighlight : true
	});
</script>

</body>