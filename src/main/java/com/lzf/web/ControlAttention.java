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

import com.lzf.entity.Attention;
import com.lzf.service.IServiceAttention;

/**
 * @author MJCoder
 *
 */
@Controller
@RequestMapping("attention")
public class ControlAttention {

	@Autowired
	private IServiceAttention serviceAttention;

	/**
	 * 
	 */
	public ControlAttention() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 点击关注
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	@ResponseBody
	private Object insert(HttpServletRequest request) {
		DtoPackaging dtoPackaging = null;
		int userSelf = Integer.parseInt(request.getParameter("userSelf"));
		int attentionUser = Integer.parseInt(request.getParameter("attentionUser"));
		Attention attention = new Attention(0, userSelf, attentionUser);
		int result = serviceAttention.insert(attention);
		if (result <= 0) {
			dtoPackaging = new DtoPackaging(false, "关注失败", null);
		} else {
			dtoPackaging = new DtoPackaging(true, "关注成功", attention);
		}
		return dtoPackaging;
	}

	/**
	 * 取消关注
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	private Object delete(HttpServletRequest request) {
		DtoPackaging dtoPackaging = null;
		int userSelf = Integer.parseInt(request.getParameter("userSelf"));
		int attentionUser = Integer.parseInt(request.getParameter("attentionUser"));
		Attention attention = new Attention(0, userSelf, attentionUser);
		int result = serviceAttention.delete(attention);
		if (result <= 0) {
			dtoPackaging = new DtoPackaging(false, "取关失败", null);
		} else {
			dtoPackaging = new DtoPackaging(true, "取关成功", attention);
		}
		return dtoPackaging;
	}
}
