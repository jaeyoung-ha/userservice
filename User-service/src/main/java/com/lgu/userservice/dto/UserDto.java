package com.lgu.userservice.dto;

import com.lgu.userservice.vo.ResponseOrder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDto {
    private String email;
    private String name;
    private String pwd;
    private String userId;
    private Date createdAt;

    private String encrpytPwd;

    private List<ResponseOrder> orders;
}
