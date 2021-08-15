package com.woniuxy.dao.impl;

import com.woniuxy.dao.UserDao;
import com.woniuxy.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @Author: rua
 * 开发AOP[传统AOP 基于AspectJ的切面]
 * 传统AOP:spring-aop.jar  aopaliance.jar
 * AspectJ: spring-aspect[切面jar]  aspectj.weaver
 */

/**
 * 连接点JoinPoint:add() delete() update() find() 可能被增强的方法
 * 目标对象 Target:需要被增强的对象
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public void add() {
		System.out.println("UserDao执行了add()");
	}

	@Override
	public int deleteById() {
		System.out.println("UserDao执行了delete()");
		return 2;
	}

	@Override
	public void update() {
		System.out.println("UserDao执行了update()");
//		try {
			String s=null;
			s.length();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public void find() {
		System.out.println("UserDao执行了find()");
	}
}
