package com.ctu.services;

import java.util.List;

import com.ctu.dtos.ProductDTO;
import com.ctu.model.Product;

public interface ProductTypeService {
    public List<ProductDTO> getAllProductTypes();

    public Product getProductTypeByName(final String proTypeName);

}
