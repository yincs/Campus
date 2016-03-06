package com.changs.kelly.campus.common.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.changs.kelly.campus.common.Application;

public class SqDaoImpl<T> implements SqlDao<T> {

	protected static SessionFactory sessionFactory;
	static {
		sessionFactory = Application.getContext().getBean(SessionFactory.class);
	}

	public int insert(T t) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(t);
			tx.commit();
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return -1;
	}

	public int delete(T t) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(t);
			tx.commit();
			return 0;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return -1;
	}

	public int update(T t) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(t);
			tx.commit();
			return 0;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return -1;
	}

	public T query(int id, Class<T> clazz) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			T t = session.get(clazz, id);
			tx.commit();
			return t;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return null;
	}

}
