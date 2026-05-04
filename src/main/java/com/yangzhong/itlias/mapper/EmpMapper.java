package com.yangzhong.itlias.mapper;

import com.github.pagehelper.Page;
import com.yangzhong.itlias.entity.Emp;
import com.yangzhong.itlias.entity.Expr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmpMapper {
    Page selectEmp(Emp emp);

    void deleteEmps(Integer[] ids);

    void addEmp(Emp emp);

    void addExpr(@Param("exprList") List<Expr> exprList);

    Emp selectEmpById(Long id);

    void updateEmp(Emp emp);

    void updateEmpExpr(List<Expr> list);

    List<Emp> selectAllEmps();
}
