// JavaScript Document

let ContextPath = "/easy-buy";
function DeleteUser(id) {
    if (confirm("确定要删除吗？")) {
        location.href = ContextPath + "/shop/delete?userId=" + id;
    }
}

function DeleteMsg(id) {
    if (confirm("确定要删除吗？")) {
        location.href = ContextPath + "/shop/delete?msgId=" + id;
    }
}