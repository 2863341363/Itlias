package com.yangzhong.itlias.controller;

import com.yangzhong.itlias.dto.Result;
import com.yangzhong.itlias.entity.EmpJob;
import com.yangzhong.itlias.entity.StudentCount;
import com.yangzhong.itlias.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;




    @GetMapping("/empGenderData")
    public Result sumEmpGender(){
        List<Map<String,Integer>> list = reportService.sumEmpGender();
        return Result.success(list);
    }

    @GetMapping("/empJobData")
    public Result sumEmpJob(){
        EmpJob empJob = reportService.sumEmpJob();
        return Result.success(empJob);
    }

    @GetMapping("/studentDegreeData")
    public  Result sumStudentCollege(){
        List<Map> list = reportService.sumStudentCollege();
        return Result.success(list);
    }

    @GetMapping("/studentCountData")
    public Result sumStudent(){
        StudentCount studentCount = reportService.sumStudent();
        return Result.success(studentCount);
    }
}
