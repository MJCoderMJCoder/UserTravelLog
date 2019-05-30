/**
 * 
 */
package com.lzf.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lzf.entity.User;

/**
 * 业务层
 * 
 * @author MJCoder
 *
 */
public interface IServiceUser {
	/**
	 * 用户登录
	 * 
	 * @param userAccount
	 * @param userPassword
	 * @return
	 */
	User login(String userAccount, String userPassword);

	/**
	 * 通过Id查询某个（游客）用户
	 * 
	 * @param userId
	 * @return
	 */
	User selectById(int userId);

	/**
	 * 查询某个用户类型对应的所有用户
	 * 
	 * @param userType
	 * @return
	 */
	List<User> select(int userType);

	/**
	 * 模糊查询
	 * 
	 * @param userType
	 * @return
	 */
	List<User> dimSelect(String userId, String userPortrait, String userName, String userAccount, String userQQ, String userPhone, String userEmail, String userConfidante,
			int userType);

	/**
	 * 添加用户、注册用户
	 * 
	 * @param user
	 * @return
	 */
	int insert(User user);

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 * @return
	 */
	int update(User user);
}
