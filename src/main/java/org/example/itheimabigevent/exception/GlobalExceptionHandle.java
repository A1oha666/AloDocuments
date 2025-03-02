package org.example.itheimabigevent.exception;

import org.example.itheimabigevent.pojo.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public Result handleException(Exception e) {
        e.printStackTrace();
        return Result.error(StringUtils.hasLength(e.getMessage())?e.getMessage():"操作失败");
    }
}
