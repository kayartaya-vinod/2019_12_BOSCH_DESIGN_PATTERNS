package com.bosch.dao;

import java.util.List;

import com.bosch.entity.Employee;
import com.bosch.templates.JdbcTemplate;
import com.bosch.templates.RowMapper;

public class JdbcEmployeeDao implements EmployeeDao {

	RowMapper<Employee> mapper = rs->{
		Employee e = new Employee();
		e.setId(rs.getInt("id"));
		e.setFirstname(rs.getString("firstname"));
		e.setLastname(rs.getString("lastname"));
		e.setEmail(rs.getString("email"));
		e.setSalary(rs.getDouble("salary"));
		return e;
	};
	
	@Override
	public List<Employee> getAllEmployees() throws DaoException {
		try {
			String sql = "select * from employees";
			return JdbcTemplate.executeQueryForMany(sql, mapper);
		}
		catch(Exception ex) {
			throw new DaoException(ex);
		}
	}

	@Override
	public void deleteEmployee(int id) throws DaoException {
		try {
			String sql = "delete from employees where id=?";
			JdbcTemplate.executeUpdate(sql, id);
		}
		catch(Exception ex) {
			throw new DaoException(ex);
		}
	}

}
