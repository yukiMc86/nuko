package com.relsola.order.service;

import com.relsola.order.bean.Order;

/**
 * OrderService
 *
 * @author relsola
 */
public interface OrderService {
    Order createOrder(Long userId, Long productId);
}
