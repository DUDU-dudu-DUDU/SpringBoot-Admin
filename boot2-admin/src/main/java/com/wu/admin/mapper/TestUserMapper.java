package com.wu.admin.mapper;

import com.wu.admin.bean.TestUser;
import org.apache.ibatis.annotations.Mapper;

// @Mapper
public interface TestUserMapper {
    public TestUser getTestUser(int id);
}
