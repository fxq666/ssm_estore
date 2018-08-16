package com.briup.estore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.estore.common.bean.Province;
import com.briup.estore.common.exception.EstoreCommonException;
import com.briup.estore.dao.IProvinceDao;
import com.briup.estore.service.interfaces.IProvinceService;

@Service
public class ProvinceServiceImpl implements IProvinceService {
	@Autowired
	private IProvinceDao provinceDao;

	@Override
	public List<Province> findByCountry(Integer country) throws EstoreCommonException {
		if (country == null) {
			throw EstoreCommonException.getException(401);
		}
		List<Province> provinces = provinceDao.findByCountry(country);
		return provinces;
	}

	@Override
	public List<Province> findByCountry1(Integer country) throws EstoreCommonException {
		if (country == null) {
			throw EstoreCommonException.getException(401);
		}
		List<Province> provinces = provinceDao.queryAllbyCountry(country);
		return provinces;
	}

	@Override
	public List<Province> findByCountry2(Integer country) throws EstoreCommonException {
		if (country == null) {
			throw EstoreCommonException.getException(401);
		}
		List<Province> provinces = provinceDao.queryAllbyCountry2(country);
		return provinces;
	}

}
