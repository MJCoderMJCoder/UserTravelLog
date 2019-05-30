/**
 * 
 */
package com.lzf.service;

import com.lzf.entity.Attention;

/**
 * @author MJCoder
 *
 */
public interface IServiceAttention {
	/**
	 * 关注
	 * 
	 * @param attention
	 * @return
	 */
	int insert(Attention attention);

	/**
	 * 取消关注
	 * 
	 * @param attention
	 * @return
	 */
	int delete(Attention attention);
}
