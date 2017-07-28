package com.simon.erp.rest.common;

public enum BusinessErrorType {
	BUSINESS_ERROR(500);
	
	private Integer errorCode;
	
	private BusinessErrorType(Integer errorCode) {
		this.errorCode = errorCode;
	}
	
	public Integer getErrorCode() {
		return this.errorCode;
	}
}
