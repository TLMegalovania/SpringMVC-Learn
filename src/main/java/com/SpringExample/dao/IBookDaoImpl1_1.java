package com.SpringExample.dao;

import com.SpringExample.model.Account;
import com.SpringExample.model.AccountRowMapper;
import com.SpringExample.model.Book;
import com.SpringExample.model.BookRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository(value="bookDao1")
public class IBookDaoImpl1_1 implements  IBookDao{

    //@Autowired
    //@Resource(name="jdbcTemplate_oracle")
    @Resource(name="jdbcTemplate")
    protected JdbcTemplate jdbcTemplate;

    //@Autowired
    //@Resource(name="namedParameterJdbcTemplate_oracle")
    @Resource(name="namedParameterJdbcTemplate")
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public int save(Book book) {
        return 0;
    }

    public int update(Book book) {
        return 0;
    }

    public int delete(Book book) {
        return 0;
    }

    public Book findById(String isbn) {
        String sql = "select * from tsb where isbm=?";
        List<Book> results = jdbcTemplate.query(sql, new Object[]{ isbn}, new BookRowMapper());
        if (results!=null && results.size() > 0)
            return results.get(0);

        return null;
    }

    public List<Book> findByName(String name) {
        String sql = "select * from tsb where sm like :likeName ";
        Map<String, Object> paramMap = new HashMap<String,Object>();
        paramMap.put("likeName", "%" + name + "%");

        List<Book> results = namedParameterJdbcTemplate.query(sql, paramMap, new BookRowMapper());
        return results;
    }

    public List<Book> findAll() {
        String sql = "select * from TSB ";
        List<Book> results = jdbcTemplate.query(sql, new BookRowMapper());
        return results;
    }
}
