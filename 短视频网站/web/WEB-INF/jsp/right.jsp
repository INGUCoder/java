<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cxtPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>提醒页</title>
</head>
<body>
<p STYLE="color: red">${message}</p>
<a href="javascript:change()">返回登录</a>
<script type="text/javascript">
    function change() {
        var t1 = setTimeout(window.location = '../../indexsFu.jsp', 3000);
        clearInterval(t1);
    }

    change();
</script>
</body>
</html>