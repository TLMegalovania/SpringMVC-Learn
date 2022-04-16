package com.SpringExample.dao;

import com.SpringExample.model.Account;
import com.SpringExample.model.Book;

import java.util.List;

/**
 * 书的持久层接口
 */
public interface IBookDao {


    int save(Book book);
    int update(Book book);
    int delete(Book book);
    Book findById(String isbn);
    List<Book> findByName(String name);
    List<Book> findAll();

}
