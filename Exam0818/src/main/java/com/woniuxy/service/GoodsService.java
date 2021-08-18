package com.woniuxy.service;

import com.github.pagehelper.PageInfo;
import com.woniuxy.bean.FirstType;
import com.woniuxy.bean.Good;
import com.woniuxy.bean.SecondType;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: jackpoit
 * @Date: 2021/08/18/15:03
 * @Description:
 */
public interface GoodsService {

	PageInfo<Good> showByKeyword(int currentPage, Good good);

	boolean doDelete(Integer[] ids);

	boolean doAdd(Good good);

	boolean doUpdate(Good good);

	List<FirstType> getFirstType();
	List<SecondType> getSecondType();

}
