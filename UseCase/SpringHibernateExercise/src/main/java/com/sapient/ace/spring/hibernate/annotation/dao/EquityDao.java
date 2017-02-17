package com.sapient.ace.spring.hibernate.annotation.dao;

import java.util.List;

import com.sapient.ace.spring.hibernate.annotation.model.Equity;

public interface EquityDao {
	public void saveEntity(Equity equity);
	public List<Equity> listEquity();
}
