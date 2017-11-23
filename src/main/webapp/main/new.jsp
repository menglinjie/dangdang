<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html;charset=utf-8" %>
<h2>
    <span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">

    <s:iterator value="newbooks" var="nb">
        <!--热销图书A开始-->
        <div class="second_d_wai">
            <div class="img">
                <a href="/book/showBook.action?bookId=
                                <s:property value="#nb.bookid" />" target='_blank'><img
                        src="<s:property value="#nb.img" />" border=0/> </a>
            </div>
            <div class="shuming">
                <a href="/book/showBook.action?bookId=
                                <s:property value="#nb.bookid" />" target="_blank"><s:property value="#nb.bname"/></a><a href="#" target="_blank"></a>
            </div>
            <div class="price">
                定价：￥<s:property value="#nb.price"/>
            </div>
            <div class="price">
                当当价：￥<s:property value="#nb.ddprice"/>
            </div>
        </div>
        <div class="book_c_xy_long"></div>
        <!--热销图书A结束-->
    </s:iterator>
</div>
<div class="clear"></div>