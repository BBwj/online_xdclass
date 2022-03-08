package net.xdclass.online_xdclass.exception;

import net.xdclass.online_xdclass.utils.JsonDate;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@ControllerAdvice

public class CustomExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody

    public JsonDate handle(Exception e) {


        if (e instanceof XDException) {


            XDException xdException = (XDException) e;
            return JsonDate.buildSError(xdException.getCode(), xdException.getMsg());
        } else {
            return JsonDate.buildSError("weizhi");
        }
    }
}