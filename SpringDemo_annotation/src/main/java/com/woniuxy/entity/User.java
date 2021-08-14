package com.woniuxy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;


/**
 * @Component //适用于任意类的管理[通用组件]
 * 三个衍生注解
 * @Controller 用于控制器层 SpringMVC框架使用
 * @Service 用于标记业务逻辑层实现类
 * @Repository 用于标记持久层实现类
 */


@Data
@AllArgsConstructor
//@Scope("prototype") // 控制对象的使用范围:默认是singleton单例
//@Component("user") //括号里的就是id  id理论可以重复 但是会覆盖 只有一个会生效
//通过注解无法配置2个不同属性值的对象 但是xml可以
@Component //Spring IOC组件标记
public class User {

	/**
	 * 通过注解注入的2种方式
	 *
	 * @Value 属性上(不太安全, 不提供setXxx方法时采用)
	 * @Value SetXxx()  通过set方法注入(数据校验,相对安全)
	 * <p>
	 * 也可写在get上 但无法DI
	 * <p>
	 * 基本类型DI:@Value("")
	 * 引用类型DI:
	 * @Autowired: 按照类型来注入的[保证这个类型的对象在Spring工厂中只能有一个]
	 * @Qualifier("idName): 配合@Autowired使用,按照类型+名称来自动注入
	 * <p>
	 * 有效替代方案:@Resource(name = "")==@Autowired +@Qualifier("idName")
	 * 按照名称直接注入
	 * <p>
	 * 有区别 resource是java自带的注解
	 */

	@Value("2")
	private Integer id;

	@Value("ADMIN")
	private String uname;


	//	@Autowired
//	@Resource(name = "car2")
	private Car car;


	public User() {
		System.out.println("创建了User");
	}

	@PostConstruct //构造之后执行的初始化方法
	public void init() {
		System.out.println("init...");
	}

	@PreDestroy //在spring工厂销毁之前来执行此方法后销毁此对象
	public void destroy() {
		System.out.println("destroy...");
	}

}
