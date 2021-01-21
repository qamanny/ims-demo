package com.qa.ims.controller;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Orderline;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderlineController implements CrudController<Orderline> {

	public static final Logger LOGGER = Logger.getLogger(OrderlineController.class);

	private CrudServices<Orderline> orderlineService;
	
	String getInput() {
		return Utils.getInput();
	}

	@Override
	public List<Orderline> readAll() {
		List<Orderline> orderlines = orderlineService.readAll();
		for (Orderline orderline : orderlines) {
			LOGGER.info(orderline.toString());
		}
		return orderlines;
	}

	@Override
	public Orderline create() {
		LOGGER.info("Please enter the order id");
		Long orderId = Long.valueOf(getInput());
		LOGGER.info("Please enter the item id");
		Long itemID = Long.valueOf(getInput());
		LOGGER.info("Please enter the amount of said item you wish for");
		Long stock = Long.valueOf(getInput());
		Orderline orderline = orderlineService.create(new Orderline(orderId, itemID, stock));
		LOGGER.info("Orderline Created");
		return orderline;
	}

	@Override
	public Orderline update() {
		LOGGER.info("Please enter the orderline id you wish to update");
		Long orderlineId = Long.valueOf(getInput());
		LOGGER.info("Please enter the order id");
		Long orderId = Long.valueOf(getInput());
		LOGGER.info("Please enter the item id");
		Long itemID = Long.valueOf(getInput());
		Orderline orderline = orderlineService.update(new Orderline(orderlineId, orderId, itemID));
		LOGGER.info("Orderline Updated");
		return orderline;
	}

	@Override
	public void delete() {
		LOGGER.info("please enter the ID of the order you wish to delete");
		Long orderId = Long.valueOf(getInput());
		orderlineService.delete(orderId);
		LOGGER.info("Order Deleted");
		
	}

}
