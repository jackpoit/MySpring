package com.woniuxy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: jackpoit
 * @Date: 2021/08/22/0:06
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "permission")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	@Column(name = "pname")
	private String pname;
	@Column(name = "type")
	private String type;
	@Column(name = "url")
	private String url;
	@Column(name = "percode")
	private String percode;
	@Column(name = "parentpid")
	private Integer parentId;

	private Integer available;
}
