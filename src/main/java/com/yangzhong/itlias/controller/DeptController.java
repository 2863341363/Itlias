package com.yangzhong.itlias.controller;

import com.yangzhong.itlias.dto.Result;
import com.yangzhong.itlias.entity.Dept;
import com.yangzhong.itlias.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    private final DeptService deptService;

    @Autowired
    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @GetMapping
    public Result<List<Dept>> selectDepts() {
        List<Dept> list = deptService.selectAllDepts();
        log.info("查询所有的部门 = {}", list);
        return Result.success(list);
    }

    @DeleteMapping
    public Result deleteDepts(@RequestParam Integer id) {
        deptService.deleteDeptsById(id);
        log.info("要删除的对象是 = {}",id);//怎么通过id返回一个部门名字
        return Result.success();
    }
}
