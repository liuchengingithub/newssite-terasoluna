
<div id="wrapper">
    <div class="content">
        <div class="card">
            <c:if test="${fullUrl.contains('searchByKeyword')}">
                <p>
                    <spring:message code="label.tr.searchnews.resultCountMessage" arguments="${allNews.totalElements}" />
                </p>
            </c:if>
            <c:forEach items="${allNews.content}" var="news">
                <h2>
                    <a href="${pageContext.request.contextPath}/newsDetail/${news.newsId}">
                            ${news.newsTitle}
                    </a>
                </h2>
                <span>${news.newsAuthor}</span>&nbsp;
<%--                <span><fmt:formatDate value="${news.newsPostDate}" pattern="dd/MM/yyyy" /></span>--%>
                <joda:format value="${news.newsPostDate}" style="SS" dateTimeZone="Asia/Tokyo"/>
                <a href="${pageContext.request.contextPath}/editNews/${news.newsId}">
                    編集
                </a>
                <button onclick="deleteConfirm('${news.newsId}')">
                    削除
                </button>
                <c:if test="${news.newsContent.length() > 140}">
                    <p>${news.newsContent.substring(0, 140)}....</p>
                </c:if>
                <c:if test="${news.newsContent.length() <= 140}">
                    <p>${news.newsContent}</p>
                </c:if>
            </c:forEach>
            <div class="pagination">
                <t:pagination page="${allNews}" />
            </div>
        </div>
    </div>

</div>
<script>
    function deleteConfirm(newsId){
        <%--console.log("${pageContext.request.contextPath}/delete/" + newsId);--%>
        console.log(newsId)
        var if_delete = confirm('削除しますか');
        if(if_delete){
            <%--$.ajax("${pageContext.request.contextPath}/editNews/delete/" + newsId, {--%>
            <%--    type: "GET"--%>
            <%--})--%>
            <%--    .done(() => {--%>
            <%--    window.open("${pageContext.request.contextPath}")--%>
            <%--})--%>
            window.open("${pageContext.request.contextPath}/editNews/delete/" + newsId)
        }
    }

</script>
