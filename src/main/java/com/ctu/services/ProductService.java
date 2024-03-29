package com.ctu.services;

import java.util.List;

import javax.persistence.NoResultException;

import com.ctu.dtos.ProductReceiveDTO;
import com.ctu.dtos.ProductResponseDTO;
import com.ctu.dtos.ProductResponseFullDemosDTO;
import com.ctu.exception.InvalidProductTypeNameException;
import com.ctu.model.ProductType;

public interface ProductService {
    public List<ProductResponseDTO> getAllProducts();
    
    public List<ProductResponseDTO> seachProductsByKeywords(String keywords);

    public ProductResponseFullDemosDTO getProductById(final Long id);

    public void createProduct(ProductReceiveDTO productPayload) throws NoResultException, InvalidProductTypeNameException;

    public void updateProduct(Long id, ProductReceiveDTO product);

    public void setProductTypeNull(ProductType productType);

    public void deleteProduct(Long id);

    public List<ProductResponseDTO> getProductByProductType(String productTypeName);
}
