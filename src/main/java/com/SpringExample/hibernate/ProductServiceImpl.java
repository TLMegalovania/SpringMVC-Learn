package com.SpringExample.hibernate;

import com.SpringExample.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="productService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    public List<Product> findAll() {
        return this.productDao.findAll();
    }

    public Product findProductById(int id) {
        return this.productDao.findProductById(id);
    }

    public void save(Product entity) {
        this.productDao.save(entity);
    }

    public void update(Product entity) {
        this.productDao.update(entity);
    }

    public void delete(int id) {
        this.productDao.delete(id);
    }
}
