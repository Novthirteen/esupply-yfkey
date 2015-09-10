<%@ include file="/common/taglibs.jsp"%>


<security:authentication var="userMenus" property="principal.userMenus"/>

 <div class="col-sm-2 col-md-2">
 	<div class="panel-group" id="accordion">
 		<c:forEach  items="${userMenus}" var="userMenu">
        	<div class="panel panel-default">
		    	<div class="panel-heading">
					<h4 class="panel-title">
						<c:choose>
						   <c:when test="${empty userMenu.items}">
						   		<span class="glyphicon glyphicon-folder-close"></span>
						   		<a data-toggle="collapse" data-parent="#accordion" href="<c:url value='${userMenu.url}'/>" onclick="loadClick('<c:url value='${userMenu.url}'/>')">
						   			<fmt:message key="${userMenu.text}" />
						   		</a>
						   		<input type="hidden" value=""  id="${userMenu.value}"  name="${userMenu.value}"  />
						   </c:when>
						   <c:otherwise> 
								<a data-toggle="collapse" data-parent="#accordion" href="#${userMenu.value}" onclick="loadClick('#${userMenu.value}')">
									<span class="glyphicon glyphicon-folder-close"></span><fmt:message key="${userMenu.text}" />
								</a>
						   </c:otherwise>
						</c:choose>
					</h4>
            	</div>
	        	<c:if test="${not empty userMenu.items}">
	        		<div id="${userMenu.value}" class="panel-collapse collapse out">
	        			<div class="panel-body">
	                    	<table class="table">
				        		<c:forEach  items="${userMenu.items}" var="userchildMenu">
				        			<tr>
			                            <td>
			                                <span class="glyphicon glyphicon-pencil text-primary"></span><a href="<c:url value='${userchildMenu.url}'/>">
			                                   <fmt:message key="${userchildMenu.text}" /></a>
			                                <input type="hidden" value=""  id="${userchildMenu.value}"  name="${userchildMenu.value}"  />
			                            </td>
			                        </tr>
				        		</c:forEach>
		        			</table>
		        		</div>
	        		</div>
	        	</c:if>
        	</div>
     	</c:forEach>
 	</div>
 </div>
 
 <script>
 	$(function(e){
 		var currentMenu = $('meta[name="menu"]').attr("content");
 		var ele = $('#'+currentMenu);
 		
 		if(ele.length>0){
 			ele.prev().addClass("selected");
 			if(ele.closest(".panel-collapse").length>0){
 				ele.closest(".panel-collapse").toggle();
 			}
 		}
 	});
 
 	function loadClick(url){
 		if(url.indexOf("#") == 0){
 			var t = $(url);
 			t.toggle();
 			//t.removeClass("collapse out");
 			//t.addClass("collapse in");
 		}
 		else{
 			window.location.href = url;
 		}
 	}
 </script>
  
  

  