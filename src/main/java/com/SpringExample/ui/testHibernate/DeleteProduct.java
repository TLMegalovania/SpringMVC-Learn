package com.SpringExample.ui.testHibernate;

import com.SpringExample.hibernate.HibernateInitialize;
import com.SpringExample.model.Product;
import org.hibernate.Session;



public class DeleteProduct {

	//删除指定产品信息
	public static void main(String[] args) {
		Session session = null;			//声明Session对象
		try {
			//Hibernate的持久化操作
			session = HibernateInitialize.getSession();//获取Session
			Product product = (Product) session.get(Product.class, new Integer("6"));//装载对象
			Product product2 = new Product();
			product2.setId(5);
			if (product!=null) {
				session.beginTransaction();//开启事务
				session.delete(product);//删除持久化信息
				session.delete(product2);
				session.getTransaction().commit();//事务提交
			}
			//session.flush();//强制刷新提交
		} catch (Exception e) {
			System.out.println("对象删除失败");
			e.printStackTrace();
		} finally{
			HibernateInitialize.closeSession();//关闭Session
		}
	}

}
