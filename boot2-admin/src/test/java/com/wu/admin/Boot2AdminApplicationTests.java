package com.wu.admin;

import com.wu.admin.bean.Users;
import com.wu.admin.mapper.UsersMapper;
import
lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Boot2AdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        System.out.println("总记录数" + aLong);
        log.info("记录总数: {}", aLong);

        log.info("数据源类型：{}", dataSource.getClass());
    }

    @Test
    void testUsersMapper(){
        Users users = usersMapper.selectById(1L);
        log.info("查询的数据是：{}", users);
    }

/*    @Test
    void testRedis(){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set("hello","world");
        String hello = operations.get("hello");
        System.out.println(hello);
    }*/


}
