<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cxtPath" value="${pageContext.request.contextPath}"></c:set>
<c:set var="moviePath"
       value="http://localhost:8080/video/">
</c:set>
<c:set var="url"
       value="http://localhost:8080/uploadImage/">
</c:set>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>播放</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="css/zerogrid.css">
    <link rel="stylesheet" href="css/css2/style.css">
    <link rel="stylesheet" href="css/menu.css">
    <link href="css/owl.carousel.css" rel="stylesheet">
    <link href="css/owl.theme.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="css/css3/baidulogin.css"/>
    <link rel="stylesheet" href="css/layui.css"/>
    <script src="js/html5.js"></script>
    <script src="js/css3-mediaqueries.js"></script>
    <script src="ckplayer/ckplayer.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/baidulogin.js"></script>
    <script type="text/javascript" src="js/user.js"></script>
    <style type="text/css">
        .comment_list {
            padding-top: 40px;
            width: 700px;
            margin: 0 auto;
        }

        .comment_details {
            float: left;
        }

        .comment_content {
            margin-top: 10px;
            font-size: 16px;
        }

        .comment_add_or_last {

            margin: 0 auto;
            clear: both;
            width: 600px;
            height: 40px;
            background: #F0F0F0;
            text-align: center;
            line-height: 40px;
        / / 行高（与div保持同高，垂直居中写法）
        }

        .imgdiv {
            float: left;

        }

        .imgcss {
            width: 50px;
            height: 50px;
            border-radius: 50%;
        }

        .comment_name {
            margin-left: 10px;
            color: #3D9EEA;
            font-size: 15px;
            font-weight: bolder;
        }

        .layui-icon {
            font-size: 10px;
            color: grey;
        }

        .del {
            margin-left: 55px;
        }
    </style>
