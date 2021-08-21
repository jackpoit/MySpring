package com.woniuxy.test;

import com.woniuxy.bean.Anjuke;
import com.woniuxy.bean.User;
import com.woniuxy.dao.AnjukeMapper;
import com.woniuxy.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/21 15:47
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class SpringTest {

	@Autowired
	private AnjukeMapper anjukeMapper;
	@Autowired
	private DataSource druid;

	@Autowired
	private UserMapper userMapper;
	@Test
	public void demo1() throws SQLException {
		//1.判断ioc是否成功
		//2.判断数据库是否连接成功
		System.out.println(druid.getConnection());
	}
	@Test
	public void demo2() throws SQLException {
		List<User> list = userMapper.findAll();
		for (User user : list) {
			System.out.println(user);
		}
	}
	@Test
	public void demo3() throws SQLException {
		List<Anjuke> list = anjukeMapper.selectAll();
		for (Anjuke anjuke : list) {
			System.out.println(anjuke);
		}
	}
	@Test
	public void demo4() throws SQLException {
		int row = anjukeMapper.deleteByPrimaryKey(29);
		System.out.println(row>0?"成功":"失败");

	}
	@Test
	public void demo5() throws SQLException {
		Anjuke anjuke = new Anjuke();
		anjuke.setZone("崇明区");
		int row = anjukeMapper.insert(anjuke);
		System.out.println(anjuke);
		System.out.println(row>0?"成功":"失败");

	}
	@Test
	public void demo6() throws SQLException {
		Anjuke anjuke = new Anjuke();
		anjuke.setZone("崇明区");
		int row = anjukeMapper.insertSelective(anjuke);
		System.out.println(anjuke);
		System.out.println(row>0?"成功":"失败");
	}
	@Test
	public void demo7() throws SQLException {
		Anjuke anjuke = new Anjuke();
		anjuke.setId(28);
		anjuke.setZone("崇明区");
		int row = anjukeMapper.updateByPrimaryKeySelective(anjuke);
		System.out.println(anjuke);
		System.out.println(row>0?"成功":"失败");
	}
	@Test
	public void demo8() throws SQLException {

		int c = anjukeMapper.selectCount(null);
		System.out.println(c);
	}
	@Test
	public void demo9() throws SQLException {
		Anjuke anjuke = new Anjuke();
		anjuke.setId(28);
		anjuke.setZone("崇明区");
		List<Anjuke> list = anjukeMapper.select(anjuke);
		for (Anjuke anjuke1 : list) {
			System.out.println(anjuke1);
		}
	}
}
