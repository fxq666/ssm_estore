package com.briup.estore.service.interfaces;

import java.util.List;

import com.briup.estore.common.bean.Province;
import com.briup.estore.common.exception.EstoreCommonException;

public interface IProvinceService {
	List<Province> findByCountry(Integer country) throws EstoreCommonException;
	List<Province> findByCountry1(Integer country) throws EstoreCommonException;
	List<Province> findByCountry2(Integer country) throws EstoreCommonException;
}
