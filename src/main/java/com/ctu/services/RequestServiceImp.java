
package com.ctu.services;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.inject.Inject;

import com.ctu.daos.RequestDAO;
import com.ctu.daos.StatusDAO;
import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.IdNotFoundException;
import com.ctu.exception.InternalServerError;
import com.ctu.model.Request;
import com.ctu.model.Status;

public class RequestServiceImp implements RequestService {
    @Inject
    RequestDAO requestDAO;
    @Inject
    StatusDAO statusDAO;

    @Override
    public List<Request> getAllLeaveRequests() {
        return requestDAO.getAllLeaveRequest();
    }

    @Override
    public Request getLeaveRequestById(Long id) {
        if (id < 1) {
            throw new IdNotFoundException(id);
        }
        try {
            return requestDAO.getOneRequest(id);
        } catch (EmptyEntityException ex) {
            throw new IdNotFoundException(id);
        }
    }

    @Override
    public void createLeaveRequest(Request request) {
        try {
            Timestamp createdTime = request.getCreatedTime();
            if (createdTime == null) {
                createdTime = Timestamp.from(Instant.now().truncatedTo(ChronoUnit.SECONDS));
            }
            Status status = statusDAO.getStatusByName("pending");
            requestDAO.createLeaveRequest(request.getRequestType(), request.getEmployeeId(),
                    createdTime, request.getFromDate(), request.getToDate(), request.getReason(), status);
        } catch (Exception ex) {
            throw new InternalServerError(ex.getMessage());
        }
    }

    @Override
    public void updateRequest(Long id, Request request) {
        Request oldRequest = getLeaveRequestById(id);
        request.setReqId(id);
        request.setCreatedTime(oldRequest.getCreatedTime());
        requestDAO.updateRequest(request);
    }

    @Override
    public void deleteRequest(Long id) {
        getLeaveRequestById(id);
        requestDAO.deleteRequest(id);
    }

    @Override
    public List<Request> seachRequestsByKeywords(String keywords) {
        return requestDAO.seachRequestsByKeywords(keywords);
    }

}
