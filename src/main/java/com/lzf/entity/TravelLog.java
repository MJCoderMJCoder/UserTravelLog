/**
 * 
 */
package com.lzf.entity;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author MJCoder
 *
 */
public class TravelLog {
	private int travelLogId; // 旅游日志ID
	private int travelLogUser; // 发布该旅游日志的用户
	private Timestamp travelLogTime; // 旅游日志发布时间
	private String travelLogImg; // 旅游日志的图片
	private String travelLogTxt; // 旅游日志的文本
	private int travelLogPraise; // 旅游日志的点赞数
	private User user;
	private List<Comment> comments;

	public TravelLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TravelLog(int travelLogId, int travelLogUser, Timestamp travelLogTime, String travelLogImg, String travelLogTxt, int travelLogPraise, User user,
			List<Comment> comments) {
		super();
		this.travelLogId = travelLogId;
		this.travelLogUser = travelLogUser;
		this.travelLogTime = travelLogTime;
		this.travelLogImg = travelLogImg;
		this.travelLogTxt = travelLogTxt;
		this.travelLogPraise = travelLogPraise;
		this.user = user;
		this.comments = comments;
	}

	public int getTravelLogId() {
		return travelLogId;
	}

	public void setTravelLogId(int travelLogId) {
		this.travelLogId = travelLogId;
	}

	public int getTravelLogUser() {
		return travelLogUser;
	}

	public void setTravelLogUser(int travelLogUser) {
		this.travelLogUser = travelLogUser;
	}

	public Timestamp getTravelLogTime() {
		return travelLogTime;
	}

	public void setTravelLogTime(Timestamp travelLogTime) {
		this.travelLogTime = travelLogTime;
	}

	public String getTravelLogImg() {
		return travelLogImg;
	}

	public void setTravelLogImg(String travelLogImg) {
		this.travelLogImg = travelLogImg;
	}

	public String getTravelLogTxt() {
		return travelLogTxt;
	}

	public void setTravelLogTxt(String travelLogTxt) {
		this.travelLogTxt = travelLogTxt;
	}

	public int getTravelLogPraise() {
		return travelLogPraise;
	}

	public void setTravelLogPraise(int travelLogPraise) {
		this.travelLogPraise = travelLogPraise;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "TravelLog [travelLogId=" + travelLogId + ", travelLogUser=" + travelLogUser + ", travelLogTime=" + travelLogTime + ", travelLogImg=" + travelLogImg
				+ ", travelLogTxt=" + travelLogTxt + ", travelLogPraise=" + travelLogPraise + ", user=" + user + ", comments=" + comments + "]";
	}

}
