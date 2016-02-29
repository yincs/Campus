package com.changs.kelly.campus.dao;

import org.springframework.jdbc.core.JdbcTemplate;


public abstract class Dao<T> {
    protected JdbcTemplate jdbcTemplate;

	public Dao() {
	}
	  
	public abstract boolean insert(T t);
	
	public abstract boolean delete(T t);
	
	public abstract boolean delete(int id);
	
	public abstract boolean update(T t);
	
	public abstract T query(int id);
}
