package com.qa.ims.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Order;

public class OrderServicesTest {
	
	@RunWith(MockitoJUnitRunner.class)
	public class orderServicesTest {
		
		@Mock
		private Dao<Order> orderDao;
		
		@InjectMocks
		private OrderServices orderServices;
		
		@Test
		public void orderServicesCreate() {
			Order order = new Order(1L, 1L, "29 Fifth Street", "CF24 9FB");
			orderServices.create(order);
			Mockito.verify(orderDao, Mockito.times(1)).create(order);
		}
		
		@Test
		public void orderServicesRead() {
			orderServices.readAll();
			Mockito.verify(orderDao, Mockito.times(1)).readAll();
		}
		
		@Test
		public void orderServicesUpdate() {
			Order order = new Order(2L, 2L, "30 Fifth Street", "CF25 9FC");
			orderServices.update(order);
			Mockito.verify(orderDao, Mockito.times(1)).update(order);
		}
		
		@Test
		public void orderServicesDelete() {
			orderServices.delete(1L);;
			Mockito.verify(orderDao, Mockito.times(1)).delete(1L);
		}
	}





}
