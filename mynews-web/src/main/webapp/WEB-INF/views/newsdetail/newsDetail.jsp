<h1>${news.newsTitle}</h1>
<span>${news.newsAuthor}</span>&nbsp;
<span>
<%--    <fmt:formatDate value="${news.newsPostDate}" type="both" />--%>
    <joda:format value="${news.newsPostDate}" style="FF" dateTimeZone="Asia/Tokyo"/>
</span>
<span>${news.newsCategory}</span>
<p>${news.newsContent}</p>