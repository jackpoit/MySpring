package com.woniuxy;

/**
 * @Author: rua
 * @Date: 2021/8/15 0:46
 * @Description:
 */

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 基于注解的Spring核心配置
 *
 * 这段配置对于深刻理解springboot有很大帮助
 */
@Configuration  //将这个类作为spring的核心配置类使用
@ComponentScan  //自动扫描当前这个类所在包及其子包下的所有类中的IOC注解
public class ApplicationConfig {
	private static String DRIVER=null;
	private static String URL=null;
	private static String USER=null;
	private static String PASSWORD=null;
	private static Integer INITIAL_POOL_SIZE=null;
	private static Integer MAX_POOL_SIZE=null;

	static {

//		String path = ApplicationConfig.class.getClassLoader().getResource("").getPath();
//		加classLoader获取的是src根路径 无com.woniuxy  如果是这个可直接放在resources中

		//获取的是ApplicationConfig所在包的绝对路径 有com.woniuxy
		String path = ApplicationConfig.class.getResource("").getPath();


		Properties props = new Properties();
		try {
			//application可以直接放在resources中 建一个com.woniuxy的文件夹中 注意要一个一个建(不然会建成名为com.woniuxy的文件夹)!!!

			props.load(new FileInputStream(path+ "application.properties"));
			DRIVER=props.getProperty("spring.jdbc.driver");
			URL=props.getProperty("spring.jdbc.url");
			USER=props.getProperty("spring.jdbc.user");
			PASSWORD=props.getProperty("spring.jdbc.password");
			INITIAL_POOL_SIZE=Integer.parseInt(props.getProperty("spring.jdbc.initPoolSize"));
			MAX_POOL_SIZE=Integer.parseInt(props.getProperty("spring.jdbc.maxPoolSize"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

//	@Scope("prototype")
//	@Bean
//	public User getUser(){
//		return new User();
//	}

	@Bean  //将数据交给Spring管理
	public DataSource getDataSource(){
		DruidDataSource druid = new DruidDataSource();
		druid.setDriverClassName(DRIVER);
		druid.setUrl(URL);
		druid.setUsername(USER);
		druid.setPassword(PASSWORD);
		druid.setInitialSize(INITIAL_POOL_SIZE);
		druid.setMaxActive(MAX_POOL_SIZE);
		return druid;
	}

	@Bean
	public JdbcTemplate getTemplate(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}

}