</head>
<body id="wrapper">
<div class="wrap-body">

    <!--////////////////////////////////////Header-->
    <header>
        <div class="wrap-header">
            <div class="zerogrid">
                <div class="row">
                    <a href="indexs.jsp" class="logo"><img src="images/logo.png"/></a>
                    <ul class="navbar_nav" data-in="fadeInDown" data-out="fadeOutUp">
                        <li><a href="indexsFu.jsp" style="font-size: 25px">首页</a></li>
                        <c:forEach var="category" items="${tbCateGorys}">
                            <li><a href="${cxtPath}/showCategory?categoryId=${category.id}"
                                   style="font-size: 25px">${category.categoryName}</a></li>
                        </c:forEach>

                    </ul>
                    <ul class="quick-link">
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
    <!--Menu-->

    <!--Container-->
    <section id="container" class="index-page" style="margin-top: 30px;">
        <div class="wrap-container zerogrid">
            <div class="row">
                <div id="main-content" class="col-2-3" style="width: 599px;">
                    <div id="ckplayer" style="width: 800; height: 500;margin-top: -1%;"></div>
                    <div id="a1"></div>
                    <h1 class="vid-name">${videoResult.videoName}</h1>
                    <div class="info">
                        <h5>By <a href="#">${videoResult.userName}</a></h5>
                        <span><i class="fa fa-calendar"></i>${videoResult.options}</span>
                        <span><i class="fa fa-heart"></i>${videoResult.plays}</span>
                        <span><a href="${cxtPath}/add_Like?id=${videoResult.id}" title="添加收藏"
                                 style="text-decoration: none; "><i class="fa fa-plus-circle" style="color: #3F3F3F;"> 添加收藏</i></a></span>

                    </div>
                    <p>${videoResult.message}</p>
                    <div class="comment_list">
                        <h2>评论</h2>
                        <hr>
                        <c:forEach var="recomment" items="${recomments}">
                            <div class="comment">

                                <div class="conmment_details" style="margin-right: 5px;">
                                    <div class="imgdiv"><img class="imgcss" src="${url}/1.jpg"/></div>
                                    <span class="comment_name">${user.userName}</span> <span>${recomment.time}</span>
                                    <div class="comment_content"
                                         style="margin-left: 70px;height: 20px;margin-bottom: 5px;"> ${recomment.content}</div>
                                    <div class="del"><i class="icon layui-icon"><input type="button" id="pares" alt="赞"
                                                                                       value="赞(${recomment.praseCount})"
                                                                                       onclick="prase('${recomment.rId}')"/></i>
                                            <%--<a class="del_comment" id="delete"> <i class="icon layui-icon" >删除</i></a>--%>
                                        <i class="icon layui-icon"></i><input type="button" alt="删除" value="删除"
                                                                              onclick="del('${recomment.rId}')"/>
                                    </div>
                                </div>
                                <hr>
                            </div>

                        </c:forEach>
                        <button id="addRe">添加评论</button>
                        <div style="display: none;" id="textK">
                            <textarea name="content" id="demo"></textarea>
                            <input type="hidden" name="videoId" value="${videoResult.id}">
                            <button id="submit">添加</button>
                        </div>
                    </div>
                    <div class="comment_add_or_last" style="margin-bottom: 5px;">
                        没有更多评论了
                    </div>
                </div>
                <div id="sidebar" class="col-1-3">
                    <div class="widget wid-post" style="margin-top: -5px;">
                        <div class="wid-header">
                            <h5>最新排行榜</h5>
                        </div>
                        <div class="wid-content" style="height: 630px;">
                            <c:forEach var="video" items="${videos2}" begin="1" end="4">
                                <div class="post wrap-vid" style="width: 318px;height: 130px;">
                                    <div class="zoom-container">
                                        <a href="${cxtPath}/player?id=${video.id}">
										<span class="zoom-caption">
											<i class="icon-play fa fa-play"></i>
										</span>
                                            <img src="${url}/${video.imgType}" style="height: 128px; width: 150px;"/>
                                        </a>
                                    </div>
                                    <div class="wrapper">
                                        <h5 class="vid-name"><a href="#">${video.videoName}</a></h5>
                                        <div class="info">
                                            <h6>By <a href="#">${video.userName}</a></h6>
                                            <span><i class="fa fa-calendar"></i>${video.options}</span>
                                            <span><i class="fa fa-heart"></i>${video.plays}</span>
                                            <span><a href="${cxtPath}/add_Like?id=${video.id}" title="添加收藏"
                                                     style="text-decoration: none; "><i class="fa fa-plus-circle"
                                                                                        style="color: #3F3F3F;"> 添加收藏</i></a></span>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
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
    <script src="js/layui.js"></script>
    <script>
        $(document).ready(function () {
            /*
                  $("#owl-demo-1").owlCarousel({
                    items : 4,
                    lazyLoad : true,
                    navigation : true
                  });*/
            /* $("#owl-demo-2").owlCarousel({
               items : 4,
               lazyLoad : true,
               navigation : true
             });*/

        });
    </script>
    <script>
        var flashvars = {
            f: 'video/mp4', //项目的相对路径WebContent下
            c: 0,
            s: 0,
            p: 1
        };
        var video = ['${moviePath}/admin/${videoResult.mvType}'];
        CKobject.embed('ckplayer/ckplayer.swf', 'a1', 'ckplayer_a1',
            '600', '400', false, flashvars, video);

    </script>
    <script>

        $("#addRe").click(function () {
            $("#textK")[0].style.display = "block";
        });


        layui.use('layedit', function () {
            var layedit = layui.layedit, $ = layui.jquery;
            var index = layedit.build('demo', {
                height: 50,
                tool: ['left', 'center', 'right', '|', 'face']
            }); //建立编辑器
            $("#submit").click(function () {
                var data = layedit.getContent(index);
                $.post("/addRecomment", {content: data, videoId:${videoResult.id}}, function (rtn) {
                    alert(rtn);
                    var data = $.parseJSON(rtn);
                    alert(data);
                    if (data.success) {
                        alert("评论成功");
                        var index = $("#pares").val();
                        $("#pares").attr('value', index + 1);
                        /*$(window).attr('location','/player?id='+
                        ${videoResult.id});*/
                    } else {
                        alert("评论失败");
                    }

                })


            })
        });

        function del(rid) {
            $.get("/deleteRecomment?rId=" + rid, function (data) {
                if (data.success) {
                    alert("删除成功");
                    $(window).attr('location', '/player?id=' +${videoResult.id});
                } else {
                    alert("删除失败");
                }
            })

        }

        function prase(rid) {
            $.get("/addPraseRecom?rId=" + rid, function (data) {
                if (data.success) {
                    alert("赞成功");
                    $("#")
                    $(window).attr('location', '/player?id=' +${videoResult.id});
                } else {
                    alert("赞失败");
                }
            })
        }

    </script>
</div>
</body>
</html>