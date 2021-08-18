package com.woniuxy.service;

import com.github.pagehelper.PageInfo;
import com.woniuxy.bean.App;

import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/11 17:00
 * @Description:
 */
public interface AppService {

	PageInfo<App> showByKeyword(int currentPage, App app);

	boolean doDelete(Integer[] ids);

	boolean doAdd(App app);

	boolean doUpdate(App app);
}
