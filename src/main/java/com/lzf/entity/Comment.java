/**
 * 
 */
package com.lzf.entity;

import java.sql.Timestamp;

/**
 * @author MJCoder
 *
 */
public class Comment {
	private int commentId; // 评论ID
	private int commentUser; // 发表该评论的用户
	private Timestamp commentsTime; // 发布评论的时间
	private String commentTxt; // 评论文本
	private int commentsTravelLog; // 评论的是那条旅游日志的记录
	private User user;

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int commentId, int commentUser, Timestamp commentsTime, String commentTxt, int commentsTravelLog, User user) {
		super();
		this.commentId = commentId;
		this.commentUser = commentUser;
		this.commentsTime = commentsTime;
		this.commentTxt = commentTxt;
		this.commentsTravelLog = commentsTravelLog;
		this.user = user;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getCommentUser() {
		return commentUser;
	}

	public void setCommentUser(int commentUser) {
		this.commentUser = commentUser;
	}

	public Timestamp getCommentsTime() {
		return commentsTime;
	}

	public void setCommentsTime(Timestamp commentsTime) {
		this.commentsTime = commentsTime;
	}

	public String getCommentTxt() {
		return commentTxt;
	}

	public void setCommentTxt(String commentTxt) {
		this.commentTxt = commentTxt;
	}

	public int getCommentsTravelLog() {
		return commentsTravelLog;
	}

	public void setCommentsTravelLog(int commentsTravelLog) {
		this.commentsTravelLog = commentsTravelLog;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentUser=" + commentUser + ", commentsTime=" + commentsTime + ", commentTxt=" + commentTxt + ", commentsTravelLog="
				+ commentsTravelLog + ", user=" + user + "]";
	}
}
