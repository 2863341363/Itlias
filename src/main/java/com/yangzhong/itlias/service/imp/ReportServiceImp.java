package com.yangzhong.itlias.service.imp;

import com.yangzhong.itlias.entity.EmpJob;
import com.yangzhong.itlias.entity.StudentCount;
import com.yangzhong.itlias.mapper.ReportMapper;
import com.yangzhong.itlias.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImp implements ReportService {
    @Autowired
    private ReportMapper reportMapper;


    @Override
    public List<Map<String, Integer>> sumEmpGender() {
        List<Map<String,Integer>> list = reportMapper.sumEmpGender();
        return list;
    }

    @Override
    public EmpJob sumEmpJob() {
        List<Map> list1 = reportMapper.sumEmpJob();
        List list2 = list1.stream().map(map-> map.get("name")).toList();
        List list3 = list1.stream().map(map -> map.get("value")).toList();
        return new EmpJob(list2,list3);
    }

    @Override
    public List<Map> sumStudentCollege() {
        List<Map> list = reportMapper.sumStudentCollege();
        return list;
    }

    @Override
    public StudentCount sumStudent() {
        List<Map> list = reportMapper.sumStudent();
        List list1 = list.stream().map(map->map.get("name")).toList();
        List list2 = list.stream().map(map->map.get("value")).toList();
        return new StudentCount(list1,list2);
    }


}
