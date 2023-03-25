package com.ctu.services;

import java.util.List;

import com.ctu.dtos.ProductReceiveDTO;
import com.ctu.model.Product;

public interface ProductTypeService {
    public List<ProductReceiveDTO> getAllProductTypes();

    public Product getProductTypeByName(final String proTypeName);

}
