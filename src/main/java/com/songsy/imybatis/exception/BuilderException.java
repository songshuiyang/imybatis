package com.songsy.imybatis.exception;

/**
 * 构建异常
 * @author songsy
 * @Date 2018/11/20 17:19
 */
public class BuilderException extends RuntimeException {

    private static final long serialVersionUID = 3880206998166270511L;

    public BuilderException() {
        super();
    }

    public BuilderException(String message) {
        super(message);
    }

    public BuilderException(String message, Throwable cause) {
        super(message, cause);
    }

    public BuilderException(Throwable cause) {
        super(cause);
    }
}

