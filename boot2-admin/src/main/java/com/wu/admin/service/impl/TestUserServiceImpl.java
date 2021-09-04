package com.wu.admin.service.impl;

import com.wu.admin.bean.TestUser;
import com.wu.admin.mapper.TestUserMapper;
import com.wu.admin.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestUserServiceImpl implements TestUserService {
    @Autowired
    TestUserMapper testUserMapper;

    public TestUser getUserById(int id){
        return testUserMapper.getTestUser(id);
    }
}
