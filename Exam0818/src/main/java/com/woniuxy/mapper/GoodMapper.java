package com.woniuxy.mapper;

import com.woniuxy.bean.Good;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/18 14:15
 * @Description:
 */
public interface GoodMapper {


	//根据条件查询
	List<Good> findByCondition(Good good);


	int deleteByIds(@Param("ids") Integer... ids);


	int add(Good good);

	int update(Good good);
}
