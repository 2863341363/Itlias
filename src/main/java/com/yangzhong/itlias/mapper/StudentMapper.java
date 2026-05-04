package com.yangzhong.itlias.mapper;

import com.github.pagehelper.Page;
import com.yangzhong.itlias.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentMapper {
     Page selcetStudent(com.yangzhong.itlias.dto.Page page, Student student);

     void deleteStudents(@Param("ids") Integer[] ids);

     void addStudent(Student student);

     Student selectById(Integer id);

     void updateStudent(Student student);

     void updateViolation(Student student);
}
