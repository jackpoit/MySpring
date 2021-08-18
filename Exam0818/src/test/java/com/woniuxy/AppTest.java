package com.woniuxy;

import static org.junit.Assert.assertTrue;

import com.alibaba.druid.pool.DruidDataSource;
import com.woniuxy.bean.Good;
import com.woniuxy.mapper.GoodMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class AppTest {

    @Autowired
    private GoodMapper goodMapper;

    @Test
    public void test01(){

        List<Good> list = goodMapper.findByCondition(null);
        for (Good good : list) {
            System.out.println(good);
        }


    }


}
