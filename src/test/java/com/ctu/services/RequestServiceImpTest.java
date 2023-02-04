
package com.ctu.services;

// import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ctu.daos.RequestDAO;
import com.ctu.daos.StatusDAO;
import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.IdNotFoundException;
import com.ctu.exception.InvalidStatusNameException;
import com.ctu.model.Request;
import com.ctu.model.Status;

@ExtendWith(MockitoExtension.class)
public class RequestServiceImpTest {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");

    @InjectMocks
    RequestServiceImp service;
    @Mock
    RequestDAO dao;
    @Mock
    StatusDAO statusdao;

    @Test
    public void testGetAllLeaveRequest() {
        Request rq1 = new Request();
        Request rq2 = new Request();
        List<Request> list = new ArrayList<Request>();
        list.add(rq1);
        list.add(rq2);
        when(dao.getAllLeaveRequest()).thenReturn(list);
        assertEquals(list, service.getAllLeaveRequests());
    }

    @Test
    // Using throws or try-catch?
    public void testGetLeaveRequestById() throws EmptyEntityException {
        Request rq = new Request();
        when(dao.getOneRequest(1l)).thenReturn(rq);
        assertEquals(rq, service.getLeaveRequestById(1l));
    }

    @Test
    public void testGetLeaveRequestByIdNotFound() {
        assertThrows(IdNotFoundException.class, () -> service.getLeaveRequestById(-1l));
    }

    @Test
    public void testGetLeaveRequestByIdEmptyEntityException() throws EmptyEntityException {
        when(dao.getOneRequest(1l)).thenThrow(EmptyEntityException.class);
        assertThrows(IdNotFoundException.class, () -> service.getLeaveRequestById(1l));
    }

    @Test
    public void testCreateLeaveRequest() throws InvalidStatusNameException {
        // Change type from LocalDateTime to Timestamp
        ZonedDateTime zonedFromDate = ZonedDateTime.parse("2022-12-20T12:30:40+0000", DATE_TIME_FORMATTER);
        ZonedDateTime zonedToDate = ZonedDateTime.parse("2022-12-21T12:30:40+0000", DATE_TIME_FORMATTER);
        Timestamp createdTime = Timestamp.from(Instant.now().truncatedTo(ChronoUnit.SECONDS));
        Timestamp fromDate = Timestamp.from(zonedFromDate.toInstant());
        Timestamp toDate = Timestamp.from(zonedToDate.toInstant());
        Status status = new Status("pending", "Request is being processed");
        Request request = new Request(
                "LEAVE_REQUEST",
                123l,
                createdTime,
                fromDate,
                toDate,
                "Not well",
                status);
        // Status status = new Status();
        when(statusdao.getStatusByName("pending")).thenReturn(status);
        service.createLeaveRequest(request);
        verify(dao).createLeaveRequest(request.getRequestType(), request.getEmployeeId(),
                createdTime, fromDate, toDate, request.getReason(), status);
    }

    @Test
    public void testUpdateRequest() throws EmptyEntityException {
        Request request = new Request();
        when(dao.getOneRequest(1l)).thenReturn(request);
        service.updateRequest(1l, request);
        verify(dao).updateRequest(request);
    }

    @Test
    public void testDeleteRequest() throws EmptyEntityException {
        Request request = new Request();
        when(dao.getOneRequest(1l)).thenReturn(request);
        service.deleteRequest(1l);
        verify(dao).deleteRequest(1l);
    }
}
