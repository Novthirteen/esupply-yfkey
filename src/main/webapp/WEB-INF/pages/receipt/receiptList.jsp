<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="receiptList.title" /></title>
<meta name="menu" content="ReceiptMenu" />
</head>

<h2>
	<fmt:message key="receiptList.heading" />
</h2>

<s:form name="receiptForm" action="receipts" method="post"
	validate="true">
	<div class="row">
		<div class="col-xs-4 search-group">
			<s:textfield cssClass="form-control search-control"
				key="receipt.tt_prhmstro_receiver" />
		</div>
		<div class="col-xs-4 search-group">
			<s:textfield cssClass="form-control search-control"
				key="receipt.tt_prhmstri_yhdnbr" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4 search-group">
			<s:textfield cssClass="form-control search-control"
				key="receipt.tt_prhmstri_fromdate" />
		</div>
		<div class="col-xs-4 search-group">
			<s:textfield cssClass="form-control search-control"
				key="receipt.tt_prhmstri_todate" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4 search-group">
			<s:textfield cssClass="form-control search-control"
				key="receipt.tt_prhmstri_partnbr" />
		</div>
		<div class="col-xs-4 search-group layouttrim">
			<s:checkbox key="receipt.isDetail" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4 search-group layouttrim">
			<input type="hidden" name="from" value="list" />
			<s:submit type="button" cssClass="btn" action="receipts"
				key="button.search" theme="simple">
				<i class="icon-search"></i>
				<fmt:message key="button.search" />
			</s:submit>
		</div>
	</div>
</s:form>

<c:choose>
	<c:when test="${!receipt.isDetail}">
		<display:table name="receipts" cellspacing="0" cellpadding="0"
			requestURI="receipts" defaultsort="1" id="receipts" pagesize="25"
			class="table table-condensed table-striped table-hover" export="true">
			<display:column property="tt_prhmstro_seq" escapeXml="true"
				sortable="true" titleKey="receipt.tt_prhmstro_seq" />
		
			<display:column property="tt_prhmstro_receiver" escapeXml="true"
				sortable="true" titleKey="receipt.tt_prhmstro_receiver"
				url="/receipt/editReceipt?from=list"
				paramId="tt_prhmstri_receiver" paramProperty="tt_prhmstro_receiver" />
				
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

			<display:setProperty name="paging.banner.item_name">
				<fmt:message key="receiptList.receipt" />
			</display:setProperty>
			<display:setProperty name="paging.banner.items_name">
				<fmt:message key="receiptList.receipts" />
			</display:setProperty>

			<display:setProperty name="export.excel.filename"
				value="Receipt List.xls" />



		</display:table>
	</c:when>
	<c:otherwise>

		<display:table name="receiptDetails" cellspacing="0" pagesize="25"
			defaultsort="1" cellpadding="0" requestURI="receipts"
			id="receiptDetails"
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

			<display:setProperty name="paging.banner.item_name">
				<fmt:message key="receiptList.receiptDetail" />
			</display:setProperty>
			<display:setProperty name="paging.banner.items_name">
				<fmt:message key="receiptList.receiptDetails" />
			</display:setProperty>

			<display:setProperty name="export.excel.filename"
				value="Receipt List.xls" />
		</display:table>
	</c:otherwise>
</c:choose>