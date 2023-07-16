<h1 style="margin-top: 0px">
    <a href="${pageContext.request.contextPath}/">mynews</a>
</h1>
<%--@elvariable id="searchNewsForm" type=""--%>
<form:form method="get" action="${pageContext.request.contextPath}/searchByKeyword" modelAttribute="searchNewsForm">
    <form:label path="keyword">キーワード</form:label>
    <form:input path="keyword" />
    <form:label path="category">トピックス</form:label>
    <form:select path="category">
        <form:option value="指定なし" label="指定なし" />
        <form:options items="${CL_CATE}" />
    </form:select>
    <form:label path="postDateRange">掲載日</form:label>
<%--    <form:input type="date" path="postDate"/>--%>
    <form:select path="postDateRange">
        <form:options items="${CL_POST_DATE}" />
    </form:select>
    <form:button id="searchBtn">
        検索
    </form:button>
</form:form>
<form:form method="get" action="${pageContext.request.contextPath}/editNews/new">
    <button id="editNews" >
        发布新闻
    </button>
</form:form>



    <table id="categoryBar">
        <tr>
            <c:forEach items="${categories}" var="category" >
                <td>
                    <a href="${pageContext.request.contextPath}/category/${category}">
                            ${category}
                    </a>
                </td>
            </c:forEach>
        </tr>
    </table>

<form:form modelAttribute="searchNewsForm">
    <form:errors path="*" element="div"/>
</form:form>