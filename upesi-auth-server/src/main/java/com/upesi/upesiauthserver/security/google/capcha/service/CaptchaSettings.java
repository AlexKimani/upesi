package com.upesi.upesiauthserver.security.google.capcha.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "google.recaptcha.key")
public class CaptchaSettings {
    //reCAPTCHA V2
    private String site;
    private String secret;

    //reCAPTCHA V3
    private String siteV3;
    private String secretV3;
    private float threshold;

    public CaptchaSettings() {
        super();
    }
}
