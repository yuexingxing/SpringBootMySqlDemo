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

        Res res = new Res();
        res.setSuccess(1);
        res.setMessage(e.getMessage());

        return res;
    }
}
