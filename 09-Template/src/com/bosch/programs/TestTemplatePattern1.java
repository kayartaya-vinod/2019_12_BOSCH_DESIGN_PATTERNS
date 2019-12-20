package com.bosch.programs;

import java.util.Map;

import com.bosch.templates.JdbcTemplate;

public class TestTemplatePattern1 {

	public static void main(String[] args) {
		
		// String sql = "insert into employees values(null, ?,?,?,?)";
		// JdbcTemplate.executeUpdate(sql, "Harish", "Kumar", "hk@xmpl.com", 3200.0);
		// System.out.println("Data inserted!");
		
		String sql = "select * from employees where id = ?";
		Map<String, Object> data = JdbcTemplate.executeQueryForSingle(sql, 1);
		System.out.println(data);
		
		sql = "select * from products where id = ?";
		data = JdbcTemplate.executeQueryForSingle(sql, 1);
		System.out.println(data);
		
	}
}
