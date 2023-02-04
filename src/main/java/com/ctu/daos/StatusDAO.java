package com.ctu.daos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.InvalidStatusNameException;
import com.ctu.model.Status;

@Stateless(name = "StatusDAO")
public class StatusDAO {
    @PersistenceContext(unitName = "primary")
    EntityManager entityManager;

    public Status getOneStatus(Integer id) throws EmptyEntityException {
        Status status = entityManager.find(Status.class, id);
        if (status == null) {
            throw new EmptyEntityException(id.longValue());
        } else {
            return status;
        }
    }

    public Status getStatusByName(String statusName) throws InvalidStatusNameException {
        TypedQuery<Status> query = entityManager.createQuery("FROM Status s WHERE s.statusName = :statusName",
                Status.class);
        Status status = query.setParameter("statusName", statusName).getSingleResult();
        if (status == null) {
            throw new InvalidStatusNameException(statusName);
        } else {
            return status;
        }
    }
}
