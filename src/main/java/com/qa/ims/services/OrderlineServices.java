package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Orderline;

public class OrderlineServices implements CrudServices<Orderline> {
	
private Dao<Orderline> orderlineDao;
	
	public OrderlineServices(Dao<Orderline> orderlineDao) {
		this.orderlineDao = orderlineDao;
	}

	public List<Orderline> readAll() {
		return orderlineDao.readAll();
	}

	public Orderline create(Orderline orderline) {
		return orderlineDao.create(orderline);
	}

	public Orderline update(Orderline orderline) {
		return orderlineDao.update(orderline);
	}

	public void delete(Long id) {
		orderlineDao.delete(id);
		
	}


}
