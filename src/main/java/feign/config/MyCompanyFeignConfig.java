package feign.config;

import com.getyourguide.supplier.properties.ServiceProperties;
import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.ErrorDecoder;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyCompanyFeignConfig {

    @Bean
    public Logger.Level getLogLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder feignErrorDecoder() {
        return new MyCompanyDownstreamErrorDecoder();
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(ServiceProperties serviceProperties) {
        return new BasicAuthRequestInterceptor(serviceProperties.getMyCompanyCredentials().getUsername(),serviceProperties.getMyCompanyCredentials().getPassword());
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        Map<String, Collection<String>> headers = new HashMap<>();
        headers.put("X-ORIGIN-ID", Collections.singletonList("GYG"));
        headers.put("X-API-VERSION", Collections.singletonList("1"));
        headers.put("X-REQUEST-ID", Collections.singletonList(UUID.randomUUID().toString()));
        return (RequestTemplate template) -> template.headers(headers);
    }

}
