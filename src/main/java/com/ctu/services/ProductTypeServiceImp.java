package com.ctu.services;

import java.util.List;

import javax.ejb.Stateless;

import com.ctu.dtos.ProductReceiveDTO;
import com.ctu.model.Product;

@Stateless
public class ProductTypeServiceImp implements ProductTypeService{

    @Override
    public List<ProductReceiveDTO> getAllProductTypes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllProductTypes'");
    }

    @Override
    public Product getProductTypeByName(String proTypeName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductTypeByName'");
    }
    
}
