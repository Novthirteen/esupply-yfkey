<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="billList.title" /></title>
<meta name="menu" content="BillMenu" />
</head>

<h2>
	<fmt:message key="billList.heading" />
</h2>

<s:form name="billForm" action="bills" method="post" validate="true">
	<div class="row">
		<div class="col-xs-4 search-group">
			<s:textfield cssClass="form-control search-control"
				key="bill.tt_xprcmstro_voucher" />
		</div>
		<div class="col-xs-4 search-group">
			<s:textfield cssClass="form-control search-control"
				key="bill.tt_xprcmstro_suppcode" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4 search-group">
			<s:textfield cssClass="form-control search-control"
				key="bill.tt_xprcmstri_fromdate" />
		</div>
		<div class="col-xs-4 search-group">
			<s:textfield cssClass="form-control search-control"
				key="bill.tt_xprcmstri_todate" />
		</div>
	</div>

	<div class="row">
		<div class="col-xs-4 search-group layouttrim">
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
		url="/bill/editBill?from=list" paramId="tt_prhmstri_receiver"
		paramProperty="tt_prhmstro_receiver" />
	<display:column property="tt_xprcmstro_suppcode" escapeXml="true"
		sortable="true" titleKey="bill.tt_xprcmstro_suppcode" />
	<display:column property="tt_xprcmstro_invdate" escapeXml="true"
		sortable="true" titleKey="bill.tt_xprcmstro_invdate" />
	<display:column property="tt_xprcmstro_totalamt" escapeXml="true"
		sortable="true" titleKey="bill.tt_xprcmstro_totalamt" />
	<display:column property="tt_xprcmstro_printed" escapeXml="true"
		sortable="true" titleKey="bill.tt_xprcmstro_printed" />
	<display:column property="tt_xprcmstro_stat" escapeXml="true"
		sortable="true" titleKey="bill.tt_xprcmstro_stat" />

	<display:setProperty name="paging.banner.item_name">
		<fmt:message key="billList.bill" />
	</display:setProperty>
	<display:setProperty name="paging.banner.items_name">
		<fmt:message key="billList.bills" />
	</display:setProperty>

	<display:setProperty name="export.excel.filename" value="Bill List.xls" />



</display:table>
