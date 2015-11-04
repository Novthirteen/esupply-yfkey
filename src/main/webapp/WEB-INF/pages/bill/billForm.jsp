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
		<div class="col-xs-4 search-group">
			<s:textfield key="bill.tt_xprcmstro_voucher" cssClass="form-control"
				readonly="true" />
			<s:hidden key="bill.tt_xprcmstro_xprcmstroid" />
			<s:hidden key="bill.tt_xprcmstro_type" />
		</div>
		<div class="col-xs-4 search-group">
			<s:textfield key="bill.tt_xprcmstro_invdate" cssClass="form-control"
				readonly="true" />

		</div>
	</div>
	<div class="row">
		<div class="col-xs-4 search-group">
			<s:textfield key="bill.tt_xprcmstro_totalamt" cssClass="form-control"
				readonly="true" />
		</div>
		<div class="col-xs-4 search-group">
			<s:textfield key="bill.tt_xpyhddeto_claiminv" cssClass="form-control"
				readonly="true" />
		</div>
	</div>
	<c:choose>
		<c:when test="${bill.tt_xprcmstro_stat eq '3'}">

			<div class="row">
				<div class="col-xs-4 search-group">
					<s:textfield key="bill.tt_xprcmstro_qty" cssClass="form-control"  />
				</div>
				<div class="col-xs-4 search-group">

					<s:textfield cssClass="form-control search-control"
						id="tt_xprcmstro_invdate" key="bill.tt_xprcmstro_invdate" />
				</div>
			</div>
			<div class="row">
				<div class="col-xs-4 search-group">
					<s:textfield key="bill.tt_xprcmstro_notaxamt"
						cssClass="form-control"  onChange="javascript:calcTotalamt();" />
				</div>
					<div class="col-xs-4 search-group">
					<s:textfield key="bill.tt_xprcmstro_taxamt" cssClass="form-control"  onChange="javascript:calcTotalamt();" />
				</div>
			</div>
				<div class="row">
				<div class="col-xs-4 search-group">
					<s:textfield key="bill.tt_xprcmstro_claimamt"
						cssClass="form-control"/>
<%-- 					<s:hidden key="bill.tt_xprcmstro_claimamt" /> --%>
				</div>
				<div class="col-xs-4 search-group">
					<s:textfield key="bill.tt_xpyhddeto_disamt"
						cssClass="form-control"  />
				</div>
			</div>
			<div class="row">
				<div class="col-xs-4 search-group">
					<s:textfield key="bill.tt_xpyhddeto_invoiceamt"
						cssClass="form-control" readonly="true"/>
				</div>
				<div class="col-xs-4 search-group">
					<s:textfield key="bill.tt_xprcmstro_indexinvnbr"
						cssClass="form-control" />
				</div>
			</div>
			<div class="row">
				<div class="col-xs-8 search-group">
					<s:textfield key="bill.tt_xprcmstro_invnbr" cssClass="form-control"
						rows="6" />
				</div>
			</div>
			<div class="row">
				<div class="col-xs-8 search-group">
					<s:textfield key="bill.tt_xprcmstro_rmk" cssClass="form-control" />
				</div>

			</div>
		</c:when>
		<c:otherwise>
			<div class="row">
				<div class="col-xs-4 search-group">
					<s:label key="bill.tt_xprcmstro_qty" cssClass="form-control"
						readonly="true" />
				</div>
				<div class="col-xs-4 search-group">

					<s:label cssClass="form-control search-control"
						id="tt_xprcmstro_invdate" key="bill.tt_xprcmstro_invdate" />
				</div>
			</div>
			<div class="row">
				<div class="col-xs-4 search-group">
					<s:label key="bill.tt_xprcmstro_taxamt" cssClass="form-control" />
				</div>
				<div class="col-xs-4 search-group">
					<s:label key="bill.tt_xprcmstro_notaxamt" cssClass="form-control" />
				</div>
			</div>
			<div class="row">
				<div class="col-xs-4 search-group">
					<s:label key="bill.tt_xprcmstro_claimamt"
						cssClass="form-control" readonly="true" />
				</div>
				<div class="col-xs-4 search-group">
					<s:label key="bill.tt_xpyhddeto_disamt"
						cssClass="form-control"  />
				</div>
			</div>
			<div class="row">
				<div class="col-xs-4 search-group">
					<s:label key="bill.tt_xpyhddeto_invoiceamt" cssClass="form-control" />
				</div>
				<div class="col-xs-4 search-group">
					<s:label key="bill.tt_xprcmstro_indexinvnbr"
						cssClass="form-control" />
				</div>
			</div>
			<div class="row">
				<div class="col-xs-8 search-group">
					<s:label key="bill.tt_xprcmstro_invnbr" cssClass="form-control"
						rows="6" />
				</div>
			</div>
			<div class="row">
				<div class="col-xs-8 search-group">
					<s:label key="bill.tt_xprcmstro_rmk" cssClass="form-control" />
				</div>

			</div>

		</c:otherwise>
	</c:choose>

	<hr>
	<div id="actions" class="form-actions">
		<c:if test="${bill.tt_xprcmstro_stat eq '3'}">
			<c:if test="${canConfirmBill}">
				<s:submit type="button" cssClass="btn btn-primary"
					action="confirmBill" key="button.confirm" theme="simple">
					<i class="icon-confirm icon-white"></i>
					<fmt:message key="button.confirm" />
				</s:submit>
			</c:if>
		</c:if>
		<c:if test="${bill.tt_xprcmstro_stat eq '4'}">
			<c:if test="${canAgreeBill}">
				<s:submit type="button" cssClass="btn btn-primary"
					action="agreeBill" key="button.agree" theme="simple">
					<i class="icon-agree icon-white"></i>
					<fmt:message key="button.agree" />
				</s:submit>
			</c:if>

			<c:if test="${canRefuseBill}">
				<s:submit type="button" cssClass="btn btn-primary"
					action="refuseBill" key="button.refuse" theme="simple">
					<i class="icon-refuse icon-white"></i>
					<fmt:message key="button.refuse" />
				</s:submit>
			</c:if>
		</c:if>
		<s:submit type="button" cssClass="btn btn-primary" action="printBill"
			key="button.print" theme="simple">
			<i class="icon-print icon-white"></i>
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
</s:form>



<script type="text/javascript">
	$(document).ready(
			function() {
				$("input[type='text']:visible:enabled:first",
						document.forms['billForm']).focus();
			});

	$('#tt_xprcmstro_invdate').datepicker({
		format : "yyyymmdd",
		language : "${pageContext.response.locale}",
		autoclose : true,
		todayHighlight : true
	});
	
	function calcTotalamt() {
		 var notaxamt = $('#editBill_bill_tt_xprcmstro_notaxamt').val();
		 var taxamt = $('#editBill_bill_tt_xprcmstro_taxamt').val();

		 var totalamt = Number(notaxamt) + Number(taxamt);
		 $('#editBill_bill_tt_xpyhddeto_invoiceamt').val(totalamt);
	   }
</script>

