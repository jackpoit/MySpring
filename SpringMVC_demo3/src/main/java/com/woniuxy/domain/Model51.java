package com.woniuxy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: jackpoit
 * @Date: 2021/08/18/0:40
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model51  implements Serializable {
	private static final long serialVersionUID = 1L;
	private String code;
	private String keyword;
	private Integer currentPage;
	private String lang;
	private String type;
}
