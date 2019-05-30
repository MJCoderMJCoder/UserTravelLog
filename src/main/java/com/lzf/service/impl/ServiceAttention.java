/**
 * 
 */
package com.lzf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.dao.IDaoAttention;
import com.lzf.entity.Attention;
import com.lzf.service.IServiceAttention;

/**
 * @author MJCoder
 *
 */
@Service
public class ServiceAttention implements IServiceAttention {

	@Autowired
	private IDaoAttention daoAttention;

	/**
	 * 
	 */
	public ServiceAttention() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lzf.service.IServiceAttention#insert(com.lzf.entity.Attention)
	 */
	@Override
	public int insert(Attention attention) {
		// TODO Auto-generated method stub
		int temp = -1;
		try {
			temp = daoAttention.insert(attention);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			return temp;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lzf.service.IServiceAttention#delete(com.lzf.entity.Attention)
	 */
	@Override
	public int delete(Attention attention) {
		// TODO Auto-generated method stub
		int temp = -1;
		try {
			temp = daoAttention.delete(attention);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			return temp;
		}
	}

}
