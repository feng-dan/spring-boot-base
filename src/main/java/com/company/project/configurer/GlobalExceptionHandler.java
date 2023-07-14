package com.company.project.configurer;

import com.company.project.core.BizException;
import com.company.project.core.ExceptionEnum;
import com.company.project.core.ResultResponse;
import com.eybond.quota.util.ExceptionContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * {@code @author} fengdan80@outlook.com
 * {@code @time} 2023/04/07 23:21:03
 * {@code @version} 1.0.0
 * {@code @description} 全局异常处理
 */

@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理自定义的业务异常
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ResultResponse bizExceptionHandler(HttpServletRequest req, BizException e) {
        log.error("发生业务异常！原因是：{}", e.getErrorMsg());
        return ResultResponse.error(e.getErrorCode(), e.getErrorMsg());
    }

    /**
     * 处理空指针的异常
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResultResponse exceptionHandler(HttpServletRequest req, NullPointerException e) {
        log.error("发生空指针异常！原因是:", e);
        return ResultResponse.error(ExceptionEnum.BODY_NOT_MATCH);
    }

    @ExceptionHandler(value = NumberFormatException.class)
    @ResponseBody
    public ResultResponse exceptionHandler(HttpServletRequest req, NumberFormatException e) {
        log.error("发生类型转换异常！原因是:", e);
        return ResultResponse.error(ExceptionEnum.PARAMS_NOT_CONVERT);
    }


    /**
     * 处理其他异常
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultResponse exceptionHandler(HttpServletRequest req, Exception e) {
        req.setAttribute("exception", e);
        log.error("未知异常！原因是:", e);
        ExceptionContextHolder.setException(e);
        return ResultResponse.error(ExceptionEnum.INTERNAL_SERVER_ERROR);
    }

}
