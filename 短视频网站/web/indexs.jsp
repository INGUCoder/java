<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cxtPath" value="${pageContext.request.contextPath}"></c:set>
<c:set var="url" value="${pageContext.request.contextPath}/uploadImage"></c:set>

<head id="wrapper">


    <meta charset="utf-8">
    <title>短视频交流网站</title>

    <script type="text/javascript" src="js/baidulogin.js"></script>
    <script type="text/javascript" src="js/user.js"></script>

    <link rel="stylesheet" href="css/reset.css">

    <!--响应式框架-->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">

    <!--css3动画库-->
    <link rel="stylesheet" href="css/animate.css">

    <!--banner大图基础样式-->
    <link rel="stylesheet" href="css/slick.css">

    <!--页面滚动基础样式-->
    <link rel="stylesheet" href="css/jquery.fullPage.css"/>

    <!--导航样式-->
    <link rel="stylesheet" href="css/head.css"/>

    <!--图片和滚屏样式-->
    <link rel="stylesheet" href="css/index.css">


    <%--//body部分--%>
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/style1.css">

    <!-- Owl Carousel Assets -->
    <link href="owl-carousel/owl.carousel.css" rel="stylesheet">
    <link href="owl-carousel/owl.theme.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link rel="stylesheet" href="font-awesome-4.4.0/css/font-awesome.min.css" type="text/css">
    <style>


    </style>
</head>
<body>
<!-- 导航 -->
<header class="header">
    <div class="container clearfix" style="padding-left: 200px;padding-top: 50px;">
        <div class="fr nav navbar-left ">
            <ul class="navbar_nav" data-in="fadeInDown" data-out="fadeOutUp">
                <li><a href="indexsFu.jsp" style="font-size: 25px">首页</a></li>
                <c:forEach var="category" items="${tbCateGorys}">
                    <li><a href="${cxtPath}/showCategory?categoryId=${category.id}"
                           style="font-size: 25px">${category.categoryName}</a></li>
                </c:forEach>

            </ul>

        </div>
        <%--这边是搜索框--%>
        <%--<form class="navbar-form navbar-right" role="search">--%>
        <%--<div class="form-group">--%>
        <%--<input type="text" class="form-control" placeholder="搜索">--%>
        <%--</div>--%>
        <%--<button type="submit" class="btn btn-default">搜索</button>--%>
        <%--</form>--%>
        <a href="javascript:void(0)" id="navToggle">
            <span></span>
        </a>
    </div>
</header>


<!-- 内容 -->
<div id="index_main" class="index_main">
    <!--导航-->
    <div class="section section1">
        <div class="index_banner">
            <div class="item">
                <div class="items scaleBg" style="background-image: url(images/banner1.jpg);"></div>
                <div class="inner">
                    <div class="block_txt">
                        <h4> Goodliness,to be continued</h4>
                        <h2>让<span>美好持续</span>发生</h2>
                        <h3>
                            <div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">

                            </div>
                        </h3>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="items scaleBg" style="background-image: url(images/2.jpg);"></div>
                <div class="inner">
                    <div class="block_txt">
                        <h4> Goodliness,to be continued</h4>
                        <h2>让<span>美好持续</span>发生</h2>
                        <h3>我们有让美好持续发生的愿望，更有让美好持续发生的能力</h3>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="items scaleBg" style="background-image: url(images/banner2.jpg);"></div>
                <div class="inner">
                    <div class="block_txt">
                        <h4></h4>

                    </div>
                </div>
            </div>
            <div class="item">
                <div class="items scaleBg" style="background-image: url(images/banner3.jpg);"></div>
                <div class="inner">
                    <div class="block_txt">
                        <h4></h4>

                    </div>
                </div>
                s
            </div>
            <div class="item">
                <div class="items scaleBg" style="background-image: url(images/banner4.jpg);"></div>
                <div class="inner">
                    <div class="block_txt">
                        <h4></h4>

                    </div>
                </div>
            </div>
        </div>
        <div class="left slick_txt">
            <div class="prev slick_arrow"></div>
        </div>
        <div class="right slick_txt">
            <div class="next slick_arrow"></div>
        </div>
        <div class="number">
            <div class="inner clearfix">
                <span class="active">01</span>
                <span>02</span>
                <span>03</span>
                <span>04</span>
                <span>05</span>
            </div>
        </div>
    </div>


    <!--////////////////////////////////////Footer-->


    <script src="js/jquery-2.1.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.fullPage.min.js"></script>
    <script src="js/index_slick.js"></script>
    <script src="js/index.js"></script>
    <script src="js/demo.js"></script>
    <script src="js/classie.js"></script>
    <script src="js/owl.carousel.js"></script>
    <script>
        $(document).ready(function () {

            $("#owl-demo-1").owlCarousel({
                items: 4,
                lazyLoad: true,
                navigation: true
            });
            $("#owl-demo-2").owlCarousel({
                items: 4,
                lazyLoad: true,
                navigation: true
            });
            $("#owl-demo-3").owlCarousel({
                items: 4,
                lazyLoad: true,
                navigation: true
            });
        });
    </script>
</div>
</body>
</html>