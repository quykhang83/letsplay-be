package com.ctu.services;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.ctu.daos.ReceiptDAO;
import com.ctu.daos.UserDAO;
import com.ctu.dtos.ReceiptResponseDTO;
import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.IdNotFoundException;
import com.ctu.exception.InvalidUserCommentException;
import com.ctu.model.Product;
import com.ctu.model.Receipt;
import com.ctu.model.User;

@Stateless
public class ReceiptServiceImp implements ReceiptService {
    @Inject
    ReceiptDAO receiptDAO;
    @Inject
    UserDAO userDAO;

    @Override
    public List<ReceiptResponseDTO> getAllReceipts() {
        List<ReceiptResponseDTO> result = new ArrayList<ReceiptResponseDTO>();
        receiptDAO.getAllReceipts().forEach((e) -> result.add(new ReceiptResponseDTO(e)));
        return result;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public ReceiptResponseDTO getReceiptById(Long id) {
        if (id < 1) {
            throw new IdNotFoundException(id);
        }
        try {
            Receipt receipt = receiptDAO.getReceiptById(id);
            return new ReceiptResponseDTO(receipt);
        } catch (EmptyEntityException e) {
            throw new IdNotFoundException(id);
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Receipt getReceiptFullById(Long id) {
        if (id < 1) {
            throw new IdNotFoundException(id);
        }
        try {
            Receipt receipt = receiptDAO.getReceiptById(id);
            return receipt;
        } catch (EmptyEntityException e) {
            throw new IdNotFoundException(id);
        }
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<ReceiptResponseDTO> getReceiptByUser(final String email) {
        List<ReceiptResponseDTO> result = new ArrayList<ReceiptResponseDTO>();
        List<Receipt> receipts = new ArrayList<Receipt>();
        try {
            User user = userDAO.getUserByEmail(email);
            receipts = user.getReceipts();
            receipts.forEach((e) -> result.add(new ReceiptResponseDTO(e)));
        } catch (EmptyEntityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createReceipt(final String email) {
        try {
            User user = userDAO.getUserByEmail(email);
            Receipt receipt = new Receipt();
            List<Product> products = user.getCart().getCartDetails();

            receipt.setUser(user);
            Timestamp createdTime = Timestamp.from(Instant.now().truncatedTo(ChronoUnit.SECONDS));
            receipt.setReceiptDate(createdTime);
            receipt.setReceiptTax(0.1F);
            receipt.setReceiptTotal(user.getCart().getCartPrice());
            receipt.setReceiptDetails(products);

            receiptDAO.createReceipt(receipt);
            products.forEach((e) -> {
                user.setSingleProductToLibrary(e);
            });
            user.getCart().clearCart();
        } catch (EmptyEntityException e) {

        }
    }

    @Override
    public void deleteReceipt(Long receiptId, String email) throws InvalidUserCommentException {
        Receipt receipt = getReceiptFullById(receiptId);
        if (!receipt.getUser().getEmail().equals(email)) {
            throw new InvalidUserCommentException();
        } else {
            receiptDAO.deleteReceipt(receiptId);
        }
    }

}
