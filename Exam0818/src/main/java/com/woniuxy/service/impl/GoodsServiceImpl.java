package com.woniuxy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.bean.FirstType;
import com.woniuxy.bean.Good;
import com.woniuxy.bean.SecondType;
import com.woniuxy.mapper.FirstTypeMapper;
import com.woniuxy.mapper.GoodMapper;
import com.woniuxy.mapper.SecondTypeMapper;
import com.woniuxy.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: jackpoit
 * @Date: 2021/08/18/15:04
 * @Description:
 */
@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodMapper goodMapper;
	@Autowired
	private FirstTypeMapper firstTypeMapper;
	@Autowired
	private SecondTypeMapper secondTypeMapper;

	@Override
	public PageInfo<Good> showByKeyword(int currentPage, Good good) {

		PageHelper.startPage(currentPage,5);
		List<Good> list = goodMapper.findByCondition(good);

		return new PageInfo<>(list);
	}

	@Override
	public boolean doDelete(Integer[] ids) {
		if (ids==null)
			return false;
		int row = goodMapper.deleteByIds(ids);
		return row>0;
	}

	@Override
	public boolean doAdd(Good good) {
		if (good==null)
			return false;
		int row = goodMapper.add(good);
		return row>0;
	}

	@Override
	public boolean doUpdate(Good good) {
		if (good==null)
			return false;
		int row = goodMapper.update(good);
		return row>0;
	}

	@Override
	public List<FirstType> getFirstType() {
		return firstTypeMapper.findAll();
	}

	@Override
	public List<SecondType> getSecondType() {
		return secondTypeMapper.findAll();
	}

}
