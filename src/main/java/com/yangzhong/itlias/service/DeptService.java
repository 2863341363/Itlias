package com.yangzhong.itlias.service;

import com.yangzhong.itlias.entity.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> selectAllDepts();

    void deleteDeptsById(Integer id);

    String getDeptNameById(Integer id);

    void addDept(String deptName);

    Dept selectDeptById(Integer id);

    void updateDeptByIdAndName(Dept dept);
}
