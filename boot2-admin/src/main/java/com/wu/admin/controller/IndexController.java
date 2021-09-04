package com.wu.admin.controller;

import com.wu.admin.bean.TestUser;
import com.wu.admin.bean.User;
import com.wu.admin.service.impl.CityServiceImpl;
import com.wu.admin.service.impl.TestUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    TestUserServiceImpl testUserservice;

    @Autowired
    CityServiceImpl cityService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @ResponseBody
    @GetMapping("/user1")
    public TestUser getById1(@RequestParam("id") int id){
        return cityService.getById(id);
    }

    @ResponseBody
    @GetMapping("/user")
    public TestUser getById(@RequestParam("id") int id){
        return testUserservice.getUserById(id);
    }


    @ResponseBody
    @GetMapping("/sql")
    public String queryFormDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        return aLong.toString();
    }



    @GetMapping(value = {"/", "/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if (!ObjectUtils.isEmpty(user.getUserName()) && "12345".equals(user.getPassword())){
            // 登录成功
            session.setAttribute("loginUser", user);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }
    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model){
/*        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null){
            return "main";
        }else {
            model.addAttribute("msg", "请先登录！");
            return "login";
        }*/
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        String s = operations.get("/main.html");
        String s1 = operations.get("/sql");

        model.addAttribute("mainCount", s);
        model.addAttribute("sqlCount", s1);

        return "main";

    }
}
