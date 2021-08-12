package com.woniuxy.service.impl;

import com.woniuxy.bean.App;
import com.woniuxy.dao.AppDao;
import com.woniuxy.service.AppService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/11 17:01
 * @Description:
 */

@Service("appService")
@Data
public class AppServiceImpl implements AppService {
	@Autowired
	@Qualifier("appDao")
	private AppDao appDao;


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
