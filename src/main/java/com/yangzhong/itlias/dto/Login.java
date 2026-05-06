package com.yangzhong.itlias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {
    private Integer id;
    private  String username;
    private String password;
    private  String name;
    private String token;
}
