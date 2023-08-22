package demo.errorController;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

//    /**
//     * 处理 Exception 类型的异常
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public Map<String,Object> defaultExceptionHandler(Exception e) {
//
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("code", 500);
//        map.put("msg", e.getMessage());
//        return map;
//    }

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Map<String,Object> defaultExceptionHandler2(Exception e) {

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code", 500);
        map.put("msg", e.getMessage());
        return map;
    }
}
