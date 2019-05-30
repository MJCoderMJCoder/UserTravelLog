/**
 * 
 */
package com.lzf.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzf.entity.Comment;
import com.lzf.service.IServiceComment;

/**
 * @author MJCoder
 *
 */
@Controller
@RequestMapping("comment")
public class ControlComment {

	@Autowired
	private IServiceComment serviceComment;

	/**
	 * 
	 */
	public ControlComment() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 发布评论
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	private Object insert(HttpServletRequest request) {
		DtoPackaging dtoPackaging = null;
		int commentUser = Integer.parseInt(request.getParameter("commentUser"));
		String commentTxt = request.getParameter("commentTxt");
		int commentsTravelLog = Integer.parseInt(request.getParameter("commentsTravelLog"));
		Comment comment = new Comment(0, commentUser, null, commentTxt, commentsTravelLog, null);
		int result = serviceComment.insert(comment);
		if (result <= 0) {
			dtoPackaging = new DtoPackaging(false, "评论失败", null);
		} else {
			dtoPackaging = new DtoPackaging(true, "评论成功", comment);
		}
		return dtoPackaging;
	}

}
