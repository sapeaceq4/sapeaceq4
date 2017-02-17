package com.sapient.ace.spring.hibernate.config.dao;

import java.util.List;

import com.sapient.ace.spring.hibernate.config.model.Equity;

public interface EquityDao {
	public void saveEntity(Equity equity);
	public List<Equity> listEquity();
}
