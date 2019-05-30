/**
 * 
 */
package com.lzf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.dao.IDaoComment;
import com.lzf.dao.IDaoTravelLog;
import com.lzf.entity.TravelLog;
import com.lzf.service.IServiceTravelLog;

/**
 * @author MJCoder
 *
 */
@Service
public class ServiceTravelLog implements IServiceTravelLog {

	@Autowired
	private IDaoTravelLog daoTravelLog;

	@Autowired
	private IDaoComment daoComment;

	/**
	 * 
	 */
	public ServiceTravelLog() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lzf.service.IServiceTravelLog#insert(com.lzf.entity.TravelLog)
	 */
	@Override
	public int insert(TravelLog travelLog) {
		// TODO Auto-generated method stub
		int temp = -1;
		try {
			temp = daoTravelLog.insert(travelLog);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			return temp;
		}
	}

	@Override
	public List<TravelLog> dimSelect(String travelLogId, String travelLogUser, String travelLogTime, String travelLogImg, String travelLogTxt, String travelLogPraise) {
		// TODO Auto-generated method stub
		return daoTravelLog.dimSelect(travelLogId, travelLogUser, travelLogTime, travelLogImg, travelLogTxt, travelLogPraise);
	}

	@Override
	public int praise(int travelLogId) {
		// TODO Auto-generated method stub
		int temp = -1;
		try {
			temp = daoTravelLog.praise(travelLogId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			return temp;
		}
	}

	@Override
	public int delete(int travelLogId) {
		// TODO Auto-generated method stub
		int temp = -1;
		try {
			temp = daoComment.deleteByTravelLogId(travelLogId);
			temp = daoTravelLog.delete(travelLogId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			return temp;
		}
	}
}
