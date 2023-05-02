package com.ctu.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ctu.exception.EmptyEntityException;
import com.ctu.model.Receipt;

public class ReceiptDAO {
    @PersistenceContext(unitName = "primary")
    EntityManager entityManager;

    public Receipt createReceipt(Receipt receipt) {
        System.out.println(receipt);
        try {
            entityManager.persist(receipt);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return receipt;
    }

    public Receipt getReceiptById(Long id) throws EmptyEntityException {
        Receipt receipt = entityManager.find(Receipt.class, id);
        if (receipt == null) {
            throw new EmptyEntityException(id);
        } else {
            return receipt;
        }
    }

    public List<Receipt> getAllReceipts() {
        List<Receipt> list = null;
        try {
            TypedQuery<Receipt> query = entityManager.createQuery("FROM Receipts r ORDER by r.receiptId", Receipt.class);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateReceipt(Receipt receipt) {
        try {
            entityManager.merge(receipt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteReceipt(Long id) {
        try {
            entityManager.remove(entityManager.find(Receipt.class, id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
