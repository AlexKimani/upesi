package com.upesi.upesiauthserver.web.error;

import java.io.Serial;

/**
 * The type User not found exception.
 */
public final class UserNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 54637739448596037L;

    /**
     * Instantiates a new User not found exception.
     */
    public UserNotFoundException () {
        super();
    }

    /**
     * Instantiates a new User not found exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public UserNotFoundException (final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new User not found exception.
     *
     * @param message the message
     */
    public UserNotFoundException (final String message) {
        super(message);
    }

    /**
     * Instantiates a new User not found exception.
     *
     * @param cause the cause
     */
    public UserNotFoundException (final Throwable cause) {
        super(cause);
    }
}
