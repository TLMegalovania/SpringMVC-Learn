package com.SpringExample.ui.testHibernate;

import com.SpringExample.hibernate.HibernateInitialize;
import com.SpringExample.model.Product;
import org.hibernate.Session;



public class UpdateProduct {

	//修改指定产品信息
	public static void main(String[] args) {
		Session session = null;			//声明Session对象
		try {
			//Hibernate的持久化操作
			session = HibernateInitialize.getSession();//获取Session
			Product product = (Product) session.load(Product.class, new Integer("4"));//装载对象
			session.beginTransaction();//开启事务
			product.setName("Java Web编程词典");//修改商品名称
			product.setRemark("明日科技出品");//修改备注信息
			session.update(product);
			session.getTransaction().commit();//事务提交
			//session.flush();
		} catch (Exception e) {
			System.out.println("对象修改失败");
			e.printStackTrace();
		} finally{
			HibernateInitialize.closeSession();//关闭Session
		}
	}
}
