$(document).ready(function () {
    $('#load').click(function () {
        $.ajax({
            url: "basket",
            type: "post",
            success: function (res) {
               ff(res)
            }
        })
    })
})

function ff(res) {
    var products = jQuery.parseJSON(res);
    var str = "<table width=\"100%\">\n" +
        "                                <tr>\n" +
        "                                    <th style=\"width: 10%\">id</th>\n" +
        "                                    <th style=\"width: 30%\">firm</th>\n" +
        "                                    <th style=\"width: 15%\">model</th>\n" +
        "                                    <th style=\"width: 15%\">purpose</th>\n" +
        "                                    <th style=\"width: 15%\">price</th>\n" +
        "                                    <th style=\"width: 15%\">action</th>\n" +
        "                                </tr>";

    $.each(products, function(key, value){

        str = str + ("<tr>\n" +
            "                                        <td style=\"text-align: center\"  id=\"value.product.id\">" + value.product.id + "</td>\n" +
            "                                        <td style=\"text-align: center\" >" + value.product.firm + "</td>\n" +
            "                                        <td style=\"text-align: center\" >" + value.product.model + "</td>\n" +
            "                                        <td style=\"text-align: center\" >" + value.product.purpose + "</td>\n" +
            "                                        <td style=\"text-align: center\" >" + value.product.price + "</td>\n" +
            "                                        <td style=\"text-align: center\" >\n" +
            "                                            <input type=\"button\" value=\"-\" id=\"minus\" onclick=\"minus(" + value.product.id + ")\" />\n" +
            "                                            <label>" + value.count + "</label>\n" +
            "                                            <input type=\"button\" value=\"+\" id=\"plus\" onclick=\"plus(" + value.product.id + ")\" />\n" +
            "                                            <input type=\"button\" value=\"del\" id=\"delete\" onclick=\"del(" + value.product.id + ")\" />\n" +
            "                                        </td>\n" +
            "                                    </tr>");
    })
    str = str + ("<label style=\"margin-left:100px;\">" + "total price:  " + products.product + "</label>" +
        "</table>");
    $('#Items').html(str);
}