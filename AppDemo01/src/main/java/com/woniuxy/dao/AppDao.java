package com.woniuxy.dao;

import com.woniuxy.bean.App;

import java.util.List;

public interface AppDao {

	List<App> queryApp();

	int deleteApp(int id);

	int updateApp(App app);

	int addApp(App app);
}
