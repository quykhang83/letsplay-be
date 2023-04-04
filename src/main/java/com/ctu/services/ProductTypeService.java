package com.ctu.services;

import java.util.List;

import com.ctu.model.Product;
import com.ctu.model.ProductType;

public interface ProductTypeService {
    public List<ProductType> getAllProductTypes();

    public ProductType getProductTypeById(final Long id);

    public Product getProductTypeByName(final String productTypeName);

    public void createProductType(final ProductType productType);

    public void updateProduct(Long id, ProductType productType);

    public void deleteProductType(Long id);

}
