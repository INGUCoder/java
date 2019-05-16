<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="cxtPath" value="${pageContext.request.contextPath}"></c:set>
<c:set var="url" value="http://localhost:8080/uploadImage"></c:set>
<html>

<head>
    <title>视频信息</title>
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

    <link href="css/css3/indexMovie.css" rel='stylesheet'
          type='text/css'/>
    <link href="css/css3/bootstrap.css" rel='stylesheet'
          type='text/css'/>
    <link href="css/css3/style.css" rel="stylesheet" type="text/css"
          media="all"/>
    <!-- start plugins -->
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script src="js/responsiveslides.min.js"></script>

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
                <a href="${cxtPath}/index.jsp"><img
                        src="${cxtPath}/images/logo.png" alt="logo"/></a>
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
                                <a href="${cxtPath}/personalCenter.jsp"> <img
                                        src="${url}/1.jpg" alt="头像" title="个人中心"
                                        style="border-radius: 50%;" width=32px height=32px/> <font
                                        color="#31B0D5" size="4">${user.userName}</font></a>
                                &nbsp;&nbsp;|&nbsp;&nbsp;
                                <a href="${cxtPath}/userLogout"> <font color="#31B0D5"
                                                                       size="4" title="退出登录">退出</font></a>
                            </c:if>
                        </p>
                    </li>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="content">
            <div class="movie_top">
                <div class="col-md-2 movie_box"></div>
                <!--主体的左边-->
                <div class="col-md-8 movie_box">
                    <form action="${cxtPath}/SaveEditMovie" method="post">
                        <h3 style="margin-left: -100px"><font color="#FFF">编辑视频：</font></h3><br>
                        <div class="grid images_3_of_2" style="border: 2px solid #fff;">
                            <div class="movie_image">
                                <span class="movie_rating">${video.grade}</span>
                                <a href="${cxtPath}/player?id=${mv.id}">
                                    <img src="${url}/${video.imgType}"
                                         class="img-responsive" alt="视频播放" title="点击播放视频"
                                         style="width: 265px;height: 293px"/>
                                </a>
                            </div>
                        </div>
                        <div class="desc1 span_3_of_2">
                            <p class="movie_option">
                                <font color="#FFFFFF"><strong>名称: </strong><input type="text" name="videoName"
                                                                                  value="${video.videoName}"
                                                                                  style="background: none"></font>
                            </p>
                            <p class="movie_option">
                                <font color="#FFFFFF"><strong>主演: </strong><input type="text" name="userName"
                                                                                  value="${video.userName}"
                                                                                  style="background: none"></font>
                            </p>
                            <p class="movie_option">
                                <font color="#FFFFFF"><strong>时长: </strong><input type="text" name="options"
                                                                                  value="${video.options}"
                                                                                  style="background: none"></font>
                            </p>
                            <input type="hidden" name="currentPage" value="${video.currentPage}">
                            <input type="hidden" name="totalPage" value="${video.totalPage}">
                            <p class="movie_option">
                                <div class="form-submit1" style="margin-left: 40px">
                            <p>
									<span>
										<input name="submit" type="submit" value="保存">
									</span>
                                &nbsp;&nbsp;
                                <span>
										<input name="reset" type="reset" id="submit1" value="重置">
									</span>
                            </p>
                        </div>
                        </p>
                        <!-- <div class="down_btn">
                            <a class="btn1" href="#"><span> </span>立即下载</a>
                        </div> -->
                        <div class="clearfix"></div>
                        <input type="hidden" name="id" value="${video.id}"/>
                        <input type="hidden" name="isplay" value="${video.isplay}"/>
                    </form>
                </div>


                <!--页脚-->
                <div class="container">
                    <footer id="footer">
                        <div id="footer-3d">
                            <div class="gp-container">
                                <span class="first-widget-bend"></span>
                            </div>
                        </div>
                        <div id="footer-widgets" class="gp-footer-larger-first-col">
                            <div class="gp-container">

                                <div class="footer_box">
                                    <div class="col_1_of_3 span_1_of_3">
                                        <h3>友情链接</h3>
                                        <ul class="first">
                                            <li><a href="#">爱奇艺</a></li>
                                            <li><a href="#">腾讯视频</a></li>
                                            <li><a href="#">百度</a></li>
                                        </ul>
                                    </div>
                                    <div class="col_1_of_3 span_1_of_3">
                                        <h3>新闻动态</h3>
                                        <ul class="first">
                                            <li><a href="#">抢先发布</a></li>
                                            <li><a href="#">top sellers</a></li>
                                            <li><a href="#">Specials</a></li>
                                        </ul>
                                    </div>
                                    <div class="col_1_of_3 span_1_of_3">
                                        <h3>联系我们</h3>
                                        <ul class="first">
                                            <li><a href="#">关于我们</a></li>
                                            <li><a href="#">联系方式</a></li>
                                            <li><a href="#">留言</a></li>
                                        </ul>
                                    </div>
                                    <div class="clearfix"></div>


                                </div>
                                <!--版权声明-->
                                <div class="copy" align="center">
                                    <p>Copyright &copy; 2015-2020.sheep.</p>
                                </div>
                                <div class="clearfix"></div>

                            </div>
                        </div>
                    </footer>

                </div>
</body>

</html>