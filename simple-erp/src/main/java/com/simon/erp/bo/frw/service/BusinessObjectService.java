package com.simon.erp.bo.frw.service;

import org.springframework.stereotype.Service;

import com.simon.erp.bo.frw.BusinessObject;

@Service
public interface BusinessObjectService<T extends BusinessObject> {
	public T load(Long id);
}
