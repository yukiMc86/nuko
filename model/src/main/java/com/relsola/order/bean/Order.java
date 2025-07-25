package com.relsola.order.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Order
 *
 * @author relsola
 */
@Data
public class Order {
    private Long id;
    private BigDecimal totalAmount;
    private Long userId;
    private String nickName;
    private String address;
    private List<Object> productList;
}
