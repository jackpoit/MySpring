package com.woniuxy.mapper;

import com.woniuxy.bean.FirstType;
import com.woniuxy.bean.Good;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/18 14:15
 * @Description:
 */
public interface FirstTypeMapper {

	FirstType findById(Integer id);
	List<FirstType> findAll();
}
