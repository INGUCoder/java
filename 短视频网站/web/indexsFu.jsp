<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cxtPath" value="${pageContext.request.contextPath}"></c:set>
<c:set var="url" value="http://localhost:8080/uploadImage"></c:set>
<head>


    <meta charset="utf-8">
    <title>短视频交流网站</title>
    <link rel="stylesheet" href="css/zerogrid.css">
    <link rel="stylesheet" href="css/css2/style.css">
    <link rel="stylesheet" href="css/menu.css">
    <link href="css/owl.carousel.css" rel="stylesheet">
    <link href="css/owl.theme.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="css/css3/baidulogin.css"/>
    <script type="text/javascript" src="js/baidulogin.js"></script>
    <script type="text/javascript" src="js/user.js"></script>
</head>
<body id="wrapper">
<div class="wrap-body">

    <!--////////////////////////////////////Header-->
    <header>
        <div class="wrap-header">
            <div class="zerogrid">
                <ul class="navbar_nav" data-in="fadeInDown" data-out="fadeOutUp">
                    <li><a href="indexs.jsp" style="font-size: 25px">首页</a></li>
                    <c:forEach var="category" items="${tbCateGorys}">
                        <li><a href="${cxtPath}/showCategory?categoryId=${category.id}"
                               style="font-size: 25px">${category.categoryName}</a></li>
                    </c:forEach>

                </ul>
                <div class="row">
                    <a href="indexs.jsp" class="logo"><img src="images/logo.png" style="  margin-left: 20px;"/></a>
                    <ul class="quick-link" style="    position: absolute;
    right: 81px;">
                        <li><c:if test="${user!=null}">
                            <p>
                                <a href="${cxtPath}/personalCenter.jsp"> <img
                                        src="${url}/1.jpg" alt="头像" title="个人中心"
                                        style="border-radius: 50%;" width=32px height=32px/> <font
                                        color="#31B0D5" size="4" title="个人中心">${user.userName}</font></a>
                                &nbsp;&nbsp;|&nbsp;&nbsp; <a href="${cxtPath}/userLogout">
                                <font color="#31B0D5" size="4" title="退出登录">退出</font>
                            </a>
                            </p>
                        </c:if> <c:if test="${user==null}">
                            <p>
                            <div class="link">
                                <a href="${pageContext.request.contextPath}/loginIndex.jsp"> <font color="#31B0D5"
                                                                                                   size="4" title="登录">登录</font>
                                </a>|&nbsp;&nbsp;&nbsp;| <a href="${pageContext.request.contextPath}/toRegister"> <font
                                    color="#31B0D5" size="4" title="注册">注册</font>
                            </a>
                            </div>
                            </p>
                        </c:if></li>
                    </ul>
                </div>
            </div>
        </div>

    </header>
    <!--////////////////////////////////////Menu-->

    <a href="#" class="nav-toggle">Toggle Navigation</a>

    <%--<nav class="cmn-tile-nav">
		<ul class="clearfix">
			<c:forEach var="category" items="${tbCateGorys}">
				<li class="colour-${category.id}"><a href="${cxtPath}/showCategory?categoryId=${category.id}" >${category.categoryName}</a></li>
			</c:forEach>
		</ul>
    </nav>--%>
    <!--////////////////////////////////////Container-->
    <section id="container" class="index-page">
        <div class="wrap-container zerogrid">
            <%--<div class="header" style="width: 1110px;">
                <input type="text" name="keyword" style=" font-size: 22px;width: 800px; border-right: 1px solid #CCCCCC;height:40px;">
                <a href="#" style="font-size: 24px; text-align: center; display: inline-block; width: 260px; line-height: 40px; border: 1px solid #cccccc; color:#CCCCCC; border-radius: 5px;" >收  索</a>
            </div>--%>
            <!------------------------------------->
            <div class="row">
                <div class="header" style="width: 1110px;margin-top: 20px;">
                    <h2>人气榜单</h2>
                </div>
                <div class="row">
                    <div class="most-viewed">
                        <div class="col-2-4" style="width: 500px;">
                            <c:forEach var="video" items="${videos1}" begin="1" end="2">
                                <div class="wrap-col">
                                    <div class="zoom-container">
                                        <a href="${cxtPath}/player?id=${video.id}">
											<span class="zoom-caption">
												<i class="icon-play fa fa-play"></i>
											</span>
                                            <img src="${url}/${video.imgType}" style="height: 300px; width: 480px;"/>
                                        </a>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="extra">
                        <div class="col-1-4" style="width: 280px;">
                            <div class="wrap-col">
                                <c:forEach var="video" items="${videos1}" begin="3" end="5">
                                    <div class="zoom-container">
                                        <a href="${cxtPath}/player?id=${video.id}">
									<span class="zoom-caption">
										<i class="icon-play fa fa-play"></i>
									</span>
                                            <img src="${url}/${video.imgType}" style="width: 275px; height: 200px;"/>
                                        </a>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="col-1-4" style="width: 300px;">
                            <div class="wrap-col" style="margin-top: -2px;">
                                <div class="col-1-4">
                                    <div class="wrap-col" style="width: 300px; height: 650px;">
                                        <c:forEach var="video" items="${videos1}" begin="5" end="6">
                                            <div class="zoom-container">
                                                <a href="${cxtPath}/player?id=${video.id}">
														<span class="zoom-caption">
															<i class="icon-play fa fa-play"></i>
														</span>
                                                    <img src="${url}/${video.imgType}"
                                                         style="width: 300px; height: 305px;margin-top: 0px;"/>
                                                </a>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                    <div class="row">
                        <div id="main-content" class="col-2-3">
                            <div class="wrap-content">
                                <section class="vid-tv">
                                    <div class="header">
                                        <h2>正能量</h2>
                                    </div>
                                    <div class="row">
                                        <div id="owl-demo-1" class="owl-carousel">
                                            <c:forEach var="video" items="${videos1}">
                                                <div class="item wrap-vid" style="width: 185px;height: 265px;">
                                                    <div class="zoom-container">
                                                        <a href="${cxtPath}/player?id=${video.id}">
												<span class="zoom-caption">
													<i class="icon-play fa fa-play"></i>
												</span>
                                                            <img src="${url}/${video.imgType}"
                                                                 style="width: 185px; height: 175px;"/>
                                                        </a>
                                                    </div>
                                                    <h3 class="vid-name"><a href="#">${video.videoName}</a></h3>
                                                    <div class="info">
                                                        <h5>By <a href="#">${video.userName}</a></h5>
                                                        <span><i class="fa fa-calendar"></i>${video.options}</span>
                                                        <span><i class="fa fa-heart"></i>${video.plays}</span>
                                                        <span><a href="${cxtPath}/add_Like?id=${video.id}" title="添加收藏"
                                                                 style="text-decoration: none; "><i
                                                                class="fa fa-plus-circle"
                                                                style="color: #3F3F3F;"> 添加收藏</i></a></span>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </section>

                                <section class="vid-sport">
                                    <div class="header">
                                        <h2>搞笑</h2>
                                    </div>
                                    <div class="row"><!--Start Box-->
                                        <div id="owl-demo-2" class="owl-carousel">
                                            <c:forEach var="video" items="${videos2}">
                                                <div class="item wrap-vid" style="width: 185px;height: 265px;">
                                                    <div class="zoom-container">
                                                        <a href="${cxtPath}/player?id=${video.id}">
															<span class="zoom-caption">
																<i class="icon-play fa fa-play"></i>
															</span>
                                                            <img src="${url}/${video.imgType}"
                                                                 style="width: 185px; height: 175px;"/>
                                                        </a>
                                                    </div>
                                                    <h3 class="vid-name"><a href="#">${video.videoName}</a></h3>
                                                    <div class="info">
                                                        <h5>By <a href="#">${video.userName}</a></h5>
                                                        <span><i class="fa fa-calendar"></i>${video.options}</span>
                                                        <span><i class="fa fa-heart"></i>${video.plays}</span>
                                                        <span><a href="${cxtPath}/add_Like?id=${video.id}" title="添加收藏"
                                                                 style="text-decoration: none; "><i
                                                                class="fa fa-plus-circle"
                                                                style="color: #3F3F3F;"> 添加收藏</i></a></span>
                                                    </div>
                                                </div>
                                            </c:forEach>

                                        </div>
                                    </div>
                                </section>

                                <section class="vid-music">
                                    <div class="header">
                                        <h2>技术</h2>
                                    </div>
                                    <div class="row"><!--Start Box-->
                                        <div id="owl-demo-3" class="owl-carousel">
                                            <c:forEach var="video" items="${videos3}">
                                                <div class="item wrap-vid" style="width: 185px;height: 265px;">
                                                    <div class="zoom-container">
                                                        <a href="${cxtPath}/player?id=${video.id}">
												<span class="zoom-caption">
													<i class="icon-play fa fa-play"></i>
												</span>
                                                            <img src="${url}/${video.imgType}"
                                                                 style="width: 185px; height: 175px;"/>
                                                        </a>
                                                    </div>
                                                    <h3 class="vid-name"><a href="#">${video.videoName}</a></h3>
                                                    <div class="info">
                                                        <h5>By <a href="#">${video.userName}</a></h5>
                                                        <span><i class="fa fa-calendar"></i>${video.options}</span>
                                                        <span><i class="fa fa-heart"></i>${video.plays}</span>
                                                        <span><a href="${cxtPath}/add_Like?id=${video.id}" title="添加收藏"
                                                                 style="text-decoration: none; "><i
                                                                class="fa fa-plus-circle"
                                                                style="color: #3F3F3F;"> 添加收藏</i></a></span>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </section>
                            </div>
                        </div>
                        <div id="sidebar" class="col-1-3">

                            <!---- Start Widget ---->
                            <div class="widget wid-post">
                                <div class="wid-header" style="width: 310px;">
                                    <h5>美女</h5>
                                </div>
                                <div class="wid-content" style="width: 310px;">
                                    <c:forEach var="video" items="${videos4}" begin="0" end="3">
                                        <div class="post wrap-vid" style="width: 318px; height: 108px;">
                                            <div class="zoom-container">
                                                <a href="${cxtPath}/player?id=${video.id}">
										<span class="zoom-caption">
											<i class="icon-play fa fa-play"></i>
										</span>
                                                    <img src="${url}/${video.imgType}"
                                                         style="width: 140px; height: 105px;"/>
                                                </a>
                                            </div>
                                            <div class="wrapper">
                                                <h5 class="vid-name"><a href="#">${video.videoName}</a></h5>
                                                <div class="info">
                                                    <h6>By <a href="#">${video.userName}</a></h6>
                                                    <span><i class="fa fa-calendar"></i>${video.options}</span>
                                                    <span><i class="fa fa-heart"></i>${video.plays}</span>
                                                    <span><a href="${cxtPath}/add_Like?id=${video.id}" title="添加收藏"
                                                             style="text-decoration: none; "><i
                                                            class="fa fa-plus-circle" style="color: #3F3F3F;"> 添加收藏</i></a></span>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <!---- Start Widget ---->
                            <div class="widget wid-news">
                                <div class="wid-header" style="width: 310px;">
                                    <h5>动物</h5>
                                </div>
                                <div class="wid-content" style="width: 310px;">
                                    <c:forEach var="video" items="${videos5}" begin="0" end="1">
                                        <div class="row">
                                            <div class="wrap-vid" style="width: 275px; height: 320px;">
                                                <div class="zoom-container">
                                                    <a href="${cxtPath}/player?id=${video.id}">
											<span class="zoom-caption">
												<i class="icon-play fa fa-play" style="bottom:60px;"></i>
											</span>
                                                        <img src="${url}/${video.imgType}"
                                                             style="width: 275px; height: 220px;"/>
                                                    </a>
                                                </div>
                                                <h3 class="vid-name">${video.videoName}</h3>
                                                <div class="info">
                                                    <h5>By <a href="#">${video.userName}</a></h5>
                                                    <span><i class="fa fa-calendar"></i>${video.options}</span>
                                                    <span><i class="fa fa-heart"></i>${video.plays}</span>
                                                    <span><a href="${cxtPath}/add_Like?id=${vide.id}" title="添加收藏"
                                                             style="text-decoration: none; "><i
                                                            class="fa fa-plus-circle" style="color: #3F3F3F;"> 添加收藏</i></a></span>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

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

    <script src="js/jquery-2.1.1.js"></script>
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