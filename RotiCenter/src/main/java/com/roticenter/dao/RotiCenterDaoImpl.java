/*
 * @author Pushpendra.Yadav
 * */
package com.roticenter.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import com.roticenter.dto.FoodOrderRequest;
import com.roticenter.dto.OrderDetailsResponse;
import com.roticenter.util.FoodOrderUtil;

public class RotiCenterDaoImpl implements RotiCenterDao {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Boolean foodOrder(FoodOrderRequest request) throws Exception{
		 String addQuery = "INSERT INTO FOOD_ORDER VALUES(?,?,?,?,?,?,?,?)";
		 return jdbcTemplate.execute(addQuery, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement pstmt) throws SQLException, DataAccessException {
				pstmt.setLong(1, FoodOrderUtil.generateOrderId());
				pstmt.setString(2,request.getOrderBy());
				pstmt.setLong(3, request.getMobile());
				pstmt.setString(4, request.getEmail());
				pstmt.setString(5, request.getAddress());
				pstmt.setString(6, request.getItemDetails());
				Timestamp date = new Timestamp(new java.util.Date().getTime());
				pstmt.setTimestamp(7,date);
				pstmt.setString(8,"In-Process");
				return pstmt.execute();
			}
		});
	}

	@Override
	public OrderDetailsResponse getOrderDetails(long mobile) {
		String query = "SELECT * FROM FOOD_ORDER WHERE MOBILE = ?";
		return jdbcTemplate.queryForObject(query,new Object[]{mobile}, new RowMapper<OrderDetailsResponse>() {

			@Override
			public OrderDetailsResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
				OrderDetailsResponse response = new OrderDetailsResponse();
				response.setAddress(rs.getString(5));
				response.setOrderId(rs.getLong(1));
				response.setEmail(rs.getString(4));
				response.setItemDetails(rs.getString(6));
				response.setMobile(rs.getLong(3));
				response.setOrderBy(rs.getString(2));
				response.setOrderDate(rs.getDate(7));
				response.setStatus(rs.getString(8));
				return response;
			}
		});
	}


}
