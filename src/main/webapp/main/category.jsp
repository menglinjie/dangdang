<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html;charset=utf-8" %>
<div class="book_l_border1" id="__FenLeiLiuLan">
    <div class="book_sort_tushu">
        <h2>
            分类浏览
        </h2>

        <!--1级分类开始-->

        <s:iterator value="categories" var="category">
            <div class="bg_old" onmouseover="this.className = 'bg_white';"
                 onmouseout="this.className = 'bg_old';">
                <h3>
                    [<a href='#'><s:property value="#category.cname"></s:property></a>]
                </h3>
                <ul class="ul_left_list">
                    <s:iterator value="#category.categoryList" var="childCategory">
                        <!--2级分类开始-->
                        <li>
                            <a href='book_list.jsp'><s:property value="#childCategory.cname"></s:property> </a>
                        </li>
                        <!--2级分类结束-->
                    </s:iterator>
                </ul>
                <div class="empty_left">
                </div>
            </div>

            <div class="more2">
            </div>
        </s:iterator>

        <!--1级分类结束-->


        <div class="bg_old">
            <h3>
                &nbsp;
            </h3>
        </div>
    </div>
</div>
