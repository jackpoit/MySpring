package com.woniuxy.dao.impl;


/**
 * @Author: rua
 * @Date: 2021/8/15 18:17
 * @Description:
 */
public class ProductDaoImpl  {
	public void add() {
		System.out.println("ProductDap执行了add()");
	}

	public void delete() {
		System.out.println("ProductDao执行了delete()");

	}

	public void update() {
		System.out.println("ProductDao执行了update()");

	}

	public void find() {
		System.out.println("ProductDao执行了find()");
	}

	public void findAll() {
		System.out.println("ProductDao执行了findAll()");
		String str="";
		for (int i = 0; i <1000 ; i++) {
			str+="sdgsadg";
		}
		System.out.println(str.length());

	}



}
