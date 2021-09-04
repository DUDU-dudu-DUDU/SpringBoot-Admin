package com.wu.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wu.admin.bean.Users;
import com.wu.admin.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    UsersService usersService;

    @GetMapping("/basic_table")
    public String basic_table(){

        return "table/basic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUsers(@PathVariable("id") Long id,
                              @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                              RedirectAttributes re){
        re.addAttribute("pn", pn);
        usersService.removeById(id);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model){
/*        List<User> users = Arrays.asList(new User("dudu", "123456"),
                new User("DUDU", "112233"),
                new User("ruirui", "22222"),
                new User("kangkang", "33333"));
        model.addAttribute("users", users);*/
        List<Users> list = usersService.list();
        model.addAttribute("users", list);

        // 分冶查询
        Page<Users> usersPage = new Page<Users>(pn,2);
        // 分冶查询结果
        Page<Users> page = usersService.page(usersPage, null);
        model.addAttribute("page", page);
        return "table/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }

    @GetMapping("/pricing_table")
    public String pricing_table(){
        return "table/pricing_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }
}
