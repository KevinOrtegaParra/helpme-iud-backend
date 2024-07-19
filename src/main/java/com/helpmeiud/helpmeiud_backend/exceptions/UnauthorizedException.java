package com.helpmeiud.helpmeiud_backend.exceptions;

public class UnauthorizedException extends RestException { 

    private static final long serialVersionUID = 1L;

    public UnauthorizedException() {
        super();
    }

    public UnauthorizedException(ErrorDto errorDto) {
        super(errorDto);
    }
}
