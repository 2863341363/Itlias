package com.yangzhong.itlias.controller;

import com.yangzhong.itlias.dto.Login;
import com.yangzhong.itlias.dto.Result;
import com.yangzhong.itlias.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService logService;




    @PostMapping("/login")
    public Result<Login> login(@RequestBody Login login) {
        Login login1 = logService.login(login);
        if (login1 != null) {
            return Result.success(login1);
        }
        return Result.error("username or password is incorrect");
    }
}
