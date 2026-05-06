package com.yangzhong.itlias.controller;


import com.github.pagehelper.PageHelper;
import com.yangzhong.itlias.Enum.Log;
import com.yangzhong.itlias.dto.Page;
import com.yangzhong.itlias.dto.PageResult;
import com.yangzhong.itlias.dto.Result;
import com.yangzhong.itlias.entity.Emp;
import com.yangzhong.itlias.service.EmpService;
import jakarta.servlet.ServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    private final EmpService empService;

    @Autowired
    EmpController(EmpService empService) {
        this.empService = empService;
    }

    //分页查询员工
    @GetMapping
    public Result selectEmps(Emp emp, Page page) {
        log.info("查询到的员工是 = {}", emp);
        PageHelper.startPage(page.getPage(), page.getPageSize());
        com.github.pagehelper.Page page1 = empService.selectEmpByPages(page, emp);
        return Result.success(new PageResult(page1.getTotal(), page1.getResult()));
    }

    //批量删除员工
    @Log
    @DeleteMapping
    public Result deleteEmps(@RequestParam Integer[] ids) {
        log.info("要删除的员工id 是 = {}", ids);
        empService.deleteEmpsByIds(ids);
        return Result.success();
    }

    //添加员工
    @Log
    @PostMapping
    public Result addEmp(@RequestBody Emp emp) {
        empService.addEmpInformation(emp);
        return Result.success();
    }

    //查询回显
    @GetMapping("/{id}")
    public Result selectEmp(@PathVariable Long id) {
        Emp emp = empService.selectEmpById(id);
        return Result.success(emp);
    }

    // 修改员工
    @Log
    @PutMapping
    public Result updateEmp(@RequestBody Emp emp) {
        empService.updateEmp(emp);
        return Result.success(emp);
    }


    //查询全部员工
    @GetMapping("/list")
    public Result selectAllEmps(ServletRequest servletRequest) {
        List list = empService.selectAllEmps();
        return Result.success(list);
    }
}
