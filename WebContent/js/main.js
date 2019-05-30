/**
 * 
 */
const URI_PREFIX = "http://localhost:8080/UserTravelLog/";

function deleteTravelLog(travelLogId) {
	$.post(URI_PREFIX + "travelLog/delete", {
		travelLogId : travelLogId + ""
	}, function(data, status) {
		if (status === "success") {
			let parseData = JSON.parse(data);
			if (parseData.success) {
				$("td#" + travelLogId + "TD").hide();
			} else {
				alert(parseData.describe);
			}
		} else {
			alert(status + "服务异常");
		}
	});
}

$(document)
		.ready(
				function() {

					let userId = "";
					let userPortrait = "";
					let userName = "";
					let userAccount = "";
					let userQQ = "";
					let userPhone = "";
					let userEmail = "";
					let userPassword = "";
					let userType = "";
					let userConfidante = "";
					/**
					 * 动态设置高度
					 */
					$(".container-fluid .table-responsive").height($(document).height() - $("#topBanner").height() - 5);

					function formatTime(time) {
						var date = new Date(time);
						var m = (date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes()); // 在小于10的数字前加一个‘0’
						var s = (date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds()); // 在小于10的数字前加一个‘0’
						var formatTime = date.getFullYear() + "年" + (date.getMonth() + 1) + "月" + date.getDate() + "日  " + date.getHours() + ":" + m + ":" + s;
						return formatTime;
					}

					$
							.post(
									URI_PREFIX + "travelLog/dimSelect",
									{
										travelLogId : "",
										travelLogUser : "",
										travelLogTime : "",
										travelLogImg : "",
										travelLogTxt : "",
										travelLogPraise : ""
									},
									function(data, status) {
										if (status === "success") {
											let parseData = JSON.parse(data);
											if (parseData.success) {
												let travelLogs = parseData.data;
												let result = "<tr><td width='25%'></td><td width='25%'></td><td width='25%'></td><td width='25%'></td>";
												for (let i = 0; i < travelLogs.length; i++) {
													let temp = travelLogs[i];
													if (i % 4 === 0) {
														result += "</tr><tr>"
													}
													result += "<td width='25%' id='"
															+ temp.travelLogId
															+ "TD'> <div class='card' style='width: 100%'><img class='card-img-top' src='"
															+ URI_PREFIX
															+ temp.travelLogImg
															+ "' alt='Card image' style='width: 100%; height: 300px;'><div class='card-body'><p class='card-title'><img class='img-thumbnail' src='"
															+ URI_PREFIX + temp.user.userPortrait + "' alt='Head image' style='width: 10%'>&nbsp;&nbsp;&nbsp;" + temp.user.userName
															+ "&nbsp; 发表于 " + formatTime(temp.travelLogTime)
															+ "</p><div class='card'><div class='card-header'><a class='collapsed card-link' data-toggle='collapse' href='#"
															+ temp.travelLogId + "Comment'>" + temp.travelLogTxt + "</a></div><div id='" + temp.travelLogId
															+ "Comment' class='collapse' data-parent='#accordion'>";
													for (let j = 0; j < temp.comments.length; j++) {
														result += "<div class='card-body row'><img class='img-thumbnail' src='"
																+ URI_PREFIX
																+ temp.comments[j].user.userPortrait
																+ "' alt='Head image' style='width: 10%; height: 10%; margin-right: 5%;'><div style='width: 80%'><div><span class='mui-col-sm-6 mui-col-xs-6' style='color: #0062CC; width: 40%;'>"
																+ temp.comments[j].user.userName
																+ "</span><span class='mui-col-sm-6 mui-col-xs-6' style='color: gray; text-align: right; width: 60%;'>"
																+ formatTime(temp.comments[j].commentsTime) + "</span></div><p style='color: #333;'>" + temp.comments[j].commentTxt
																+ "</p></div></div>";
													}
													result += "</div></div><a href='#' class='btn btn-primary' style='width: 100%; margin-top: 10px;' onclick='deleteTravelLog("
															+ temp.travelLogId + ")'>（违规违禁）删除</a></div></div></td>"
												}
												result += "</tr>"
												$("#travelLog .table tbody").html(result);
												// $("#travelLog .table tbody tr td").width($(document).width() / 4);
											} else {
												alert(parseData.describe);
											}
										} else {
											alert(status + "服务异常");
										}
									});
					$("#queryBtn")
							.click(
									function() {
										let requestParam = $("#queryInput").val();
										$
												.post(
														URI_PREFIX + "travelLog/dimSelect",
														{
															travelLogId : requestParam + "",
															travelLogUser : requestParam + "",
															travelLogTime : requestParam + "",
															travelLogImg : requestParam + "",
															travelLogTxt : requestParam + "",
															travelLogPraise : requestParam + ""
														},
														function(data, status) {
															if (status === "success") {
																let parseData = JSON.parse(data);
																if (parseData.success) {
																	let travelLogs = parseData.data;
																	let result = "<tr><td width='25%'></td><td width='25%'></td><td width='25%'></td><td width='25%'></td>";
																	for (let i = 0; i < travelLogs.length; i++) {
																		let temp = travelLogs[i];
																		if (i % 4 === 0) {
																			result += "</tr><tr>"
																		}
																		result += "<td width='25%' id='"
																				+ temp.travelLogId
																				+ "TD'> <div class='card' style='width: 100%'><img class='card-img-top' src='"
																				+ URI_PREFIX
																				+ temp.travelLogImg
																				+ "' alt='Card image' style='width: 100%; height: 300px;'><div class='card-body'><p class='card-title'><img class='img-thumbnail' src='"
																				+ URI_PREFIX
																				+ temp.user.userPortrait
																				+ "' alt='Head image' style='width: 10%'>&nbsp;&nbsp;&nbsp;"
																				+ temp.user.userName
																				+ "&nbsp; 发表于 "
																				+ formatTime(temp.travelLogTime)
																				+ "</p><div class='card'><div class='card-header'><a class='collapsed card-link' data-toggle='collapse' href='#"
																				+ temp.travelLogId + "Comment'>" + temp.travelLogTxt + "</a></div><div id='" + temp.travelLogId
																				+ "Comment' class='collapse' data-parent='#accordion'>";
																		for (let j = 0; j < temp.comments.length; j++) {
																			result += "<div class='card-body row'><img class='img-thumbnail' src='"
																					+ URI_PREFIX
																					+ temp.comments[j].user.userPortrait
																					+ "' alt='Head image' style='width: 10%; height: 10%; margin-right: 5%;'><div style='width: 80%'><div><span class='mui-col-sm-6 mui-col-xs-6' style='color: #0062CC; width: 40%;'>"
																					+ temp.comments[j].user.userName
																					+ "</span><span class='mui-col-sm-6 mui-col-xs-6' style='color: gray; text-align: right; width: 60%;'>"
																					+ formatTime(temp.comments[j].commentsTime) + "</span></div><p style='color: #333;'>"
																					+ temp.comments[j].commentTxt + "</p></div></div>";
																		}
																		result += "</div></div><a href='#' class='btn btn-primary' style='width: 100%; margin-top: 10px;' onclick='deleteTravelLog("
																				+ temp.travelLogId + ")'>（违规违禁）删除</a></div></div></td>"
																	}
																	result += "</tr>"
																	$("#travelLog .table tbody").html(result);
																} else {
																	alert(parseData.describe);
																}
															} else {
																alert(status + "服务异常");
															}
														});
									});
					/**
					 * 禁用右键菜单
					 */
					$(document).bind("contextmenu", function(event) {
						return false;
					});

					/**
					 * 发布广告界面显示
					 */
					$("#publishAD").click(function(event) { // with plugin options $("#input-id").fileinput({ 'showUpload' : false, 'previewFileType' : 'any' });
						$("#publishADModal").show();
					});

					/**
					 * 发布广告界面的文件上传表单显示
					 */
					let travelLogImg = document.getElementById("travelLogImg");
					$("#travelLogImg").on("change", function() {
						if (travelLogImg.files.length < 1) {
							$("#publishADModal .custom-file-label").text("选择文件");
						} else if (travelLogImg.files.length > 1) {
							travelLogImg.files.splice(0, travelLogImg.files.length - 1);
							// $("#publishADModal .custom-file-label").text("最多只能上传一个文件");
							$("#publishADModal .custom-file-label").text(travelLogImg.files[0].name + "");
						} else {
							$("#publishADModal .custom-file-label").text(travelLogImg.files[0].name + "");
						}
					});

					/**
					 * 发布广告界面关闭
					 */
					$("#publishADModal .modal-header .close").click(function(event) {
						$("#publishADModal").hide();
					});

					/**
					 * 发布广告
					 * 
					 * 使用 jQuery 上传带文件的表单时，，因为使用的是 FormData，所以必须在传入 $.ajax 的参数中配置 processData: false。
					 * 
					 * 注意请求的 Content-Type 首部；对参数添加 contentType 字段，将其值设置为 false 即可。如果 jQuery 版本小于 1.6，则手动设置为 multipart/form-data
					 */
					$("#publishADModal .modal-footer .btn").click(function(event) {
						let travelLogTxt = $("#travelLogTxt").val();
						if (travelLogTxt.length <= 0) {
							alert("请输入广告内容");
						} else {
							let data = new FormData();
							data.append("travelLogImg", travelLogImg.files[0]);
							data.append("travelLogUser", userId);
							data.append("travelLogTxt", travelLogTxt);
							$.ajax({
								data : data,
								type : "POST",
								url : URI_PREFIX + "travelLog/publishAD",
								dataType : "json",
								cache : false,
								processData : false,
								contentType : false,
								success : function(data) {
									if (data.success) {
										$("#queryBtn").click();
										$("#publishADModal").hide();
									} else {
										alert(data.describe);
									}
								},
								error : function(error) {
									console.log(error);
								}
							});
						}
					});

					$("#updateInfo").click(function(event) {
						$("#nameInput").val(userName);
						$("#qqInput").val(userQQ);
						$("#phoneInput").val(userPhone);
						$("#emailInput").val(userEmail);
						$("#pwdInput").val(userPassword);
						$("#entryScenicModal").show();
					});

					/**
					 * 录入景区的模态框的关闭按钮单击响应事件
					 */
					$("#entryScenicModal .modal-header .close").click(function(event) {
						$("#entryScenicModal").hide();
					});

					/**
					 * 录入景区的模态框的提交按钮单击响应事件
					 */
					$("#entryScenicModal .modal-footer .btn").click(function(event) {
						userName = $("#nameInput").val();
						userQQ = $("#qqInput").val();
						userPhone = $("#phoneInput").val();
						userEmail = $("#emailInput").val();
						userPassword = $("#pwdInput").val();
						if (userName.length <= 0) {
							alert("请输入姓名");
						} else if (userQQ.length <= 0) {
							alert("请输入QQ");
						} else if (userPhone.length <= 0) {
							alert("请输入手机");
						} else if (userEmail.length <= 0) {
							alert("请输入邮箱");
						} else if (userPassword.length <= 0) {
							alert("请输入密码");
						} else {
							$.post(URI_PREFIX + "user/update", {
								userId : userId,
								userPortrait : userPortrait, // 用户头像
								userName : userName, // 用户姓名
								userAccount : userAccount, // 用户账号
								userQQ : userQQ, // 用户QQ
								userPhone : userPhone, // 用户手机号
								userEmail : userEmail, // 用户邮箱
								userPassword : userPassword, // 用户密码
								userType : userType, // 用户类型【用户类型：1（大于0 ）是普通用户；-1（小于0）是管理员；0是超级管理员。】
								userConfidante : userConfidante
							}, function(data, status) {
								// 返回的数据示例：
								// {"success":true,"describe":"该景区信息录入成功","data":null}
								if (status === "success") {
									let parseData = JSON.parse(data);
									if (parseData.success) {
										$("#userName").text(userName);
										$("#userAccount").text("账号：" + userAccount);
										$("#userQQ").text("QQ：" + userQQ);
										$("#userPhone").text("手机：" + userPhone);
										$("#userEmail").text("邮箱：" + userEmail);
										if (typeof (Storage) !== "undefined") {
											sessionStorage.userId = userId;
											sessionStorage.userPortrait = userPortrait;
											sessionStorage.userName = userName;
											sessionStorage.userAccount = userAccount;
											sessionStorage.userQQ = userQQ;
											sessionStorage.userPhone = userPhone;
											sessionStorage.userEmail = userEmail;
											sessionStorage.userPassword = userPassword;
											sessionStorage.userType = userType;
											sessionStorage.userConfidante = userConfidante;
										} else {
											document.cookie = "userId=" + userId;
											document.cookie = "userPortrait=" + userPortrait;
											document.cookie = "userName=" + userName;
											document.cookie = "userAccount=" + userAccount;
											document.cookie = "userQQ=" + userQQ;
											document.cookie = "userPhone=" + userPhone;
											document.cookie = "userEmail=" + userEmail;
											document.cookie = "userPassword=" + userPassword;
											document.cookie = "userType=" + userType;
											document.cookie = "userConfidante=" + userConfidante;
										}
										$("#entryScenicModal").hide();
									} else {
										alert(parseData.describe);
									}
								} else {
									alert(status + "服务异常");
								}
							});
						}
					});

					/**
					 * 初始用户信息的显示
					 */
					if (typeof (Storage) !== "undefined") {
						userId = sessionStorage.userId;
						userPortrait = sessionStorage.userPortrait;
						userName = sessionStorage.userName;
						userAccount = sessionStorage.userAccount;
						userQQ = sessionStorage.userQQ;
						userPhone = sessionStorage.userPhone;
						userEmail = sessionStorage.userEmail;
						userPassword = sessionStorage.userPassword;
						userType = sessionStorage.userType;
						userConfidante = sessionStorage.userConfidante;
						$("#userName").text(userName);
						$("#userAccount").text("账号：" + userAccount);
						$("#userQQ").text("QQ：" + userQQ);
						$("#userPhone").text("手机：" + userPhone);
						$("#userEmail").text("邮箱：" + userEmail);
					} else {
						userId = getCookie("userId");
						userPortrait = getCookie("userPortrait");
						userName = getCookie("userName");
						userAccount = getCookie("userAccount");
						userQQ = getCookie("userQQ");
						userPhone = getCookie("userPhone");
						userEmail = getCookie("userEmail");
						userPassword = getCookie("userPassword");
						userType = getCookie("userType");
						userConfidante = getCookie("userConfidante");
						$("#userName").text(userName);
						$("#userAccount").text("账号：" + userAccount);
						$("#userQQ").text("QQ：" + userQQ);
						$("#userPhone").text("手机：" + userPhone);
						$("#userEmail").text("邮箱：" + userEmail);
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
