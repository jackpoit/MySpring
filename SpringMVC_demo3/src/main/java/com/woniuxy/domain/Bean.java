package com.woniuxy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: jackpoit
 * @Date: 2021/08/18/0:05
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bean {
	private List<User> list; //约定
}
