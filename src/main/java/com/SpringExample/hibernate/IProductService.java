package com.SpringExample.hibernate;

import com.SpringExample.model.Product;

import java.util.List;

public interface IProductService {


    public List<Product> findAll();
    public Product findProductById(int id);
    public void save(Product entity);
    public void update(Product entity);
    public void delete(int id);
}
