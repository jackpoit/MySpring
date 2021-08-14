package com.woniuxy.web.servlet;

import com.woniuxy.entity.Employee;
import com.woniuxy.service.EmployeeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *Spring针对Web应用进行整合:Spring-web.jar
 * 后期Spring会为Web层提供一个解决方案 SpringMVC
 *
 */
@WebServlet("/index")
public class ShowAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1.合理吗?[保证Spring工厂是唯一的,且每个Servlet都能获取到工厂]  监听器
		//弊端:每次请求都要创建Spring 工厂一次 性能小号巨大(不可行)
		//ServletContext对象:web应用的上下文对象[整个Web应用的Servlet都可以访问到:域对象(存储数据的区域) 底层是map(键值对)]
		//ServletContext的生命周期:
		//			创建:当web应用正常发布,优先创建ServletContext对象,且只会创建一次

//
//		ServletContext servletContext = req.getServletContext();
//		ClassPathXmlApplicationContext applicationContext = (ClassPathXmlApplicationContext) servletContext.getAttribute("applicationContext");

		ServletContext sc = req.getServletContext();
		WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(sc);

		EmployeeService esi = applicationContext.getBean(EmployeeService.class);


		//1.准备从数据库查询出首页数据(业务逻辑层 + DAO层)
		List<Employee> list = esi.queryAllEmp();
		//2. 将数据放在request域中
		req.setAttribute("empList", list);
		//3. 转发到首页
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
