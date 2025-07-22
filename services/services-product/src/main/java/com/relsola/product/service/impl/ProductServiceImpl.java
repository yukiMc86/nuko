package com.relsola.product.service.impl;

import java.math.BigDecimal;

import com.relsola.product.bean.Product;
import com.relsola.product.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * ProductServiceImpl
 *
 * @author relsola
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProductById(Long id) {
        Product product = new Product();
        product.setId(id);
        product.setPrice(new BigDecimal("99"));
        product.setProductName("xx" + id);
        product.setNum(2);

        return product;
    }
}
