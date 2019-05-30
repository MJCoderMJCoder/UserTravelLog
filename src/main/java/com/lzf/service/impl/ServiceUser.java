/**
 * 
 */
package com.lzf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lzf.dao.IDaoUser;
import com.lzf.entity.User;
import com.lzf.service.IServiceUser;
import com.lzf.util.Const;

/**
 * @author MJCoder
 *
 */
@Service
public class ServiceUser implements IServiceUser {

	// 注入dao@Autowired
	@Resource
	private IDaoUser daoUser;

	@Override
	public User login(String userAccount, String userPassword) {
		// TODO Auto-generated method stub
		return daoUser.login(userAccount, userPassword);
	}

	@Override
	public User selectById(int userId) {
		// TODO Auto-generated method stub
		return daoUser.selectById(userId);
	}

	@Override
	public List<User> select(int userType) {
		// TODO Auto-generated method stub
		return daoUser.select(userType);
	}

	@Override
	public List<User> dimSelect(String userId, String userPortrait, String userName, String userAccount, String userQQ, String userPhone, String userEmail, String userConfidante,
			int userType) {
		// TODO Auto-generated method stub
		return daoUser.dimSelect(userId, userPortrait, userName, userAccount, userQQ, userPhone, userEmail, userConfidante, userType);
	}

	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		int temp = -1;
		try {
			temp = daoUser.insert(user);
		} catch (Exception e) {
			if (e.getMessage().contains("UNIQUE")) {
				temp = Const.UNIQUE;
			}
			e.printStackTrace();
		} finally {
			return temp;
		}
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		int temp = -1;
		try {
			temp = daoUser.update(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return temp;
		}
	}

}
