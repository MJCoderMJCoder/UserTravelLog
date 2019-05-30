/**
 * 
 */
package com.lzf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.dao.IDaoComment;
import com.lzf.entity.Comment;
import com.lzf.service.IServiceComment;

/**
 * @author MJCoder
 *
 */
@Service
public class ServiceComment implements IServiceComment {

	@Autowired
	private IDaoComment daoComment;

	/**
	 * 
	 */
	public ServiceComment() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lzf.service.IServiceComment#insert(com.lzf.entity.Comment)
	 */
	@Override
	public int insert(Comment comment) {
		// TODO Auto-generated method stub
		int temp = -1;
		try {
			temp = daoComment.insert(comment);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			return temp;
		}
	}

}
