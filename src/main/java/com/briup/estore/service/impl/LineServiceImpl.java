package com.briup.estore.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.estore.common.bean.Line;
import com.briup.estore.common.exception.EstoreCommonException;
import com.briup.estore.dao.ILineDao;
import com.briup.estore.service.interfaces.ILineService;
/**
 * 添加订单项
 * @author ying
 *
 */
@Service
public class LineServiceImpl implements ILineService {
	@Autowired
	private ILineDao lineDao;

	@Override
	public void saveLine(Line line) throws EstoreCommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrderLine(Line line) throws EstoreCommonException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 查询订单
	 */
	@Override
	public Set<Line> findorderLine(Long id) throws EstoreCommonException {
		
		Set<Line> line2 = lineDao.findorderLine(id);
        if (line2 == null) {
        	throw EstoreCommonException.getException(404);
			
		}
		return line2;
	}
	

}
