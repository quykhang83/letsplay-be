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
import com.ctu.model.ProductDemo;
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
        // ProductType type = null;
        ProductType type = productTypeDAO.getProductTypeByName("#");

        Product product = new Product(productPayload.getProductName(), productPayload.getProductPrice(),
                productPayload.getProductDescription(), type, productPayload.getProductCapacity(), 0L);
        ProductDemo productDemo = new ProductDemo(productPayload.getProductDemoTitle(), productPayload.getProductDemoUrl());
        product.addSingleProductDemo(productDemo);
        productDAO.createProduct(product);
    }

    @Override
    public void updateProduct(Long id, ProductReceiveDTO product) {
        Product oldProduct;
        try {
            oldProduct = productDAO.getProductById(id);
        } catch (EmptyEntityException e) {
            throw new IdNotFoundException(id);
        }

        if (product.getProductName() != null) {
            oldProduct.setProductName(product.getProductName());
        }
        if (product.getProductPrice() != null) {
            oldProduct.setProductPrice(product.getProductPrice());
        }
        if (product.getProductDescription() != null) {
            oldProduct.setProductDescription(product.getProductDescription());
        }
        if (product.getProductTypeName() == "") {
            oldProduct.setProductType(null);
        } else if (product.getProductTypeName() != null) {
            ProductType newProductType;
            try {
                newProductType = productTypeDAO.getProductTypeByName(product.getProductTypeName());
                oldProduct.setProductType(newProductType);
            } catch (InvalidProductTypeNameException e) {
                throw new InvalidProductTypenameWebException(product.getProductTypeName());
            }
        }
        if (product.getProductCapacity() != null) {
            oldProduct.setProductCapacity(product.getProductCapacity());
        }
        if (product.getProductDemoTitle() != null && product.getProductDemoUrl() != null) {
            ProductDemo productDemo = new ProductDemo(product.getProductDemoTitle(), product.getProductDemoUrl());
            oldProduct.addSingleProductDemo(productDemo);
        }

        productDAO.updateProduct(oldProduct);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void setProductTypeNull(ProductType productType) {
        Set<Product> products = new HashSet<Product>();
        products = productType.getProduct();
        try {
            ProductType typeNull = productTypeDAO.getProductTypeByName("#");
            for (Product product : products) {
                product.setProductType(typeNull);
                System.out.println("Product Service: " + product.getProductType().getProductTypeName());
                productDAO.updateProduct(product);
            }
        } catch (InvalidProductTypeNameException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
