package com.getyourguide.supplier.properties;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    private SecurityProperties security;


    // Classes needed for the properties
    @Getter
    @Setter
    public static class SecurityProperties {
        /**
         * GetYourGuide Username
         */
        private String username;

        /**
         * GetYourGuide password
         */
        private String password;
    }
}
