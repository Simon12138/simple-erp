package com.simon.erp.bo.frw.service;

import com.simon.erp.bo.frw.BusinessObject;

public interface BusinessObjectService<T extends BusinessObject> {
	public T load(Long id);
}
