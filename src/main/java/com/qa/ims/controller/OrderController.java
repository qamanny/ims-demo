package com.qa.ims.controller;


public class OrderController implements CrudController<Order> {
	
	public static final Logger LOGGER = Logger.getLogger(OrderController.class);
	
	private CrudServices<Order> orderService;
	private CrudServices<Orderline> orderlineService;
	


}