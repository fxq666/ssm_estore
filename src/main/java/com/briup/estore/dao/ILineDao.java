package com.briup.estore.dao;

import java.util.Set;

import com.briup.estore.common.bean.Line;


public interface ILineDao  {
	public void saveLine(Line line);
	public void deleteOrderLine(Long id);
	public Set<Line> findorderLine(Long id);
	
	
}
