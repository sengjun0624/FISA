package dev.syntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

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

class Test01 {

	private BookingService bookingService;
	private PaymentService paymentServiceMock;
	private RoomService roomServiceMock;
	private BookingDAO bookingDAOMock;
	private MailSender mailSenderMock;

	@BeforeEach
	void setup() {

		// Mock(ing) - 주어진 클래스에 대한 모킹용 객체 생성
		this.paymentServiceMock = mock(PaymentService.class);
		this.roomServiceMock = mock(RoomService.class);
		this.bookingDAOMock = mock(BookingDAO.class);
		this.mailSenderMock = mock(MailSender.class);

		this.bookingService = new BookingService(paymentServiceMock, roomServiceMock, bookingDAOMock, mailSenderMock);
	}

	@Test
	@DisplayName("적절한 예약 정보가 전달되면 룸 예약 비용을 계산할 수 있다.")
	void should_CalculateCorrectPrice_When_CorrectInput() {
		// bookingService의 calculatePrice() 메서드 테스트

		// BDD(Behavior Driven Development)
		// Given, 예약 정보 데이터
		BookingRequest bookingRequest = BookingRequest.builder()
			.userId("1")
			.dateFrom(LocalDate.of(2025, Month.JANUARY, 1))
			.dateTo(LocalDate.of(2025, Month.JANUARY, 5))
			.guestCount(2)
			.prepaid(false)
			.build();

		double expected = 4 * 2 * 50.0;

		// When, 테스트 대상 메서드를 호출했을 때,
		double actual = bookingService.calculatePrice(bookingRequest);

		// Then
		assertEquals(expected, actual);
	}

}
