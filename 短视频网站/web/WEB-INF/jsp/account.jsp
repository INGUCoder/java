<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
    <link rel="stylesheet" href="css/amazeui.min.css"/>
    <link rel="stylesheet" href="css/pageStyle.css">
    <script src="js/jquery.min.js"></script>
</head>
<body>

<div class="main_top">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">用户列表</strong>
            <small></small>
        </div>
    </div>
    <hr>
    <div class="am-g">
        <div class="am-u-sm-12 am-u-md-6">
            <%--<div class="am-btn-toolbar">
                <div class="am-btn-group am-btn-group-xs">
                    <button id="add" class="am-btn am-btn-default">
                        <span class="am-icon-plus"></span> 添加管理员</button>
                </div>
            </div>--%>
        </div>
    </div>
</div>
<div class="goods_list" id="account_List">
    <ul class="title_ul">
        <li>序号</li>
        <li>用户</li>
        <li>用户名</li>
        <li>电话</li>
        <li>删除</li>
    </ul>

    <c:forEach var="user" items="${Result.list}">
        <ul class="list_goods_ul">
            <li>${user.id}</li>
            <li>${user.userName}</li>
            <li>${user.userNickname}</li>
            <li>${user.phone}</li>
            <li><a href='javascript:useMgr.delCate("${user.id}")'><img class="img_icon" src="images/delete_icon.png"
                                                                       alt=""></a></li>
        </ul>
    </c:forEach>
</div>
</div>

<script>
    $(function () {
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
        $('#add').click(function () {
            $("#modal_view").fadeIn();
            $("#modal_content_account").fadeIn();
        });

        $("#close").click(function () {
            $("#modal_view").fadeOut();
            $("#modal_content_account").fadeOut();
        });
    });
    var useMgr = {
        delCate: function (id) {
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/userDelete",
                dataType: 'json',
                data: "id=" + id,
                success: function (data) {
                    alert(data.result)
                    window.location.reload();
                },
                error: function (data) {
                    alert(data.result)
                }

            })
        }
    }
</script>
</body>
</html>