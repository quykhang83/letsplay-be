package com.ctu.services;

import java.util.List;

import com.ctu.model.Request;

public interface RequestService {
    public List<Request> getAllLeaveRequests();
    
    public List<Request> seachRequestsByKeywords(String keywords);

    public Request getLeaveRequestById(final Long id);

    public void createLeaveRequest(Request request);

    public void updateRequest(Long id, Request request);

    public void deleteRequest(Long id);
}
