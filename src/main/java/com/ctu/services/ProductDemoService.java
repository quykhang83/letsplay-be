package com.ctu.services;

import java.util.List;

import com.ctu.exception.EmptyEntityException;
import com.ctu.model.ProductDemo;

public interface ProductDemoService {
    public List<ProductDemo> getAllProductDemos();

    public ProductDemo getProductDemoById(final Long id);

    public List<ProductDemo> getProductDemosByProductId(final Long productId) throws EmptyEntityException;

    public void createProductDemo(final ProductDemo productDemo);

    public void updateProductDemo(Long id, ProductDemo productDemo);

    public void deleteProductDemo(Long id);
}
