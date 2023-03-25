package com.ctu.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.InvalidProductTypeNameException;
import com.ctu.model.ProductType;

public class ProductTypeDAO {
    @PersistenceContext(unitName = "primary")
    EntityManager entityManager;

    public ProductType getProductTypeById(Integer id) throws EmptyEntityException {
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
}
