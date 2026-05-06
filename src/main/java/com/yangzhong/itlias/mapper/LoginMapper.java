package com.yangzhong.itlias.mapper;

import com.yangzhong.itlias.dto.Login;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    Login login(Login login);
}
