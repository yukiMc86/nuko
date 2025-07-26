package com.relsola.order.feign.fallback;

import com.relsola.order.feign.ProductFeignClient;
import com.relsola.product.bean.Product;
import org.springframework.stereotype.Component;

/**
 * ProductFeignClientFallback
 *
 * @author relsola
 */
@Component
public class ProductFeignClientFallback implements ProductFeignClient {

    @Override
    public Product getProductById(Long productId) {
        return null;
    }
}
