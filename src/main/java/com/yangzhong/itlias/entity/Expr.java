package com.yangzhong.itlias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expr {
    private Integer id;
    private Integer empId;
    private String company;
    private String job;
    private LocalDate begin;
    private LocalDate end;
}
