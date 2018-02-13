/*
 * @author Pushpendra.Yadav
 * */
package com.roticenter.dto;

public class FoodOrderResponse {
private String bookinStatus;
private String errorMessage;
private String successMessage;
public String getErrorMessage() {
	return errorMessage;
}
public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}
public String getSuccessMessage() {
	return successMessage;
}
public void setSuccessMessage(String successMessage) {
	this.successMessage = successMessage;
}
private long bookingId;
public String getBookinStatus() {
	return bookinStatus;
}
public void setBookinStatus(String bookinStatus) {
	this.bookinStatus = bookinStatus;
}
public long getBookingId() {
	return bookingId;
}
public void setBookingId(long bookingId) {
	this.bookingId = bookingId;
}

}
