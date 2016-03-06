package com.changs.kelly.campus.common.dao;

public interface SqlDao<T> {

	abstract int insert(T t);

	abstract int delete(T t);

	abstract int update(T t);

	abstract T query(int id, Class<T> clazz);
}
