package com.relsola.order.interceptor;

import feign.RequestInterceptor;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * XTokenRequestInterceptor
 *
 * @author relsola
 */
@Component
public class XTokenRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(feign.RequestTemplate template) {
        template.header("x-Token", UUID.randomUUID().toString());
    }
}
