package com.SpringExample.hibernate;

import com.SpringExample.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements IProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    /*
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    */

    //获取和当前线程绑定的Seesion
    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    public List<Product> findAll() {
        String hql = "from Product";
        Query<Product> query = this.getSession().createQuery(hql);
        return query.list();
    }

    public Product findProductById(int id) {
        Product product = (Product) this.getSession().get(Product.class, new Integer(id));//装载对象
        return product;
    }

    public void save(Product entity) {
        this.getSession().save(entity);
    }

    public void update(Product entity) {
        this.getSession().update(entity);
    }

    public void delete(int id) {
        Product product = this.findProductById(id);
        if (product!=null)
            this.getSession().delete(product);
    }
}
