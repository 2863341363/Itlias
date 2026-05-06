package com.yangzhong.itlias.service.imp;

import com.yangzhong.itlias.dto.Page;
import com.yangzhong.itlias.dto.PageResult;

import com.yangzhong.itlias.entity.Student;
import com.yangzhong.itlias.mapper.StudentMapper;
import com.yangzhong.itlias.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
public class StudentServiceImp implements StudentService {
@Autowired
private StudentMapper studentMapper;
    @Override
    public PageResult selectStudentPage(Page page, Student student) {
        com.github.pagehelper.Page page1 = studentMapper.selcetStudent(page,student);
        return new PageResult(page1.getTotal(),page1.getResult());
    }

    @Override
    public void deleteStudentsByIds(Integer[] ids) {
        studentMapper.deleteStudents(ids);
    }
@Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addStudent(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.addStudent(student);
    }

    @Override
    public Student selectById(Integer id) {
        return studentMapper.selectById(id);
    }
@Transactional
    @Override
    public void updateStudent(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateStudent(student);
    }
@Transactional
    @Override
    public void updateViolation(Integer id, Integer score) {
        //修改时间更新
    Student student = new Student();
    student.setUpdateTime(LocalDateTime.now());
    student.setId(id);
    student.setViolationScore(score);
    studentMapper.updateViolation(student);
    }
}
