<%@ include file="/common/taglibs.jsp"%>

<c:redirect url="/home">
 <c:param name="cb"
            value="<%=java.util.UUID.randomUUID().toString()%>"></c:param>
</c:redirect>