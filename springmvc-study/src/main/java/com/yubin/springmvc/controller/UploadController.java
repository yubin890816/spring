package com.yubin.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 单个文件上传、多文件上传案例演示
 *
 * @author YUBIN
 * @create 2020-08-17
 */
@Controller
public class UploadController {

    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile[] multipartFiles,@RequestParam("desc") String desc) throws IOException {
        System.out.println(desc);
        for (MultipartFile multipartFile : multipartFiles) {
            if (!multipartFile.isEmpty()) {
                System.out.println("originalFileName: " + multipartFile.getOriginalFilename());
                multipartFile.transferTo(new File("D:\\file\\" + multipartFile.getOriginalFilename()));
            }
        }
        return "success";
    }
}
