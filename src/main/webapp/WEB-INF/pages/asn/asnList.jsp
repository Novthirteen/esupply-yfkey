<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="asnList.title" /></title>
<meta name="menu" content="AdminMenu" />
</head>

<h2>
	<fmt:message key="asnList.heading" />
</h2>

<s:form name="asnForm" action="asns" method="post" validate="true">
	<div class="row-fluid">
		<div class="span3">
			<s:textfield key="asn.tt_xasnmstro_asnnbr" />
		</div>
		<div class="span3">
			<s:textfield key="asn.tt_xasnmstro_stat" />
		</div>
	</div>
	<div class="row-fluid">
		<div class="span3">
			<s:textfield key="asn.tt_xasnmstro_suppcode" />
		</div>
		<div class="span3">
			<s:textfield key="asn.tt_xasnmstro_shipto" />
		</div>
	</div>
	<div class="row-fluid">
		<div class="span3">
			<s:textfield key="asn.tt_xasnmstri_fromdate" />
		</div>
		<div class="span3">
			<s:textfield key="asn.tt_xasnmstri_todate" />
		</div>
	</div>
	<div class="row-fluid">
		<div class="span3">
			<s:textfield key="asn.tt_xasnmstri_partnbr" />
		</div>
		<div class="span3">
			<s:checkbox key="asn.isDetail" />
		</div>
	</div>
	<div class="row-fluid">
		<div class="span3">
			<input type="hidden" name="from" value="list" />
			<s:submit type="button" cssClass="btn btn-primary"
				action="confirmAsn" key="button.confirm" theme="simple">
				<i class="icon-plus icon-white"></i>
				<fmt:message key="button.confirm" />
			</s:submit>
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
				url="/asn/editAsn?from=list" paramId="tt_xasnmstro_asnnbr"
				paramProperty="tt_xasnmstro_asnnbr" />
			<display:column property="tt_xasnmstro_startdt" escapeXml="true"
				sortable="true" titleKey="asn.tt_xasnmstro_startdt" />

			<display:setProperty name="paging.banner.item_name">
				<fmt:message key="asnList.asn" />
			</display:setProperty>
			<display:setProperty name="paging.banner.items_name">
				<fmt:message key="asnList.asns" />
			</display:setProperty>

			<display:setProperty name="export.excel.filename"
				value="Asn List.xls" />



		</display:table>
	</c:when>
	<c:otherwise>

		<display:table name="asnDetails" cellspacing="0" pagesize="25"
			defaultsort="1" cellpadding="0" requestURI="asns" id="asnDetails"
			class="table table-condensed table-striped table-hover" export="true">

			<display:column property="tt_xpyhddeto_seq" escapeXml="true"
				sortable="true" titleKey="asnDetail.tt_xpyhddeto_seq" />
			<display:column property="tt_xpyhddeto_yhdnbr" escapeXml="true"
				sortable="true" titleKey="asnDetail.tt_xpyhddeto_yhdnbr" />
			<display:column property="tt_xpyhddeto_partnbr" escapeXml="true"
				sortable="true" titleKey="asnDetail.tt_xpyhddeto_partnbr" />
			<display:column property="tt_xpyhddeto_partdesc" escapeXml="true"
				sortable="true" titleKey="asnDetail.tt_xpyhddeto_partdesc" />
			<display:column property="tt_xpyhddeto_supppart" escapeXml="true"
				sortable="true" titleKey="asnDetail.tt_xpyhddeto_supppart" />
			<display:column property="tt_xpyhddeto_uom" escapeXml="true"
				sortable="true" titleKey="asnDetail.tt_xpyhddeto_uom" />
			<display:column property="tt_xpyhddeto_spq" escapeXml="true"
				sortable="true" titleKey="asnDetail.tt_xpyhddeto_spq" />
			<display:column property="tt_xpyhddeto_reqqty" escapeXml="true"
				sortable="true" titleKey="asnDetail.tt_xpyhddeto_reqqty" />
			<display:column property="tt_xpyhddeto_ordqty" escapeXml="true"
				sortable="true" titleKey="asnDetail.tt_xpyhddeto_ordqty" />

			<display:setProperty name="paging.banner.item_name">
				<fmt:message key="asnList.asnDetail" />
			</display:setProperty>
			<display:setProperty name="paging.banner.items_name">
				<fmt:message key="asnList.asnDetails" />
			</display:setProperty>

			<display:setProperty name="export.excel.filename"
				value="Asn List.xls" />
		</display:table>
	</c:otherwise>
</c:choose>