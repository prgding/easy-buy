// JavaScript Document
function Delete(id)
{
	if(confirm("确定要删除吗？")) {
		location.href = "/shopping/delete?userid=" + id;
	}
}