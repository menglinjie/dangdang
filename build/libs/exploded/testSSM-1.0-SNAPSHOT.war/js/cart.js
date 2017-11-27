$(document).ready(function () {
    var mount;
    var bookId;
    $(".del_num").blur(function () {
        mount = $(this).val();
        console.log($(this));
    })

    //"变更"点击事件
    $(".biangeng").click(function () {
        bookId = $(this).attr("name");//var bookId1 = $(this).prop("name");
        $.ajax({
            type: "post",
            url: "/cart/update.action",
            data: {
                amount: mount,
                bookId: bookId
            },
            success: function () {
                window.location.href = "/cart/cart_list.jsp";
                console.log("请求成功");

            },
            error: function () {
                console.log("请求失败");
            }
        })
    })

    //"删除"点击事件
    $(".shanchu").click(function () {
        bookId = $(this).attr("name");//获取bookId
        $.ajax({
            type: "post",
            url: "/cart/delete.action",
            data: {
                bookId: bookId
            },
            success: function () {
                window.location.href = "/cart/cart_list.jsp";
                console.log("请求成功");

            },
            error: function () {
                console.log("请求失败");
            }
        })
    })

    //"恢复"点击事件
    $(".huifu").click(function () {
        bookId = $(this).attr("name");//获取bookId
        $.ajax({
            type: "post",
            url: "/cart/recover.action",
            data: {
                bookId: bookId
            },
            success: function () {
                window.location.href = "/cart/cart_list.jsp";
                console.log("请求成功");

            },
            error: function () {
                console.log("请求失败");
            }
        })
    })
})