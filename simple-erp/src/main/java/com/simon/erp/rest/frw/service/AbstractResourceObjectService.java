package com.simon.erp.rest.frw.service;

import com.simon.erp.rest.frw.AbstractResourceObject;

public interface AbstractResourceObjectService {
	
	public AbstractResourceObject load(Long id, String select, String filter);
	
	public AbstractResourceObject list(String select, String filter, String search);

}
