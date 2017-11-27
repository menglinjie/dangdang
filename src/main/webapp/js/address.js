$(document).ready(function () {
    console.log("进入js")
    //"下拉列表点击事件"
    $("#address").bind("change", function () {
        alert("change事件")
        console.log($(this).val());
        var addressId = $(this).val();

        $.ajax({
            type: "post",
            url: "/address/get.action",
            data: {
                addressId: addressId
            },
            success: function (address) {
                var ad = JSON.parse(address);
                console.log("请求成功");
                $("#adId").val(ad.id);
                $("#receiveName").val(ad.uname);
                $("#fullAddress").val(ad.address);
                $("#postalCode").val(ad.code1);
                $("#phone").val(ad.phone);
                $("#mobile").val(ad.mobile);
            },
            error: function () {
                console.log("请求失败");
            }
        })
    })

})