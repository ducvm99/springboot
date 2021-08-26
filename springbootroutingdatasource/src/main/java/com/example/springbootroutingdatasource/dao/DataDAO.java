package com.example.springbootroutingdatasource.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
public class DataDAO extends JdbcDaoSupport {
    @Autowired
    public DataDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<String> queryPublisher() {
        String sql = "select name from publishers";

        List<String> list = this.getJdbcTemplate().queryForList(sql, String.class);
        return list;
    }

    public List<String> queryAdvertiser() {
        String sql = "select name from advertisers";

        List<String> list = this.getJdbcTemplate().queryForList(sql, String.class);
        return list;
    }
}
