package com.yangzhong.itlias.controller;

import com.github.pagehelper.PageHelper;
import com.yangzhong.itlias.dto.Page;
import com.yangzhong.itlias.dto.PageResult;
import com.yangzhong.itlias.dto.Result;
import com.yangzhong.itlias.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
    @Autowired
    private LogService logService;
    @GetMapping("/log/page")
    public Result selectLog( Page page){
        PageHelper.startPage(page.getPage(),page.getPageSize());
        PageResult pageResult = logService.selectLog();
        return Result.success(pageResult);
    }
}
