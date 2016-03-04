package com.changs.kelly.campus.common;

public interface BaseSqlDao<T> {

	abstract int insert(T t);

	abstract int delete(T t);

	abstract int update(T t);

	abstract T query(int id, Class<T> clazz);
}
