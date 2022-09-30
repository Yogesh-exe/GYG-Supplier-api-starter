package com.getyourguide.supplier.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "service.properties")
@EnableConfigurationProperties
@Getter
@Setter
public class ServiceProperties {

    /**
     * GetYourGuide's security details
     */
    private SecurityProperties getYourGuideCredentials;

    /**
     * My Company's security details
     */
    private SecurityProperties myCompanyCredentials;


    // Classes needed for the properties
    @Getter
    @Setter
    public static class SecurityProperties {
        /**
         * Username
         */
        private String username;

        /**
         * Password
         */
        private String password;
    }
}
