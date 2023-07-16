<form:form method="post" action="${pageContext.request.contextPath}/editNews/new" modelAttribute="newsEditForm">
    <form:errors path="*" element="div" />
    <form:label path="newsTitle">題名</form:label>
    <form:input path="newsTitle" />
    <br />
    <form:label path="newsAuthor">作者</form:label>
    <form:input path="newsAuthor" />
    <form:label path="newsCategory">トピックス</form:label>
    <form:select path="newsCategory" items="${CL_CATE}" />
    <br />
    <form:label path="newsContent">内容</form:label>
    <form:textarea cols="100" rows="70" path="newsContent" />
    <br />
    <form:button id="reserveBtn">完了</form:button>
</form:form>