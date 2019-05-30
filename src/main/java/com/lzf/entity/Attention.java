/**
 * 
 */
package com.lzf.entity;

/**
 * @author MJCoder
 *
 */
public class Attention {
	private int attentionId;
	private int userSelf; // 用户自己
	private int attentionUser; // 关注的用户

	public Attention() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Attention(int attentionId, int userSelf, int attentionUser) {
		super();
		this.attentionId = attentionId;
		this.userSelf = userSelf;
		this.attentionUser = attentionUser;
	}

	public int getAttentionId() {
		return attentionId;
	}

	public void setAttentionId(int attentionId) {
		this.attentionId = attentionId;
	}

	public int getUserSelf() {
		return userSelf;
	}

	public void setUserSelf(int userSelf) {
		this.userSelf = userSelf;
	}

	public int getAttentionUser() {
		return attentionUser;
	}

	public void setAttentionUser(int attentionUser) {
		this.attentionUser = attentionUser;
	}

	@Override
	public String toString() {
		return "Attention [attentionId=" + attentionId + ", userSelf=" + userSelf + ", attentionUser=" + attentionUser + "]";
	}

}
