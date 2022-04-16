package com.SpringExample.service;

import com.SpringExample.dao.IBookDao;
import com.SpringExample.model.Book;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value="bookService1") //==>BookServiceImpl_1 bookService1 = new BookServiceImpl_1();
public class BookServiceImpl_1 implements IBookService {

    @Resource(name="bookDao1")
    private IBookDao bookDao;

    public boolean add(Book book) {
        int updated  = bookDao.save(book);
        return updated > 0 ? true : false;
    }

    public boolean update(Book book) {
        int updated  =  bookDao.update(book);
        return updated > 0 ? true : false;
    }

    public boolean delete(Book book) {
        int updated  =  bookDao.delete(book);
        return updated > 0 ? true : false;
    }

    public Book findById(String isbn) {
        return bookDao.findById(isbn);
    }

    public List<Book> findByName(String name) {
        return bookDao.findByName(name);
    }

    public List<Book> findAll() {
        return bookDao.findAll();
    }
}
