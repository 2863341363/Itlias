package com.yangzhong.itlias.mapper;

import com.yangzhong.itlias.entity.Dept;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface DeptMapper {
    List<Dept> selectDepts();

    void deleteDepts(Integer id);

    String getDeptsName(Integer id);
}
