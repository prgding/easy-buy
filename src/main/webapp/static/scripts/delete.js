// JavaScript Document

let ContextPath = "/easy-buy";
function DeleteUser(id) {
    if (confirm("确定要删除账户吗？")) {
        location.href = ContextPath + "/user/deleteUser?userId=" + id;
    }
}

function DeleteMsg(id) {
    if (confirm("确定要删除留言吗？")) {
        location.href = ContextPath + "/msg/deleteMsg?msgId=" + id;
    }
}