package dev.syntax;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.Executable;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.syntax.data.BookingDAO;
import dev.syntax.data.BookingRequest;
import dev.syntax.exception.BusinessException;
import dev.syntax.model.Room;
import dev.syntax.service.BookingService;
import dev.syntax.service.MailSender;
import dev.syntax.service.PaymentService;
import dev.syntax.service.RoomService;

public class Test04 {
	private BookingService bookingService;
	private PaymentService paymentServiceMock;
	private RoomService roomServiceMock;
	private BookingDAO bookingDAOMock;
	private MailSender mailSenderMock;

	@BeforeEach
	void setup() {
		this.paymentServiceMock = mock(PaymentService.class);
		this.roomServiceMock = mock(RoomService.class);
		this.bookingDAOMock = mock(BookingDAO.class);
		this.mailSenderMock = mock(MailSender.class);

		this.bookingService = new BookingService(paymentServiceMock, roomServiceMock, bookingDAOMock, mailSenderMock);

	}

	@Test
	@DisplayName("Room 1이 5실을 반환하면 예약 가능한 방은 5개 이며, 공실일 경우, 예약 가능한 방은 0이다.")
	void should_CountAvailablePlaces_When_CalledMultipleTimes() {

		when(this.roomServiceMock.getAvailableRooms())
			.thenReturn(Collections.singletonList(new Room("Room 1", 5))) // 5실
			.thenReturn(Collections.emptyList()); // thenReturn()을 체이닝, 공실

		int expectedFirstCall = 5;
		int expectedSecondCall = 0;

		// When
		int actualFirst = bookingService.getAvailablePlaceCount();
		int actualSecond = bookingService.getAvailablePlaceCount();

		// Then
		assertAll(() -> assertEquals(expectedFirstCall, actualFirst),
			() -> assertEquals(expectedSecondCall, actualSecond));

	}

	@Test
	@DisplayName("makeBooking()을 통해 findAvailableRoomId()에서 방이 없을 경우 BusinessException을 던짐.")
	void should_ThrowException_When_NoRoomAvailable() {
		BookingRequest bookingRequest = BookingRequest.builder()
			.userId("1")
			.dateFrom(LocalDate.of(2025, Month.JANUARY, 1))
			.dateTo(LocalDate.of(2025, Month.JANUARY, 5))
			.guestCount(2)
			.prepaid(false)
			.build();

		when(this.roomServiceMock.findAvailableRoomId(bookingRequest))
			.thenThrow(BusinessException.class);


		assertThrows(BusinessException.class, () -> {
			bookingService.makeBooking(bookingRequest);
		});
	}
}
