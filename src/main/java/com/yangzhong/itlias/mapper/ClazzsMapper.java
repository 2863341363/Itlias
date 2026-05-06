package com.yangzhong.itlias.mapper;


import com.github.pagehelper.Page;

import com.yangzhong.itlias.entity.Clazz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClazzsMapper {
    Page<Clazz> selectClazzsList(com.yangzhong.itlias.dto.Page page, Clazz clazz);

    void deleteClazzs(Long id);

    void addClazz(@Param("clazz")Clazz clazz);

    Clazz selectClazzById(Integer id);

    void updateClazz(Clazz clazz);

    List<Clazz> selectAllClazzs();

    Integer countStudentsByClazzId(Long id);
}
