package com.yangzhong.itlias.service.imp;

import com.yangzhong.itlias.dto.Login;
import com.yangzhong.itlias.mapper.LoginMapper;
import com.yangzhong.itlias.service.LoginService;
import com.yangzhong.itlias.util.JWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImp implements LoginService {

    @Autowired
    private LoginMapper logMapper;

    @Override
    public Login login(Login login) {
        Login login1 = logMapper.login(login);
        if (login1 != null) {
           String token =  JWT.generateToken(login1.getId(),login1.getUsername(),login1.getName());
           login1.setToken(token);
            log.info("登录成功: {}", login1);
            return login1;
        }
        return null;
    }
}
