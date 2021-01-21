package com.qa.ims.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.Orderline;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order>{
	
	public static final Logger LOGGER = Logger.getLogger(OrderController.class);

	private CrudServices<Order> orderService;
	private CrudServices<Orderline> orderlineService;
	
	public OrderController(CrudServices<Order> orderService) {
		this.orderService = orderService;
	}
	
	public OrderController(CrudServices<Order> orderService, CrudServices<Orderline> orderlineService) {
		super();
		this.orderService = orderService;
		this.orderlineService = orderlineService;
	}
	

	String getInput() {
		return Utils.getInput();
	}
	
	Long getLongInput() {
		return Utils.getLong();
	}
	
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderService.readAll();
		for(Order order: orders) {
			LOGGER.info(order.toString());
		}
		return orders;
		}

	@Override
	public Order create() {
		LOGGER.info("Please enter the customer id");
		Long customerid = Long.valueOf(getInput());
		LOGGER.info("Please enter the customer address");
		String address = getInput();
		LOGGER.info("Please enter the customer postcode");
		String postcode = getInput();
		Order order = orderService.create(new Order(customerid, address, postcode));
		LOGGER.info("Congrats on making a purchase, your order id is: " + order.getOrderId());
	
	@Override
	public Order update() {
		LOGGER.info("Please enter the id of order to update");
		Long orderId = Long.valueOf(getInput());
		LOGGER.info("Please enter the new item");
		Long itemID = Long.valueOf(getInput());
		LOGGER.info("Please enter the amount of the item");
		String postcode = getInput();
		}
		Orderline orderline = orderlineService.update(new Orderline(orderId, itemID, stock));
		LOGGER.info("Order has been created");
		return order;
	}
	
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long order_id = Long.valueOf(getInput());
		orderService.delete(order_id);
	}
	
//	public double BasketPrice() {
//		double price = 0;
//
//		for (Item order : orders) {
//			price += order.getItem_price();
//		}
//		return price;
//	}
}