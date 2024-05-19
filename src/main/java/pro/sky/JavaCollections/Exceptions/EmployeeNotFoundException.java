package pro.sky.JavaCollections.Exceptions;

import java.io.IOException;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
