package cn.moyada.spring.cloud.service.model;

import java.io.Serializable;

/**
 * @author xueyikang
 * @since 1.0
 **/
public class Result implements Serializable {

    private static final long serialVersionUID = -343563411453231242L;

    private int code;

    private String data;

    private String msg;

    private boolean success;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
