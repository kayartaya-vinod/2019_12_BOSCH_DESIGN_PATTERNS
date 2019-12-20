package com.bosch.programs;

import java.util.List;

import com.bosch.entity.Employee;
import com.bosch.templates.JdbcTemplate;
import com.bosch.templates.RowMapper;

public class TestTemplateQuery {

	public static void main(String[] args) throws Exception{
		
		String sql = "select * from employees where salary > ?";
		RowMapper<Employee> erm = (rs) -> {
			Employee e = new Employee();
			e.setId(rs.getInt("id"));
			e.setFirstname(rs.getString("firstname"));
			e.setLastname(rs.getString("lastname"));
			e.setEmail(rs.getString("email"));
			e.setSalary(rs.getDouble("salary"));
			return e;
		};
		
		List<Employee> list = JdbcTemplate.executeQueryForMany(sql, erm, 2500);
		for(Employee e: list) {
			System.out.println(e);
		}
		
		
	}

}
