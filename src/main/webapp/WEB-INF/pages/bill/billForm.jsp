<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="bill.title" /></title>
<meta name="menu" content="BillMenu" />
</head>

<h2>
	<fmt:message key="bill.heading" />
</h2>

<s:form name="billForm" action="editBill" method="post" validate="true"
	cssClass="well form-horizontal" autocomplete="off">
	<input type="hidden" name="from" value="${param.from}" />
	<div class="row">
		<div class="col-xs-4">
			<s:label key="bill.tt_xprcmstro_voucher" cssClass="form-control" />
			<s:hidden key="bill.tt_xprcmstro_xprcmstroid" />
		</div>
		<div class="col-xs-4">
			<s:label key="bill.tt_xprcmstro_invdate" cssClass="form-control" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4">
			<s:label key="bill.tt_xprcmstro_totalamt" cssClass="form-control" />
		</div>
		<div class="col-xs-4">
			<s:label key="bill.tt_xprcmstro_claimamt" cssClass="form-control" />
		</div>
	</div>


	<div id="actions" class="form-actions">
		<c:if test="${bill.tt_xprcmstro_stat eq '1'}">
			<s:submit type="button" cssClass="btn btn-primary"
				action="confirmBill" key="button.confirm" theme="simple">
				<i class="icon-confirm icon-white"></i>
				<fmt:message key="button.confirm" />
			</s:submit>
		</c:if>
		<c:if test="${bill.tt_xprcmstro_stat eq '2'}">
			<s:submit type="button" cssClass="btn btn-primary" action="agreeBill"
				key="button.agree" theme="simple">
				<i class="icon-agree icon-white"></i>
				<fmt:message key="button.agree" />
			</s:submit>

			<s:submit type="button" cssClass="btn btn-primary"
				action="refuseBill" key="button.refuse" theme="simple">
				<i class="icon-refuse icon-white"></i>
				<fmt:message key="button.refuse" />
			</s:submit>
		</c:if>
		<s:submit type="button" cssClass="btn btn-primary" action="printBill"
			key="button.print" theme="simple">
			<i class="icon-printm icon-white"></i>
			<fmt:message key="button.print" />
		</s:submit>
		<s:submit type="button" cssClass="btn" method="cancel"
			key="button.back" theme="simple">
			<i class=" icon-arrow-left"></i>
			<fmt:message key="button.back" />
		</s:submit>
	</div>



	<display:table name="billDetails" cellspacing="0" cellpadding="0"
		requestURI="/billDetails" id="billDetail"
		class="table table-condensed table-striped table-hover" export="false">
		<display:column property="tt_xpyhddeto_receiver" escapeXml="false"
			titleKey="billDetail.tt_xpyhddeto_receiver" />
		<display:column property="tt_xpyhddeto_partnbr" escapeXml="true"
			titleKey="billDetail.tt_xpyhddeto_partnbr" />
		<display:column property="tt_xpyhddeto_seq" escapeXml="true"
			titleKey="billDetail.tt_xpyhddeto_seq" />
		<display:column property="tt_xpyhddeto_rcqty" escapeXml="true"
			titleKey="billDetail.tt_xpyhddeto_rcqty" />	
		<display:column property="tt_xpyhddeto_poprice" escapeXml="true"
			titleKey="billDetail.tt_xpyhddeto_poprice" />
		<display:column property="tt_xpyhddeto_uom" escapeXml="true"
			titleKey="billDetail.tt_xpyhddeto_uom" />
		<display:column property="tt_xpyhddeto_invprice" escapeXml="true"
			titleKey="billDetail.tt_xpyhddeto_invprice" />
		<display:column property="tt_xpyhddeto_invamt" escapeXml="true"
			titleKey="billDetail.tt_xpyhddeto_invamt" />
		<display:column property="tt_xpyhddeto_partdesc" escapeXml="true"
			titleKey="billDetail.tt_xpyhddeto_partdesc" />
		<display:column property="tt_xpyhddeto_rcdate" escapeXml="true"
			titleKey="billDetail.tt_xpyhddeto_rcdate" />
	</display:table>


	<div class="row">
		<div class="col-xs-4">
			<s:textfield key="bill.tt_xprcmstro_qty" cssClass="form-control" />
		</div>
		<div class="col-xs-4">
			<s:textfield key="bill.tt_xprcmstro_invdate" cssClass="form-control" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4">
			<s:textfield key="bill.tt_xprcmstro_taxamt" cssClass="form-control" />
		</div>
		<div class="col-xs-4">
			<s:textfield key="bill.tt_xprcmstro_notaxamt" cssClass="form-control" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4">
			<s:textfield key="bill.tt_xprcmstro_totalamt" cssClass="form-control" />
		</div>
		<div class="col-xs-4">
			<s:textfield key="bill.tt_xprcmstri_indexinvnbr"
				cssClass="form-control" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-8">
			<s:textfield key="bill.tt_xprcmstro_invnbr" cssClass="form-control"
				rows="6" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-8">
			<s:textfield key="bill.tt_xprcmstro_rmk" cssClass="form-control" />
		</div>

	</div>

</s:form>



<script type="text/javascript">
	$(document).ready(
			function() {
				$("input[type='text']:visible:enabled:first",
						document.forms['billForm']).focus();
			});
</script>
