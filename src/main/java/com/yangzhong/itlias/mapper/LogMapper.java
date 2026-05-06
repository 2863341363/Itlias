package com.yangzhong.itlias.mapper;

import com.github.pagehelper.Page;
import com.yangzhong.itlias.dto.LogOp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {

     Page selectLog();

     void insertLog(LogOp logOp);
}
