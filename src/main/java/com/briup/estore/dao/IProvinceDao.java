package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.common.bean.Province;
import com.briup.estore.common.exception.EstoreCommonException;

public interface IProvinceDao {
	List<Province> findByCountry(Integer country) throws EstoreCommonException;
	List<Province> queryAllbyCountry(Integer country) throws EstoreCommonException;
	List<Province> queryAllbyCountry2(Integer country) throws EstoreCommonException;
}
