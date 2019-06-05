package com.javaliu.modules.hightload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping(value = "/highLoad/")
public class HightLoadController {

    private static final Logger logger = LoggerFactory.getLogger(HightLoadController.class);

    private static final List<String> list = new ArrayList<>();

    @RequestMapping(value = "highCPU")
    public void highCPU() {
        while (true) {
            System.out.println("AAAAAAAAAAAAAAAAAAAAAA");
        }
    }

    @RequestMapping(value = "highMemory")
    public void highMemory(HttpServletRequest request, HttpServletResponse response) {
        for (int i = 0; i < 1000000; i++) {
            String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < 1000; j++) {
                sb.append(str.charAt(new Random().nextInt(61)));
            }
            list.add(sb.toString());
        }
    }
}
