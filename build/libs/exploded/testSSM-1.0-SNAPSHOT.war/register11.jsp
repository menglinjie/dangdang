<%@  page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <script type="text/javascript">
        var flag = false;

        function checkemail() {
            //判断邮箱是否合法
            var email = document.getElementById("email");
            //用户输入的邮箱值
            var value = email.value;

            var span = document.getElementById("nameMsg");
            if (value == null || value == "" || value.indexOf("@") == -1 || value.indexOf(".") == -1) {
                span.innerHTML = "<font  color='red'>您的邮箱格式不合法</font>";
                flag = false;
            } else {
                span.innerHTML = "<font  color='green'>您的邮箱合法</font>";
                flag = true;
            }
        }

        function checkm() {
            if (flag == true) {
                var email = document.getElementById("email");
                //用户输入的邮箱
                var value = email.value;
                var xhr
                if (window.ActiveXObject) {
                    xhr = new ActiveXObject("Microsoft.XMLHTTP");
                } else {
                    xhr = new XMLHttpRequest();
                }
                //ajax发送请求
                //发起请求
                xhr.open("Get", "/ZhengDaTeam/check/user?email=" + value);
                xhr.send(null);

                //3 监听响应
                xhr.onreadystatechange = function () {
                    if (xhr.readyState == 4 && xhr.status == 200) {
                        var f = xhr.responseText;
                        var span = document.getElementById("nameMsg");

                        if (f == "false") {
                            span.innerHTML = "<font  color='green'>您的邮箱合法</font>";
                        } else {
                            span.innerHTML = "<font  color='red'>您的邮箱已存在</font>";
                        }
                    }
                }
            }
        }

        function checkpassword() {
            var password = document.getElementById("password");
            var value = password.value;
            var span = document.getElementById("passwordMsg");
            if (value.length != 8 || value == null || value == "") {
                span.innerHTML = "<font color='red'>您的密码不合法</font>";
            } else {
                span.innerHTML = "<font  color='green'>您的密码合法</font>";
            }
        }

        function AllAddress() {
            var xhr;
            if (window.ActiveXObject) {
                xhr = new ActiveXObject("Microsoft.XMLHTTP");
            } else {
                xhr = new XMLHttpRequest();
            }
            xhr.open("get", "/ZhengDaTeam/check/AllAddress");
            xhr.send(null);
            //3 监听响应
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    //JSON串转JSON对象
                    var addresses = JSON.parse(xhr.responseText);
                    for (var i = 0; i < addresses.length; i++) {
                        var address = document.getElementById("address");
                        var option = document.createElement("option");
                        option.value = addresses[i].id;
                        var textnode = document.createTextNode(addresses[i].addressName);
                        option.appendChild(textnode);
                        address.appendChild(option);
                    }
                    var as = addresses[0].addresses;
                    for (var j = 0; j < as.length; j++) {
                        var city = document.getElementById("city");
                        var option = document.createElement("option");
                        var textnode = document.createTextNode(as[j].addressName);
                        option.appendChild(textnode);
                        city.appendChild(option);
                    }


                }
            }
        }

        function changecity() {
            var address = document.getElementById("address");
            var addressid = address.options[address.selectedIndex].value;
            var xhr;
            if (window.ActiveXObject) {
                xhr = new ActiveXObject("Microsoft.XMLHTTP");
            } else {
                xhr = new XMLHttpRequest();
            }
            xhr.open("get", "/ZhengDaTeam/check/selectByID?parentid=" + addressid);
            xhr.send(null);
            xhr.onreadystatechange = function () {
                if (xhr.status == 200 & xhr.readyState == 4) {
                    var addresses = JSON.parse(xhr.responseText);
                    var city = document.getElementById("city");
                    city.innerHTML = "";
                    for (var i = 0; i < addresses.length; i++) {

                        var option = document.createElement("option");
                        option.value = addresses[i].id;
                        var text = document.createTextNode(addresses[i].addressName);
                        option.appendChild(text);
                        city.appendChild(option);
                    }
                }
            }
        }

        function change() {
            var img = document.getElementById("img");
            img.src = "${pageContext.request.contextPath}/check/validatecode?a" + Math.random();
        }

        function divIn(event) {
            var img = event.target;
            img.style.cursor = "pointer"
            var zoom = document.getElementById("zoom");
            var zoomImg = document.getElementById("f");
            zoomImg.src = img.src;
            zoom.style.display = "block";
            zoom.style.position = "absolute";
            zoom.style.top = event.clientY + 20;
            zoom.style.left = event.clientX + 20;
            zoom.style.zIndex = 3;
        }

        function divOut(event) {
            var div = event.target;
            div.style.cursor = null;
            var zoom = document.getElementById("zoom");
            zoom.style.display = "none";
        }
    </script>
</head>
<body onload="AllAddress()">
邮箱 <input id="email" name="email" onblur="checkm()" onkeyup="checkemail()" type="text"/><span id="nameMsg">   </span>
<br/>
密码 <input id="password" name="password" onkeyup="checkpassword()" type="password"/><span id="passwordMsg"></span><br/>
地址 <select id="address" onchange="changecity()">
</select>
<select id="city">
</select>
<br/>
性别 男<input type="radio" name="sex" checked="checked" value="male"/> 女<input name="sex" type="radio"
                                                                            value="female"/><br/>
请输入验证码 <input type="text" name="verify"><img onmouseover="divIn(event)" onmouseout="divOut(event)"
                                             onmousemove="divIn(event)" id="img"
                                             src="images/book_no6.gif" alt="">"/> <a
        href="javascript:void(0)" onclick="change()">看不清，换一张</a>
<div id="zoom">
    <img id="f" width="240">
</div>
<br/>
<input type="submit" value="注册"/>
</body>
</html>