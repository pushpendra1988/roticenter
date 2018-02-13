/*
 * @author Pushpendra.Yadav
 * */

package com.roticenter.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.roticenter.dto.FoodOrderRequest;
import com.roticenter.dto.FoodOrderResponse;
import com.roticenter.dto.OrderDetailsResponse;
import com.roticenter.service.RotiCenterOrderServiceImpl;

@SpringBootApplication
public class SpringjdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringjdbcApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		RotiCenterOrderServiceImpl service = context.getBean("rotiCenterService",RotiCenterOrderServiceImpl.class);
		FoodOrderRequest request = new FoodOrderRequest();
		System.out.println("=======================Roti Center=========================");
		request.setAddress("Gachibowli");
		request.setEmail("anjanpushpendra@gmail.com");
		request.setItemDetails("2-roti");
		request.setMobile(7680846185L);
		request.setOrderBy("pushpendra kumar");
		FoodOrderResponse response = service.foodOrder(request);
		//OrderDetailsResponse orderDetails = service.getOrderDetails(0);
		//System.out.println(response.getSuccessMessage());
	}
}
