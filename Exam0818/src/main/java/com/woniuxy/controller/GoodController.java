package com.woniuxy.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.bean.FirstType;
import com.woniuxy.bean.Good;
import com.woniuxy.bean.SecondType;
import com.woniuxy.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @Author: jackpoit
 * @Date: 2021/08/18/15:07
 * @Description:
 */
@RestController
@RequestMapping("good")
public class GoodController {

	@Autowired
	private GoodsService goodsService;

	@RequestMapping("query")
	public PageInfo<Good> queryGood(@RequestParam(name = "nowPage",required = false,defaultValue = "1") Integer currentPage, Good good) {
		System.out.println();
		return goodsService.showByKeyword(currentPage, good);
	}

	@RequestMapping("delete")
	public String deleteGood(String[] ids) {

		Integer[] aids = new Integer[ids.length];
		for (int i = 0; i < ids.length; i++) {
			if (ids[i] != null) {
				aids[i] = Integer.parseInt(ids[i]);
			}
		}
		boolean flag = goodsService.doDelete(aids);
		return flag?"Y":"N";
	}

	@RequestMapping("add")
	public String addGood(Good good) {
			good.setGoodsStatus(0);
		boolean flag = goodsService.doAdd(good);
		return flag ? "Y" : "N";

	}

	@RequestMapping("update")
	public String updateGood(Good good)  {
		boolean flag = goodsService.doUpdate(good);
		return flag ? "Y" : "N";

	}

	@RequestMapping("getFirst")
	public List<FirstType> getFirst()  {
		return goodsService.getFirstType();
	}

	@RequestMapping("getSecond")
	public List<SecondType> getSecond()  {
		return goodsService.getSecondType();
	}

}
