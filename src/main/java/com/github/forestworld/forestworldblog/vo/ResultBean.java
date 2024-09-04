package com.github.forestworld.forestworldblog.vo;

import lombok.Data;


import java.io.Serializable;
import com.github.forestworld.forestworldblog.constant.Constants;

@Data
public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * token过期
     */
    public static final int TOKEN_EXPIRE = -1;


    /**
     * token无效，需要重新登录
     */
    public static final int NOT_LOGIN = -2;

    public static final int SUCCESS = 0;

    public static final int FAIL = 1;

    public static final int NO_PERMISSION = 2;

    private String msg = "success";

    private int code = SUCCESS;

    private T data;

    public ResultBean() {
        super();
    }

    public ResultBean(T data) {
        super();
        this.data = data;
    }

    public ResultBean(T data, int code) {
        super();
        this.data = data;
        this.code=code;
    }

    public ResultBean(T data, int code, String msg) {
        super();
        this.data = data;
        this.code=code;
        this.msg=msg;
    }

    public ResultBean(String msg) {
        super();
        this.data = null;
        this.code=FAIL;
        this.msg=msg;
    }

    public ResultBean(Throwable e) {
        super();
        this.msg = e.toString();
        this.code = FAIL;
    }

    public static <T> ResultBean<T> success(String msg){
        return success(msg, null);
    }

    public static <T> ResultBean<T> successDate(T data){
        return new ResultBean<>(data);
    }

    public static <T> ResultBean<T> success(){
        return success(Constants.OPERATE_SUCCESS, null);
    }

    public static <T> ResultBean<T> success(String msg,T data){
        return new ResultBean<T>(data,SUCCESS,msg);
    }
    public static <T> ResultBean<T> error(String msg,T data){
        return new ResultBean<T>(data,FAIL,msg);
    }

    public static <T> ResultBean<T> error(String msg){
        return error(msg, null);
    }



    private Long timeStamp;

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
