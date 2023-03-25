package com.ctu.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.ctu.daos.ProductDAO;
import com.ctu.daos.ProductTypeDAO;
import com.ctu.dtos.ProductDTO;
import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.IdNotFoundException;
import com.ctu.exception.InvalidProductTypeNameException;
import com.ctu.exception.InvalidProductTypenameWebException;
import com.ctu.model.Product;
import com.ctu.model.ProductType;

public class ProductServiceImp implements ProductService {
    @Inject
    ProductDAO productDAO;
    @Inject
    ProductTypeDAO productTypeDAO;

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productDAO.getAllProducts();
        List<ProductDTO> productResults = new ArrayList<ProductDTO>();
        for (Product product : products) {
            productResults.add(new ProductDTO(product));
        }
        return productResults;
    }

    @Override
    public List<Product> seachProductsByKeywords(String keywords) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Product getProductById(Long id) {
        if (id < 1) {
            throw new IdNotFoundException(id);
        }
        try {
            return productDAO.getProductById(id);
        } catch (EmptyEntityException e) {
            throw new IdNotFoundException(id);
        }
    }

    @Override
    public void createProduct(ProductDTO productPayload) {
        ProductType type = null;
        try {
            type = productTypeDAO.getProductTypeByName(productPayload.getProductTypeName());
        } catch (InvalidProductTypeNameException e) {
            throw new InvalidProductTypenameWebException(productPayload.getProductTypeName());
        }

        Product product = new Product(productPayload.getProductName(), productPayload.getProductPrice(), productPayload.getProductDescription(),type, productPayload.getProductCapacity(), 0L);
        
        productDAO.createProduct(product.getProductName(), product.getProductPrice(), product.getProductDescription(),
                type, product.getProductCapacity(), product.getProductDownloads());
    }

    @Override
    public void updateProduct(Long id, Product product) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteProduct(Long id) {
        // TODO Auto-generated method stub

    }

}
