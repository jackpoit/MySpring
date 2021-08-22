package com.woniuxy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "realname")
    private String realName;
    @Column(name = "idcard")
    private String idCard;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "salt")
    private String salt;
    @Column(name = "locked")
    private Integer locked;
}
