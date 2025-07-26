package com.relsola.order.feign;

import com.relsola.order.feign.fallback.ProductFeignClientFallback;
import com.relsola.product.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ProductFeignClient
 *
 * @author relsola
 */
@FeignClient(value = "services-product", fallback = ProductFeignClientFallback.class)
public interface ProductFeignClient {

    @GetMapping("product/{productId}")
    Product getProductById(@PathVariable("productId") Long productId);
}
