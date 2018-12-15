package com.epam.andriushchenko.captcha;

public class CaptchaTimeController {
    private long captchaCreationTime;

    public CaptchaTimeController() {
        captchaCreationTime = System.currentTimeMillis();
    }

    public boolean isTimeNotPassed() {
        return captchaCreationTime + 100_000 > System.currentTimeMillis();
    }
}
