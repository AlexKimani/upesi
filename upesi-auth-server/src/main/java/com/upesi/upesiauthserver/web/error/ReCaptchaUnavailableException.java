package com.upesi.upesiauthserver.web.error;

/**
 * The type Re captcha unavailable exception.
 */
public final class ReCaptchaUnavailableException extends RuntimeException {
    /**
     * Instantiates a new Re captcha unavailable exception.
     */
    public ReCaptchaUnavailableException () {
        super();
    }

    /**
     * Instantiates a new Re captcha unavailable exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ReCaptchaUnavailableException (final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Re captcha unavailable exception.
     *
     * @param message the message
     */
    public ReCaptchaUnavailableException (final String message) {
        super(message);
    }

    /**
     * Instantiates a new Re captcha unavailable exception.
     *
     * @param cause the cause
     */
    public ReCaptchaUnavailableException (final Throwable cause) {
        super(cause);
    }
}
