// JavaScript Document
function DeleteUser(id) {
    if (confirm("确定要删除吗？")) {
        location.href = "/shopping/shop/delete?userId=" + id;
    }
}

function DeleteMsg(id) {
    if (confirm("确定要删除吗？")) {
        location.href = "/shopping/shop/delete?msgId=" + id;
    }
}