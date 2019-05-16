var onoff = true//根据此布尔值判断当前为注册状态还是登录状态
var confirm = document.getElementsByClassName("confirm")[0]
var user = document.getElementById("user")
var passwd = document.getElementById("passwd")
var con_pass = document.getElementById("confirm-passwd")

//自动居中title
var name_c = document.getElementById("title")
var name = name_c.innerHTML.split("")
name_c.innerHTML = ""
for (i = 0; i < name.length; i++)
    if (name[i] != ",")
        name_c.innerHTML += "<i>" + name[i] + "</i>"
//引用hint()在最上方弹出提示

//注册按钮
function signin() {
    window.location.href = "http://localhost:8080/toRegister";
}
