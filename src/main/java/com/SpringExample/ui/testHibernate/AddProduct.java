package com.SpringExample.ui.testHibernate;

import com.SpringExample.hibernate.HibernateInitialize;
import com.SpringExample.model.Product;
import org.hibernate.Session;



public class AddProduct {

	/**
	 * 添加商品
	 */
	public static void main(String[] args) {
		Session session = null;			//声明Session对象
		Product product = new Product();//实例化持久化类, 目前处于瞬时状态
		//为持久化类属性赋值
		product.setName("Java Web编程宝典");//设置产品名称
		product.setPrice(81.00);//设置产品价格
		product.setFactory("清华大学出版社");//设置生产商
		product.setRemark("无");//无
		//Hibernate的持久化操作
		try {
			session = HibernateInitialize.getSession();//获取Session
			session.beginTransaction();//开启事务
			session.save(product);//执行数据库添加操作， 目前处于持久化状态
			session.getTransaction().commit();//事务提交 ，目前处于脏对象状态
		} catch (Exception e) {
			session.getTransaction().rollback();//事务回滚
			System.out.println("数据添加失败");
			e.printStackTrace();
		}finally{
			HibernateInitialize.closeSession();//关闭Session对象，目前处于托管状态，最后被JVM回收
		}
	}
}
