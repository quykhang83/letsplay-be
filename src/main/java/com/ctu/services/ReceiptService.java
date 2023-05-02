package com.ctu.services;

import java.util.List;

import com.ctu.dtos.ReceiptResponseDTO;
import com.ctu.exception.InvalidUserCommentException;

public interface ReceiptService {
    public List<ReceiptResponseDTO> getAllReceipts();

    public ReceiptResponseDTO getReceiptById(final Long id);

    public List<ReceiptResponseDTO> getReceiptByUser(final String email);

    public void createReceipt(final String email);

    public void deleteReceipt(Long receiptId, String email) throws InvalidUserCommentException;
}
