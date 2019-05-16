<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="cxtPath" value="${pageContext.request.contextPath}"></c:set>
<c:set var="url" value="http://localhost:8080/uploadImage"></c:set>
<html>

<head>
    <title>修改资料</title>
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

    <link href="${cxtPath}/css/css3/indexMovie.css" rel='stylesheet'
          type='text/css'/>
    <link href="${cxtPath}/css/css3/bootstrap.css" rel='stylesheet'
          type='text/css'/>
    <link href="${cxtPath}/css/css3/style.css" rel="stylesheet" type="text/css"
          media="all"/>
    <!-- start plugins -->
    <script type="text/javascript" src="${cxtPath}/js/jquery.min.js"></script>
    <script src="${cxtPath}/js/responsiveslides.min.js"></script>
    <script src="${cxtPath}/js/user.js"></script>
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

<%--<body style="background-color: lightpink;height: 1080px;">--%>
<%--<body style="background: url('https://ws3.sinaimg.cn/large/005BYqpgly1g1gipc122bj31hc0u0k0z.jpg');background-repeat: no-repeat;background-size: cover">--%>
<body style="background-color: rgb(222,184,135);height: 1080px">

<div class="container">
    <div class="container_wrap">
        <div class="header_top">
            <div class="col-sm-3 logo" style="margin-top: -2%;;margin-left: 20px;">
                <a href="${cxtPath}/index.jsp"><img src="${cxtPath}/images/logo.png" alt="logo"/></a>
            </div>
            <div class="col-sm-5 nav" style="margin-top: -0.5%">

            </div>
            <div class="col-sm-4 header_right" style="position: absolute;right: 165px;">
                <ul class="header_right_box">
                    <li>
                        <p>
                            <c:if test="${user!=null}">
                                <img src="${url}/1.jpg" alt="头像"
                                     style="border-radius: 50%;" width=32px height=32px/> <font
                                    color="#31B0D5" size="4">个人中心</font> &nbsp;&nbsp;|&nbsp;&nbsp;
                                <a href="${cxtPath}/personalCenter.jsp"> <font
                                        color="#31B0D5" size="4">退出</font></a>
                            </c:if>
                        </p>
                    </li>
                    <div class="clearfix"></div>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>

        <!--主体-->
        <div class="content">

            <div class="movie_top">
                <!--主体的左边:目录-->
                <div class="col-md-3">
                    <div style="border: 2px solid #F7E1B5; width: 53%;height: 220px">
                        <div class="movie_img">
                            <div class="grid_2">
                                <a href="${cxtPath}/personalCenter.jsp">
                                    <h3>
                                        <font color="#FFFFFF">个人资料</font>
                                    </h3>
                                </a>
                            </div>
                            <div class="grid_2 col_1">
                                <h3>
                                    <font color="#285E8E">修改资料</font>
                                </h3>
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
                <div class="col-md-8 movie_box" style="border: 2px solid #F7E1B5;">
                    <form method="post" action="${cxtPath}/editUser"
                          enctype="multipart/form-data">
                        <div class="desc1 span_3_of_2">
                            <br/>
                            <h3>
                                <font color="#FFFFFF">修改资料</font>
                            </h3>
                            <br/>
                            <div style="margin-left: 5em;">
                                <p class="movie_option">
                                    <font color="#FFFFFF"><strong>用户名：&nbsp;&nbsp;&nbsp;
                                    </strong><span><input type="text" name="userName"
                                                          value="${user.userName}" style="background: none;"
                                    /> </span></font>
                                </p>
                                <p class="movie_option">
                                    <font color="#FFFFFF"><strong>昵称:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    </strong><span> <input type="text" name="userNickname"
                                                           value="${user.userNickname}"
                                                           style="background: none;"/></span></font>
                                </p>
                                <p class="movie_option">
                                    <font color="#FFFFFF"><strong>手机号码：</strong><span><input
                                            type="text" name="phone" value="${user.phone}"
                                            style="background: none;"/></span></font>
                                </p>
                                <p class="movie_option">
                                    <font color="#FFFFFF"><strong>密码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong><span>
												<input type="password" name="userPassword" value=""
                                                       style="background: none;" id="edPass"/> <font color="red"
                                                                                                     size="2"
                                                                                                     id="edPass_span"></font>
										</span></font>
                                </p>
                                <p class="movie_option">
                                    <font color="#FFFFFF"><strong>新密码：&nbsp;&nbsp;&nbsp;</strong><span><input
                                            type="password" name="newUserPassword" value=""
                                            style="background: none;" id="reEdPass"
                                            placeholder="必须包含大小写字母、数字、特殊字符"/> <font color="red"
                                                                                    size="2" id="reEdPass_Span"></font> </span></font>
                                </p>
                                <p class="movie_option">
                                    <font color="#FFFFFF"><strong>确认密码：</strong><span><input
                                            type="password" name="reUserPassword" value=""
                                            style="background: none;" id="confEdPass"/> <font
                                            color="red" size="2" id="confEdPass_span"></font> </span></font>
                                </p>
                                <input type="hidden" value="${user.id}" name="id">
                                <input type="hidden" value="${user.userName}" id="hdUserName"/>
                            </div>
                        </div>
                        <div class="grid images_3_of_2">
                            <br><br><br><br>
                            <h4><font color="#FFFFFF">头像</font></h4>
                            <br/>
                            <div style="border: 2px solid #F5F5F5; width: 50px; height: 50px;"><img src="${url}/1.jpg"
                                                                                                    width="46px"
                                                                                                    height="46px"/>
                            </div>
                        </div>

                        <div class="clearfix"></div>
                        <div class="form-submit1" align="center">
                            <p>
									<span><input name="submit" type="submit" id="submit"
                                                 value="修改"></span>&nbsp;&nbsp;&nbsp; <span><input
                                    name="reset" type="reset" id="submit1" value="重置"></span>
                            </p>
                        </div>

                        <div class="clearfix"></div>
                    </form>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>

<!--页脚-->
<div class="container">
    <footer id="footer">

        <div id="footer-widgets" class="gp-footer-larger-first-col">
            <div class="gp-container">
                <!--版权声明-->
                <div class="copy" align="center">
                    <p>Copyright &copy; 2015-2020</p>
                </div>
                <div class="clearfix"></div>

            </div>
        </div>
    </footer>

</div>
</body>

</html>