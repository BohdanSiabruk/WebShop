function minus(id) {
    $.ajax({
        url: "basketMinus",
        data: {minus: 'minus', id: id},
        type: "post",
        success: function (res) {
            ff(res)
        }
    })
}

function plus(id) {
    $.ajax({
        url: "basketPlus",
        data: {plus: 'plus', id: id},
        type: "post",
        success: function (res) {
            ff(res)
        }
    })
}

function addToBasket(id) {
    console.log("add")
    $.ajax({
        url: "basketAdd",
        data: {add: 'add', id: id},
        type: "post",
        success: function (res) {
            ff(res);
        }
    })
}

function del(id) {
    $.ajax({
        url: "basketRemove",
        data: {del: 'delete', id: id},
        type: "post",
        success: function (res) {
            ff(res);
        }
    })
}

function cleanBasket() {
    $.ajax({
        url: "basketClear",
        data: {cleanBasket: 'cleanasket'},
        type: "post",
        success: function (res) {
            ff(res);
        }
    })
}
