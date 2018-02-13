package com.roticenter.dao;

import com.roticenter.dto.FoodOrderRequest;
import com.roticenter.dto.OrderDetailsResponse;

public interface RotiCenterDao {
	public Boolean foodOrder(FoodOrderRequest request) throws Exception; 
	public OrderDetailsResponse getOrderDetails(long mobile);

}
