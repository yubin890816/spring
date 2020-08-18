package com.yubin.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 自定义异常类
 *
 * @author YUBIN
 * @create 2020-08-19
 */
@ResponseStatus(reason = "名字不是admin", code = HttpStatus.NOT_ACCEPTABLE)
public class UserNameException extends RuntimeException {
}
