package com.woniuxy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 2L;
    private Integer id;
    private String userName;
    private String userPass;
    private String userPhone;
    private Integer userType;

}
