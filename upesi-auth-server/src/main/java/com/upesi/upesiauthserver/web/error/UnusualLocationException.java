package com.upesi.upesiauthserver.web.error;

import org.springframework.security.core.AuthenticationException;

import java.io.Serial;

/**
 * The type Unusual location exception.
 */
public final class UnusualLocationException extends AuthenticationException {
   @Serial
   private static final long serialVersionUID = 57697978437750384L;
    /**
     * Instantiates a new Unusual location exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public UnusualLocationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Unusual location exception.
     *
     * @param message the message
     */
    public UnusualLocationException(String message) {
        super(message);
    }
}
