package net.rakan.god.myspringboottemplate.common.exception;

import lombok.Data;

/**
 * 自定义service通用异常
 *
 * @author LiChangRui (1924097082@qq.com) on 2023/3/7
 */
@Data
public class ServiceException extends RuntimeException {
    private int code = 500;
    private String msg;

    public ServiceException(String msg) {
        super(msg);
        System.out.println("可预料异常：【" + msg + "】");
        this.msg = msg;
    }

    public ServiceException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public ServiceException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public ServiceException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

}