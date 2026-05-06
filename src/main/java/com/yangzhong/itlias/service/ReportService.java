package com.yangzhong.itlias.service;

import com.yangzhong.itlias.entity.EmpJob;
import com.yangzhong.itlias.entity.StudentCount;

import java.util.List;
import java.util.Map;

public interface ReportService {
    List<Map<String, Integer>> sumEmpGender();

    EmpJob sumEmpJob();

    List<Map> sumStudentCollege();

    StudentCount sumStudent();
}
