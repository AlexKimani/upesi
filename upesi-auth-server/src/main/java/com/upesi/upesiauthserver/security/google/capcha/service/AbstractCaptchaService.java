package com.upesi.upesiauthserver.security.google.capcha.service;

import com.upesi.upesiauthserver.web.error.ReCaptchaInvalidException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestOperations;

import java.util.regex.Pattern;

/**
 * The type Abstract captcha service.
 */
@Slf4j
@RequiredArgsConstructor
public abstract class AbstractCaptchaService implements ICaptchaService {
    /**
     * The Request.
     */
    protected final HttpServletRequest request;
    /**
     * The Captcha settings.
     */
    protected final CaptchaSettings captchaSettings;
    /**
     * The Re captcha attempt service.
     */
    protected final ReCaptchaAttemptService reCaptchaAttemptService;
    /**
     * The Rest template.
     */
    protected final RestOperations restTemplate;
    private static final String REGEX_PATTERN = "[A-Za-z0-9_-]+";
    /**
     * The constant RESPONSE_PATTERN.
     */
    protected static final Pattern RESPONSE_PATTERN = Pattern.compile(REGEX_PATTERN);
    /**
     * The constant RECAPTCHA_URL_TEMPLATE.
     */
    protected static final String RECAPTCHA_URL_TEMPLATE = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s&remoteip=%s";

    /**
     * Process response.
     *
     * @param response the response
     * @throws ReCaptchaInvalidException the re captcha invalid exception
     */
    @Override
    public void processResponse(String response) throws ReCaptchaInvalidException {
        ICaptchaService.super.processResponse(response);
    }

    /**
     * Process response.
     *
     * @param response the response
     * @param action   the action
     * @throws ReCaptchaInvalidException the re captcha invalid exception
     */
    @Override
    public void processResponse(String response, String action) throws ReCaptchaInvalidException {
        ICaptchaService.super.processResponse(response, action);
    }

    /**
     * Gets re captcha site.
     *
     * @return the re captcha site
     */
    @Override
    public String getReCaptchaSite() {
        return this.captchaSettings.getSite();
    }

    /**
     * Gets re captcha secret.
     *
     * @return the re captcha secret
     */
    @Override
    public String getReCaptchaSecret() {
        return this.captchaSettings.getSecret();
    }

    /**
     * Security check.
     *
     * @param response the response
     */
    protected void securityCheck(final String response) {
        log.debug("Attempting to validate response {}", response);
        if (this.reCaptchaAttemptService.isBlocked(this.getClientIP())) {
            throw new ReCaptchaInvalidException("Client exceeded maximum number of failed attempts");
        }
        if (!this.responseSanityCheck(response)) {
            throw new ReCaptchaInvalidException("Response contains invalid characters");
        }
    }

    /**
     * Response sanity check boolean.
     *
     * @param response the response
     * @return the boolean
     */
    protected boolean responseSanityCheck(final String response) {
        return StringUtils.hasLength(response) && RESPONSE_PATTERN.matcher(response).matches();
    }

    /**
     * Gets client ip.
     *
     * @return the client ip
     */
    protected String getClientIP() {
        final String xfHeader = this.request.getHeader("X-Forwarded-For");
        if (xfHeader == null || xfHeader.isEmpty() || !xfHeader.contains(this.request.getRemoteAddr())) {
            return this.request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }
}
