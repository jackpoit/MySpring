package com.woniuxy;

import static org.junit.Assert.assertTrue;

import com.woniuxy.bean.Good;
import com.woniuxy.bean.MyDataSource;
import com.woniuxy.bean.Student;
import com.woniuxy.dao.UserDao;
import com.woniuxy.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void iocTest01(){
        //1.获得spring容器
        ApplicationContext application = new ClassPathXmlApplicationContext("application.xml");
        //2.从spring容器中得到对象
        UserDao userDao = (UserDao) application.getBean("userDaoId");
        //3.检查是否得到spring容器的管理的对象
        userDao.add();

    }
    @Test
    public void iocTest02(){
        //1.获得spring容器
        ApplicationContext application = new ClassPathXmlApplicationContext("application.xml");
        //2.从spring容器中得到对象
        UserService userService = (UserService) application.getBean("userServiceId");
        //3.检查是否得到spring容器的管理的对象
        userService.add();

    }

    @Test
    public void test03(){
        ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("application.xml");

        Good good = (Good) application.getBean("good");
        System.out.println(good);

        application.close();
    }

    @Test
    public void test04(){
        ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("application.xml");

        Student stu01 = (Student) application.getBean("student01");
        Student stu02 = (Student) application.getBean("student02");
        System.out.println(stu01);
        System.out.println(stu02);

    }

    @Test
    public void test05(){
        ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("application.xml");
        MyDataSource dataSource = (MyDataSource) application.getBean("myDataSource");
        System.out.println(dataSource);

    }

}
