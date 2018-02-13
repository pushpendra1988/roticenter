/*
 * @author Pushpendra.Yadav
 * */

package com.roticenter.service;

import com.roticenter.dao.RotiCenterDaoImpl;
import com.roticenter.dto.FoodOrderRequest;
import com.roticenter.dto.FoodOrderResponse;
import com.roticenter.dto.OrderDetailsResponse;
import com.roticenter.validator.FoodOrderValidation;
import com.roticenter.validator.ValidationInfo;
public class RotiCenterOrderServiceImpl implements RotiCenterOrderService {

	private RotiCenterDaoImpl rotiCenterDao;
	public RotiCenterOrderServiceImpl(RotiCenterDaoImpl rotiCenterDao){
		this.rotiCenterDao = rotiCenterDao;
	}
	
	@Override
	public FoodOrderResponse foodOrder(FoodOrderRequest request) {
		FoodOrderResponse response = new FoodOrderResponse();
		ValidationInfo error = null;
		FoodOrderValidation validation = new FoodOrderValidation();
		try{
			 error = validation.foodOrderValidation(request);
			if(!error.isError()){
				boolean foodOrder = rotiCenterDao.foodOrder(request);
				if(!foodOrder){
					response.setBookingId(1);
					response.setBookinStatus("Success.");
					response.setSuccessMessage("Your Order Has been booked successfully.");
				}
				else{
					response.setErrorMessage("BookingFailed");
				}
			}
			else{
				response.setErrorMessage(error.getValidationError());
			}
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return response;
	}

	@Override
	public OrderDetailsResponse getOrderDetails(long mobile) {
		OrderDetailsResponse response = null;
		if(mobile != 0){
			 response = rotiCenterDao.getOrderDetails(mobile);
		}
		else{
			throw new RuntimeException("Please Enter Your Mobile Number");
		}
		
		return response;
	}

}
