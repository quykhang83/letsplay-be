package com.ctu.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.NoResultException;

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
    public void createProduct(ProductReceiveDTO productPayload) throws InvalidProductTypeNameException {
        ProductType type = null;
     
        type = productTypeDAO.getProductTypeByName(productPayload.getProductTypeName());

        Product product = new Product(productPayload.getProductName(), productPayload.getProductPrice(), productPayload.getProductDescription(),type, productPayload.getProductCapacity(), 0L);
        
        productDAO.createProduct(product.getProductName(), product.getProductPrice(), product.getProductDescription(),
                type, product.getProductCapacity(), product.getProductDownloads());
    }

    @Override
    public void updateProduct(Long id, ProductReceiveDTO product) {
        Product oldProduct;
        try {
            oldProduct = productDAO.getProductById(id);
        } catch (EmptyEntityException e) {
            throw new IdNotFoundException(id);
        }
        

        if(product.getProductName()!=null){
            oldProduct.setProductName(product.getProductName());
        }
        if(product.getProductPrice()!=null){
            oldProduct.setProductPrice(product.getProductPrice());
        }
        if(product.getProductDescription()!=null){
            oldProduct.setProductDescription(product.getProductDescription());
        }
        if(product.getProductTypeName()!=null){
            ProductType newProductType;
            try {
                newProductType = productTypeDAO.getProductTypeByName(product.getProductTypeName());
                oldProduct.setProductType(newProductType);
            } catch (InvalidProductTypeNameException e) {
                throw new InvalidProductTypenameWebException(product.getProductTypeName());
            }
        }
        if(product.getProductCapacity()!=null){
            oldProduct.setProductCapacity(product.getProductCapacity());
        }

        productDAO.updateProduct(oldProduct);
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
