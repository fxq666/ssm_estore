package com.briup.estore.service.interfaces;

import java.util.Set;

import com.briup.estore.common.bean.Line;
import com.briup.estore.common.exception.EstoreCommonException;

public interface ILineService {
    /**
     * 保存订单
     * @param line
     * @throws EstoreCommonException
     */
	public void saveLine(Line line) throws EstoreCommonException;
	
	/**
	 * 删除订单
	 * @param line
	 * @throws EstoreCommonException
	 */
	public void deleteOrderLine(Line line) throws EstoreCommonException;
	
	/**
	 * 查询订单
	 * @param line
	 * @return set集合
	 * @throws EstoreCommonException
	 */
	public Set<Line> findorderLine(Long id) throws EstoreCommonException;
}
