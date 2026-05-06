package com.yangzhong.itlias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private String name;
    private Integer gender;
    private LocalDate begin;
    private LocalDate end;
    private Integer id;
    private String phone;
    private String username;
    private String password;
    private String image;
    private Integer job;
    private Integer salary;
    private LocalDate entryDate;
    private Integer deptId;
    private String deptName;
    private String createTime;
    private String updateTime;
    private List<Expr> exprList;
}
