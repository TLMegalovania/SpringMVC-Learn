package com.SpringExample.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {

    public Book mapRow(ResultSet resultSet, int rowIndex) throws SQLException {
        Book book = new Book();
        book.setIsbn(resultSet.getString("isbn"));
        book.setSm(resultSet.getString("sm"));
        book.setLb(resultSet.getString("lb"));
        book.setYssl(resultSet.getInt("yssl"));
        book.setDj(resultSet.getDouble("dj"));
        book.setCbrq(resultSet.getDate("cbrq"));
        return book;
    }
}
