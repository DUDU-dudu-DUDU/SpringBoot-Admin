package com.wu.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wu.admin.bean.Users;
import com.wu.admin.mapper.UsersMapper;
import com.wu.admin.service.UsersService;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
}
