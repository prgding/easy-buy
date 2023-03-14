// JavaScript Document
window.onload = function () {
	showChater();
	scrollChater();
}
window.onscroll = scrollChater;
window.onresize = scrollChater;

function FocusItem(obj) {
	obj.parentNode.parentNode.className = "current";
	var msgBox = obj.parentNode.getElementsByTagName("span")[0];
	msgBox.innerHTML = "";
	msgBox.className = "";
}

function CheckItem(obj) {
	obj.parentNode.parentNode.className = "";
	var msgBox = obj.parentNode.getElementsByTagName("span")[0];
	switch (obj.name) {
		case "userName":
			if (obj.value == "") {
				msgBox.innerHTML = "用户名不能为空";
				msgBox.className = "error";
				return false;
			}
			break;
		case "passWord":
			if (obj.value == "") {
				msgBox.innerHTML = "密码不能为空";
				msgBox.className = "error";
				return false;
			}
			break;
		case "rePassWord":
			if (obj.value == "") {
				msgBox.innerHTML = "确认密码不能为空";
				msgBox.className = "error";
				return false;
			} else if (obj.value != document.getElementById("passWord").value) {
				msgBox.innerHTML = "两次输入的密码不相同";
				msgBox.className = "error";
				return false;
			}
			break;
		case "veryCode":
			if (obj.value == "") {
				msgBox.innerHTML = "验证码不能为空";
				msgBox.className = "error";
				return false;
			}
			break;
	}
	return true;
}

function checkUsernameDuplicate(obj) {
	// 发送Ajax请求，检查用户名是否已经存在
	var username = obj.value;
	var url = "account/checkIfExists?userName=" + username;
	var xmlHttpRequest = new XMLHttpRequest();
	xmlHttpRequest.onreadystatechange = function () {
		if (xmlHttpRequest.readyState == 4) {
			if (xmlHttpRequest.status == 200) {
				var msgBox = obj.parentNode.getElementsByTagName("span")[0];
				if (xmlHttpRequest.responseText === "用户名已存在") {
					msgBox.innerHTML = "用户名已存在";
					msgBox.className = "error";
				} else {
					msgBox.innerHTML = "用户名可用";
					msgBox.className = "success";
				}
			} else {
				console.log(xmlHttpRequest.status);
			}
		}
	}
	xmlHttpRequest.open("GET", url, true);
	xmlHttpRequest.send();
}

function checkForm(frm) {
	var els = frm.getElementsByTagName("input");
	for (var i = 0; i < els.length; i++) {
		if (typeof (els[i].getAttribute("onblur")) == "function") {
			if (!CheckItem(els[i])) return false;
		}
	}
	return true;
}

function showChater() {
	var _chater = document.createElement("div");
	_chater.setAttribute("id", "chater");
	var _dl = document.createElement("dl");
	var _dt = document.createElement("dt");
	var _dd = document.createElement("dd");
	var _a = document.createElement("a");
	_a.setAttribute("href", "#");
	_a.onclick = openRoom;
	_a.appendChild(document.createTextNode("在线聊天"));
	_dd.appendChild(_a);
	_dl.appendChild(_dt);
	_dl.appendChild(_dd);
	_chater.appendChild(_dl);
	document.body.appendChild(_chater);
}

function openRoom() {
	window.open("chat-room.html", "chater", "status=0,scrollbars=0,menubar=0,location=0,width=600,height=400");
}

function scrollChater() {
	var chater = document.getElementById("chater");
	var scrollTop = document.documentElement.scrollTop;
	var scrollLeft = document.documentElement.scrollLeft;
	chater.style.left = scrollLeft + document.documentElement.clientWidth - 92 + "px";
	chater.style.top = scrollTop + document.documentElement.clientHeight - 25 + "px";
}