package com.woniuxy.mapper;

import com.woniuxy.bean.Good;
import com.woniuxy.bean.SecondType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/18 14:15
 * @Description:
 */
public interface SecondTypeMapper {


	SecondType findById(Integer id);

	List<SecondType> findAll();
}
