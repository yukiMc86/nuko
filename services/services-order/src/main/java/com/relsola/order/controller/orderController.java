package com.relsola.order.controller;

import com.relsola.order.bean.Order;
import com.relsola.order.properties.OrderProperties;
import com.relsola.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * orderController
 *
 * @author relsola
 */
@Slf4j
@RestController
@RefreshScope
public class orderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderProperties orderProperties;

    @GetMapping("/create")
    public Order createOrder(@RequestParam("userId") Long userId,
                             @RequestParam("productId") Long productId) {

        log.info("timeout: {},autoConfirm: {}",
                orderProperties.getTimeout(), orderProperties.getAutoConfirm());

        return orderService.createOrder(userId, productId);
    }
}
