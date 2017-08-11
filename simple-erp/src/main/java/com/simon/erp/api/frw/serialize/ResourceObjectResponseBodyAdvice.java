package com.simon.erp.api.frw.serialize;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 
 * @author I309922
 * <p>Support the first level select</p>
 */

@ControllerAdvice
public class ResourceObjectResponseBodyAdvice implements ResponseBodyAdvice<Object> {

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		if(request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest httpRequest = (ServletServerHttpRequest) request;
			String select = httpRequest.getServletRequest().getParameter("select");
			String fields[] = select.split(",");
			Object retObj = null;
			if(body.getClass().isArray()) {
				Object[] list = (Object[]) body;
				retObj = handleList(convertToArray(list), fields);
			} else {
				retObj = handleObject(body, fields);
			}
			return retObj;
		} else {
			return body;
		}
	}
	
	private List<Object> handleList(List<Object> list, String[] includes) {
		List<Object> retList = new ArrayList<>();
        for (Object o : list){
            Map<String, Object> map = handleObject(o, includes);
            retList.add(map);
        }
        return retList;
	}
	
	private Map<String, Object> handleObject(Object o, String[] includes) {
		Map<String,Object> map = new HashMap<String, Object>();

        Field[] fields = o.getClass().getDeclaredFields();
        try {
        	for (Field field : fields) {
            	field.setAccessible(true);
                if (includes.length == 0) {
                    map.put(field.getName(), field.get(o));
                } else if (includes.length > 0){
                    if(isStringInArray(field.getName(), includes)){
                        map.put(field.getName(), field.get(o));
                    }
                }

            }
        } catch (IllegalAccessException e) {
        	return new HashMap<>();
        }
        
        return map;
	}
	
	private Boolean isStringInArray(String s, String [] collection) {
		for(String ele : collection) {
			if(StringUtils.pathEquals(ele, s)) {
				return true;
			}
		}
		return false;
	}
	
	private List<Object> convertToArray(Object[] list) {
		List<Object> retResult = new ArrayList<>();
		for(Object object : list) {
			retResult.add(object);
		}
		return retResult;
	}
}
