<!DOCTYPE html>
<html class="no-js">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width" />
<script type="text/javascript"
        src="https://code.jquery.com/jquery-3.6.0.min.js"
>

</script>
<c:set var="titleKey">
    <tiles:insertAttribute name="title" ignore="true" />
</c:set>
<title><spring:message code="${titleKey}" text="mynews" /></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
<body>
    <div class="container">
        <tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="body" />
        <hr>
        <p style="text-align: center; background: #e5eCf9;">Copyright &copy; 20XX CompanyName</p>
    </div>
</body>
</html>