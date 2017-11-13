//文档开始
$(document).ready(function () {

    //页面状态 0：正在对输入内容进行检验 1：检验完成，可以注册 -1：有错误，请进行修改
    var status = -1;

    //获取“邮箱”输入框焦点
    $("#txtEmail").focus();

    //“邮箱”输入框焦点丢失事件
    $("#txtEmail").blur(function () {

        var email = $("#txtEmail").val();
        var myReg = /^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
        if (email == "") {
            console.log("email为空");
            $("#emailinfo").text("电子邮件不能为空");
            status = -1;
        } else if (!myReg.test(email)) {
            console.log("email错误");
            $("#emailinfo").text("电子邮件地址格式错误");
            status = -1;
        } else {
            status = 0;
            $("#emailinfo").text("正在检测邮件可用性...");
            $.ajax({
                type: "post",
                url: "checkEmail.action",
                data: {
                    email: email
                },
                dataType: "text",
                success: function (da) {
                    console.log(da);
                    if (da == '1') {
                        $("#emailinfo").empty();
                        $("#emailinfo").text("电子邮件地址可用");
                        $("#emailinfo").attr("style", "color:green");
                        $.cookie("email", email);
                        status = 1;
                    }
                    if (da == '0') {
                        $("#emailinfo").text("抱歉，邮件地址已经被使用");
                        status = -1;
                    }
                },
                error: function () {
                    console.log("请求失败");
                    status = -1;
                }
            })

        }
    })

    //"昵称"输入框焦点丢失事件
    $("#txtNickName").blur(function () {
        var nickName = $("#txtNickName").val();
        var myName = /^[a-zA-Z0-9\u4e00-\u9fa5]{4,20}$/;//由英文、汉字或者数字组成
        var nameinfo = $("#nameinfo");

        if (nickName == "") {
            nameinfo.text("昵称不能为空");
            nameinfo.attr("style", "color:red");
            status = -1;
        } else if (!myName.test(nickName)) {
            nameinfo.text("昵称格式不正确");
            nameinfo.attr("style", "color:red");
            status = -1;
        } else {
            nameinfo.empty();
            nameinfo.text("昵称合法");
            nameinfo.attr("style", "color:green");
            status = 1;
        }
    })

    //“密码”输入框焦点丢失事件
    $("#txtPassword").blur(function () {
        var password = $("#txtPassword").val();//密码
        var myPass = /^[a-zA-Z0-9]{4,20}$/;
        var passinfo = $("#passwordinfo");//密码span

        console.log(password);
        if (password == "") {
            passinfo.text("密码不能为空");
            passinfo.attr("style", "color:red");
            status = -1;
        } else if (!myPass.test(password)) {
            passinfo.text("密码格式不正确");
            passinfo.attr("style", "color:red");
            status = -1;
        } else {
            passinfo.empty();
            passinfo.text("密码合法");
            passinfo.attr("style", "color:green");
            status = 1;
        }
    })

    //"重复密码"输入框焦点丢失事件
    $("#txtRepeatPass").blur(function () {
        var repass = $("#txtRepeatPass").val();//重复密码
        var pass = $("#txtPassword").val();//密码
        var pass1info = $("#password1info");

        if (repass == "") {
            pass1info.text("重复密码不能为空");
            pass1info.attr("style", "color:red");
            status = -1;
        } else if (repass == pass) {
            pass1info.text("重复密码与密码相同");
            pass1info.attr("style", "color:green");
            status = -1;
        } else {
            pass1info.text("重复密码与密码不相同");
            pass1info.attr("style", "color:red");
            status = 1;
        }
    })

    //"验证码"输入框焦点丢失事件
    $("#txtVerifyCode").blur(function () {
        var VerifyCode = $("#txtVerifyCode").val();//验证码
        var myCode = /^\d{4}$/;
        var numberinfo = $("#numberinfo");

        console.log(VerifyCode);

        if (VerifyCode == "") {
            numberinfo.text("验证码不能为空");
            numberinfo.attr("style", "color:red");
            status = -1;
        } else if (!myCode.test(VerifyCode)) {
            numberinfo.text("验证码格式错误");
            numberinfo.attr("style", "color:red");
            status = -1;
        } else {
            status = 0;
            numberinfo.text("正在检测验证码...");
            numberinfo.attr("style", "color:red");
            $.ajax({
                type: "post",
                url: "/image/checkImg.action",
                data: {
                    number: VerifyCode
                },
                dataType: "text",
                success: function (da) {
                    console.log(da);
                    if (da == '1') {
                        numberinfo.empty();
                        numberinfo.text("验证码正确");
                        numberinfo.attr("style", "color:green");
                        status = 1;
                    }
                    if (da == '0') {
                        numberinfo.text("验证码错误");
                        numberinfo.attr("style", "color:red");
                        status = -1;
                    }
                },
                error: function () {
                    console.log("请求失败");
                    status = -1;
                }
            })
        }
    })

    //验证码刷新
    $("#imgVcode").click(function () {
        $("#imgVcode").attr('src', "/image/imgCode.action?timestamp=" + new Date().getTime());
    })

    $("#codeFl").click(function () {
        $("#imgVcode").attr('src', "/image/imgCode.action?timestamp=" + new Date().getTime());
    })

    //"注册提交"按钮点击事件
    $("#btnClientRegister").click(function () {
        if (status == -1) {

            //history.go(-1);
            alert("输入有误，请修改后再进行注册！");
            return false;//阻止表单提交
        } else if (status == 0) {
            alert("正在进行检测，请稍后再注册！");
            return false;
        } else {
            console.log("检测通过，正在注册...")
        }
    })

    //获取cookie内邮箱地址
    $("#lblEmail").text($.cookie("email"));

})