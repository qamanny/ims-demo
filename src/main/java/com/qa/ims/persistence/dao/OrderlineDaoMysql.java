package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Orderline;

public class OrderlineDaoMysql implements Dao<Orderline> {
	
	public static final Logger LOGGER = Logger.getLogger(OrderlineDaoMysql.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public OrderlineDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://34.89.103.147/ims";
		this.username = username;
		this.password = password;
	}

	public OrderlineDaoMysql(String jdbcConnectionUrl, String username, String password) {
		super();
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	Orderline orderlineFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderlineId = resultSet.getLong("orderlineId");
		Long orderId = resultSet.getLong("orderId");
		Long itemID = resultSet.getLong("itemID");
		Long stock = resultSet.getLong("stock");
		return new Orderline(orderlineId, orderId, itemID, stock);
	}

	@Override
	public List<Orderline> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderline");) {
			ArrayList<Orderline> orderlines = new ArrayList<>();
			while (resultSet.next()) {
				orderlines.add(orderlineFromResultSet(resultSet));
			}
			return orderlines;
		} catch (SQLException e) {
			LOGGER.debug(e.getSQLState());
			LOGGER.debug(e.getStackTrace());
		}
		return new ArrayList<>();
	}

	public Orderline readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM orderline ORDER BY orderlineID DESC LIMIT 1");) {
			resultSet.next();
			return orderlineFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getStackTrace());
		}
		return null;
	}

	@Override
	public Orderline create(Orderline orderline) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("INSERT INTO orderline(orderId, itemID, stock) VALUES('" + orderline.getOrderId()
					+ "','" + orderline.getItemID() + "','" + orderline.getStock() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getStackTrace());
		}
		return null;
	}

	public Orderline readOrderline(Long orderlineId) {

		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			ResultSet resultSet = statement
					.executeQuery("SELECT FROM orderline WHERE orderlineId='" + orderlineId + "';");
			return orderlineFromResultSet(resultSet);

		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getStackTrace());
		}
		return null;

	}

	@Override
	public Orderline update(Orderline orderline) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("UPDATE orderline SET itemID = '" + orderline.getItemID() + "', orderID = '"
					+ orderline.getOrderId() + "', stock = '" + orderline.getStock() + "' WHERE orderlineId = '"
					+ orderline.getOrderlineId() + "');");
			return readOrderline(orderline.getOrderId());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public void delete(long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from orderline where orderlineId =" + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}

	}


}
