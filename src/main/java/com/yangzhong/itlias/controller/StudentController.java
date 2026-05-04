package com.yangzhong.itlias.controller;

import com.github.pagehelper.PageHelper;
import com.yangzhong.itlias.dto.Page;
import com.yangzhong.itlias.dto.PageResult;
import com.yangzhong.itlias.dto.Result;
import com.yangzhong.itlias.entity.Student;
import com.yangzhong.itlias.service.imp.StudentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;


    //分页查询学生
    @GetMapping
    public Result<PageResult> selectStudents(@ModelAttribute Page page, @ModelAttribute Student student){
        PageHelper.startPage(page.getPage(),page.getPageSize());
        com.yangzhong.itlias.dto.PageResult pageResult = studentService.selectStudentPage(page,student);
        return Result.success(pageResult);
    }

    //删除学员
    @DeleteMapping("/{ids}")
    public Result deleteStudents(@PathVariable Integer[] ids){
        log.info("要删除的员工id是={}",ids);
        studentService.deleteStudentsByIds(ids);
        return Result.success();
    }

    //添加学员
    @PostMapping
    public Result addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return Result.success();
    }

    //查询回显
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        Student student = studentService.selectById(id);
        return Result.success(student);
    }

    //修改学员
    @PutMapping
    public Result updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return Result.success();
    }

    //修改违纪信息
    @PutMapping("/violation/{id}/{score}")
    public Result updateViolation(@PathVariable Integer id, @PathVariable Integer score){
        studentService.updateViolation(id,score);
        return Result.success();
    }
}
