package com.bosch.dao;

import com.bosch.entity.Employee;

public class TestStatePattern {

	public static void main(String[] args) throws DaoException {
		EntityManager em = new EntityManager();
		
		Employee e1 = new Employee("Jane", "Doe", "janedoe@xmpl.com", 3300.0);
		em.insert(e1);
		
		Employee e2 = new Employee("John", "Doe", "johndoe@xmpl.com", 3000.0);
		e2.setId(1);
		em.update(e2);
		
		Employee e3 = new Employee();
		e3.setId(4);
		em.delete(e3);
		
		em.commit();
		System.out.println("Done!");
		
		
	}
}
