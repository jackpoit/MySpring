package com.woniuxy.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


/**
 * @Author: rua
 * @Date: 2021/8/12 11:44
 * @Description:
 */
@Configuration
public class Myconfig {
//
//	@ConfigurationProperties(prefix = "spring.datasource")
//	@Bean("dataSource")
//	public DataSource getDataSource() {
//		DruidDataSource dataSource = new DruidDataSource();
//		return dataSource;
//	}
//
//	@Bean
//	JdbcTemplate jdbcTemplateOne() {
//		return new JdbcTemplate(getDataSource());
//	}


}
