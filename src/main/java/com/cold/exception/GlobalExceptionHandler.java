package com.cold.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Auther: ohj
 * @Date: 2018/8/15 08:18
 * @Description:全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = Logger.getLogger(GlobalExceptionHandler.class.getSimpleName());
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map handleException(Exception e) {
        log.log(Level.FINEST,ExceptionUtils.getMessage(e));  // 记录错误信息
        String msg = e.getMessage();
        if (msg == null || msg.equals("")) {
            msg = "服务器出错";
        }
        Map map = new HashMap(5);
        map.put("code", 400);
        map.put("msg", msg);
        log.log(Level.ALL,msg,e);
        return map;
    }
}