<%@ page import="lombok.experimental.var" %>
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
    <style>
        #modal_content2 {
            padding: 30px 20px;
            width: 400px;
            height: 260px;
            background: white;
            position: fixed;
            left: 50%;
            top: 50%;
            margin-left: -200px;
            margin-top: -100px;
        }

        #close2 {
            position: absolute;
            right: 10px;
            top: 10px;
        }
    </style>
</head>
<body>


<div class="main_top">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">分类管理</strong>
            <small></small>
        </div>
    </div>
    <hr>
    <div class="am-g">
        <div class="am-u-sm-12 am-u-md-6">
            <div class="am-btn-toolbar">
                <div class="am-btn-group am-btn-group-xs">
                    <button id="add" class="am-btn am-btn-default">
                        <span class="am-icon-plus"></span> 添加分类
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="goods_list" id="account_List">
    <ul class="title_ul">
        <li>id</li>
        <li>分类名称</li>
        <li>修改分类</li>
        <li>删除分类</li>
    </ul>
    <c:forEach var="tbCategory" items="${list}">
        <ul class="list_goods_ul">
            <li>${tbCategory.id}</li>
            <li>${tbCategory.categoryName}</li>
            <li>
                <a href="#" class="updatebtn" data-id="${tbCategory.id}">
                    <img class="img_icon" src="images/edit_icon.png" alt="">
                </a>
            </li>
            <li>
                <a href='javascript:useMgr.delCate("${tbCategory.id}")'><img class="img_icon"
                                                                             src="images/delete_icon.png" alt=""></a>
            </li>
        </ul>
    </c:forEach>
</div>

<div id="modal_view">


</div>

<div id="modal_content" style="height: 260px;">
    <div id="close"><img src="images/delete_icon.png" alt=""></div>
    <div class="edit_content">
        <div class="item1">
            <div>
                <span>添加分类：</span>
            </div>
        </div>
        <div class="item1">
            <div>
                <span>分类名称：</span>
                <input type="text" class="am-form-field" id="name" name="categoryName">&nbsp;&nbsp;<br>
                <button class="am-btn am-btn-default" type="button" id="abdicates">添加</button>
            </div>
        </div>
    </div>
</div>

<div id="modal_content2" style="display: none;">
    <div id="close2"><img src="images/delete_icon.png" alt=""></div>
    <div class="edit_content">
        <div class="item1">
            <div>
                <span>修改分类：</span>
            </div>
        </div>
        <div class="item1">
            <div>
                <span>分类名称：</span>
                <input type="text" class="am-form-field" id="name2" name="categoryName">&nbsp;&nbsp;
                <br/>
                <input type="hidden" id="id2" name="id">
                <button class="am-btn am-btn-default" type="button" id="updatebtn">修改</button>
            </div>
        </div>
    </div>
</div>


<script>

    $(function () {
        $('#add').click(function () {
            $("#modal_view").fadeIn();
            $("#modal_content").fadeIn();
        });
        $('.updatebtn').click(function () {
            var id = $(this).data("id");
            /*在当前页面回显*/
            $.post('${pageContext.request.contextPath}/categoryUpdateUI', {"id": id}, function (data) {
                $("#name2").val(data.categoryName);
                $("#id2").val(data.id);
            }, "json");
            $("#modal_view").fadeIn();
            $("#modal_content2").fadeIn();

        });
        $("#close2").click(function () {
            $("#modal_view").fadeOut();
            $("#modal_content2").fadeOut();
        });

        $("#close").click(function () {
            $("#modal_view").fadeOut();
            $("#modal_content").fadeOut();
        });
        $("#abdicates").click(function () {
            var categoryName = $("#name").val();
            $(window).attr('location', '${pageContext.request.contextPath}/categoryAdd?categoryName=' + categoryName);
        });
        $("#updatebtn").click(function () {
            var id2 = $("#id2").val();
            var categoryName2 = $("#name2").val();
            /*会做跳转*/
            $(window).attr('location', '${pageContext.request.contextPath}/categoryUpdate?id=' + id2 + '&categoryName=' + categoryName2);
        });


    });
    var useMgr = {
        delCate: function (id) {
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/categoryDelete",
                dataType: 'json',
                data: "id=" + id,
                success: function (data) {
                    /*var _data = $.parseJSON(data);*/
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