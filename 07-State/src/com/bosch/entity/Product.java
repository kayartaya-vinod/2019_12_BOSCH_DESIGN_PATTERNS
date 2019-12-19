package com.bosch.entity;

import com.bosch.dao.EntityState;
import com.bosch.dao.Persistable;

public class Product implements Persistable {

	private EntityState state;

	private Integer id;
	private String name;
	private String category;
	private Double price;

	public Product() {
	}

	public Product(String name, String category, Double price) {
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String getInsertSql() {
		return "insert into products(name, category, price) values(?,?,?)";
	}

	@Override
	public Object[] getInsertValues() {
		return new Object[] { name, category, price };
	}

	@Override
	public void changeState(EntityState state) {
		if (this.state == null || state == null) {
			this.state = state;
		}
	}

	@Override
	public EntityState getState() {
		return state;
	}

	@Override
	public String getUpdateSql() {
		return "update products set name=?, category=?, price=? where id=?";
	}

	@Override
	public Object[] getUpdateValues() {
		return new Object[] { name, category, price, id };
	}

	@Override
	public String getDeleteSql() {
		return "delete from products where id=?";
	}

	@Override
	public Object[] getDeleteValues() {
		return new Object[] { id };
	}

}
