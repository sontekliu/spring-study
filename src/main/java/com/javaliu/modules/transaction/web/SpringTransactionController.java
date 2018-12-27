package com.javaliu.modules.transaction.web;

import com.javaliu.modules.transaction.entity.User;
import com.javaliu.modules.transaction.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/transaction/")
public class SpringTransactionController {

    private static final Logger logger = LoggerFactory.getLogger(SpringTransactionController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "addUser")
    public String addUser(HttpServletRequest request, HttpServletResponse response, Model model){
        User user = new User();
        user.setCode("abcde");
        user.setName("张三");
        userService.addUser(user);
        return "modules/transaction/index";
    }
}
