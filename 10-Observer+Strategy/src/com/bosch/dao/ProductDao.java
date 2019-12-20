package com.bosch.dao;

import com.bosch.entity.Product;

public class ProductDao extends AbstractDao<Product> {

	@Override
	protected String getInsertSql() {
		return "insert into products (name, category, price) values (?,?,?)";
	}

	@Override
	protected Object[] getInsertValues(Product p) {
		return new Object[] { p.getName(), p.getCategory(), p.getPrice() };
	}

	@Override
	protected String getUpdateSql() {
		return "update products set name=?, category=?, price=? where id=?";
	}

	@Override
	protected Object[] getUpdateValues(Product p) {
		return new Object[] {
			p.getName(),
			p.getCategory(),
			p.getPrice(),
			p.getId()
		};
	}

	@Override
	protected String getDeleteSql() {
		return "delete from products where id=?";
	}

	@Override
	protected Object[] getDeleteValues(Product p) {
		return new Object[] { p.getId() };
	}

}
