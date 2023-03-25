package com.ctu.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

import com.ctu.exception.EmptyEntityException;
import com.ctu.model.Product;
import com.ctu.model.ProductType;

@Stateless(name = "ProductDAO")
public class ProductDAO {
    @PersistenceContext(unitName = "primary")
    EntityManager entityManager;

    public Product createProduct(String productName, Double productPrice, String productDescription, ProductType productType, Double productCapacity, Long productDownloads) {
        Product product = new Product(productName, productPrice, productDescription, productType, productCapacity, productDownloads);
        System.out.println(product);
        try {
            entityManager.persist(product);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return product;
    }

    public Product getProductById(Long id) throws EmptyEntityException {
        Product product = entityManager.find(Product.class, id);
        if (product == null) {
            throw new EmptyEntityException(id);
        } else {
            return product;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Product> seachPoductsByKeywords(String keywords) {
        List<Product> list = null;
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Product.class)
                .get();
        String matchString = "";
        for (String word : keywords.split(" ")) {
            matchString += word + "* ";
        }
        Query searchKeyword = queryBuilder
                .simpleQueryString()
                .onField("productName")
                .boostedTo(5f)
                .andFields("productTypeId")
                .boostedTo(2f)
                .withAndAsDefaultOperator()
                .matching(matchString)
                .createQuery();
        System.out.println("=========================" + matchString);
        FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(searchKeyword, Product.class);
        list = jpaQuery.getResultList();
        return list;
    }

    public List<Product> getAllProducts() {
        List<Product> list = null;
        try {
            TypedQuery<Product> query = entityManager.createQuery("FROM Products p ORDER by p.productId", Product.class);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteProduct(Long id) {
        try {
            entityManager.remove(entityManager.find(Product.class, id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(Product product) {
        try {
            entityManager.merge(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
