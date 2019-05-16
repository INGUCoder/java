<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="cxtPath" value="${pageContext.request.contextPath}"></c:set>
<c:set var="url" value="${pageContext.request.contextPath}/uploadImage/"></c:set>
<html>

<head>
    <title>个人中心</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="在线视频网站"/>
    <script type="application/x-javascript">
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>

    <link href="${cxtPath}/css/indexMovie.css" rel='stylesheet' type='text/css'/>
    <link href="${cxtPath}/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link href="${cxtPath}/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- start plugins -->
    <script type="text/javascript" src="${cxtPath}/js/jquery-1.11.1.min.js"></script>
    <link href='http://fonts.useso.com/css?family=Roboto+Condensed:100,200,300,400,500,600,700,800,900' rel='stylesheet'
          type='text/css'>
    <script src="${cxtPath}/js/responsiveslides.min.js"></script>

    <script>
        $(function () {
            $("#slider").responsiveSlides({
                auto: true,
                nav: true,
                speed: 500,
                namespace: "callbacks",
                pager: true,
            });
        });
    </script>
</head>

<body>
<div class="container">
    <div class="container_wrap">
        <!--顶部-->
        <div class="header_top">
            <div class="col-sm-3 logo" style="margin-top: -2%">
                <a href="${cxtPath}/index.jsp"><img src="${cxtPath}/images/logo.png" alt="logo"/></a>
            </div>
            <div class="col-sm-5 nav" style="margin-top: -0.5%">
                <ul>

                </ul>
            </div>
            <div class="col-sm-4 header_right">
                <ul class="header_right_box">
                    <li>
                        <p>
                            <c:if test="${user!=null}">
                                <img src="/1.jpg" alt="头像" style="border-radius:50%;" width=32px height=32px/>
                                <font color="#31B0D5" size="4">个人中心</font>
                                &nbsp;&nbsp;|&nbsp;&nbsp;
                                <a href="${cxtPath}/userLogout">
                                    <font color="#31B0D5" size="4">退出</font></a>
                            </c:if>
                        </p>
                    </li>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>

        <!--主体-->
        <div class="content">

            <div class="movie_top">
                <div class="col-md-3">
                    <div style="border:2px solid #F7E1B5; width: 53%;height: 220px">
                        <div class="movie_img">
                            <div class="grid_2">
                                <h3><font color="#285E8E">个人资料</font></h3>
                            </div>
                            <div class="grid_2 col_1">
                                <a href="${cxtPath}/editUser.jsp">
                                    <h3><font color="#FFFFFF">修改资料</font></h3></a>
                            </div>
                            <div class="grid_2 col_1">
                                <a href="${cxtPath}/getMoviesByUserID?index=1">
                                    <h3><font color="#FFFFFF">影片管理</font></h3>
                                </a>
                            </div>
                            <div class="grid_2 col_1">
                                <a href="${cxtPath}/likeList?index=1">
                                    <h3><font color="#FFFFFF">我的收藏</font></h3></a>
                            </div>
                        </div>
                    </div>
                </div>

                <!--主体的右边-->
                <div class="col-md-8 movie_box" style="border:2px solid #F7E1B5;">

                    <div class="desc1 span_3_of_2">
                        <br/>
                        <h3><font color="#FFFFFF">个人资料</font></h3>
                        <br/>
                        <div style="margin-left: 5em;">
                            <p class="movie_option">
                                <font color="#FFFFFF"><strong>用户名: </strong><span>${user.userName}</span></font>
                            </p>
                            <p class="movie_option">
                                <font color="#FFFFFF"><strong>昵称: </strong><span>${user.userNickname}</span></font>
                            </p>
                            <p class="movie_option">
                                <font color="#FFFFFF"><strong>注册时间: </strong>
                                    <span><%--<f:formatDate value="${user.registerDate}"
										pattern="yyyy-MM-dd HH:mm:ss"/>--%>${user.registerDate}</span></font>
                            </p>
                            <p class="movie_option">
                                <font color="#FFFFFF"><strong>手机号码: </strong><span>${user.phone}</span></font>
                            </p>
                        </div>
                    </div>

                    <div class="grid images_3_of_2">
                        <br><br><br><br>
                        <h4><font color="#FFFFFF">头像</font></h4>
                        <br/>
                        <div style="border: 2px solid #F5F5F5; width: 50px; height: 50px;"><img src="${url}/1.jpg"
                                                                                                width="46px"
                                                                                                height="46px"/></div>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>

<!--页脚-->
<!--////////////////////////////////////Footer-->
<footer>
    <div class="zerogrid top-footer">
        <div class="row">
            <div class="col-1-5">
                <a href="https://v.qq.com/"><img src="images/15.jpg"/></a>
            </div>
            <div class="col-1-5">
                <a href="https://www.iqiyi.com/"><img src="images/16.jpg"/></a>
            </div>
            <div class="col-1-5">
                <a href="https://y.qq.com/"><img src="images/17.jpg"/></a>
            </div>
            <div class="col-1-5">
                <a href="http://www.youku.com/"><img src="images/18.jpg"/></a>
            </div>
            <div class="col-1-5">
                <a href="http://www.kugou.com/"><img src="images/19.jpg"/></a>
            </div>
        </div>
    </div>
</footer>


</div>
</body>

</html>