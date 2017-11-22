<%@page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>当当图书 – 全球最大的中文网上书店</title>
    <script type="text/javascript" src="../js/prototype-1.6.0.3.js">
    </script>
    <link href="../css/book.css" rel="stylesheet" type="text/css"/>
    <link href="../css/second.css" rel="stylesheet" type="text/css"/>
    <link href="../css/secBook_Show.css" rel="stylesheet" type="text/css"/>
    <link href="../css/list.css" rel="stylesheet" type="text/css"/>
</head>
<body>
&nbsp;

<!-- 头部开始 -->
<%@include file="../common/head.jsp" %>
<!-- 头部结束 -->

<div style="width: 962px; margin: auto;">
    <a href="#"><img src="../images/default/book_banner_081203.jpg" border="0"/> </a>
</div>
<div class='your_position'>
    您现在的位置:&nbsp;
    <a href='/user/newhotBook.action'>当当图书</a> &gt;&gt;
    <font style='color: #cc3300'><strong><s:iterator value="categories" var="category">
        <s:property value="#category.cname"></s:property>
    </s:iterator> </strong> </font>
</div>

<div class="book">

    <!--左栏开始-->
    <div id="left" class="book_left">
        <div id="__fenleiliulan">
            <div class=second_l_border2>
                <h2>
                    分类浏览
                </h2>
                <ul>
                    <li>
                        <div>
                            <div class=second_fenlei>
                                &middot;<a
                                    href="/category/bookList.action?categoryId=<s:property value="categoryId"></s:property>
                    &isPa=0&orderBy=1&pageNow=1&childrenId=<s:property value="categoryId" />">

                                全部</a>&nbsp;(<s:iterator value="categories" var="category">
                                <s:property value="#category.count"></s:property>
                            </s:iterator>)
                            </div>
                        </div>
                    </li>
                    <div class="clear"></div>

                    <!--2级分类开始-->
                    <s:iterator value="categories" var="category">
                        <s:iterator value="#category.categoryList" var="categoryChildren">
                            <li>
                                <div>
                                    <div class=second_fenlei>
                                        &middot;
                                    </div>
                                    <div class=second_fenlei>
                                        <a href="/category/bookList.action?categoryId=<s:property value="categoryId"></s:property>
                    &isPa=1&orderBy=1&pageNow=1&childrenId=<s:property value="#categoryChildren.id" />">
                                            <s:property value="#categoryChildren.cname"></s:property> &nbsp;(<s:property
                                                value="#categoryChildren.count"></s:property>)</a>
                                    </div>
                                </div>
                            </li>
                            <div class="clear"></div>
                        </s:iterator>
                    </s:iterator>

                    <!--2级分类结束-->

                    <li>
                        <div></div>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <!--左栏结束-->

    <!--中栏开始-->
    <div class="book_center">

        <!--图书列表开始-->
        <div id="divRight" class="list_right">

            <div id="book_list" class="list_r_title">
                <div class="list_r_title_text">
                    排序方式
                </div>
                <select onchange='' name='select_order' size='1'
                        class='list_r_title_ml'>
                    <option value="">
                        按上架时间 降序
                    </option>
                </select>
                <div id="divTopPageNavi" class="list_r_title_text3">

                    <!--分页导航开始-->

                    <div class='list_r_title_text3a'>
                        <a name=link_page_next
                           href="/category/bookList.action?categoryId=<s:property value="categoryId"></s:property>
                    &isPa=<s:property value="isPa"></s:property>&orderBy=<s:property value="orderBy"></s:property>
                    &pageNow=<s:property value="pageNow"></s:property>-1&childrenId=<s:property value="childrenId" />">
                            <img src='../images/page_up.gif'/> </a>
                    </div>

                    <div class='list_r_title_text3a'>
                        <img src='../images/page_up_gray.gif'/>
                    </div>

                    <div class='list_r_title_text3b'>
                        第<s:property value="categoryPage.pageNow"></s:property> 页/共<s:property
                            value="categoryPage.totalPageCount"></s:property>页
                    </div>

                    <div class='list_r_title_text3a'>
                        <a name=link_page_next
                           href="/category/bookList.action?categoryId=<s:property value="categoryId"></s:property>
                    &isPa=<s:property value="isPa"></s:property>&orderBy=<s:property value="orderBy"></s:property>
                    &pageNow=<s:property value="pageNow"></s:property>+1&childrenId=<s:property value="childrenId" />">
                            <img src='../images/page_down.gif'/> </a>
                    </div>

                    <div class='list_r_title_text3a'>
                        <img src='../images/page_down_gray.gif'/>
                    </div>

                    <!--分页导航结束-->
                </div>
            </div>

            <!--商品条目开始-->
            <s:iterator value="categoryPage.items" var="ctgr">
                <s:iterator value="#ctgr.bookList" var="book">
                    <div class="list_r_line"></div>
                    <div class="clear"></div>

                    <div class="list_r_list">
							<span class="list_r_list_book"><a name="link_prd_img" href='#'>
								<img src="<s:property value="#book.img" /> "/> </a> </span>
                        <h2>
                            <a name="link_prd_name" href='#'><s:property value="#book.bname"/></a>
                        </h2>
                            <%--<h3>--%>
                            <%--顾客评分：100--%>
                            <%--</h3>--%>
                        <h4 class="list_r_list_h4">
                            作 者:
                            <a href='#' name='作者'><s:property value="#book.author"/></a>
                        </h4>
                        <h4>
                            出版社：
                            <a href='#' name='出版社'><s:property value="#book.publisher"/></a>
                        </h4>
                        <h4>
                            出版时间：<s:property value="#book.publishTime"/>
                        </h4>
                        <h5>
                            <s:property value="#book.brief"/>
                        </h5>
                        <div class="clear"></div>
                        <h6>
                            <span class="del">￥<s:property value="#book.price"/></span>
                            <span class="red">￥<s:property value="#book.ddprice"/></span>
                            节省：<s:property value="#book.price-#book.ddprice"/>
                        </h6>
                        <span class="list_r_list_button">
							<a href="#">
							<img src='../images/buttom_goumai.gif'/> </a>
							<span id="cartinfo"></span>
                </span>
                    </div>
                </s:iterator>
            </s:iterator>

            <%--<div class="clear"></div>--%>

            <%--<div class="clear"></div>--%>
            <%--<div class="list_r_list">--%>
            <%--<span class="list_r_list_book"><a name="link_prd_img" href='#'>--%>
            <%--<img src="../productImages/1.jpg"/> </a> </span>--%>
            <%--<h2>--%>
            <%--<a name="link_prd_name" href='#'>精通JavaEE轻量级框架整合方案</a>--%>
            <%--</h2>--%>
            <%--<h3>--%>
            <%--顾客评分：100--%>
            <%--</h3>--%>
            <%--<h4 class="list_r_list_h4">--%>
            <%--作 者:--%>
            <%--<a href='#' name='作者'>菜鸟</a>--%>
            <%--</h4>--%>
            <%--<h4>--%>
            <%--出版社：--%>
            <%--<a href='#' name='出版社'>人民邮电出版社</a>--%>
            <%--</h4>--%>
            <%--<h4>--%>
            <%--出版时间：2009-01-01--%>
            <%--</h4>--%>
            <%--<h5>--%>
            <%--这是一本好书，描述了Struts、Hibernate和Spring等框架的整合应用！--%>
            <%--</h5>--%>
            <%--<div class="clear"></div>--%>
            <%--<h6>--%>
            <%--<span class="del">￥79</span>--%>
            <%--<span class="red">￥60</span>--%>
            <%--节省：￥19--%>
            <%--</h6>--%>
            <%--<span class="list_r_list_button">--%>
            <%--<a href="#"> --%>
            <%--<img src='../images/buttom_goumai.gif'/> </a>--%>
            <%--<span id="cartinfo3"></span>--%>
            <%--</span>--%>
            <%--</div>--%>

            <!--商品条目结束-->

            <div class="clear"></div>
            <div id="divBottomPageNavi" class="fanye_bottom">
            </div>

        </div>
        <!--图书列表结束-->

    </div>
    <!--中栏结束-->
    <div class="clear"></div>
</div>

<!--页尾开始 -->
<%@include file="../common/foot.jsp" %>
<!--页尾结束 -->
</body>
</html>
