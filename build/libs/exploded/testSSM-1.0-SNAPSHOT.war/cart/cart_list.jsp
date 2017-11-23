<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>当当图书 – 全球最大的中文网上书店</title>
    <link href="../css/book.css" rel="stylesheet" type="text/css"/>
    <link href="../css/second.css" rel="stylesheet" type="text/css"/>
    <link href="../css/secBook_Show.css" rel="stylesheet" type="text/css"/>
    <link href="../css/shopping_vehicle.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../js/jquery-3.0.0.min.js"></script>
    <script type="text/javascript" src="../js/jquery.cookie.js"></script>
    <script type="text/javascript" src="../js/login.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            var bookId = $("#bookId").text();
            var amount = $("#amount").val();
            console.log(bookId);

            function test1() {
                var bookId = this.attr("name");
                console.log(bookId);
            }
            function getamount() {
                var amount = this.val();
                console.log(amount);
            }


        })
    </script>
</head>
</head>
<body>
<br/>
<br/>
<div class="my_shopping">
    <img class="pic_shop" src="../images/pic_myshopping.gif"/>

</div>
<div id="div_choice" class="choice_merch">
    <h2 id="cart_tips">
        您已选购以下商品
    </h2>

    <div class="choice_bord">
        <table class="tabl_buy" id="tbCartItemsNormal">
            <tr class="tabl_buy_title">
                <td class="buy_td_6">
                    <span>&nbsp;</span>
                </td>
                <td>
                    <span class="span_w1">商品名</span>
                </td>
                <td class="buy_td_5">
                    <span class="span_w2">市场价</span>
                </td>
                <td class="buy_td_4">
                    <span class="span_w3">当当价</span>
                </td>
                <td class="buy_td_1">
                    <span class="span_w2">数量</span>
                </td>
                <td class="buy_td_2">
                    <span>变更数量</span>
                </td>
                <td class="buy_td_1">
                    <span>删除</span>
                </td>
            </tr>
            <tr class='objhide' over="no">
                <td colspan="8">
                    &nbsp;
                </td>
            </tr>
            <s:iterator value="#session.cart.map">
                <!-- 购物列表开始 -->
                <tr class='td_no_bord'>
                    <td style='display: none'>
                        9317290
                    </td>
                    <td class="buy_td_6">
                        <span class="objhide"><img/> </span>
                    </td>
                    <td>
                        <a id="update" href="/book/showBook.action?bookId=
                                <s:property value="value.book.bookid" />"><s:property
                                value="value.book.bname"></s:property> </a>
                    </td>
                    <td class="buy_td_5">
                        <span class="c_gray"><s:property value="value.book.price"></s:property></span>
                    </td>
                    <td class="buy_td_4">
                        &nbsp;&nbsp;
                        <span>￥<s:property value="value.book.ddprice"></s:property></span>
                    </td>
                    <td class="buy_td_1">
                        &nbsp;&nbsp;<s:property value="value.amount"></s:property>
                    </td>

                    <td>
                            <%--<p id="bookId" style="display: none"><s:property value='value.book.bookid'/></p>--%>
                        <input class="del_num" type="text" size="3" maxlength="4"
                               value="<s:property value="value.amount" /> " name="amount" id="amount"
                               onblur="getamount(this)"/>
                        <a href="#" id="bian" name="<s:property value='value.book.bookid'/>"
                           onclick="test1(this)">变更</a>
                    </td>
                    <td>
                        <a href="#">删除</a>
                    </td>
                </tr>

                <!-- 购物列表结束 -->
            </s:iterator>
        </table>
        <div id="div_no_choice" class="objhide">
            <div class="choice_title"></div>
            <div class="no_select">
                您还没有挑选商品
            </div>
        </div>
        <div class="choice_balance">
            <div class="select_merch">
                <a href='/user/newhotBook.action'> 继续挑选商品>></a>
            </div>
            <div class="total_balance">
                <div class="save_total">
                    <%--您共节省：--%>
                    <%--<span class="c_red"> ￥<span id="total_economy">56</span>--%>
                    <%--</span>--%>
                    <%--<span id='total_vip_economy' class='objhide'> ( 其中享有优惠： <span--%>
                    <%--class="c_red"> ￥<span id='span_vip_economy'>0.00</span> </span>--%>
                    <%--) </span>--%>
                    <%--<span style="font-size: 14px">|</span>--%>
                    <span class="t_add">商品金额总计：</span>
                    <span class="c_red_b"> ￥<span id='total_account'><s:property
                            value="#session.cart.totalprice"/></span>
							</span>
                </div>
                <div id="balance" class="balance">
                    <a name='checkout' href='../order/order_info.jsp'>
                        <img src="../images/butt_balance.gif" alt="结算" border="0" title="结算"/>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 用户删除恢复区 -->


<div id="divCartItemsRemoved" class="del_merch">
    <div class="del_title">
        您已删除以下商品，如果想重新购买，请点击“恢复”
    </div>
    <table class=tabl_del id=del_table>
        <tbody>


        <tr>
            <td width="58" class=buy_td_6>
                &nbsp;
            </td>
            <td width="365" class=t2>
                <a href="#">Java基础</a>
            </td>
            <td width="106" class=buy_td_5>
                ￥56
            </td>
            <td width="134" class=buy_td_4>
                <span>￥50</span>
            </td>
            <td width="56" class=buy_td_1>
                <a href="#">恢复</a>
            </td>
            <td width="16" class=objhide>
                &nbsp;
            </td>
        </tr>


        <tr class=td_add_bord>
            <td colspan=8>
                &nbsp;
            </td>
        </tr>


        </tbody>
    </table>
</div>
<br/>
<br/>
<br/>
<br/>
<!--页尾开始 -->
<%@include file="../common/foot.jsp" %>
<!--页尾结束 -->
</body>
</html>



