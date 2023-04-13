package com.ctu.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ctu.exception.EmptyEntityException;
import com.ctu.model.Product;
import com.ctu.model.ProductDemo;

public class ProductDemoDAO {
    @PersistenceContext(unitName = "primary")
    EntityManager entityManager;

    public List<ProductDemo> getAllProductDemos() {
        List<ProductDemo> list = null;
        try {
            TypedQuery<ProductDemo> query = entityManager.createQuery("FROM ProductDemos pd ORDER by pd.productDemoId", ProductDemo.class);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ProductDemo getProductDemoById(Long id) throws EmptyEntityException {
        ProductDemo productDemo = entityManager.find(ProductDemo.class, id);
        if (productDemo == null) {
            throw new EmptyEntityException(id.longValue());
        } else {
            return productDemo;
        }
    }

    public ProductDemo createProductDemo(String productDemoTitle, String productDemoUrl, Product product) {
        ProductDemo productDemo = new ProductDemo(productDemoTitle, productDemoUrl);
        productDemo.setProduct(product);
        System.out.println(productDemo);
        try {
            entityManager.persist(productDemo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productDemo;
    }

    public void updateProductDemo(ProductDemo productDemo) {
        try {
            entityManager.merge(productDemo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteProductDemo(Long id) {
        try {
            entityManager.remove(entityManager.find(ProductDemo.class, id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
