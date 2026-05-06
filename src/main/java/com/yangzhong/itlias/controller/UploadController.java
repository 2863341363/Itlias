package com.yangzhong.itlias.controller;

import com.yangzhong.itlias.dto.Result;
import com.yangzhong.itlias.util.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private AliyunOSSOperator ossOperator;
    @PostMapping
    public Result upload(@RequestParam MultipartFile file) throws java.lang.Exception {
        log.info("收到上传请求: fileName={}, size={}", file.getOriginalFilename(), file.getSize());
        String url = ossOperator.upload(file.getBytes(),file.getOriginalFilename());
        log.info("上传成功: url={}", url);
        return Result.success(url);
    }
}
