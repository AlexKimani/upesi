package com.upesi.upesiauthserver.security.google.capcha.service;

import com.upesi.upesiauthserver.web.error.ReCaptchaInvalidException;
import com.upesi.upesiauthserver.web.error.ReCaptchaUnavailableException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;

import java.net.URI;

@Slf4j
@Service("captchaService")
public class CaptchaService extends AbstractCaptchaService {
    public CaptchaService(HttpServletRequest request, CaptchaSettings captchaSettings, ReCaptchaAttemptService reCaptchaAttemptService, RestOperations restTemplate) {
        super(request, captchaSettings, reCaptchaAttemptService, restTemplate);
    }

    @Override
    public void processResponse(final String response) {
        securityCheck(response);

        final URI verifyUri = URI.create(String.format(RECAPTCHA_URL_TEMPLATE, getReCaptchaSecret(), response, getClientIP()));
        try {
            final GoogleResponse googleResponse = this.restTemplate.getForObject(verifyUri,
                    GoogleResponse.class);
            log.debug("Google response: {}", googleResponse);
            if (!googleResponse.isSuccess()) {
                if (googleResponse.hasClientError()) {
                    this.reCaptchaAttemptService.reCaptchaFailed(this.getClientIP());
                }
                throw new ReCaptchaInvalidException("reCaptcha was not successfully validated");
            }
        } catch (RestClientException exception) {
            throw new ReCaptchaUnavailableException("Registration unavailable at this time. Please try again later.", exception);
        }
        this.reCaptchaAttemptService.reCaptchaSucceeded(getClientIP());
    }
}
