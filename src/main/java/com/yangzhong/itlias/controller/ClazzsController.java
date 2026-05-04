package com.yangzhong.itlias.controller;


import com.github.pagehelper.PageHelper;
import com.yangzhong.itlias.dto.Page;
import com.yangzhong.itlias.dto.PageResult;
import com.yangzhong.itlias.dto.Result;
import com.yangzhong.itlias.entity.Clazz;
import com.yangzhong.itlias.service.ClazzsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clazzs")
public class ClazzsController {
    @Autowired
    private ClazzsService clazzsService;

    //分页查询班级
    @GetMapping
    public Result selectClazzsList(Page page, Clazz clazz) {
        PageHelper.startPage(page.getPage(), page.getPageSize());
        PageResult pageResult = clazzsService.selectClazzsList(page, clazz);
        return Result.success(pageResult);
    }

    //单次删除班级
    @DeleteMapping("/{id}")
    public Result deleteClazzs(@PathVariable Long id) {
        clazzsService.deleteClazzs(id);
        return Result.success();
    }

    //添加班级
    @PostMapping
    public Result addClazz(@RequestBody Clazz clazz) {
        clazzsService.addClazz(clazz);
        return Result.success();
    }

    //查询回显班级
    @GetMapping("/{id}")
    public Result selectClazzById(@PathVariable Integer id) {
        Clazz clazz = clazzsService.selectClazzsById(id);
        return Result.success(clazz);
    }

    //修改班级
    @PutMapping
    public Result updateClazz(@RequestBody Clazz clazz) {
        clazzsService.updateClazz(clazz);
        return Result.success();
    }

    //查询所有班级
    @GetMapping("/list")
    public Result selectAll() {
        return Result.success(clazzsService.selectAll());
    }
}
