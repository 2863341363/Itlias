package com.yangzhong.itlias.service;

import com.yangzhong.itlias.dto.Page;
import com.yangzhong.itlias.dto.PageResult;
import com.yangzhong.itlias.entity.Clazz;

import java.util.List;

public interface ClazzsService {

    void addClazz(Clazz clazz);


    PageResult selectClazzsList(Page page, Clazz clazz);

    void deleteClazzs(Long id);

    Clazz selectClazzsById(Integer id);

    void updateClazz(Clazz clazz);

    List<Clazz> selectAll();
}
