package com.yangzhong.itlias.service;

import com.yangzhong.itlias.dto.Page;
import com.yangzhong.itlias.dto.PageResult;
import com.yangzhong.itlias.entity.Student;

public interface StudentService {
    PageResult selectStudentPage(Page page, Student student);

    void deleteStudentsByIds(Integer[] ids);

    void addStudent(Student student);

    Student selectById(Integer id);

    void updateStudent(Student student);

    void updateViolation(Integer id, Integer score);
}
