package com.woniuxy.dao.impl;

import com.woniuxy.dao.EmpDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

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
public class EmpDaoImpl implements EmpDao {

	@Override
	public void add() {
		System.out.println("empDao执行了add()");
	}

	@Override
	public int delete() {
		System.out.println("empDao执行了delete()");
		return 1;
	}

	@Override
	public void update() {
		try {
			int a=10/0;
			System.out.println("empDao执行了update()");
		}catch (Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public void find() {
		System.out.println("empDao执行了find()");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> findAll() {
		System.out.println("empDao执行了findAll()");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Arrays.asList("a","b","c");
	}
}
