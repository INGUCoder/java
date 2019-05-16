<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String ctx = request.getContextPath();
    pageContext.setAttribute("ctx", ctx);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
    <link rel="stylesheet" href="css/amazeui.min.css"/>
    <link rel="stylesheet" href="css/jquery.plupload.queue.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/plupload.full.min.js"></script>
    <script src="js/jquery.plupload.queue.js"></script>
    <script src="js/zh_CN.js"></script>
    <script type="text/javascript" charset="utf-8" src="js/umedit/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="js/umedit/ueditor.all.js"></script>
    <script type="text/javascript" charset="utf-8" src="js/umedit/lang/zh-cn/zh-cn.js"></script>

</head>
<body>
<div class="main_top">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">上传视屏
        </strong>
            <small></small>
        </div>
    </div>
    <hr>
    <div STYLE="text-align: center">
        <div id="uploader">
            <p>Your browser doesn't have Flash, Silverlight or HTML5 support.</p>
        </div>
    </div>
    <form id="blog_form" enctype="multipart/form-data" action="${ctx}/add_Video" method="post">
        <div class="edit_content">
            <div class="item1">
                <div>
                    <span>电影名称：</span>
                    <input type="text" class="am-form-field" name="videoName" style="width: 300px">&nbsp;&nbsp;
                </div>
            </div>
            <%--<input type="text" name="article_desc" id="article_desc" style="display: none;">--%>
            <div class="item1">
                <span>所属分类：</span>
                <select id="category_select" name="categoryId" style="width: 150px">&nbsp;&nbsp;
                </select>
                </select>
            </div>
            <div class="item1">
                <span>所属分类：</span>
                <select id="grad" name="grade" style="width: 150px">&nbsp;&nbsp;
                    <option value="1d">1星</option>
                    <option value="2d">2星</option>
                    <option value="3d">3星</option>
                    <option value="4d">4星</option>
                    <option value="5d">5星</option>
                </select>
            </div>

            <div class="item1">
                <div>
                    <span>时长：</span>
                    <input type="text" class="am-form-field" name="opptions" style="width: 300px">&nbsp;&nbsp;
                </div>
            </div>
            <div class="item1 update_pic">
                <span>摘要图片：</span>
                <img src="" id="imageview" class="item1_img" style="display: none;">
                <label for="fileupload" id="label_file">上传文件</label>
                <input type="file" name="fileName" id="fileupload"/>
            </div>
            <div class="item1">
                <div>
                    <span>视屏详情：</span>
                    <input type="text" class="am-form-field" name="message" style="width: 300px">&nbsp;&nbsp;
                </div>
            </div>
            <button class="am-btn am-btn-default" type="submit" id="send"
                    style="margin-top: 10px; background-color: lightseagreen; color:white;">
                发 布
            </button>
        </div>

    </form>

</div>

<script>
    $(function () {
        $.post("${pageContext.request.contextPath}/CategoryList", function (data) {
            $(data).each(function (i, n) {
                $("#category_select").append("<option value='" + n.id + "'>" + n.categoryName + "</option>");
            });
            $('#category_select').trigger('change');
        }, "json");


        /*原理是把本地图片路径："D(盘符):/image/..."转为"http://..."格式路径来进行显示图片*/
        $("#fileupload").change(function () {
            var $file = $(this);
            var objUrl = $file[0].files[0];
            //获得一个http格式的url路径:mozilla(firefox)||webkit or chrome
            var windowURL = window.URL || window.webkitURL;
            //createObjectURL创建一个指向该参数对象(图片)的URL
            var dataURL;
            dataURL = windowURL.createObjectURL(objUrl);
            $("#imageview").attr("src", dataURL);
            console.log($('#imageview').attr('style'));
            if ($('#imageview').attr('style') === 'display: none;') {
                $('#imageview').attr('style', 'inline');
                $('#imageview').width("300px");
                $('#imageview').height("180px");
                $('.update_pic').attr('style', 'margin-bottom: 150px;');
            }
        });
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