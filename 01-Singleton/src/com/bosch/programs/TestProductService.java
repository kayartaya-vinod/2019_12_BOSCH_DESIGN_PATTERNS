package com.bosch.programs;

import com.bosch.service.ProductService;

public class TestProductService {

	public static void main(String[] args) throws Exception {
		
		ProductService s1 = ProductService.getInstance();
		ProductService s2 = ProductService.getInstance();

		System.out.println(s1);
		System.out.println(s2);

		System.out.println("s1==s2 is " + (s1 == s2));
		
		ProductService s3 =  s1.clone(); // not really cloning..
		System.out.println(s3);
		System.out.println("s1==s3 is " + (s1==s3));
		
		for(int i=0; i<5; i++) {
			new Thread(()->{
				ProductService s = ProductService.getInstance();
				System.out.println(s);
			}).start();
		}

	}
}
