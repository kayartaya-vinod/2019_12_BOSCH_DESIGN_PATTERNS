package com.bosch.service;

// This class is marked as final, so that an object of this class cannot be
// created using a subclass of the same.
public final class ProductService implements Cloneable {

	// constructor is private, so that an object of this class can only
	// be created from with in this class
	private ProductService() {
	}
	
	static class Holder {
		private static ProductService instance = new ProductService();
	}
	
	public static ProductService getInstance() {
		// this is where the Holder class is loaded into the JVM (on first use)
		return Holder.instance;
	}

	// in case if the client API demands cloning of this instance...
	@Override
	public ProductService clone() throws CloneNotSupportedException {
		// return (ProductService) super.clone();
		return Holder.instance;
	}
	
	
	
	// other member functions of ProductService
}
