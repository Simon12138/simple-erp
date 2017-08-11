package com.simon.erp.api.frw;

import org.springframework.http.ResponseEntity;

public interface ResourceObjectController <RO extends AbstractResourceObject> {
	
	public ResponseEntity<RO> get(Long id, String select);

    public ResponseEntity<RO[]> list(String select);
}
