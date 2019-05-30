/**
 * 
 */
const URI_PREFIX = "http://localhost:8080/UserTravelLog/";
$(document).ready(function() {
	/**
	 * 登录
	 */
	const URI_LOGIN = URI_PREFIX + "user/login";
	const URI_MAIN = URI_PREFIX + "html/main.html";
	$("#login").click(function() {
		let parent = $(this).parent();
		let userAccount = parent.find("#userAccount").val();
		let userPassword = parent.find("#userPassword").val();
		if (userAccount === "") {
			$("#resultHint").text("请输入账号");
		} else if (userPassword === "") {
			$("#resultHint").text("请输入密码");
		} else {
			$.post(URI_LOGIN, {
				userAccount : userAccount,
				userPassword : userPassword,
			}, function(data, status) {
				// 返回的数据示例：
				// {"success":true,"describe":"登录成功","data":{"userId":1,"userName":"纸纷飞","userPhone":"18334706003","userPassword":"6003","userGender":"男","idNo":"598157378","userType":1,"userX":0.0,"userY":0.0,"lastModifyTime":1545888166000,"token":"eyJ0eXAiOiJKV1QiLCJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYiLCJhbGdvcml0aG0iOiJIUzI1NiJ9.eyJ1c2VyUGFzc3dvcmQiOiI2MDAzIiwidXNlclBob25lIjoiMTgzMzQ3MDYwMDMiLCJjdXJyZW50VGltZU1pbGxpcyI6MTU0NTg4ODE3NDQ3MiwidXNlckdlbmRlciI6IueUtyIsInVzZXJUeXBlIjoxLCJ1c2VyTmFtZSI6Iue6uOe6t-mjniIsImlkTm8iOiI1OTgxNTczNzgifQ.ug7A5z882HVgWPvJdVcBG4LeQl8P8vXW2dQt66HDfHs","userType2":{"userTypeId":1,"userTypeName":"超级管理员"},"userAssociateds":null}}
				if (status === "success") {
					let parseData = JSON.parse(data);
					if (parseData.success) {
						$("#resultHint").text("");
						if (typeof (Storage) !== "undefined") {
							sessionStorage.userId = parseData.data.userId;
							sessionStorage.userPortrait = parseData.data.userPortrait;
							sessionStorage.userName = parseData.data.userName;
							sessionStorage.userAccount = parseData.data.userAccount;
							sessionStorage.userQQ = parseData.data.userQQ;
							sessionStorage.userPhone = parseData.data.userPhone;
							sessionStorage.userEmail = parseData.data.userEmail;
							sessionStorage.userPassword = parseData.data.userPassword;
							sessionStorage.userType = parseData.data.userType;
							sessionStorage.userConfidante = parseData.data.userConfidante;
						} else {
							document.cookie = "userId=" + parseData.data.userId;
							document.cookie = "userPortrait=" + parseData.data.userPortrait;
							document.cookie = "userName=" + parseData.data.userName;
							document.cookie = "userAccount=" + parseData.data.userAccount;
							document.cookie = "userQQ=" + parseData.data.userQQ;
							document.cookie = "userPhone=" + parseData.data.userPhone;
							document.cookie = "userEmail=" + parseData.data.userEmail;
							document.cookie = "userPassword=" + parseData.data.userPassword;
							document.cookie = "userType=" + parseData.data.userType;
							document.cookie = "userConfidante=" + parseData.data.userConfidante;
						}
						if (parseData.data.userType < 0) {
							$(location).prop('href', URI_MAIN)
						} else {
							$("#resultHint").text("只要管理员才可以登录后台系统。");
						}
					} else {
						$("#resultHint").text(parseData.describe);
					}
				} else {
					$("#resultHint").text(status + "服务异常");
				}
			});
		}
	});

	/**
	 * 给账号添加用户上次输入的默认值
	 */
	if (typeof (Storage) !== "undefined") {
		$("#userAccount").val(sessionStorage.userAccount);
	} else {
		$("#userAccount").val(getCookie("userAccount"));
	}

	/**
	 * 获取cookie
	 */
	function getCookie(cookieName) {
		let name = cookieName + "=";
		let ca = document.cookie.split(';');
		for (let i = 0; i < ca.length; i++) {
			let c = ca[i].trim();
			if (c.indexOf(name) == 0) {
				return c.substring(name.length, c.length);
			}
		}
		return "";
	}
});
