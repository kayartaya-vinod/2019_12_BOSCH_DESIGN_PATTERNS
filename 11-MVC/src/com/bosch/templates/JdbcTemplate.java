package com.bosch.templates;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.bosch.util.DbConnectionFactory;

// by making the class as final and constructor
// as private, we are avoiding unnecessary object creation
public final class JdbcTemplate {

	private JdbcTemplate() {
	}
	
	// a template method for PreparedStatement.executeQuery
	// returns a list of T instances
	public static <T> List<T> executeQueryForMany(
			String sql, RowMapper<T> mapper, Object...params)  throws TemplateException{
		
		List<T> list = new ArrayList<T>();
		
		try(
				Connection conn = DbConnectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
			){
				for (int i = 0; i < params.length; i++) {
					stmt.setObject(i+1, params[i]);
				}
				
				try(ResultSet rs = stmt.executeQuery()){
					while(rs.next()) {
						list.add(mapper.mapRow(rs));
					}
				}
			}
			catch(Exception ex) {
				throw new TemplateException(ex);
			}
		
		return list;
	}
	
	
	// a template method for PreparedStatement.executeQuery
	public static Map<String, Object> executeQueryForSingle(String sql, Object ...params) throws TemplateException {
		try(
			Connection conn = DbConnectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
		){
			for (int i = 0; i < params.length; i++) {
				stmt.setObject(i+1, params[i]);
			}
			
			try(ResultSet rs = stmt.executeQuery()){
				if(rs.next()) {
					return resultSetToMap(rs);
				}
				return null;
			}
		}
		catch(Exception ex) {
			throw new TemplateException(ex);
		}
	}
	
	private static Map<String, Object> resultSetToMap(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		Map<String, Object> m = new LinkedHashMap<String, Object>();
		for(int i=1, j=rsmd.getColumnCount(); i<=j; i++) {
			String key = rsmd.getColumnName(i);
			Object value = rs.getObject(i);
			m.put(key, value);
		}
		return m;
	}

	// a template method for PreparedStatement.executeUpdate
	public static int executeUpdate(String sql, Object ...params) throws TemplateException {
		try(
			Connection conn = DbConnectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
		){
			for (int i = 0; i < params.length; i++) {
				stmt.setObject(i+1, params[i]);
			}
			return stmt.executeUpdate();
		}
		catch(Exception ex) {
			throw new TemplateException(ex);
		}
	}
	
}
