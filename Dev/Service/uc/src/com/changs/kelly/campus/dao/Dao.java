package com.changs.kelly.campus.dao;

import java.awt.List;
import java.sql.Connection;

import com.changs.kelly.campus.db.DbConn;

public abstract class Dao<T> {
	protected Connection mConn;

	public Dao() {
		this.mConn = DbConn.getConn();
	}
	  
	public abstract boolean insert(T t);
	
	public abstract boolean delete(T t);
	
	public abstract boolean delete(int id);
	
	public abstract boolean update(T t);
	
	public abstract T query(int id);
}
