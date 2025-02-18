package dev.syntax;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import dev.syntax.data.BookingDAO;
import dev.syntax.model.Room;
import dev.syntax.service.BookingService;
import dev.syntax.service.MailSender;
import dev.syntax.service.PaymentService;
import dev.syntax.service.RoomService;
class Test03 {

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
	@DisplayName("만약 Room 1이 2개의 방이 남았을 경우, 현재 예약 가능한 방은 2로 반환된다.")
	void should_CountAvailablePlaces_When_OneRoomAvailable() {
		when(this.roomServiceMock.getAvailableRooms()).thenReturn(Collections.singletonList(new Room("Room 1 ", 2)));
		int actual = bookingService.getAvailablePlaceCount();

		assertEquals(actual, 2);
	}

	@Test
	@DisplayName("Room 1이 2실, Room 2가 5실 남았을 경우, 총 예약 가능한 방은 7이다.")
	void should_CountAvailablePlaces_When_MultipleRoomAvailable() {
		when(this.roomServiceMock.getAvailableRooms()).thenReturn( List.of(new Room("Room 1", 2), new Room("Room 2", 5)));
		int actual = bookingService.getAvailablePlaceCount();
		assertEquals(actual, 7);


	}
}
