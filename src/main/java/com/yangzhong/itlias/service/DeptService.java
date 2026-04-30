package com.yangzhong.itlias.service;

import com.yangzhong.itlias.entity.Dept;

import java.util.List;

public interface DeptService {
    public List<Dept> selectAllDepts();

    void deleteDeptsById(Integer id);

    void getDeptNameById(Integer id);
}
