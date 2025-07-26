package com.relsola.order.service.Impl;

import java.math.BigDecimal;
import java.util.List;

import com.relsola.order.bean.Order;
import com.relsola.order.feign.ProductFeignClient;
import com.relsola.order.service.OrderService;
import com.relsola.product.bean.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * OrderServiceImpl
 *
 * @author relsola
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ProductFeignClient productFeignClient;

    @Override
    public Order createOrder(Long userId, Long productId) {
//        Product product = getProductFromRemote(productId);

        Product product = productFeignClient.getProductById(productId);

        Order order = new Order();
        order.setId(1L);
        order.setTotalAmount(product.getPrice().multiply(new BigDecimal(product.getNum())));
        order.setUserId(userId);
        order.setNickName("Relsola");
        order.setAddress("mu");
        order.setProductList(List.of(product));
        return order;
    }

    private Product getProductFromRemote(Long productId) {
        ServiceInstance choose = loadBalancerClient.choose("services-product");

        String url = choose.getUri().toString() + "/product/" + productId;
        log.info("远程路径: {}", url);
        return restTemplate.getForObject(url, Product.class);
    }
}
