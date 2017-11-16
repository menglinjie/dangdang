//文档开始
$(document).ready(function () {
    var userId = $("#hide-session").text();
    console.log(userId);
    if (userId == "") {//用户未登录
        $("#logout-a").hide();//隐藏“登出”
        $("#huanying").hide();//隐藏欢迎语句
        $("#login-a").show();
        $("#rejister-a").show();
    } else {
        $("#login-a").hide();//隐藏登录
        $("#rejister-a").hide();
        $("#logout-a").show();//显示登出
        $("#huanying").show();//显示欢迎语句
    }
})