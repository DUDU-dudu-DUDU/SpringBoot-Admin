package com.wu.admin.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("users")
public class Users {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
