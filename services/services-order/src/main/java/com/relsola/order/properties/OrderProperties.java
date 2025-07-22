package com.relsola.order.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * OrderProperties
 *
 * @author relsola
 */
@ConfigurationProperties(prefix = "order")
@Component
@Data
public class OrderProperties {
    String timeout;

    String autoConfirm;
}
