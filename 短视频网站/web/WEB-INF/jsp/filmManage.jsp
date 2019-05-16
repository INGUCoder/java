<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="cxtPath" value="${pageContext.request.contextPath}"></c:set>
<c:set var="url" value="${pageContext.request.contextPath}/uploadImage/"></c:set>
<html>
<head>
    <title>影片管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="视频交流网站"/>
    <link href=css/css3/indexMovie.css" rel='stylesheet' type='text/css'/>
    <link href="css/css3/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link href="css/css3/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/jquery.page.css" rel="stylesheet" type="text/css">
    <script type="application/x-javascript">
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>

    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script src="js/responsiveslides.min.js"></script>
    <script src="js/page.js"></script>
    <script src="js/movie.js"></script>
</head>
<%--<img src="https://ws3.sinaimg.cn/large/005BYqpgly1g1giex31e1j31hc0u0gnp.jpg"/>--%>
<%--<img src="http://p2.so.qhmsg.com/t01a4e1c8bbc1cb5544.jpg"/>--%>
<%--<body style="background: url('https://ws3.sinaimg.cn/large/005BYqpgly1g1gipc122bj31hc0u0k0z.jpg');background-repeat: no-repeat;background-size: cover">--%>
<body style="background-color: rgb(222,184,135);height: 1080px">

<div class="container">


    <div class="container_wrap">
        <!--顶部-->
        <div class="header_top">
            <div class="col-sm-3 logo" style="margin-top: -2%;margin-left: 20px;">
                <a href="${cxtPath}/index.jsp"><img src="${cxtPath}/uploadImage/logo.png" alt="logo"/></a>
            </div>

            <div class="col-sm-4 header_right" style="position: absolute;right: 165px;">
                <ul class="header_right_box">
                    <li>
                        <p>
                            <c:if test="${user!=null}">
                                <img src="${url}/1.jpg" title="个人中心"
                                     alt="头像" style="border-radius:50%;" width=32px height=32px/>
                                <font color="#31B0D5" size="4" title="个人中心">个人中心</font>
                                &nbsp;&nbsp;|&nbsp;&nbsp;
                                <a href="${cxtPath}/userLogout" title="退出登录">
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
                    <div style="border:2px solid #F7E1B5; width: 53%;height: 228px">
                        <div class="movie_img">
                            <div class="grid_2">
                                <a href="${cxtPath}/personalCenter.jsp">
                                    <h3><font color="#FFFFFF">个人资料</font></h3></a>
                            </div>
                            <div class="grid_2 col_1">
                                <a href="${cxtPath}/editUser.jsp">
                                    <h3><font color="#FFFFFF">修改资料</font></h3></a>
                            </div>
                            <div class="grid_2 col_1">
                                <h3><font color="#285E8E">影片管理</font></h3>
                            </div>

                            <div class="grid_2 col_1">
                                <a href="${cxtPath}/likeList?index=1">
                                    <h3><font color="#FFFFFF">我的收藏</font></h3></a>
                            </div>
                        </div>
                    </div>
                </div>
                <form method="post" action="">
                    <!--主体的右边-->
                    <div class="col-md-9 movie_box">
                        <h2><font color="#FFFFFF">我的影片</font></h2>
                        <hr>
                        <div>
                            <div align="center" style="float: left;">
                                <a class="pagebtn" style="border:1px solid #FFFFE0;" href="${cxtPath}/toUpload">上传影片</a>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <br>

                        <c:forEach var="mv" items="${videoList}">
                            <div class="movie movie-test movie-test-dark movie-test-left">
                                <div class="movie__images" style=" width:200px;height:200px">
                                    <a href="${cxtPath}/player?id=${mv.id}"
                                       class="movie-beta__link">
                                        <img src="${url}${mv.imgType}"
                                             class="img-responsive" alt="影片缩略图" title="点击播放"
                                             style=" width:200px;height:200px"/>
                                    </a>
                                </div>
                                <div class="movie__info">
                                    <a href="${cxtPath}/player?id=${mv.id}" class="movie__title">${mv.videoName}</a>
                                    <p class="movie__time"><span>时长：</span>${mv.options}</p>
                                        <%--<p class="movie__option"><span>地区：</span>${mv.movieCountry}</p>--%>
                                    <ul class="list_6">
                                        <li>评分 ：<p>${mv.grade}</p></li>
                                        <li><i class="icon1"> </i>
                                            <p>${mv.plays}</p></li>
                                        <li><i class="icon3"> </i>
                                            <p>${mv.options}</p></li>
                                    </ul>
                                </div>
                                &nbsp;
                                <input type="button" alt="编辑影片" value="编辑"
                                       onclick="editMovie('${mv.id}','${page.currentPage}','${page.totalPage}')"
                                       style="background: none;color: #FFF;border: 2px solid #2C518D;"/>
                                &nbsp;
                                <input type="button" alt="删除影片" value="删除" onclick="delMovie('${mv.id}')"
                                       style="background: none;color: #FFF;border: 2px solid #2C518D;"/>
                                <div class="clearfix"></div>
                            </div>
                        </c:forEach>
                        <div class="clearfix"></div>
                        <br/>

                        <!--分页按钮-->
                        <input type="button" class="pagebtn" value="第一页" onclick="toPage(1)"/> -
                        <input type="button" class="pagebtn" value="上一页" onclick="toPage(${page.currentPage-1})"/> -
                        <input type="button" class="pagebtn" value="当前页:${page.currentPage}"/> -
                        <input type="button" id="next" class="pagebtn" value="下一页"
                               onclick="toPage(${page.currentPage+1})"/> -
                        <input type="hidden" class="pagebtn" name="totalPage" value="${page.totalPage}">
                        <input type="button" class="pagebtn" value="尾    页" onclick="toPage(${page.totalPage})"/> -
                        <input type="text" class="page" value="共 ${page.totalPage} 页    跳转到第"
                               size="16" disabled="disabled"/> -
                        <input type="text" value="${page.currentPage}" id="currentPage"
                               class="pageValue" size="2" onblur="toPage(this.value)"
                               style="background: none; border: 1px solid #FFFFE0;"/> -
                        <input type="button" class="pagebtn" value="页    go"/>
                        <input type="hidden" name="currentPage" id="hidecurrentPage"/>
                    </div>
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
    </div>
</div>

<!--页脚-->
<div class="container">
    <footer id="footer">
        <div id="footer-widgets" class="gp-footer-larger-first-col">
            <div class="gp-container">.

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
<script>
    function toPage(number) {
        var total = $("input[name='totalPage']").val();
        if (number > total) {
            number = total;
        }
        $("input[name='currentPage']").attr("value", number);
        document.forms[0].action = 'getMoviesByUserID';
        document.forms[0].submit();
    }

</script>
</html>