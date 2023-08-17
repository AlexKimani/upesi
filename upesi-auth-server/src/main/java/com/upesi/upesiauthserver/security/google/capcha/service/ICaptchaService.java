package com.upesi.upesiauthserver.security.google.capcha.service;

import com.upesi.upesiauthserver.web.error.ReCaptchaInvalidException;
import reactor.core.publisher.Mono;

/**
 * The interface Captcha service.
 */
public interface ICaptchaService {
    /**
     * Process response.
     *
     * @param response the response
     * @throws ReCaptchaInvalidException the re captcha invalid exception
     */
    default void processResponse (final String response) throws ReCaptchaInvalidException {}

    /**
     * Process response.
     *
     * @param response the response
     * @param action   the action
     * @throws ReCaptchaInvalidException the re captcha invalid exception
     */
    default void processResponse (final String response, String action) throws ReCaptchaInvalidException {}

    /**
     * Gets re captcha site.
     *
     * @return the re captcha site
     */
    String getReCaptchaSite();

    /**
     * Gets re captcha secret.
     *
     * @return the re captcha secret
     */
    String getReCaptchaSecret();
}
