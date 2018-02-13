/*
 * @author Pushpendra.Yadav
 * */

package com.roticenter.validator;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import com.roticenter.dto.FoodOrderRequest;
import com.roticenter.util.FoodOrderUtil;

public class FoodOrderValidation {
	
	
	public ValidationInfo foodOrderValidation(FoodOrderRequest request){
		ValidationInfo validationInfo = new ValidationInfo();
		StringBuffer sb = new StringBuffer();
		if(StringUtils.isEmpty(request.getOrderBy())){
			sb.append("Order By is required Field.,");
		}
		
		if(StringUtils.isEmpty(request.getEmail())) {
			sb.append("Email is required Field.,");
		}	
		
		EmailValidator ev = EmailValidator.getInstance();
		if(!ev.isValid(request.getEmail())){
			sb.append("Please Enter a valid Email,");
		}
		
		if(StringUtils.isEmpty(request.getAddress())) {
			sb.append("Address is required Field.,");
		}
		
		if(!FoodOrderUtil.validatePhoneNumber(String.valueOf(request.getMobile()))){
			sb.append("not a valid Phone number.,");
		}
		
		if(StringUtils.isEmpty(request.getItemDetails())){
			sb.append("Please Enter the Items you want to order for.,");
		}
	
		if(sb.length() != 0){
			sb.deleteCharAt(sb.length()-1);
			validationInfo.setIsError(true);
			validationInfo.setValidationError(sb.toString());
		}
		return validationInfo;
	}
}
