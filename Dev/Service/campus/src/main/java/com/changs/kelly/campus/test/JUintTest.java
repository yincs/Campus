package com.changs.kelly.campus.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class JUintTest extends TestCase {

	private ApplicationContext ctx = null;

	public void testConfigureFile() throws Exception {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		javax.sql.DataSource dataSource = ctx.getBean(javax.sql.DataSource.class);

		org.hibernate.SessionFactory sessionFactory = ctx.getBean(org.hibernate.SessionFactory.class);

		System.out.println("返回：" + sessionFactory);

		Session session = sessionFactory.openSession(); // 创建一个会话
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); // 开始一个事务
			Query query = session.createQuery("from Customer as c order by c.name asc");
			List customers = query.list();
			for (Iterator it = customers.iterator(); it.hasNext();) {
				// printCustomer(context, out, (Customer) it.next());
			}

			tx.commit(); // 提交事务

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}

}
