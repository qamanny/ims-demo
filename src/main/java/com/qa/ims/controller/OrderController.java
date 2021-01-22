package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.Orderline;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = Logger.getLogger(OrderController.class);

	private CrudServices<Order> orderService;

	public OrderController(CrudServices<Order> orderServices) {
		this.orderService = orderServices;
	}
	
	String getInput() {
		return Utils.getInput();
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
		Long customerId = Long.valueOf(getInput());
		LOGGER.info("Please enter the address of the customer");
		String address = getInput();
		LOGGER.info("Please enter the postcode of the customer");
		String postcode = getInput();
		Order order = orderService.create(new Order(customerId, address, postcode));
		LOGGER.info("Item created");
		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long orderId = Long.valueOf(getInput());
		LOGGER.info("Please enter the customer id");
		Long customerId = Long.valueOf(getInput());
		LOGGER.info("Please enter the address of the customer");
		String address = getInput();
		LOGGER.info("Please enter the postcode of the customer");
		String postcode = getInput();
		Order order = orderService.update(new Order(orderId, customerId, address, postcode));
		LOGGER.info("Order Updated");
		return order;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long orderid = Long.valueOf(getInput());
		orderService.delete(orderid);
		LOGGER.info("Order deleted");
	}

}
