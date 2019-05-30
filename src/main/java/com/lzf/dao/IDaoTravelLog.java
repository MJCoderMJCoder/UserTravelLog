/**
 * 
 */
package com.lzf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lzf.entity.TravelLog;

/**
 * @author MJCoder
 *
 */
public interface IDaoTravelLog {
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
	List<TravelLog> dimSelect(@Param(value = "travelLogId") String travelLogId, @Param(value = "travelLogUser") String travelLogUser,
			@Param(value = "travelLogTime") String travelLogTime, @Param(value = "travelLogImg") String travelLogImg, @Param(value = "travelLogTxt") String travelLogTxt,
			@Param(value = "travelLogPraise") String travelLogPraise);

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
