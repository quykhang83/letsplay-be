package com.ctu.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.InvalidProductTypeNameException;
import com.ctu.model.ProductType;

public class ProductTypeDAO {
    @PersistenceContext(unitName = "primary")
    EntityManager entityManager;

    public List<ProductType> getAllProductTypes() {
        List<ProductType> list = null;
        try {
            TypedQuery<ProductType> query = entityManager.createQuery("FROM ProductTypes pt ORDER by pt.productTypeId", ProductType.class);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ProductType getProductTypeById(Long id) throws EmptyEntityException {
        ProductType productType = entityManager.find(ProductType.class, id);
        if (productType == null) {
            throw new EmptyEntityException(id.longValue());
        } else {
            return productType;
        }
    }

    public ProductType getProductTypeByName(String typeName) throws InvalidProductTypeNameException {
        TypedQuery<ProductType> query = entityManager.createQuery("FROM ProductTypes pt WHERE pt.productTypeName = :typeName",
                ProductType.class);
        ProductType productType = query.setParameter("typeName", typeName).getSingleResult();
        if (productType == null) {
            throw new InvalidProductTypeNameException(typeName);
        } else {
            return productType;
        }
    }

    public ProductType createProductType(String productTypeName, String productTypeDescription) {
        ProductType productType = new ProductType(productTypeName, productTypeDescription);
        System.out.println(productType);
        try {
            entityManager.persist(productType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productType;
    }



    public void deleteProductType(Long id) {
        try {
            entityManager.remove(entityManager.find(ProductType.class, id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
