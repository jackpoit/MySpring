package com.woniuxy.service.impl;

import com.woniuxy.bean.App;
import com.woniuxy.dao.AppDao;
import com.woniuxy.service.AppService;

import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/11 17:01
 * @Description:
 */
public class AppServiceImpl implements AppService {
	private AppDao appDao;

	public AppDao getAppDao() {
		return appDao;
	}

	public void setAppDao(AppDao appDao) {
		this.appDao = appDao;
	}

	@Override
	public List<App> queryApp() {
		return appDao.queryApp();
	}

	@Override
	public int deleteApp(int id) {
		return appDao.deleteApp(id);
	}

	@Override
	public int updateApp(App app) {
		return appDao.updateApp(app);
	}

	@Override
	public int addApp(App app) {
		return appDao.addApp(app);
	}
}
