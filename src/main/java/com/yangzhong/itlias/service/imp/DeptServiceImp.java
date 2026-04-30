package com.yangzhong.itlias.service.imp;

import com.yangzhong.itlias.entity.Dept;
import com.yangzhong.itlias.mapper.DeptMapper;
import com.yangzhong.itlias.service.DeptService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImp implements DeptService {
    private final DeptMapper deptMapper;

    public DeptServiceImp(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }
//查询所有的部门
    @Override
    public List<Dept> selectAllDepts() {
        return deptMapper.selectDepts();
    }
//删除部门通过id
    @Override
    public void deleteDeptsById(Integer id) {
        deptMapper.deleteDepts(id);
    }
//通过部门id获取部门名字
    @Override
    public String getDeptNameById(Integer id) {
       return deptMapper.getDeptsName(id);
    }
}
