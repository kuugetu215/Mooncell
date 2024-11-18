package karazuki.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import result.Result;

/**全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(Exception.class)  //指定捕获异常种类
    public Result ex(Exception ex){
        ex.printStackTrace(); //输出异常的堆栈信息
        return Result.error("对不起，操作失败，请联系管理员");
    }

}