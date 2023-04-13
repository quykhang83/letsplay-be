package com.ctu.services;

import java.util.List;
import java.util.Set;

import com.ctu.model.ProductDemo;

public interface ProductDemoService {
    public List<ProductDemo> getAllProductDemos();

    public ProductDemo getProductDemoById(final Long id);

    public Set<ProductDemo> getProductDemoByProductId(final Long productId);

    public void createProductDemo(final ProductDemo productDemo);

    public void updateProductDemo(Long id, ProductDemo productDemo);

    public void deleteProductDemo(Long id);
}
