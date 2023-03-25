package com.ctu.services;

import java.util.List;

import com.ctu.dtos.ProductDTO;
import com.ctu.model.Product;

public interface ProductService {
    public List<ProductDTO> getAllProducts();
    
    public List<Product> seachProductsByKeywords(String keywords);

    public Product getProductById(final Long id);

    public void createProduct(ProductDTO productPayload);

    public void updateProduct(Long id, Product product);

    public void deleteProduct(Long id);
}
