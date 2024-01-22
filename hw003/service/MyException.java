package service;

import java.io.IOException;

public class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
    }
}
