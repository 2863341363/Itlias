package com.yangzhong.itlias.service.imp;

import com.yangzhong.itlias.entity.Dept;
import com.yangzhong.itlias.mapper.DeptMapper;
import com.yangzhong.itlias.service.DeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class DeptServiceImp implements DeptService {
    private final DeptMapper deptMapper;

    public DeptServiceImp(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    @Override
    public List<Dept> selectAllDepts() {
        return deptMapper.selectDepts();
    }

    @Override
    public void deleteDeptsById(Integer id) {
        deptMapper.deleteDepts(id);
    }

    @Override
    public String getDeptNameById(Integer id) {
        return deptMapper.getDeptsName(id);
    }

    @Override
    public void addDept(String deptName) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTime = now.format(formatter);
        Dept dept = new Dept(null, deptName, currentTime, currentTime);
        deptMapper.addDept(dept);
    }

    @Override
    public Dept selectDeptById(Integer id) {
        return deptMapper.selectDept(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateDeptByIdAndName(Dept dept) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        dept.setUpdateTime(time);
        deptMapper.updateDept(dept);
    }
}
