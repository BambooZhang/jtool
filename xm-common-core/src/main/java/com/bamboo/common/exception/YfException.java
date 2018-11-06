package com.bamboo.common.exception;

public class YfException extends RuntimeException {
    private Error error;
    private Object data;

    public YfException(Error error) {
        this((Error)error, (Object)null);
    }

    public YfException(Error error, Object data) {
        super("code=" + error.getCode() + ",msg=" + error.getMsg() + ",data=" + data);
        this.error = error;
        this.data = data;
    }

    public YfException(String code, Object msg) {
        this(new Error(code, msg));
    }

    public YfException(String code, Object msg, Object data) {
        this(new Error(code, msg), data);
    }

    public Error getError() {
        return this.error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public Object getData() {
        return this.data;
    }

    public YfException setData(Object data) {
        this.data = data;
        return this;
    }
}
