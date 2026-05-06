package com.yangzhong.itlias.service;

import com.yangzhong.itlias.dto.Page;
import com.yangzhong.itlias.entity.Emp;

import java.util.List;

public interface EmpService {

    com.github.pagehelper.Page selectEmpByPages(Page page, Emp emp);

    void deleteEmpsByIds(Integer[] ids);

    void addEmpInformation(Emp emp);

    Emp selectEmpById(Long id);

    void updateEmp(Emp emp);

    List selectAllEmps();
}
