
package com.ctu.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.ws.rs.WebApplicationException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ctu.model.Request;
import com.ctu.services.RequestService;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS) // When using @BeforeAll method as non-static
public class RequestAPITest {

	@InjectMocks
	RequestAPI api;

	@Mock
	RequestService service;

	private Timestamp createdTime;
	private Timestamp fromDate;
	private Timestamp toDate;

	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");

	@BeforeAll
	public void setUp() {
		// Change type from LocalDateTime to Timestamp
		ZonedDateTime zonedFromDate = ZonedDateTime.parse("2022-12-20T12:30:40+0000", DATE_TIME_FORMATTER);
		ZonedDateTime zonedToDate = ZonedDateTime.parse("2022-12-21T12:30:40+0000", DATE_TIME_FORMATTER);
		createdTime = Timestamp.from(Instant.now().truncatedTo(ChronoUnit.SECONDS));
		fromDate = Timestamp.from(zonedFromDate.toInstant());
		toDate = Timestamp.from(zonedToDate.toInstant());
	}

	// @Test
	// void testcreateLeaveRequestTest() {
	// 	Request request = new Request(
	// 			"LEAVE_REQUEST",
	// 			123l,
	// 			createdTime,
	// 			fromDate,
	// 			toDate,
	// 			"Not well", null);
	// 	assertEquals(200, api.createLeaveRequest(request).getStatus());
	// }

	@Test
	void testCreateLeaveRequestMissingKeys() {
		Request request = new Request(
				"LEAVE_REQUEST",
				123l,
				null,
				null,
				null,
				"Not well", null);
		request.setEmployeeId(null);
		assertThrows(WebApplicationException.class, () -> api.createLeaveRequest(request));
	}

	@Test
	void testDeleteRequest() {
		assertEquals(200, api.deleteRequest(1l).getStatus());
		verify(service).deleteRequest(1l);
	}

	@Test
	void testGetLeaveRequest() {
		List<Request> list = null;
		when(service.getAllLeaveRequests()).thenReturn(list);
		assertEquals(200, api.getLeaveRequest().getStatus());
	}

	@Test
	void testGetLeaveRequestById() {
		Request request = new Request();
		when(service.getLeaveRequestById(1l)).thenReturn(request);
		assertEquals(200, api.getLeaveRequestById(1l).getStatus());
	}

	@Test
	void testUpdateRequest() {
		Request request = new Request(
				"LEAVE_REQUEST",
				123l,
				createdTime,
				fromDate,
				toDate,
				"Not well", null);
		assertEquals(200, api.updateRequest(1l, request).getStatus());
	}

	@Test
	void testUpdateRequestMissingKeys() {
		Request request = new Request(
				"LEAVE_REQUEST",
				123l,
				null,
				null,
				null,
				"Not well", null);
		assertThrows(WebApplicationException.class, () -> api.updateRequest(1l, request));
	}
}
