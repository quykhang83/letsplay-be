
package com.ctu.daos;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.persistence.EntityManager;

// import org.junit.jupiter.api.BeforeAll;
// import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ctu.exception.EmptyEntityException;
import com.ctu.model.Request;

@ExtendWith(MockitoExtension.class)
public class RequestDAOTest {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");

    @InjectMocks
    RequestDAO dao;

    @Mock
    EntityManager entityManager;

    @Test
    void testCreateLeaveRequest() {

    }

    @Test
    void testDeleteRequest() {

    }

    @Test
    void testGetAllLeaveRequest() {

    }

    @Test
    void testGetOneRequest() throws EmptyEntityException {
        // Change type from LocalDateTime to Timestamp
        ZonedDateTime zonedFromDate = ZonedDateTime.parse("2022-12-20T12:30:40+0000", DATE_TIME_FORMATTER);
        ZonedDateTime zonedToDate = ZonedDateTime.parse("2022-12-21T12:30:40+0000", DATE_TIME_FORMATTER);
        Timestamp createdTime = Timestamp.from(Instant.now().truncatedTo(ChronoUnit.SECONDS));
        Timestamp fromDate = Timestamp.from(zonedFromDate.toInstant());
        Timestamp toDate = Timestamp.from(zonedToDate.toInstant());
        Request request = new Request(
                "LEAVE_REQUEST",
                123l,
                createdTime,
                fromDate,
                toDate,
                "Not well", null);
        when(entityManager.find(Request.class, 1l)).thenReturn(request);
        // This line was added because the old version in remote git 
        // was changed to 2l, and my branch can not overwrite it so I need to commit
        // to change to 1l
        assertEquals(request, dao.getOneRequest(1l));
    }

    @Test
    void testGetOneRequestEmptyEntityException() throws EmptyEntityException {
        when(entityManager.find(Request.class, 1l)).thenReturn(null);
        assertThrows(EmptyEntityException.class, () -> dao.getOneRequest(1l));
    }


    @Test
    void testUpdateRequest() {

    }
}
