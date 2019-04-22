package com.example.websql.handler;

import com.example.websql.Res;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Res exceptionHandler(HttpServletRequest request, Exception e) {

        return Res.build(1, 0, e.getMessage(), request.getRequestURL());
    }
}
