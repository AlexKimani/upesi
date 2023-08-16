package com.upesi.upesiauthserver.web.error;

import java.io.Serial;

/**
 * The type Invalid old password exception.
 */
public final class InvalidOldPasswordException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 3747855995960L;

    /**
     * Instantiates a new Invalid old password exception.
     */
    public InvalidOldPasswordException () {
        super();
    }

    /**
     * Instantiates a new Invalid old password exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public InvalidOldPasswordException (final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Invalid old password exception.
     *
     * @param message the message
     */
    public InvalidOldPasswordException (final String message) {
        super(message);
    }

    /**
     * Instantiates a new Invalid old password exception.
     *
     * @param cause the cause
     */
    public InvalidOldPasswordException (final Throwable cause) {
        super(cause);
    }
}
