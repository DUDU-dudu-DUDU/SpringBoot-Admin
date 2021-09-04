package com.wu.admin.mapper;

import com.wu.admin.bean.TestUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

// @Mapper
public interface CityMapper {
    @Select("select * from user where id=#{id}")
    public TestUser getById(int id);
}
