package com.ucss.elementary.tnwn.filters;

import com.ucss.elementary.tnwn.model.CustomException;
import com.ucss.elementary.tnwn.model.response.BaseResponse;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.io.IOException;

/**
 * Created by lq on 2018/3/6.
 * 异常增强，以JSON的形式返回给客服端
 * 异常增强类型：NullPointerException,RunTimeException,ClassCastException,
 　　　　　　　　 NoSuchMethodException,IOException,IndexOutOfBoundsException
 　　　　　　　　 以及springmvc自定义异常等，如下：
 SpringMVC自定义异常对应的status code
 Exception                       HTTP Status Code
 ConversionNotSupportedException         500 (Internal Server Error)
 HttpMessageNotWritableException         500 (Internal Server Error)
 HttpMediaTypeNotSupportedException      415 (Unsupported Media Type)
 HttpMediaTypeNotAcceptableException     406 (Not Acceptable)
 HttpRequestMethodNotSupportedException  405 (Method Not Allowed)
 NoSuchRequestHandlingMethodException    404 (Not Found)
 TypeMismatchException                   400 (Bad Request)
 HttpMessageNotReadableException         400 (Bad Request)
 MissingServletRequestParameterException 400 (Bad Request)
 *
 */

@ControllerAdvice
public class RestExceptionHandler {
    //运行时异常
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public BaseResponse runtimeExceptionHandler(RuntimeException runtimeException) {
        runtimeException.printStackTrace();
        return new BaseResponse("1000", runtimeException.getMessage());
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public BaseResponse nullPointerExceptionHandler(NullPointerException ex) {
        ex.printStackTrace();
        return new BaseResponse("1001",ex.getMessage());
    }
    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    @ResponseBody
    public BaseResponse classCastExceptionHandler(ClassCastException ex) {
        ex.printStackTrace();
        return new BaseResponse("1002",ex.getMessage());
    }
    //字段类型异常
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public BaseResponse methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException ex) {
        ex.printStackTrace();
        return new BaseResponse("1002",ex.getName()+"输入有误，请重新输入");
    }

    //IO异常
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public BaseResponse iOExceptionHandler(IOException ex) {
        ex.printStackTrace();
        return new BaseResponse("1003",ex.getMessage());
    }
    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    @ResponseBody
    public BaseResponse noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        ex.printStackTrace();
        return new BaseResponse("1003",ex.getMessage());
    }

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseBody
    public BaseResponse indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        ex.printStackTrace();
        return new BaseResponse("1005",ex.getMessage());
    }
    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public BaseResponse requestNotReadable(HttpMessageNotReadableException ex){
        System.out.println("400..requestNotReadable");
        ex.printStackTrace();
        return new BaseResponse("400",ex.getMessage());
    }
    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    @ResponseBody
    public BaseResponse requestTypeMismatch(TypeMismatchException ex){
        System.out.println("400..TypeMismatchException");
        ex.printStackTrace();
        return new BaseResponse("400",ex.getMessage());
    }
    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    public BaseResponse requestMissingServletRequest(MissingServletRequestParameterException ex){
        System.out.println("400..MissingServletRequest");
        ex.printStackTrace();
        String parmstr="parm不能为空！";
        return new BaseResponse("400",parmstr.replaceAll("parm",ex.getParameterName()));//ReturnFormat.retParam(400, null);
    }
   /* //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseBody
    public BaseResponse request405(){
        System.out.println("405...");
        return new BaseResponse("405",null);
    }*/
    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    @ResponseBody
    public BaseResponse request406(){
        System.out.println("406...");
        return new BaseResponse("406",null);
    }
    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class,HttpMessageNotWritableException.class})
    @ResponseBody
    public BaseResponse server500(RuntimeException runtimeException){
        System.out.println("500...");
        return new BaseResponse("500",runtimeException.getMessage());
    }
    //自定义抛出异常
    @ExceptionHandler({CustomException.class})
    @ResponseBody
    public BaseResponse customExceptionHandler(CustomException ex){
        ex.printStackTrace();
        return new BaseResponse(ex.getCode(),ex.getMsg());
    }
}
