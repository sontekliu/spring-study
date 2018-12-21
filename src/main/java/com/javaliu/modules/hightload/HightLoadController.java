package com.javaliu.modules.hightload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/highLoad/")
public class HightLoadController {

    private static final Logger logger = LoggerFactory.getLogger(HightLoadController.class);

    private List<byte[]> list = new ArrayList<>();

    @RequestMapping(value = "highCPU")
    public void highCPU(){
        while (true){
            System.out.println("AAAAAAAAAAAAAAAAAAAAAA");
        }
    }

    @RequestMapping(value = "highMemory")
    public String highMemory(HttpServletRequest request, HttpServletResponse response){
        for(int i=0; i< 5;i++){
            File file = new File("/opt/software/jdk-8u191-linux-x64.tar.gz");
            InputStream inputStream = null;
            try {
                inputStream = new BufferedInputStream(new FileInputStream(file));
                byte[] buffer = new byte[1024 * 1000];
                while (inputStream.read(buffer) != -1){
                    list.add(buffer);
                    buffer = new byte[1024 * 1000];
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (null != inputStream) {
                        inputStream.close();
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return "index";
    }
}
