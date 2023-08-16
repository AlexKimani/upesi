package com.upesi.upesiauthserver.web.error;

import java.io.Serial;

/**
 * The type Re captcha invalid exception.
 */
public final class ReCaptchaInvalidException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 57697978437750384L;
    /**
     * Instantiates a new Re captcha invalid exception.
     */
    public ReCaptchaInvalidException () {
        super();
    }

    /**
     * Instantiates a new Re captcha invalid exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ReCaptchaInvalidException (final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Re captcha invalid exception.
     *
     * @param message the message
     */
    public ReCaptchaInvalidException (final String message) {
        super(message);
    }

    /**
     * Instantiates a new Re captcha invalid exception.
     *
     * @param cause the cause
     */
    public ReCaptchaInvalidException (final Throwable cause) {
        super(cause);
    }
}
