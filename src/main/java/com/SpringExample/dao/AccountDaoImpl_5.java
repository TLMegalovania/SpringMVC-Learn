package com.SpringExample.dao;

import com.SpringExample.model.Account;
import com.SpringExample.model.AccountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository(value="accountDao5")
public class AccountDaoImpl_5 implements IAccountDao {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Autowired
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void saveAccount() {
        System.out.println("这是" + this.getClass().getName() + "保存了我的账户");
    }

    public int save(Account account) {
        String sql = "INSERT INTO account (name, money) VALUES (?,?)";

        int update = this.jdbcTemplate.update(sql,
                new Object[] { account.getName(), account.getMoney()});
        return update;
    }

    public int update(Account account) {
        String sql = "UPDATE account SET name=?,money=? WHERE id=?";

        int update = this.jdbcTemplate.update(sql,
                new Object[] {account.getName(),account.getMoney(),account.getId()});
        return update ;
    }

    public int delete(Account account) {
        String sql = "delete from account WHERE id=?";

        int update = this.jdbcTemplate.update(sql, new Object[] { account.getId() });
        return update;
    }

    public Account findById(Integer id) {
        String sql = "select * from account where id=?";
        List<Account> results = jdbcTemplate.query(sql, new Object[]{ id}, new AccountRowMapper());
        if (results!=null && results.size() > 0)
            return results.get(0);

        return null;
    }

    public List<Account> findByName(String name) {
        String sql = "select * from account where name like :likeName ";
        Map<String, Object> paramMap = new HashMap<String,Object>();
        paramMap.put("likeName", "%" + name + "%");

        List<Account> results = namedParameterJdbcTemplate.query(sql, paramMap, new AccountRowMapper());
        return results;
    }

    public List<Account> findAll() {
        String sql = "select * from account ";
        List<Account> results = jdbcTemplate.query(sql, new AccountRowMapper());
        return results;
    }
}
