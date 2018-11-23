package com.songsy.imybatis.exception;

public class IPersistenceException extends RuntimeException {

  private static final long serialVersionUID = -7537395265357977271L;

  public IPersistenceException() {
    super();
  }

  public IPersistenceException(String message) {
    super(message);
  }

  public IPersistenceException(String message, Throwable cause) {
    super(message, cause);
  }

  public IPersistenceException(Throwable cause) {
    super(cause);
  }
}
