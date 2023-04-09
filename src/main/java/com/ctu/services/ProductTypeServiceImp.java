package com.ctu.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.ctu.daos.ProductTypeDAO;
import com.ctu.dtos.ProductResponseDTO;
import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.IdNotFoundException;
import com.ctu.model.Product;
import com.ctu.model.ProductType;

@Stateless
public class ProductTypeServiceImp implements ProductTypeService {
    @Inject
    ProductTypeDAO productTypeDAO;
    @Inject
    ProductService productService;

    @Override
    public List<ProductType> getAllProductTypes() {
        List<ProductType> productTypes = productTypeDAO.getAllProductTypes();
        return productTypes;
    }

    @Override
    public ProductType getProductTypeById(Long id) {
        if (id < 1) {
            throw new IdNotFoundException(id);
        }
        try {
            ProductType productType = productTypeDAO.getProductTypeById(id);
            return productType;
        } catch (EmptyEntityException e) {
            throw new IdNotFoundException(id);
        }
    }

    @Override
    public Product getProductTypeByName(String proTypeName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductTypeByName'");
    }

    @Override
    public void createProductType(ProductType productType) {

        productTypeDAO.createProductType(productType.getProductTypeName(), productType.getProductTypeDescription());
    }

    @Override
    public void updateProductType(Long id, ProductType productType) {
        ProductType oldType;
        try {
            oldType = productTypeDAO.getProductTypeById(id);
        } catch (EmptyEntityException e) {
            throw new IdNotFoundException(id);
        }

        if (productType.getProductTypeName() != null) {
            oldType.setProductTypeName(productType.getProductTypeName());
        }
        if (productType.getProductTypeDescription() != null) {
            oldType.setProductTypeDescription(productType.getProductTypeDescription());
        }

        productTypeDAO.updateProductType(oldType);
    }

    @Override
    public void deleteProductType(Long id) {
        ProductType type = getProductTypeById(id);
        productService.setProductTypeNull(type);
        productTypeDAO.deleteProductType(id);
    }

}
