package com.yangzhong.itlias.service.imp;

import com.yangzhong.itlias.dto.Page;
import com.yangzhong.itlias.entity.Emp;
import com.yangzhong.itlias.entity.Expr;
import com.yangzhong.itlias.mapper.EmpMapper;
import com.yangzhong.itlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
public class EmpServiceImp implements EmpService {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final EmpMapper empMapper;

    EmpServiceImp(EmpMapper empMapper) {
        this.empMapper = empMapper;
    }

    @Override
    public com.github.pagehelper.Page selectEmpByPages(Page page, Emp emp) {
        return empMapper.selectEmp(emp);
    }

    @Override
    public void deleteEmpsByIds(Integer[] ids) {
        empMapper.deleteEmps(ids);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void addEmpInformation(Emp emp) {
        String now = currentTime();
        emp.setCreateTime(now);
        emp.setUpdateTime(now);

        empMapper.addEmp(emp);
        log.info("add employee id={}", emp.getId());

        if (emp.getExprList() != null && !emp.getExprList().isEmpty()) {
            Integer empId = emp.getId();
            for (Expr expr : emp.getExprList()) {
                expr.setEmpId(empId);
            }
            empMapper.addExpr(emp.getExprList());
        }
    }

    @Override
    public Emp selectEmpById(Long id) {
        return empMapper.selectEmpById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateEmp(Emp emp) {
        emp.setUpdateTime(currentTime());
        empMapper.updateEmp(emp);
        if (emp.getExprList() != null && !emp.getExprList().isEmpty()) {
            empMapper.updateEmpExpr(emp.getExprList());
        }
    }

    @Override
    public List selectAllEmps() {
       return  empMapper.selectAllEmps();
    }

    private String currentTime() {
        return LocalDateTime.now().format(DATE_TIME_FORMATTER);
    }
}
