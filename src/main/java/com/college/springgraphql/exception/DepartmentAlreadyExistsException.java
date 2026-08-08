package com.college.springgraphql.exception;

public class DepartmentAlreadyExistsException extends  RuntimeException {
    public DepartmentAlreadyExistsException(String message) {
        super(message);
    }
}
