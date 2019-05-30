/**
 * 
 */
package com.lzf.dao;

import com.lzf.entity.Comment;

/**
 * @author MJCoder
 *
 */
public interface IDaoComment {
	/**
	 * 添加新的评论
	 * 
	 * @param comment
	 * @return
	 */
	int insert(Comment comment);

	/**
	 * 删除评论；通过旅游日志的ID
	 * 
	 * @param travelLogId
	 * @return
	 */
	int deleteByTravelLogId(int travelLogId);
}
