package com.roticenter.validator;

public class ValidationInfo {
	private boolean isError;
	private String validationError;
	private String dbError;
	private String errorMessage;
	
	public String getValidationError() {
		return validationError;
	}
	public void setValidationError(String validationError) {
		this.validationError = validationError;
	}
	public String getDbError() {
		return dbError;
	}
	public void setDbError(String dbError) {
		this.dbError = dbError;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public boolean isError() {
		return isError;
	}
	public void setIsError(boolean isError) {
		this.isError = isError;
	}

}
