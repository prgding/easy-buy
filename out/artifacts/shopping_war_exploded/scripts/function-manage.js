// JavaScript Document
function DeleteUser(id)
{
	if(confirm("确定要删除吗？")) {
		location.href = "/shopping/delete?userid=" + id;
	}
}
function DeleteMsg(id)
{
	if(confirm("确定要删除吗？")) {
		location.href = "/shopping/delete?msgId=" + id;
	}
}