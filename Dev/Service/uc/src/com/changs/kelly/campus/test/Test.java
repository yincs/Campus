package com.changs.kelly.campus.test;

import java.sql.SQLException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.changs.kelly.campus.dao.UserDao;
import com.changs.kelly.campus.db.DbConn;
import com.changs.kelly.campus.entity.UserInfo;

public class Test {

	public static void main(String[] args) {
		try {
			String url = DbConn.getConn().getMetaData().getURL();
			System.out.println(url);
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		
		Resource resource = new ClassPathResource("application.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		UserDao userDao =  factory.getBean("userDao",UserDao.class);
		
		
		UserInfo info = new UserInfo();
		info.setUserId("123456");
		info.setUserName("长松");
		info.setUserRemark("spring");
		info.setUserBrithday("1992-12-12");
		info.setUserSex(1);
		userDao.insert(info);
	}

}
