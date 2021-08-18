package com.woniuxy.converters;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: jackpoit
 * 自定义转换器的实现步骤
 *		 类 implements Converter<原类型,目标类型>
 *  SpringMVC框架中默认提供了一个日期格式转换器
 *
 */
public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
