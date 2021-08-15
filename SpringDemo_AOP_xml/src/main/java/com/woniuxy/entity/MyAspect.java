package com.woniuxy.entity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author: rua
 * 基于AOP的xml开发
 * AOP一般都是对方法层面的增强
 * Aspect 定义切面:一些通知+一些切入点
 */
//@Component("myAspect")
@Component //当不写Id是 交给Spring时默认id是类名首字母小写
public class MyAspect {

	private static final Log LOG = LogFactory.getLog(MyAspect.class);


	public void writeLog(JoinPoint joinPoint) {    //通知Advice:增强方法
//		System.out.println("#####日志管理#####" + joinPoint);

		LOG.info(joinPoint + "正在被增强");
		LOG.debug("单步调试中");
		LOG.error("程序报错了");

	}

	public void checkDelete(int result) {    //形参名必须和returning="result"要一致
		System.out.println("***是否删除成功***" + result);
	}

	public Object testTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object result = joinPoint.proceed();//执行核心业务方法并返回方法返回值
		long end = System.currentTimeMillis();
		System.out.println("方法返回值:" + result);
		System.out.println("耗时:" + (end - start) + "s");
		return result;
		//需要return吗
	}



	public void checkUpdate(Throwable e) {    //需要使用异常Exception和错误Error的顶层接口 ,e与上面的e要一致
//		e.printStackTrace();
		LOG.error("程序出错了"+e.getClass()+e.getMessage());
		//事务发生异常 执行rollback
	}

	public void finallyTest(){
		System.out.println("最终通知:一般用来释放资源");
	}
}
