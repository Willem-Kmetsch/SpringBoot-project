package org.hbmuma.springbootgit202031.exception;

public class MyErrorException extends RuntimeException{
    public MyErrorException() {
        super("定制异常");
    }
}
