//文档开始
$(document).ready(function () {
    //页面状态 0：正在对输入内容进行检验 1：检验完成，可以注册 -1：有错误，请进行修改
    var status = -1;

    //获取“邮箱”输入框焦点
    $("#txtUsername").focus();

    //“邮箱”输入框焦点丢失事件
    $("#txtUsername").blur(function () {

        var email = $("#txtUsername").val();
        var myReg = /^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
        console.log(email);
        if (email == "") {
            console.log("email为空");
            $("#divErrorMssage").text("电子邮件不能为空");
            status = -1;
        } else if (!myReg.test(email)) {
            console.log("email错误");
            $("#divErrorMssage").text("电子邮件地址格式错误");
            status = -1;
        } else {
            $("#divErrorMssage").empty();
            status = 1;
        }
    })

    //"登录"按钮点击事件
    $("#btnSignCheck").click(function () {
        if (status == -1) {
            alert("邮箱输入有误，请修改后再进行注册！");
            return false;//阻止表单提交
        } else {
            $("#divErrorMssage").empty();
            console.log("检测通过，正在注册...")
        }
    })
})