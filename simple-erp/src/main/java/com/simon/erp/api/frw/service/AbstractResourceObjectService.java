package com.simon.erp.api.frw.service;

import com.simon.erp.api.frw.AbstractResourceObject;

public interface AbstractResourceObjectService {
	
	public AbstractResourceObject load(Long id, String select, String filter);
	
	public AbstractResourceObject list(String select, String filter, String search);

}
