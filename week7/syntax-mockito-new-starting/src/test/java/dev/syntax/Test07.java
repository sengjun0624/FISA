package dev.syntax;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.syntax.data.BookingDAO;
import dev.syntax.data.BookingRequest;
import dev.syntax.service.BookingService;
import dev.syntax.service.MailSender;
import dev.syntax.service.PaymentService;
import dev.syntax.service.RoomService;

class Test07 {

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

	@Test // pay()가 호출되었는지 검증
	void should_InvokePayment_When_Prepaid() {
		// Given
		BookingRequest bookingRequest = BookingRequest.builder()
			.userId("1")
			.dateFrom(LocalDate.of(2025, Month.JANUARY, 1))
			.dateTo(LocalDate.of(2025, Month.JANUARY, 5))
			.guestCount(2)
			.prepaid(true) // pay()가 호출되었는지 확인하기 위해 true
			.build();

		// When
		bookingService.makeBooking(bookingRequest);

		// Then, pay()가 한 번만 호출되었는지 검증
		verify(paymentServiceMock, times(1)).pay(bookingRequest, 400.0);

	}

	@Test // pay()가 한 번도 호출되지 않았는지 검증
	void should_Not_InvokePayment_When_Prepaid() {
		// prepaid값을 false로 변경 후 테스트 수행
		// Given
		BookingRequest bookingRequest = BookingRequest.builder()
			.userId("1")
			.dateFrom(LocalDate.of(2025, Month.JANUARY, 1))
			.dateTo(LocalDate.of(2025, Month.JANUARY, 5))
			.guestCount(2)
			.prepaid(false) // pay()가 호출되지 않았는지 검증하기 위해 false
			.build();
		// When
		bookingService.makeBooking(bookingRequest);

		// Then, pay()가 한 번도 호출되지 않았는지 검증
		verify(paymentServiceMock, never()).pay(any(), anyDouble());

	}

	@Test // makeBooking() 내에 bookingDAO.save()가 호출되었는지
	void should_MakeBooking_When_InputOK() {

	}

	@Test // cancelBooking()에 대해 테스트
	void should_CancelBooking_When_InputOK() {

	}
}
