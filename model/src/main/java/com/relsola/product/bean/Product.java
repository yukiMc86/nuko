package com.relsola.product.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Product
 *
 * @author relsola
 */
@Data
public class Product {
    private Long id;
    private BigDecimal price;
    private String productName;
    private int num;
}
