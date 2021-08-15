package com.woniuxy.entity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author: rua
 * 基于AOP的注解开发
 * AOP一般都是对方法层面的增强
 * Aspect 定义切面:一些通知+一些切入点
 */
@Component    //将切面交给Spring管理
@Aspect    //AOP切面标记
public class MyAspect {

	private static final Log LOG = LogFactory.getLog(MyAspect.class);

	//AspectJ提供了一套非常厉害的切入点表达式的写法


	//@Before 前置通知 :在切入点之前增强
	@Before("execution(* com.woniuxy.dao.impl.*Impl.add(..))")
	public void writeLog(JoinPoint joinPoint) {    //通知Advice:增强方法
//		System.out.println("#####日志管理#####" + joinPoint);

		LOG.info(joinPoint + "正在被增强");
		LOG.debug("单步调试中");
		LOG.error("程序报错了");

	}

	//@AfterReturning 后置通知 还可以接受方法的返回值,result只是一个变量名,用来接受核心逻辑方法执行后的返回值
	@AfterReturning(pointcut = "execution(* com.woniuxy.dao.impl.*Impl.delete*(..))", returning = "result")
	public void checkDelete(int result) {    //形参名必须和returning="result"要一致
		System.out.println("***是否删除成功***" + result);
	}

	//3.@Around 环绕通知[需要手动配置的通知]
	@Around("execution(* com.woniuxy.dao.impl.*.find*(..))")
	public Object testTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object result = joinPoint.proceed();//执行核心业务方法并返回方法返回值
		long end = System.currentTimeMillis();
		System.out.println("方法返回值:" + result);
		System.out.println("耗时:" + (end - start) + "s");
		return result;
		//需要return吗
	}


	//4.@AfterThrowing 异常抛出通知[当切入点的核心方法在执行中出错时,就会被此增强方法拦截]
	@AfterThrowing(pointcut = "execution(* com.woniuxy.dao.impl.*.update(..))", throwing = "e")
	public void checkUpdate(Throwable e) {    //需要使用异常Exception和错误Error的顶层接口 ,e与上面的e要一致
//		e.printStackTrace();
		LOG.error("程序出错了"+e.getClass()+e.getMessage());
		//事务发生异常 执行rollback
	}

	@After("execution(* com.woniuxy.dao.impl.*.update(..))")
	public void finallyTest(){
		System.out.println("最终通知:一般用来释放资源");
	}
}
