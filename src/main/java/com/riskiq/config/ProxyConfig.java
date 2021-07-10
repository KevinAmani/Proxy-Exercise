package com.riskiq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author riskiq
 * @created 1/17/18
 */
@Component
@ConfigurationProperties(value = "riskiq.proxy")
public class ProxyConfig {

    private String userFile;

    public String getUserFile() {
        return userFile;
    }

    public void setUserFile(String userFile) {
        this.userFile = userFile;
    }
}