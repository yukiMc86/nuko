package com.relsola.product.service;

import com.relsola.product.bean.Product;

/**
 * ProductServiceImpl
 *
 * @author relsola
 */
public interface ProductService {
    Product getProductById(Long id);
}
