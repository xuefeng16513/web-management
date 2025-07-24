package com.zidong.tlians_web_management.exception;

import com.zidong.tlians_web_management.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)//捕获所有异常
    public Result handleException(Exception e){
        e.printStackTrace();
        String fullMessage = e.getMessage();
        String simpleMessage = extractCoreMessage(fullMessage);
        return Result.error (simpleMessage);
    }

    private String extractCoreMessage(String message) {
        if (message == null) return "未知错误";

        // 常见数据库错误的正则表达式
        String[] patterns = {
                "Column '.*?' cannot be null",                       // 字段不能为空
                "Duplicate entry '.*?' for key '.*?'",               // 唯一约束
                "Cannot add or update a child row: .*? fails",       // 外键约束
                "Data truncation: .*",                               // 数据截断
                "Unknown column '.*?' in '.*?'"                      // 字段不存在
        };

        for (String regex : patterns) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(message);
            if (matcher.find()) {
                return matcher.group();
            }
        }

        // 兜底处理，只取最后一句
        String[] parts = message.split(";");
        return parts[parts.length - 1].trim();
    }


}
