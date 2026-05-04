package com.yangzhong.itlias.service.imp;

import com.yangzhong.itlias.dto.Page;
import com.yangzhong.itlias.dto.PageResult;
import com.yangzhong.itlias.entity.Clazz;
import com.yangzhong.itlias.mapper.ClazzsMapper;
import com.yangzhong.itlias.service.ClazzsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzsServiceImp implements ClazzsService {
    @Autowired
    private ClazzsMapper clazzsMapper;

@Transactional
    @Override
    public void addClazz(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzsMapper.addClazz(clazz);
    }

    @Override
    public PageResult selectClazzsList(Page page, Clazz clazz) {
      com.github.pagehelper.Page  page1 = clazzsMapper.selectClazzsList(page,clazz);
      return new PageResult(page1.getTotal(), page1.getResult());
    }

    @Override
    public void deleteClazzs(Long id) {
        clazzsMapper.deleteClazzs(id);
    }

    @Override
    public Clazz selectClazzsById(Integer id) {
        return clazzsMapper.selectClazzById(id);
    }

    @Override
    public void updateClazz(Clazz clazz) {
        clazzsMapper.updateClazz(clazz);
    }

    @Override
    public List<Clazz> selectAll() {
      return  clazzsMapper.selectAllClazzs();
    }


}
