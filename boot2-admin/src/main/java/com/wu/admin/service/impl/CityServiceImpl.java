package com.wu.admin.service.impl;

import com.wu.admin.bean.TestUser;
import com.wu.admin.mapper.CityMapper;
import com.wu.admin.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityMapper cityMapper;

    public TestUser getById(int id){
        return cityMapper.getById(id);
    }
}
