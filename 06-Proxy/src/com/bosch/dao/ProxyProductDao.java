package com.bosch.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// an object of this class can intercept methods on a "target" object,
// in our example, it is the DummyProductDao object.
public class ProxyProductDao implements InvocationHandler {

	private Object target;
	
	public ProxyProductDao(Object target) {
		this.target = target;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		Object retVal = null;
		
		switch(method.getName()) {
		case "saveProduct": 
		case "deleteProduct": 
		
			System.out.println("Beginning transaction");
			// delegate the call to the actual target method (on the DummyProductDao)
			retVal = method.invoke(target, args);
			System.out.println("Committing transaction");
			System.out.println("------------------------------------");
			break;
		case "getProductCount":
			retVal = method.invoke(target, args);
			break;
		default:
			throw new RuntimeException("Unknown method for proxy");
		}
		
		return retVal;
	}

}
