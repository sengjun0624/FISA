package dev.syntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.syntax.data.BookingDAO;
import dev.syntax.data.BookingRequest;
import dev.syntax.model.Room;
import dev.syntax.service.BookingService;
import dev.syntax.service.MailSender;
import dev.syntax.service.PaymentService;
import dev.syntax.service.RoomService;

//Annotation 문법을 사용하기 위한 확장 기능 활성화
@ExtendWith(MockitoExtension.class)
class Test10 {

	@InjectMocks // @Mock이 작성된 필드들을 주입(생성자를 통해)
	private BookingService bookingService;

	@Mock // 해당 필드를 목 객체로 지정
	private PaymentService paymentServiceMock;
	@Mock
	private RoomService roomServiceMock;
	@Spy
	private BookingDAO bookingDAOMock;
	@Mock
	private MailSender mailSenderMock;

	@Test // from Test03
	void should_CountAvailablePlaces_When_OneRoomAvailable() {
		// given
		// 기존 방식 - when.. thenReturn
		// when(this.roomServiceMock.getAvailableRooms()).thenReturn(Collections.singletonList(new Room("Room 1", 2)));

		// 바뀐 방식 - given.. willReturn
		given(this.roomServiceMock.getAvailableRooms())
			.willReturn(Collections.singletonList(new Room("Room 1", 5)));
		int expected = 5;

		// when
		int actual = bookingService.getAvailablePlaceCount();

		// then
		assertEquals(expected, actual);
	}


	@Test // from Test07
	void should_InvokePayment_When_Prepaid() {
		// given
		BookingRequest bookingRequest = BookingRequest.builder()
			.userId("1")
			.dateFrom(LocalDate.of(2025, Month.JANUARY, 1))
			.dateTo(LocalDate.of(2025, Month.JANUARY, 5))
			.guestCount(2)
			.prepaid(true)
			.build();

		// when
		bookingService.makeBooking(bookingRequest);

		// then
		// 기존 방식 - verify()
		// verify(paymentServiceMock, times(1)).pay(bookingRequest, 400.0); // pay()가 한 번만 호출되는지 검증

		// 바뀐 방식 - thenShould()
		then(paymentServiceMock).should(times(1)).pay(bookingRequest, 400.0);
		verifyNoMoreInteractions(paymentServiceMock);
	}
}








