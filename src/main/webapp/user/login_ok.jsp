<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>用户注册 - 当当网</title>
    <link href="../css/login.css" rel="stylesheet" type="text/css"/>
    <link href="../css/page_bottom.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../js/jquery-3.0.0.min.js"></script>
    <script type="text/javascript" src="../js/jquery.cookie.js"></script>
    <script type="text/javascript" src="../js/jquerySession.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {

            //倒计时跳转
            $(document).ready(function () {
                function jump(count) {
                    window.setTimeout(function () {
                        count--;
                        if (count > 0) {
                            $('#h6').html("页面将在" + count + "秒后转回：http://localhost:8080/address/getAll.action" +
                                "，如果转入失败，请单击");
                            $("#h6").append("<a href='/address/getAll.action'>这里</a>");
                            jump(count);
                        } else {
                            location.href = "http://localhost:8080/address/getAll.action";
                        }
                    }, 1000);
                }

                jump(4);
            });
        })
    </script>
</head>
<body>
<%@include file="../common/head1.jsp" %>

<div class="login_success">
    <div class="login_bj">
        <div class="succ">
            <img src="${pageContext.request.contextPath}/images/login_success.jpg"/>
        </div>
        <h5 id="h5">
            <s:property value="#session.user.name"/>，您已经成功登录
        </h5>
        <h6 id="h6">
            <a href="${pageContext.request.contextPath}/order/address_form.jsp"></a>
        </h6>
    </div>
</div>

<%@include file="../common/foot1.jsp" %>
</body>
</html>

