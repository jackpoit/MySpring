package com.woniuxy;

import static org.junit.Assert.assertTrue;

import com.alibaba.druid.pool.DruidDataSource;
import com.woniuxy.bean.App;
import com.woniuxy.service.AppService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void test01(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/appdb?serverTimezone=UTC&characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        String sql="SELECT * FROM app";
        List<App> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<App>(App.class));
        System.out.println(list);

        String sql1="DELETE FROM app where id=?";
        int row = jdbcTemplate.update(sql, new BeanPropertyRowMapper<App>(App.class), 10);
        System.out.println(row);


    }


}
