/**
 * 
 */
package com.lzf.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.lzf.entity.TravelLog;
import com.lzf.service.IServiceTravelLog;
import com.lzf.util.WatermarkUtil;

/**
 * @author MJCoder
 *
 */
@Controller
@RequestMapping("travelLog")
public class ControlTravelLog {

	@Resource
	private IServiceTravelLog serviceTravelLog;

	/**
	 * 
	 */
	public ControlTravelLog() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 添加新的旅游日志
	 * 
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	@ResponseBody
	private Object insert(HttpServletRequest request) {
		DtoPackaging dtoPackaging = null;
		try {
			String path = request.getServletContext().getRealPath("upload"); // uploads文件夹位置
			CommonsMultipartResolver cmr = new CommonsMultipartResolver(request.getServletContext());
			if (cmr.isMultipart(request)) {
				MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) (request);
				MultipartFile file = mRequest.getFile("travelLogImg");
				String fileName = file.getOriginalFilename(); // 原始名称
				File dir = new File(path, System.currentTimeMillis() + "_" + fileName);// 新文件名
				if (!dir.exists()) { // 如果目标文件所在的目录不存在，则创建父目录
					dir.mkdirs();
				}
				file.transferTo(dir);// 将内存中的数据写入磁盘
				String travelLogImg = dir.getAbsolutePath().substring(dir.getAbsolutePath().indexOf("upload")).replace("\\", "/");
				System.out.println(path + " >>> " + travelLogImg);
				int travelLogUser = Integer.parseInt(request.getParameter("travelLogUser"));
				String travelLogTxt = mRequest.getParameter("travelLogTxt");
				TravelLog travelLog = new TravelLog(0, travelLogUser, null, travelLogImg, travelLogTxt, 0, null, null);
				System.out.println("前：" + travelLog);
				int result = serviceTravelLog.insert(travelLog);
				System.out.println("后：" + travelLog);
				if (result <= 0) {
					dtoPackaging = new DtoPackaging(false, "旅游日志发布失败", null);
				} else {
					dtoPackaging = new DtoPackaging(true, "旅游日志发布成功", travelLog);
				}
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return dtoPackaging;
		}
	}

	/**
	 * 模糊查询旅游日志
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "dimSelect", method = RequestMethod.POST)
	@ResponseBody
	private Object dimSelect(HttpServletRequest request) {
		DtoPackaging dtoPackaging = null;
		String travelLogId = "%" + request.getParameter("travelLogId") + "%";
		String travelLogUser = "%" + request.getParameter("travelLogUser") + "%";
		String travelLogTime = "%" + request.getParameter("travelLogTime") + "%";
		String travelLogImg = "%" + request.getParameter("travelLogImg") + "%";
		String travelLogTxt = "%" + request.getParameter("travelLogTxt") + "%";
		String travelLogPraise = "%" + request.getParameter("travelLogPraise") + "%";
		System.out.println(travelLogId + "；" + travelLogUser + "；" + travelLogTime + "；" + travelLogImg + "；" + travelLogTxt + "；" + travelLogPraise);
		List<TravelLog> travelLogs = serviceTravelLog.dimSelect(travelLogId, travelLogUser, travelLogTime, travelLogImg, travelLogTxt, travelLogPraise);
		System.out.println(travelLogs);
		if (travelLogs == null) {
			dtoPackaging = new DtoPackaging(false, "旅游日志获取失败", null);
		} else {
			dtoPackaging = new DtoPackaging(true, "旅游日志获取成功", travelLogs);
		}
		return dtoPackaging;
	}

	/**
	 * 点赞
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "praise", method = RequestMethod.POST)
	@ResponseBody
	private Object praise(HttpServletRequest request) {
		DtoPackaging dtoPackaging = null;
		int travelLogId = Integer.parseInt(request.getParameter("travelLogId"));
		int result = serviceTravelLog.praise(travelLogId);
		if (result <= 0) {
			dtoPackaging = new DtoPackaging(false, "点赞过快，请稍后重试。", null);
		} else {
			dtoPackaging = new DtoPackaging(true, "谢谢你！", null);
		}
		return dtoPackaging;
	}

	/**
	 * 旅游日志删除
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	private Object delete(HttpServletRequest request) {
		DtoPackaging dtoPackaging = null;
		int travelLogId = Integer.parseInt(request.getParameter("travelLogId"));
		int result = serviceTravelLog.delete(travelLogId);
		if (result <= 0) {
			dtoPackaging = new DtoPackaging(false, "旅游日志删除失败。", null);
		} else {
			dtoPackaging = new DtoPackaging(true, "旅游日志已删除", null);
		}
		return dtoPackaging;
	}

	/**
	 * 添加新的旅游日志（发布广告）
	 * 
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "publishAD", method = RequestMethod.POST)
	@ResponseBody
	private Object publishAD(HttpServletRequest request) {
		DtoPackaging dtoPackaging = null;
		try {
			String path = request.getServletContext().getRealPath("upload"); // uploads文件夹位置
			CommonsMultipartResolver cmr = new CommonsMultipartResolver(request.getServletContext());
			if (cmr.isMultipart(request)) {
				MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) (request);
				MultipartFile file = mRequest.getFile("travelLogImg");
				String fileName = file.getOriginalFilename(); // 原始名称
				File dir = new File(path, System.currentTimeMillis() + "_" + fileName);// 新文件名
				if (!dir.exists()) { // 如果目标文件所在的目录不存在，则创建父目录
					dir.mkdirs();
				}
				file.transferTo(dir);// 将内存中的数据写入磁盘
				String travelLogImg = dir.getAbsolutePath().substring(dir.getAbsolutePath().indexOf("upload")).replace("\\", "/");
				System.out.println(path + " >>> " + travelLogImg);
				WatermarkUtil.addWatermark(dir.getAbsolutePath(), dir.getAbsolutePath(), "广告", dir.getAbsolutePath().substring(dir.getAbsolutePath().lastIndexOf(".") + 1));
				int travelLogUser = Integer.parseInt(request.getParameter("travelLogUser"));
				String travelLogTxt = mRequest.getParameter("travelLogTxt");
				TravelLog travelLog = new TravelLog(0, travelLogUser, null, travelLogImg, travelLogTxt, 0, null, null);
				System.out.println("前：" + travelLog);
				int result = serviceTravelLog.insert(travelLog);
				System.out.println("后：" + travelLog);
				if (result <= 0) {
					dtoPackaging = new DtoPackaging(false, "旅游日志发布失败", null);
				} else {
					dtoPackaging = new DtoPackaging(true, "旅游日志发布成功", travelLog);
				}
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return dtoPackaging;
		}
	}

}
