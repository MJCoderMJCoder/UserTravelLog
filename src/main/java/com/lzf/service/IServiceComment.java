/**
 * 
 */
package com.lzf.service;

import com.lzf.entity.Comment;

/**
 * @author MJCoder
 *
 */
public interface IServiceComment {

	/**
	 * 添加新的评论
	 * 
	 * @param comment
	 * @return
	 */
	int insert(Comment comment);
}
