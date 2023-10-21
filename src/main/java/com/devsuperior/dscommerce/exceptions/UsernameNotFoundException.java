package com.devsuperior.dscommerce.exceptions;

@SuppressWarnings("serial")
public class UsernameNotFoundException extends RuntimeException {

    public UsernameNotFoundException(String msg) {
        super(msg);
    }
}
