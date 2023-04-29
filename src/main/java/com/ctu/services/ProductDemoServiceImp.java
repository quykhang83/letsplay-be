package com.ctu.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.ctu.daos.ProductDAO;
import com.ctu.daos.ProductDemoDAO;
import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.IdNotFoundException;
import com.ctu.model.Product;
import com.ctu.model.ProductDemo;

@Stateless
public class ProductDemoServiceImp implements ProductDemoService{
    @Inject
    ProductDemoDAO productDemoDAO;
    @Inject
    ProductDAO productDAO;

    @Override
    public List<ProductDemo> getAllProductDemos() {
        List<ProductDemo> productDemos = productDemoDAO.getAllProductDemos();
        return productDemos;
    }

    @Override
    public ProductDemo getProductDemoById(Long id) {
        if (id < 1) {
            throw new IdNotFoundException(id);
        }
        try {
            ProductDemo productDemo = productDemoDAO.getProductDemoById(id);
            return productDemo;
        } catch (EmptyEntityException e) {
            throw new IdNotFoundException(id);
        }
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<ProductDemo> getProductDemosByProductId(Long productId) throws EmptyEntityException{
        List<ProductDemo> productDemos = new ArrayList<ProductDemo>();
        List<ProductDemo> result = new ArrayList<ProductDemo>();
        try {
            Product product = productDAO.getProductById(productId);
            productDemos = product.getProductDemos();
        } catch (EmptyEntityException e) {
            throw new IdNotFoundException(productId);
        }
        productDemos.forEach((e) -> result.add(e));
        return result;
    }

    @Override
    public void createProductDemo(ProductDemo productDemo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createProductDemo'");
    }

    @Override
    public void updateProductDemo(Long id, ProductDemo productDemo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProductDemo'");
    }

    @Override
    public void deleteProductDemo(Long id) {
        getProductDemoById(id);
        productDemoDAO.deleteProductDemo(id);
    }
    
}
