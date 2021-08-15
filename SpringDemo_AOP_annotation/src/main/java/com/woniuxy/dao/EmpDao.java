package com.woniuxy.dao;

import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/15 21:53
 * @Description:
 */
public interface EmpDao {

	void add();

	int delete();

	void update();

	void find();

	List<String> findAll();
}
