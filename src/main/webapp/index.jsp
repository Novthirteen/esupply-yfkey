<%@ include file="/common/taglibs.jsp"%>

<c:redirect url="/home">
   <c:param name="cb"
            value="${java.UUID.randomUUID().toString()}"></c:param>
</c:redirect>