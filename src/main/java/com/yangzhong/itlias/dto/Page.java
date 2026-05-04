package com.yangzhong.itlias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page {
    private LocalDateTime begin;
    private LocalDateTime end;
    private Integer page = 1;
    private Integer pageSize = 10;
}
