package com.woniuxy.util;


import com.woniuxy.bean.User;

/**
 * @Author: rua
 * @Date: 2021/8/12 9:00
 * @Description:
 */
public class BeanFactory {
	private static final BeanFactory FACTORY=new BeanFactory();
	private BeanFactory(){

	}

	/**
	 * 通过id来获取bean对象
	 * @param idName xml中bean的id
	 * @return 对象
	 */
	public Object getBean(String idName){
		if (idName==null||"".equals(idName))
			return null;
		//1.通过id去默认的xml中招对应的class路径
		String className = XmlParser.getClassNameById(idName);
		try {
			//2.通过字符串来获取对应的字节码对象
			Class<?> clazz = Class.forName(className);
			//3.返回对象
			return clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public static void main(String[] args) {
		User user = (User) FACTORY.getBean("user");
		System.out.println(user);

	}

}
