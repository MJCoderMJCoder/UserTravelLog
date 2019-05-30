/**
 * 
 */
package com.lzf.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lzf.entity.TravelLog;

/**
 * @author MJCoder
 *
 */
public interface IServiceTravelLog {

	/**
	 * 添加旅游日志
	 * 
	 * @param travelLog
	 * @return
	 */
	int insert(TravelLog travelLog);

	/**
	 * 模糊查询旅游日志
	 * 
	 * @return
	 */
	List<TravelLog> dimSelect(String travelLogId, String travelLogUser, String travelLogTime, String travelLogImg, String travelLogTxt, String travelLogPraise);

	/**
	 * 点赞数加一
	 * 
	 * @param travelLogId
	 * @return
	 */
	int praise(int travelLogId);

	/**
	 * 删除该旅游日志
	 * 
	 * @param travelLogId
	 * @return
	 */
	int delete(int travelLogId);
}
