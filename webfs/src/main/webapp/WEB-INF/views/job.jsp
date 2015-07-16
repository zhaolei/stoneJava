<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
	<title>${msg}</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="navbar">
        <div class="navbar-inner">
            <a class="brand" href="<c:url value="/index" />">WebAdmin</a>
            <ul class="nav">
                <li class="active" ><a href="<c:url value="/index" />" href="#">首页</a></li>
                <li><a href="<c:url value="/file" />">WebFile</a></li>
                <li><a href="<c:url value="/job" />">Job</a></li>
            </ul>
        </div>
    </div>
</body>
</html>
