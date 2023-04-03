package com.ctu.services;

import java.util.List;

import javax.persistence.NoResultException;

import com.ctu.dtos.ProductReceiveDTO;
import com.ctu.dtos.ProductResponseDTO;
import com.ctu.exception.InvalidProductTypeNameException;

public interface ProductService {
    public List<ProductResponseDTO> getAllProducts();
    
    public List<ProductResponseDTO> seachProductsByKeywords(String keywords);

    public ProductResponseDTO getProductById(final Long id);

    public void createProduct(ProductReceiveDTO productPayload) throws NoResultException, InvalidProductTypeNameException;

    public void updateProduct(Long id, ProductReceiveDTO product);

    public void deleteProduct(Long id);

    public List<ProductResponseDTO> getProductByProductType(String productTypeName);
}
