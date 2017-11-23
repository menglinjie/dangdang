<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html;charset=utf-8" %>
<h2>
    编辑推荐
</h2>
<div id=__bianjituijian/danpin>
    <div class=second_c_02>
        <s:iterator value="recommendbooks" var="rb">
            <div class=second_c_02_b1>
                <div class=second_c_02_b1_1>
                    <a href='/book/showBook.action?bookId=
                                <s:property value="#rb.bookid" />' target='_blank'><img src="<s:property value="#rb.img" />" width=70 border=0/> </a>
                </div>

                <div class=second_c_02_b1_2>
                    <h3>
                        <a href='/book/showBook.action?bookId=
                                <s:property value="#rb.bookid" />' target='_blank' title='输赢'><s:property value="#rb.bname"></s:property> </a>
                    </h3>
                    <h4>
                        作者：<s:property value="#rb.author"></s:property> 著
                        <br/>
                        出版社：<s:property value="#rb.publisher"></s:property>&nbsp;&nbsp;&nbsp;&nbsp;出版时间：<s:property
                            value="#rb.publishTime"></s:property>
                    </h4>
                    <h5>
                        简介：<s:property value="#rb.brief"></s:property>
                    </h5>
                    <h6>
                        定价：￥<s:property value="#rb.price"></s:property>&nbsp;&nbsp;当当价：￥<s:property
                            value="#rb.ddprice"></s:property>
                    </h6>
                    <div class=line_xx></div>
                </div>
            </div>
        </s:iterator>

    </div>
</div>
