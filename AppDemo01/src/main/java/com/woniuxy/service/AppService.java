package com.woniuxy.service;

import com.woniuxy.bean.App;

import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/11 17:00
 * @Description:
 */
public interface AppService {

	List<App> queryApp();

	int deleteApp(int id);

	int updateApp(App app);

	int addApp(App app);
}
