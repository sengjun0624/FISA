package dev.syntax;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.Executable;
import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.syntax.data.BookingDAO;
import dev.syntax.data.BookingRequest;
import dev.syntax.service.BookingService;
import dev.syntax.service.MailSender;
import dev.syntax.service.PaymentService;
import dev.syntax.service.RoomService;

class Test06 {

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
	@DisplayName("pay()를 통해 어떤 BookingRequest와 price가 전달되어도 BusinessException을 던진다.")
	void should_NotCompleteBooking_When_PriceNotEnough() {
		// 조건에 관계없이 예외를 던지는지 알고싶다면, 일반화된 값을 넣어줄 수 있다.
		BookingRequest bookingRequest = BookingRequest.builder()
			.userId("1")
			.dateFrom(LocalDate.of(2025, Month.JANUARY, 1))
			.dateTo(LocalDate.of(2025, Month.JANUARY, 5))
			.guestCount(2)
			.prepaid(false)
			.build();
		// 어떤 값이 들어오는지 상관이 없다면, any()를 넣어준다.
		// 혹은 값이 고정되어 있지 않을 때
		// when(this.paymentServiceMock.pay(any(), anyDouble()))
		// 	.thenThrow(UnsupportedOperationException.class);

		// 만약 2개 이상의 인수가 전달되는 상황에서 특정 값은 정확하게 고정시키고 싶을 경우, eq()를 통해 값을 지정
		when(this.paymentServiceMock.pay(any(), eq(400.0)))
			.thenThrow(UnsupportedOperationException.class);

		assertThrows(UnsupportedOperationException.class, () -> bookingService.makeBooking(bookingRequest));
	}
}
