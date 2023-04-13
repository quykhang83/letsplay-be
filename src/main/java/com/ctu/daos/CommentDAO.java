package com.ctu.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

import com.ctu.exception.EmptyEntityException;
import com.ctu.model.Comment;

public class CommentDAO {
    @PersistenceContext(unitName = "primary")
    EntityManager entityManager;

    public Comment createComment(Comment comment) {
        System.out.println(comment);
        try {
            entityManager.persist(comment);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return comment;
    }

    public Comment getCommentById(Long id) throws EmptyEntityException {
        Comment comment = entityManager.find(Comment.class, id);
        if (comment == null) {
            throw new EmptyEntityException(id);
        } else {
            return comment;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Comment> seachCommentByKeywords(String keywords) {
        List<Comment> list = null;
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Comment.class)
                .get();
        String matchString = "";
        for (String word : keywords.split(" ")) {
            matchString += word + "* ";
        }
        Query searchKeyword = queryBuilder
                .simpleQueryString()
                .onField("CommentName")
                .boostedTo(5f)
                .andFields("CommentTypeId")
                .boostedTo(2f)
                .withAndAsDefaultOperator()
                .matching(matchString)
                .createQuery();
        System.out.println("=========================" + matchString);
        FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(searchKeyword, Comment.class);
        list = jpaQuery.getResultList();
        return list;
    }

    public List<Comment> getAllComments() {
        List<Comment> list = null;
        try {
            TypedQuery<Comment> query = entityManager.createQuery("FROM Comments p ORDER by p.commentId", Comment.class);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateComment(Comment comment) {
        try {
            entityManager.merge(comment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteComment(Long id) {
        try {
            entityManager.remove(entityManager.find(Comment.class, id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
