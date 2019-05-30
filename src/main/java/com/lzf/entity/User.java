/**
 * 
 */
package com.lzf.entity;

import java.util.List;

/**
 * @author MJCoder
 *
 *         用户表：目前主要有普通用户和管理员两大类
 */
public class User {
	private int userId; // 用户Id
	private String userPortrait; // 用户头像
	private String userName; // 用户姓名
	private String userAccount; // 用户账号
	private String userQQ; // 用户QQ
	private String userPhone; // 用户手机号
	private String userEmail; // 用户邮箱
	private String userPassword; // 用户密码
	private int userType; // 用户类型【用户类型：1（大于0 ）是普通用户；-1（小于0）是管理员；0是超级管理员。】
	private String userConfidante; // 用户的关键联系人（闺蜜、铁哥们）
	private List<Attention> attentions; // 关注了那些用户

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String userPortrait, String userName, String userAccount, String userQQ, String userPhone, String userEmail, String userPassword, int userType,
			String userConfidante, List<Attention> attentions) {
		super();
		this.userId = userId;
		this.userPortrait = userPortrait;
		this.userName = userName;
		this.userAccount = userAccount;
		this.userQQ = userQQ;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userType = userType;
		this.userConfidante = userConfidante;
		this.attentions = attentions;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserPortrait() {
		return userPortrait;
	}

	public void setUserPortrait(String userPortrait) {
		this.userPortrait = userPortrait;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserQQ() {
		return userQQ;
	}

	public void setUserQQ(String userQQ) {
		this.userQQ = userQQ;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getUserConfidante() {
		return userConfidante;
	}

	public void setUserConfidante(String userConfidante) {
		this.userConfidante = userConfidante;
	}

	public List<Attention> getAttentions() {
		return attentions;
	}

	public void setAttentions(List<Attention> attentions) {
		this.attentions = attentions;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPortrait=" + userPortrait + ", userName=" + userName + ", userAccount=" + userAccount + ", userQQ=" + userQQ + ", userPhone="
				+ userPhone + ", userEmail=" + userEmail + ", userPassword=" + userPassword + ", userType=" + userType + ", userConfidante=" + userConfidante + ", attentions="
				+ attentions + "]";
	}

}
