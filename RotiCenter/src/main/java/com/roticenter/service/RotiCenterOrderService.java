package com.roticenter.service;

import com.roticenter.dto.FoodOrderRequest;
import com.roticenter.dto.FoodOrderResponse;
import com.roticenter.dto.OrderDetailsResponse;

public interface RotiCenterOrderService {

	public FoodOrderResponse foodOrder(FoodOrderRequest request); 
	public OrderDetailsResponse getOrderDetails(long mobile);
}
