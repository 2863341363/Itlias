package com.yangzhong.itlias.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReportMapper {

    List<Map<String, Integer>> sumEmpGender();

    List<Map> sumEmpJob();

    List<Map> sumStudentCollege();

    List<Map> sumStudent();
}
