package com.woniuxy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.bean.App;
import com.woniuxy.mapper.AppMapper;
import com.woniuxy.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/11 17:01
 * @Description:
 */
@Service
public class AppServiceImpl implements AppService {

	@Autowired
	private AppMapper appMapper;

	@Override
	public PageInfo<App> showByKeyword(int currentPage, App app) {
		PageHelper.startPage(currentPage,5);
		List<App> list = appMapper.findByCondition(app);
		return new PageInfo<>(list);
	}

	@Override
	public boolean doDelete(Integer[] ids) {
		if (ids == null) {
			return false;
		}
		int row = appMapper.deleteByIds(ids);
		return row > 0;
	}

	@Override
	public boolean doAdd(App app) {
		if (app==null) {
			return false;
		}
		int row = appMapper.add(app);
		return row>0;
	}

	@Override
	public boolean doUpdate(App app) {
		if (app==null) {
			return false;
		}
		int row = appMapper.update(app);
		return row>0;
	}
}
