<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="asnList.title" /></title>
<meta name="menu" content="AsnMenu" />
</head>

<h2>
	<fmt:message key="asnList.heading" />
</h2>

<s:form name="asnForm" action="asns" method="post" validate="true">
	<div class="row">
		<div class="col-xs-4 search-group">
			<s:textfield cssClass="form-control search-control"
				key="asn.tt_xasnmstro_asnnbr" />
		</div>
		<div class="col-xs-4 search-group">
			<s:select key="asn.tt_xasnmstro_stat" list="asnStatusList"
				listKey="label" listValue="value" cssClass="form-control" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4 search-group">
			<s:textfield cssClass="form-control search-control"
				key="asn.tt_xasnmstro_yhnbr" />
		</div>
		<div class="col-xs-4 search-group">
			<s:textfield cssClass="form-control search-control"
				key="asn.tt_xasnmstro_shipto" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4 search-group">
			<s:textfield cssClass="form-control search-control"
				key="asn.tt_xasnmstri_fromdate" />
		</div>
		<div class="col-xs-4 search-group">
			<s:textfield cssClass="form-control search-control"
				key="asn.tt_xasnmstri_todate" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4 search-group">
			<s:textfield cssClass="form-control search-control"
				key="asn.tt_xasnmstri_partnbr" />
		</div>
		<div class="col-xs-4 search-group layouttrim">
			<s:checkbox key="asn.isDetail" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4 search-group">
			<input type="hidden" name="from" value="list" />
			<s:submit type="button" cssClass="btn" action="asns"
				key="button.search" theme="simple">
				<i class="icon-search"></i>
				<fmt:message key="button.search" />
			</s:submit>
		</div>
	</div>
</s:form>

<c:choose>
	<c:when test="${!asn.isDetail}">
		<display:table name="asns" cellspacing="0" cellpadding="0"
			requestURI="asns" defaultsort="1" id="asns" pagesize="25"
			class="table table-condensed table-striped table-hover" export="true">
			<display:column property="tt_xasnmstro_seq" escapeXml="true"
				sortable="true" titleKey="asn.tt_xasnmstro_seq" />
			<display:column property="tt_xasnmstro_asnnbr" escapeXml="true"
				sortable="true" titleKey="asn.tt_xasnmstro_asnnbr"
				url="/asn/editAsn?from=list" paramId="tt_xasnmstro_xasnmstroid"
				paramProperty="tt_xasnmstro_xasnmstroid" />
			<display:column property="tt_xasnmstro_startdt" escapeXml="true"
				sortable="true" titleKey="asn.tt_xasnmstro_startdt" />
			<display:column property="tt_xasnmstro_stat_desc" escapeXml="true"
				sortable="true" titleKey="asn.tt_xasnmstro_stat_desc" />
			<display:column property="tt_xasnmstro_creator" escapeXml="true"
				sortable="true" titleKey="asn.tt_xasnmstro_creator" />

			<display:setProperty name="paging.banner.item_name">
				<fmt:message key="asnList.asn" />
			</display:setProperty>
			<display:setProperty name="paging.banner.items_name">
				<fmt:message key="asnList.asns" />
			</display:setProperty>
			<display:setProperty name="export.excel.filename"
				value="Asn List.xls" />

			<display:setProperty name="export.pdf" value="false" />
			<display:setProperty name="export.excel" value="true" />
			<display:setProperty name="export.csv" value="false" />
			<display:setProperty name="export.xml" value="false" />
		</display:table>
	</c:when>
	<c:otherwise>

		<display:table name="asnDetails" cellspacing="0" pagesize="25"
			defaultsort="1" cellpadding="0" requestURI="asnDetails"
			id="asnDetails"
			class="table table-condensed table-striped table-hover" export="true">

			<display:column property="tt_xasndeto_seq" escapeXml="true"
				sortable="true" titleKey="asnDetail.tt_xasndeto_seq" />
			<display:column property="tt_xasndeto_asnnbr" escapeXml="true"
				sortable="true" titleKey="asnDetail.tt_xasndeto_asnnbr" />
			<display:column property="tt_xasndeto_yhdnbr" escapeXml="true"
				sortable="true" titleKey="asnDetail.tt_xasndeto_yhdnbr" />
			<display:column property="tt_xasndeto_partnbr" escapeXml="true"
				sortable="true" titleKey="asnDetail.tt_xasndeto_partnbr" />
			<display:column property="tt_xasndeto_partdesc" escapeXml="true"
				sortable="true" titleKey="asnDetail.tt_xasndeto_partdesc" />
			<display:column property="tt_xasndeto_supppart" escapeXml="true"
				sortable="true" titleKey="asnDetail.tt_xasndeto_supppart" />
			<display:column property="tt_xasndeto_uom" escapeXml="true"
				sortable="true" titleKey="asnDetail.tt_xasndeto_uom" />
			<display:column property="tt_xasndeto_spq" escapeXml="true"
				sortable="true" titleKey="asnDetail.tt_xasndeto_spq" />
			<display:column property="tt_xasndeto_asnqty" escapeXml="true"
				sortable="true" titleKey="asnDetail.tt_xasndeto_asnqty" />

			<display:setProperty name="paging.banner.item_name">
				<fmt:message key="asnList.asnDetail" />
			</display:setProperty>
			<display:setProperty name="paging.banner.items_name">
				<fmt:message key="asnList.asnDetails" />
			</display:setProperty>

			<display:setProperty name="export.excel.filename"
				value="AsnDetail List.xls" />

			<display:setProperty name="export.pdf" value="false" />
			<display:setProperty name="export.excel" value="true" />
			<display:setProperty name="export.csv" value="false" />
			<display:setProperty name="export.xml" value="false" />
		</display:table>
	</c:otherwise>
</c:choose>