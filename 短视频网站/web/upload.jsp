<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="cxtPath" value="${pageContext.request.contextPath}"></c:set>
<html>

<head>
    <title>影片上传</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="在线视频网站"/>
    <link href="css/css3/indexMovie.css" rel='stylesheet'
          type='text/css'/>
    <link href="css/css3/bootstrap.css" rel='stylesheet'
          type='text/css'/>
    <link href="css/css3/style.css" rel="stylesheet" type="text/css"
          media="all"/>
    <link href="css/css3/jquery.plupload.queue.css" rel='stylesheet' type='text/css'/>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script src="js/responsiveslides.min.js"></script>
    <script type="text/javascript" src="js/plupload.full.min.js"></script>
    <script type="text/javascript" src="js/jquery.plupload.queue.js"></script>
    <script type="text/javascript" src="js/zh_CN.js"></script>

</head>

<body style="background-color: rgb(222,184,135);height: 1360px">
<div class="container">
    <div class="container_wrap">
        <!--顶部-->
        <div class="header_top">
            <div class="col-sm-3 logo" style="margin-top: -2%">
                <a href="${cxtPath}/index.jsp"><img src="${cxtPath}/uploadImage/logo.png" alt="logo"/></a>
            </div>
            <div class="col-sm-5 nav" style="margin-top: -0.5%">
            </div>
            <div class="col-sm-4 header_right">
                <ul class="header_right_box">
                    <li>
                        <p>
                            <c:if test="${user!=null}">
                                <a href="${cxtPath}/personalCenter.jsp">
                                    <img src="${cxtPath}/uploadImage/1.jpg" alt="头像" style="border-radius:50%;"
                                         width=32px height=32px/>
                                    <font color="#31B0D5" size="4">${user.userName}</font></a>
                                &nbsp;&nbsp;|&nbsp;&nbsp;
                                <a href="${cxtPath}/userLogout">
                                    <font color="#31B0D5" size="4">退出</font></a>
                            </c:if></p>
                    </li>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>

        <div class="content" style="margin-top: -5%">
            <div class="content">
                <div class="register">
                    <h3 align="center">
                        <font color="#FFFFFF" size="7">上传影片</font>
                    </h3>
                    <div id="uploader">
                        <p>Your browser doesn't have Flash, Silverlight or HTML5 support.</p>
                    </div>
                    <form enctype="multipart/form-data" action="${cxtPath}/updateLoadVideo" method="post">
                        <div class="register-top-grid">
                            <input type="hidden" name="userId" value="${user.id}"/>
                            <div>
                                <span><font color="#FFFFFF" size="4">缩略图</font><label></label></span>
                                <input type="file" name="fileName"/>
                            </div>
                            <div>
                                <span><font color="#FFFFFF" size="4">名称</font><label></label></span>
                                <input type="text" name="videoName" placeholder="请输入影片名称">
                            </div>
                            <div>
                                <span><font color="#FFFFFF" size="4">时长</font><label></label></span>
                                <input type="text" name="options" placeholder="请输入影片时长">
                            </div>
                            <div>
                                <span><font color="#FFFFFF" size="4">类型</font><label></label></span>
                                <select class="select" name="categoryId">
                                    <option selected="selected">请选择类型</option>
                                    <c:forEach items="${categories}" var="categorie">
                                        <option value="${categorie.id}">${categorie.categoryName}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="clearfix"></div>

                            <div>
                                <span><font color="#FFFFFF" size="4">描述/简介</font><label></label></span>
                                <input type="text" name="message" placeholder="请输入影片描述/简介">
                            </div>
                            <div>
                                <span><font color="#FFFFFF" size="4">推荐指数/评分</font><label></label></span>
                                <select class="select" name="grade">
                                    <option selected="selected">请给影片评分</option>
                                    <option value="1">1.0分</option>
                                    <option value="2">2.0分</option>
                                    <option value="3">3.0分</option>
                                    <option value="4">4.0分</option>
                                    <option value="5">5.0分</option>
                                </select>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="register-but" align="center">
                            <input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
                                type="reset" value="重置">
                            <div class="clearfix"></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <footer id="footer">
        <div id="footer-3d" style="height: 0px;">
            <div class="gp-container">
                <span class="first-widget-bend"></span>
            </div>
        </div>
        <div id="footer-widgets" class="gp-footer-larger-first-col">
            <div class="gp-container">
                <div class="footer-widget footer-1">
                    <div class="wpb_wrapper">
                        <img src="images/f_logo.png" alt=""/>
                    </div>
                    <br>

                </div>
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

<script type="text/javascript">
    $(function () {
        // Initialize the widget when the DOM is ready
        var uploader = $("#uploader").pluploadQueue({
            // General settings
            runtimes: 'html5,flash,silverlight,html4,jsp',
            url: "${pageContext.request.contextPath}/uploadVideo",

            // Maximum file size
            max_file_size: '10000mb',

            chunk_size: '1mb',

            // Resize images on clientside if we can
            resize: {
                width: 200,
                height: 200,
                quality: 90,
                crop: true
                // crop to exact dimensions
            },

            // Specify what files to browse for
            filters: [{
                title: "Image files",
                extensions: "jpg,gif,png"
            }, {
                title: "Vedio files",
                extensions: "mp4,mkv,qsv"
            }, {
                title: "Zip files",
                extensions: "zip,avi"
            }],

            // Rename files by clicking on their titles
            rename: true,

            // Sort files
            sortable: true,

            // Enable ability to drag'n'drop files onto the widget (currently only HTML5 supports that)
            dragdrop: true,

            // Views to activate
            views: {
                list: true,
                thumbs: true, // Show thumbs
                active: 'thumbs'
            },

            // Flash settings
            flash_swf_url: 'js/Moxie.swf',

            // Silverlight settings
            silverlight_xap_url: 'js/Moxie.xap'
        });

        $("#toStop").on('click', function () {
            uploader.stop();
        });

        $("#toStart").on('click', function () {
            uploader.start();
        });
    });
</script>

</body>

</html>