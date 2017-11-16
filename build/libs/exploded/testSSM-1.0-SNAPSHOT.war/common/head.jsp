<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html;charset=utf-8" %>
<link href="../css/book_head090107.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="../js/jquery.cookie.js"></script>
<script type="text/javascript" src="../js/jquerySession.js"></script>
<script type="text/javascript" src="../js/main.js"></script>
<div class="head_container">
    <div class="head_welcome">
        <div class="head_welcome_right">
            <span class="head_welcome_text"> </span>
            <span class="head_welcome_text"> <span class="little_n">
					| <a href="#" name="mydangdang" class="head_black12a">我的当当</a> | <a
                    href="#" name="helpcenter" class="head_black12a" target="_blank">帮助</a>
					| </span> </span>
            <div class="cart gray4012">
                <a href="../cart/cart_list.jsp">购物车</a>
            </div>
        </div>
        <span class="head_toutext" id="logininfo">
			<p id="hide-session" hidden><s:property value="#session.user.id"></s:property></p>
		<b id="huanying">您好<s:property value="#session.user.name"></s:property>,欢迎光临当当网</b>
		&nbsp;<a href="/user/loginout.action" class="b" id="logout-a">登出</a>&nbsp;
		&nbsp;<a href="../user/login_form.jsp" class="b" id="login-a">登录</a>
			|<a href="../user/register_form.jsp" class="b" id="rejister-a">注册</a>&nbsp;
		</span>
    </div>
    <div class="head_head_list">
        <div class="head_head_list_left">
			<span class="head_logo"><a href="#" name="backtobook"><img
                    src="../images/booksaleimg/book_logo.gif"/> </a> </span>
        </div>
        <div class="head_head_list_right">

            <div class="head_head_list_right_b">
            </div>
        </div>
    </div>
    <div class="head_search_div">

    </div>
    <div class="head_search_bg"></div>
</div>
