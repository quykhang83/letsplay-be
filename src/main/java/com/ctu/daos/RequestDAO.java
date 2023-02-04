package com.ctu.daos;

import java.sql.Timestamp;
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
import com.ctu.model.Request;
import com.ctu.model.Status;

@Stateless(name = "RequestDAO")
public class RequestDAO {
    @PersistenceContext(unitName = "primary")
    EntityManager entityManager;

    public Request createLeaveRequest(String requestType,
            Long employeeId,
            Timestamp createdTime, Timestamp fromDate, Timestamp toDate, String reason, Status status) {
        Request leaveReq = new Request(requestType, employeeId, createdTime, fromDate, toDate, reason, status);
        try {
            entityManager.persist(leaveReq);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return leaveReq;
    }

    public Request getOneRequest(Long id) throws EmptyEntityException {
        Request request = entityManager.find(Request.class, id);
        if (request == null) {
            throw new EmptyEntityException(id);
        } else {
            return request;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Request> seachRequestsByKeywords(String keywords) {
        List<Request> list = null;
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Request.class)
                .get();
        String matchString = "";
        for (String word : keywords.split(" ")) {
            matchString += word + "* ";
        }
        Query searchKeyword = queryBuilder
                .simpleQueryString()
                .onField("reason")
                .boostedTo(5f)
                .andFields("employeeId")
                .boostedTo(2f)
                .withAndAsDefaultOperator()
                .matching(matchString)
                .createQuery();
        System.out.println("=========================" + matchString);
        FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(searchKeyword, Request.class);
        list = jpaQuery.getResultList();
        return list;
    }

    public List<Request> getAllLeaveRequest() {
        List<Request> list = null;
        try {
            TypedQuery<Request> query = entityManager.createQuery("FROM Requests r ORDER by r.reqId", Request.class);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteRequest(Long id) {
        try {
            entityManager.remove(entityManager.find(Request.class, id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateRequest(Request request) {
        try {
            entityManager.merge(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Request> getPendingRequestsInNext3Days(String now, String next3days) {
        List<Request> list = null;
        try {
            TypedQuery<Request> query = entityManager.createQuery(
                    "FROM Requests r WHERE r.fromDate >= now AND r.fromDate <= next3days ORDER by r.reqId",
                    Request.class);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
