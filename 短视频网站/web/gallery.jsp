<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cxtPath" value="${pageContext.request.contextPath}"></c:set>
<c:set var="url" value="http://localhost:8080/uploadImage"></c:set>
<link rel="stylesheet" href="css/bootstrap.css">
<head>
    <meta charset="utf-8">
    <title>分类详情</title>
    <link rel="stylesheet" href="css/zerogrid.css">
    <link rel="stylesheet" href="css/css2/style.css">
    <link rel="stylesheet" href="css/menu.css">
    <link href="css/owl.carousel.css" rel="stylesheet">
    <link href="css/owl.theme.css" rel="stylesheet">
    <link rel="stylesheet" href="css/css3/baidulogin.css"/>
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script src="js/html5.js"></script>
    <script src="js/css3-mediaqueries.js"></script>
    <script type="text/javascript" src="js/baidulogin.js"></script>
    <script type="text/javascript" src="js/user.js"></script>
</head>
<body id="wrapper">
<div class="wrap-body">

    <!--////////////////////////////////////Header-->
    <header>
        <div class="wrap-header">
            <div class="zerogrid">
                <div class="row">
                    <a href="indexsFu.jsp" class="logo"><img src="images/logo.png" style="padding-left: 0px;"/></a>
                    <ul class="navbar_nav" data-in="fadeInDown" data-out="fadeOutUp">
                        <li><a href="indexs.jsp" style="font-size: 25px">首页</a></li>
                        <c:forEach var="category" items="${tbCateGorys}">
                            <li><a href="${cxtPath}/showCategory?categoryId=${category.id}"
                                   style="font-size: 25px">${category.categoryName}</a></li>
                        </c:forEach>

                    </ul>

                    <ul style="display: inline-block;    margin-top: 28px;
    margin-left: 376px;">


                        <form action="${cxtPath}/searchVideo" class="navbar-form navbar-right" role="search"
                              style="display: inline-block" method="post">
                            <div class="form-group" style="display: inline-block">
                                <input type="text" name="keyword" class="form-control" placeholder="搜索">
                            </div>
                            <button type="submit" class="btn btn-default" style="display: inline-block" id="btn_search">
                                搜索
                            </button>
                        </form>

                    </ul>
                    <ul class="quick-link" style=" padding-left: 41px;
    width: 340px;">
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
    <%--  <nav class="cmn-tile-nav">
          <ul class="clearfix">
              <c:forEach var="category" items="${tbCateGorys2}">
                  <li class="colour-${category.id}"><a href="${cxtPath}/showCategory?categoryId=${category.id}" >${category.categoryName}</a></li>
              </c:forEach>
          </ul>
      </nav>--%>
    <!--////////////////////////////////////Container-->
    <section id="container" class="index-page">
        <div class="wrap-container zerogrid">
            <div class="row">
                <div id="main-content" class="col-2-3">
                    <section class="all">
                        <div class="header" style="margin-right: 10px;
    margin-left: -11px;">
                            <h2>${showName}</h2>
                        </div>
                        <div class="row">
                            <c:forEach var="video" items="${movies}" begin="0" end="7">
                                <div class="col-1-4">
                                    <div class="wrap-col" style="margin-left: 5px;">
                                        <div class="wrap-vid" style="width: 200px;height: 290px;">
                                            <div class="zoom-container">
                                                <a href="${cxtPath}/player?id=${video.id}">
												<span class="zoom-caption">
													<i class="icon-play fa fa-play"></i>
												</span>
                                                    <img src="${url}/${video.imgType}"
                                                         title="${video.videoName}"
                                                         style="width: 185px;height: 184px;"/>
                                                </a>
                                            </div>
                                            <h3 class="vid-name"><a href="#">${video.videoName}</a></h3>
                                            <div class="info">
                                                <h5>By <a href="#">${video.videoName}</a></h5>
                                                <span><i class="fa fa-calendar"></i>${video.options}</span>
                                                <span><i class="fa fa-heart"></i>${video.plays}</span>
                                                <span><a href="${cxtPath}/add_Like?id=${videoResult.id}" title="添加收藏"
                                                         style="text-decoration: none; "><i class="fa fa-plus-circle"
                                                                                            style="color: #3F3F3F;"> 添加收藏</i></a></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </section>
                    <div class="navigation">
                        <ul>
                        </ul>
                    </div>
                    <div class="clearfix"></div>

                </div>
                <div id="sidebar" class="col-1-3">
                    <div class="widget wid-post" style="width:300px;">
                        <div class="wid-header">
                            <h5>过去最热</h5>
                        </div>
                        <div class="wid-content">
                            <c:forEach var="video" items="${videos2}" begin="0" end="3">
                                <div class="post wrap-vid" style="width: 318px;height: 128px;">
                                    <div class="zoom-container">
                                        <a href="${cxtPath}/player?id=${video.id}">
										<span class="zoom-caption">
											<i class="icon-play fa fa-play"></i>
										</span>
                                            <img src="${url}/${video.imgType}" style="height: 128px; width: 140px;"/>
                                        </a>
                                    </div>
                                    <div class="wrapper">
                                        <h5 class="vid-name"><a href="#">${video.videoName}</a></h5>
                                        <div class="info">
                                            <h6>By <a href="#">${video.userName}</a></h6>
                                            <span><i class="fa fa-calendar"></i>${video.options}</span>
                                            <span><i class="fa fa-heart"></i>${video.plays}</span>
                                            <span><a href="${cxtPath}/add_Like?id=${videoResult.id}" title="添加收藏"
                                                     style="text-decoration: none; "><i class="fa fa-plus-circle"
                                                                                        style="color: #3F3F3F;"> 添加收藏</i></a></span>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <%--	<div class="widget wid-news">
                            <div class="wid-header">
                                <h5>人气榜单</h5>
                            </div>
                            <div class="wid-content">
                                <c:forEach var="video" items="${videos3}" begin="0" end="3">
                                    <div class="row">
                                        <div class="wrap-vid">
                                            <div class="zoom-container">
                                                <a href="${cxtPath}/player?id=${video.id}">
                                                <span class="zoom-caption">
                                                    <i class="icon-play fa fa-play"></i>
                                                </span>
                                                    <img src="${url}/${video.id}${video.imgType}"/>
                                                </a>
                                            </div>
                                            <h3 class="vid-name">${video.videoName}</h3>
                                            <div class="info">
                                                <h5>By <a href="#">${video.userName}</a></h5>
                                                <span><i class="fa fa-calendar"></i>${video.options}</span>
                                                <span><i class="fa fa-heart"></i>${video.plays}</span>
                                                <span><a href="${cxtPath}/add_Like?id=${videoResult.id}" title="添加收藏" style="text-decoration: none; "><i class="fa fa-plus-circle" style="color: #3F3F3F;"> 添加收藏</i></a></span>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>--%>
                </div>
            </div>
        </div>
    </section>

    <!--////////////////////////////////////Footer-->
    <footer>
        <div class="zerogrid top-footer">
            <div class="row">
                <div class="col-1-5">
                    <a href="#"><img src="images/15.jpg"/></a>
                </div>
                <div class="col-1-5">
                    <a href="#"><img src="images/16.jpg"/></a>
                </div>
                <div class="col-1-5">
                    <a href="#"><img src="images/17.jpg"/></a>
                </div>
                <div class="col-1-5">
                    <a href="#"><img src="images/18.jpg"/></a>
                </div>
                <div class="col-1-5">
                    <a href="#"><img src="images/19.jpg"/></a>
                </div>
            </div>
        </div>
    </footer>

    <script src="js/jquery-2.1.1.js"></script>
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

        });
    </script>

</div>
</body>
</html>