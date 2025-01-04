package com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.mapper;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class ObjectMapper {

	private static void copyProperties(Object source, Object target) {
        try {
			BeanUtils.copyProperties(target, source);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
