<%@ include file="/common/taglibs.jsp"%>

<s:form name="selectUserPlantForm" action="selectUserPlant"
	method="post" validate="false" autocomplete="off"
	cssClass="well form-horizontal">
	<div class="modal fade" id="selectDomainModal" tabindex="-1"
		role="dialog" aria-labelledby="selectDomainLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h2 class="modal-title" id="selectDomainModalLabel">
						<fmt:message key="user.selectUserPlant.title" />
					</h2>
				</div>
				<div class="row modal-body">
					<div class="col-xs-1"></div>
					<div class="col-xs-11">
						<s:select key="user.selectUserPlant" id="plantCode"
							name="plantCode" list="%{#session.availableUserPlants}"
							listValue="label" listKey="value" cssStyle="width:200px;">
						</s:select>
					</div>
				</div>
				<div class="modal-footer">
					<s:submit type="button" cssClass="btn btn-primary"
						key="button.confirm" theme="simple">
						<i class="icon-ok icon-white"></i>
						<fmt:message key="button.confirm" />
					</s:submit>
				</div>
			</div>
		</div>
	</div>
</s:form>

<script type="text/javascript">
	$(document).ready(function() {
		$('#selectDomainModal').modal({
			backdrop : 'static',
			keyboard : false
		});
	});
</script>