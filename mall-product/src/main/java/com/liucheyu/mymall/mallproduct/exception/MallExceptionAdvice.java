package com.liucheyu.mymall.mallproduct.exception;

import com.liucheyu.common.exception.BizCodeEnum;
import com.liucheyu.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice(basePackages = "com.liucheyu.mymall.mallproduct.controller")
public class MallExceptionAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleNotValidException(MethodArgumentNotValidException ex) {
        //log.error();
        BindingResult bindingResult = ex.getBindingResult();
        Map<String, String> errMap = new HashMap<>(bindingResult.getErrorCount());
        bindingResult.getFieldErrors().forEach(err -> errMap.put(err.getField(), err.getDefaultMessage()));

        return R.error(BizCodeEnum.NOTVALID_EXCEPTION.getCode(), BizCodeEnum.NOTVALID_EXCEPTION.getMsg()).put("data", errMap);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleNotValidException(Throwable throwable) {

        return R.error(BizCodeEnum.UNKNOW_EXCEPTION.getCode(), BizCodeEnum.UNKNOW_EXCEPTION.getMsg());
    }

}
