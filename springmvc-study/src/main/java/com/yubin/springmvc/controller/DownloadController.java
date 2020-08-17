package com.yubin.springmvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;

/**
 * 下载功能示例
 *
 * @author YUBIN
 * @create 2020-08-17
 */
@Controller
public class DownloadController {

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws Exception {

        ServletContext servletContext = request.getServletContext();
        // 获取文件路径 此处你也可以写成动态的
        String realPath = servletContext.getRealPath("/js/jquery-1.9.1.min.js");
        // 获取文件流
        FileInputStream fileInputStream = new FileInputStream(realPath);

        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        fileInputStream.close();

        HttpHeaders headers = new HttpHeaders();
        // 设置响应头信息
        headers.set("Content-Disposition", "attachment;filename=jquery-1.9.1.min.js");

        return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
    }
}
