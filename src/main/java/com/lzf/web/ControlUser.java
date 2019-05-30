/**
 * 
 */
package com.lzf.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.lzf.entity.User;
import com.lzf.service.IServiceUser;
import com.lzf.util.Const;

/**
 * @author MJCoder
 *
 */
@Controller
@RequestMapping("user")
public class ControlUser {

	@Autowired
	private IServiceUser serviceUser;

	/**
	 * 
	 */
	public ControlUser() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 注册/新增游客
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	@ResponseBody
	private Object insert(HttpServletRequest request) {
		String userPortrait = request.getParameter("userPortrait"); // 用户头像
		String userName = request.getParameter("userName"); // 用户姓名
		String userAccount = request.getParameter("userAccount"); // 用户账号
		String userQQ = request.getParameter("userQQ"); // 用户QQ
		String userPhone = request.getParameter("userPhone"); // 用户手机号
		String userEmail = request.getParameter("userEmail"); // 用户邮箱
		String userPassword = request.getParameter("userPassword"); // 用户密码
		int userType = Integer.parseInt(request.getParameter("userType")); // 用户类型【用户类型：1（大于0 ）是普通用户；-1（小于0）是管理员；0是超级管理员。】
		String userConfidante = request.getParameter("userConfidante"); // 用户类型【用户类型：1（大于0 ）是普通用户；-1（小于0）是管理员；0是超级管理员。】
		User user = new User(0, userPortrait, userName, userAccount, userQQ, userPhone, userEmail, userPassword, userType, userConfidante, null);
		System.out.println("前：" + user);
		int result = serviceUser.insert(user);
		System.out.println("后：" + user);
		DtoPackaging dtoPackaging = null;
		if (result <= 0) {
			if (result == Const.UNIQUE) {
				dtoPackaging = new DtoPackaging(false, "该账号已存在", null);
			} else {
				dtoPackaging = new DtoPackaging(false, "注册失败", null);
			}
		} else {
			dtoPackaging = new DtoPackaging(true, "注册成功", user);
		}
		return dtoPackaging;
	}

	/**
	 * 登录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	private Object login(HttpServletRequest request) {
		String userAccount = request.getParameter("userAccount"); // 用户账号
		String userPassword = request.getParameter("userPassword"); // 用户密码
		System.out.println(userAccount + "；" + userPassword);
		User user = serviceUser.login(userAccount, userPassword);
		DtoPackaging dtoPackaging = null;
		if (user == null) {
			dtoPackaging = new DtoPackaging(false, "登录失败，账号或密码有误。", null);
		} else {
			dtoPackaging = new DtoPackaging(true, "登录成功", user);
		}
		return dtoPackaging;
	}

	/**
	 * 更新用户信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	private Object update(HttpServletRequest request) {
		DtoPackaging dtoPackaging = null;
		try {
			String path = request.getServletContext().getRealPath("upload"); // uploads文件夹位置
			CommonsMultipartResolver cmr = new CommonsMultipartResolver(request.getServletContext());
			if (cmr.isMultipart(request)) {
				MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) (request);
				MultipartFile file = mRequest.getFile("userPortrait");
				String fileName = file.getOriginalFilename(); // 原始名称
				File dir = new File(path, System.currentTimeMillis() + "_" + fileName);// 新文件名
				if (!dir.exists()) { // 如果目标文件所在的目录不存在，则创建父目录
					dir.mkdirs();
				}
				file.transferTo(dir);// 将内存中的数据写入磁盘
				String userPortrait = dir.getAbsolutePath().substring(dir.getAbsolutePath().indexOf("upload")).replace("\\", "/");
				System.out.println(path + " >>> " + userPortrait);
				int userId = Integer.parseInt(request.getParameter("userId")); // 用户头像
				String userName = request.getParameter("userName"); // 用户姓名
				String userAccount = request.getParameter("userAccount"); // 用户账号
				String userQQ = request.getParameter("userQQ"); // 用户QQ
				String userPhone = request.getParameter("userPhone"); // 用户手机号
				String userEmail = request.getParameter("userEmail"); // 用户邮箱
				String userPassword = request.getParameter("userPassword"); // 用户密码
				int userType = Integer.parseInt(request.getParameter("userType")); // 用户类型【用户类型：1（大于0 ）是普通用户；-1（小于0）是管理员；0是超级管理员。】
				String userConfidante = request.getParameter("userConfidante"); // 用户的关键联系人（闺蜜、铁哥们）
				User user = new User(userId, userPortrait, userName, userAccount, userQQ, userPhone, userEmail, userPassword, userType, userConfidante, null);
				int result = serviceUser.update(user);
				if (result <= 0) {
					dtoPackaging = new DtoPackaging(false, "信息修改失败", null);
				} else {
					dtoPackaging = new DtoPackaging(true, "信息修改成功", user);
				}
			} else {
				int userId = Integer.parseInt(request.getParameter("userId")); // 用户头像
				String userPortrait = request.getParameter("userPortrait"); // 用户头像
				String userName = request.getParameter("userName"); // 用户姓名
				String userAccount = request.getParameter("userAccount"); // 用户账号
				String userQQ = request.getParameter("userQQ"); // 用户QQ
				String userPhone = request.getParameter("userPhone"); // 用户手机号
				String userEmail = request.getParameter("userEmail"); // 用户邮箱
				String userPassword = request.getParameter("userPassword"); // 用户密码
				int userType = Integer.parseInt(request.getParameter("userType")); // 用户类型【用户类型：1（大于0 ）是普通用户；-1（小于0）是管理员；0是超级管理员。】
				String userConfidante = request.getParameter("userConfidante"); // 用户的关键联系人（闺蜜、铁哥们）
				User user = new User(userId, userPortrait, userName, userAccount, userQQ, userPhone, userEmail, userPassword, userType, userConfidante, null);
				int result = serviceUser.update(user);
				if (result <= 0) {
					dtoPackaging = new DtoPackaging(false, "信息修改失败", null);
				} else {
					dtoPackaging = new DtoPackaging(true, "信息修改成功", user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return dtoPackaging;
		}
	}

}
