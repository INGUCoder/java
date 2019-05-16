<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css"
          type="text/css"/>
    <link rel="stylesheet" href="css/amazeui.min.css"/>
    <link rel="stylesheet" href="css/pageStyle.css">

</head>
<body style="background:#f3f3f3;">

<div class="main_top">
    <%-- <s:debug/>--%>
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">视屏管理
        </strong>
            <small></small>
        </div>
    </div>
    <hr>
    <div class="am-g">
        <div class="am-u-sm-12 am-u-md-6">
            <div class="am-btn-toolbar">
                <div class="am-btn-group am-btn-group-xs">
                    <button id="add" class="am-btn am-btn-default">
                        <span class="am-icon-plus"></span> 新增
                    </button>
                </div>
            </div>
        </div>
        <div class="am-u-sm-12 am-u-md-3">

        </div>
        <%-- <div class="am-u-sm-12 am-u-md-3">
             <div class="am-input-group am-input-group-sm">
                 <input type="text" class="am-form-field" id="input_search"
                        value="${keyWord}">
                 <span class="am-input-group-btn">
                     <button class="am-btn am-btn-default" type="button" id="input_search_btn">搜索</button>
                 </span>
             </div>
         </div>--%>
    </div>
</div>

<div class="goods_list">
    <ul class="title_ul">
        <li>序号</li>
        <li>视屏名称</li>
        <li>创建者</li>
        <li>删除</li>
    </ul>

    <c:forEach var="video" items="${Result.list}">
        <ul class="list_goods_ul">
            <li>${video.id}</li>
            <li>${video.videoName}</li>
            <li>${video.userName}</li>
            <li>
                <a href='javascript:useMgr.delCate("${video.id}")'>
                    <img class="img_icon" src="images/delete_icon.png" alt="">
                </a>
            </li>
        </ul>
    </c:forEach>
    <!--分页-->
    <div id="page" class="page_div"></div>
</div>

<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/paging.js"></script>
<script>

    //分页
    $("#page").paging({
        pageNo:${Result.currentPage},
        totalPage:${Result.totalPage},
        totalSize:${Result.totalCount},
        callback: function (num) {
            /*var keyWord = $("#input_search").val();*/
            $(window).attr('location', '/videoPageList?currPage=' + num);
        }
    });

    $("#add").click(function () {
        $(window).attr('location', '${pageContext.request.contextPath}/addVideo.jsp');
    });
    $("#input_search_btn").click(function () {
        var keyWord = $("#input_search").val();
        $(window).attr('location', '${pageContext.request.contextPath}/article_pageList.action?keyWord=' + keyWord);
    })
    var useMgr = {
        delCate: function (id) {
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/videoDelete",
                dataType: 'json',
                data: "id=" + id,
                success: function (data) {
                    if (data.success) {
                        alert("删除成功");
                        window.location.reload();
                    } else {
                        alert("删除失败");
                    }
                }

            })
        }
    }

</script>

</body>
</html>