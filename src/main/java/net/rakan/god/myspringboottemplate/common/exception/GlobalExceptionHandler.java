package net.rakan.god.myspringboottemplate.common.exception;

import lombok.extern.slf4j.Slf4j;
import net.rakan.god.myspringboottemplate.common.vo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常捕捉类
 *
 * @author LiChangRui (1924097082@qq.com) on 2023/3/7
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

//    @Autowired
//    private BaseCommonService baseCommonService;

    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public Result<Object> serviceExceptionHandler(ServiceException serviceException) {
//        StackTraceElement stackTraceElement = serviceException.getStackTrace()[0];
//        String logContentStr = "主动抛出的异常：类名：【" + stackTraceElement.getClassName() + "】，方法名：【" + stackTraceElement.getMethodName() + "】 第"
//                + stackTraceElement.getLineNumber() + "行。" + "错误信息：【" + serviceException.getMsg() + "】";

//        baseCommonService.addLog(logContentStr, CommonConstant.LOG_TYPE_3, null);
        return Result.error(serviceException.getMsg());
    }

//    @ResponseBody
//    @ExceptionHandler(Exception.class)
//    public void exceptionHandler(Exception exception) {
//        exception.printStackTrace();
//        StackTraceElement stackTraceElement = exception.getStackTrace()[0];
//        String logContentStr = "被动抛出的异常：类名：【" + stackTraceElement.getClassName() + "】，方法名：【" + stackTraceElement.getMethodName() + "】 第"
//                + stackTraceElement.getLineNumber() + "行。" + "错误信息：【" + exception.getMessage() + "】";
//        baseCommonService.addLog(logContentStr, CommonConstant.LOG_TYPE_3, null);
//    }
}