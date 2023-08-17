package com.upesi.upesiauthserver.security.google.capcha.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * The type Re captcha attempt service.
 */
@Service("reCaptchaAttemptService")
public class ReCaptchaAttemptService {
    private static final int TIME_DURATION = 4;
    private static final int MAX_ATTEMPTS = 4;
    private final LoadingCache<String, Integer> attemptsCache;

    /**
     * Instantiates a new Re captcha attempt service.
     */
    public ReCaptchaAttemptService() {
        this.attemptsCache = CacheBuilder.newBuilder()
                .expireAfterWrite(TIME_DURATION, TimeUnit.HOURS)
                .build(new CacheLoader<String, Integer>() {
                    @Override
                    public Integer load(String key) throws Exception {
                        return 0;
                    }
                });
    }

    /**
     * Re captcha succeeded.
     *
     * @param key the key
     */
    public void reCaptchaSucceeded(final String key) {
        this.attemptsCache.invalidate(key);
    }

    /**
     * Re captcha failed.
     *
     * @param key the key
     */
    public void reCaptchaFailed(final String key) {
        int attempts = this.attemptsCache.getUnchecked(key);
        attempts ++;
        this.attemptsCache.put(key, attempts);
    }

    /**
     * Is blocked boolean.
     *
     * @param key the key
     * @return the boolean
     */
    public boolean isBlocked(final String key) {
        return this.attemptsCache.getUnchecked(key) >= MAX_ATTEMPTS;
    }
}
