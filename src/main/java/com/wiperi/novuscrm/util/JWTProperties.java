package com.wiperi.novuscrm.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "novus-crm.jwt")
public class JWTProperties {

    private String secret;
    private long expiration;
    private String tokenHead;
}
