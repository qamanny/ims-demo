package com.qa.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.Ims;
import com.qa.ims.persistence.dao.ItemDaoMysql;
import com.qa.ims.persistence.domain.Item;

public class ItemDaoMysqlTest {
	
	public static final Logger LOGGER = Logger.getLogger(ItemDaoMysql.class);


	private static String jdbcConnectionUrl = "jdbc:mysql://localhost:3306/ims_test";
	private static String username = "root";
	private static String password = "root";

	@BeforeClass
	public static void init() {
		Ims ims = new Ims();
		ims.init(jdbcConnectionUrl, username, password, "src/test/resources/sql-schema.sql");
	}

	@Before
	public void setup() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from item;");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	@Test
	public void createTest() {
		ItemDaoMysql itemDaoMysql = new ItemDaoMysql(jdbcConnectionUrl, username, password);
		long id = 1L;
		String item_name = "Red Wrench";
		Double item_price = 18.99;
		Item item = new Item(id, item_name, item_price);
		Item saveditem = new Item(id, item_name, item_price);
		ArrayList<Item> itemRead = new ArrayList<>();
		item = itemDaoMysql.create(item);
		itemDaoMysql.readAll();
		assertEquals(item, saveditem);;
		assertNotNull(itemRead);
	}

	@Test
	public void updateTest() {
		ItemDaoMysql itemDaoMysql = new ItemDaoMysql(jdbcConnectionUrl, username, password);
		long id = 1L;
		String item_name = "Blue Wrench";
		Double item_price = 17.99;
		Item item = new Item(id, item_name, item_price);
		Item saveditem = new Item(id, item_name, item_price);
		item = itemDaoMysql.update(item);
		saveditem = itemDaoMysql.update(saveditem);
		assertEquals(item, saveditem);
	}
}



