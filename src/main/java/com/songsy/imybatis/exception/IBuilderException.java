package com.songsy.imybatis.exception;

/**
 * 构建异常
 * @author songsy
 * @Date 2018/11/20 17:19
 */
public class IBuilderException extends RuntimeException {

    private static final long serialVersionUID = 3880206998166270511L;

    public IBuilderException() {
        super();
    }

    public IBuilderException(String message) {
        super(message);
    }

    public IBuilderException(String message, Throwable cause) {
        super(message, cause);
    }

    public IBuilderException(Throwable cause) {
        super(cause);
    }
}

