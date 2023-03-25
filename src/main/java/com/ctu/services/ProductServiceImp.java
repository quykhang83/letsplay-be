package com.ctu.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.ctu.daos.ProductDAO;
import com.ctu.daos.ProductTypeDAO;
import com.ctu.dtos.ProductReceiveDTO;
import com.ctu.dtos.ProductResponseDTO;
import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.IdNotFoundException;
import com.ctu.exception.InvalidProductTypeNameException;
import com.ctu.exception.InvalidProductTypenameWebException;
import com.ctu.model.Product;
import com.ctu.model.ProductType;

@Stateless
public class ProductServiceImp implements ProductService {
    @Inject
    ProductDAO productDAO;
    @Inject
    ProductTypeDAO productTypeDAO;

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productDAO.getAllProducts();
        List<ProductResponseDTO> productResults = new ArrayList<ProductResponseDTO>();
        for (Product product : products) {
            productResults.add(new ProductResponseDTO(product));
        }
        return productResults;
    }

    @Override
    public List<ProductResponseDTO> seachProductsByKeywords(String keywords) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        if (id < 1) {
            throw new IdNotFoundException(id);
        }
        try {
            Product product = productDAO.getProductById(id);
            return new ProductResponseDTO(product);
        } catch (EmptyEntityException e) {
            throw new IdNotFoundException(id);
        }
    }

    @Override
    public void createProduct(ProductReceiveDTO productPayload) {
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
    public void updateProduct(Long id, ProductReceiveDTO product) {
        try {
            productDAO.getProductById(id);
        } catch (EmptyEntityException e) {
            throw new IdNotFoundException(id);
        }
        ProductType newProductType;
        try {
            newProductType = productTypeDAO.getProductTypeByName(product.getProductTypeName());
        } catch (InvalidProductTypeNameException e) {
            throw new InvalidProductTypenameWebException(product.getProductTypeName());
        }
        Product newProduct = new Product(product);
        newProduct.setProductId(id);
        newProduct.setProductType(newProductType);
        productDAO.updateProduct(newProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        getProductById(id);
        productDAO.deleteProduct(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<ProductResponseDTO> getProductByProductType(String productTypeName) {
        Set<Product> products = new HashSet<Product>();
        List<ProductResponseDTO> results = new ArrayList<ProductResponseDTO>();
        try {
            ProductType type = productTypeDAO.getProductTypeByName(productTypeName);
            products = type.getProduct();
        } catch (InvalidProductTypeNameException e) {
            throw new InvalidProductTypenameWebException(productTypeName);
        }
        products.forEach((e) -> results.add(new ProductResponseDTO(e)));
        return results;
    }

}
