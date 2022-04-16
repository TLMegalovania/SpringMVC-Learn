package com.SpringExample.service;

import com.SpringExample.model.Account;
import com.SpringExample.model.Book;

import java.util.List;

public interface IBookService {

    boolean add(Book book);
    boolean update(Book book);
    boolean delete(Book book);
    Book findById(String isbm);
    List<Book> findByName(String name);
    List<Book> findAll();
}
