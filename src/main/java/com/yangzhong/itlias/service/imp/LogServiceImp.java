package com.yangzhong.itlias.service.imp;

import com.github.pagehelper.Page;
import com.yangzhong.itlias.dto.PageResult;
import com.yangzhong.itlias.mapper.LogMapper;
import com.yangzhong.itlias.service.LogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImp implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public PageResult selectLog() {
        Page page = logMapper.selectLog();
        return new PageResult(page.getTotal(), page.getResult());
    }
}
