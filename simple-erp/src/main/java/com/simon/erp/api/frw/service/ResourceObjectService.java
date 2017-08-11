package com.simon.erp.api.frw.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simon.erp.api.frw.AbstractResourceObject;
import com.simon.erp.bo.frw.BusinessObject;
import com.simon.erp.bo.frw.service.BusinessObjectService;

@Service
public class ResourceObjectService<RO extends AbstractResourceObject, BO extends BusinessObject> {
	
    @Autowired
    private BusinessObjectService<BusinessObject> service;
    
    private DozerBeanMapper dozerMapper = new DozerBeanMapper();
    
    protected Class<RO> roClass;
    protected Class<BO> boClass;
    
    public ResourceObjectService() {
    	
    }
	public ResourceObjectService(Class<RO> roClass, Class<BO> boClass) {
    	this.roClass = roClass;
    	this.boClass = boClass;
    }
	
	public RO load(Long id, String select) {
		BusinessObject bo = service.load(id);
		RO result = dozerMapper.map(bo, roClass);
		return result;
	}
//	
//	public RO list(String select) {
//		
//	}

}
