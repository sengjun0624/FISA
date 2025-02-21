package dev.syntax;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.syntax.data.BookingDAO;
import dev.syntax.data.BookingRequest;
import dev.syntax.service.BookingService;
import dev.syntax.service.MailSender;
import dev.syntax.service.PaymentService;
import dev.syntax.service.RoomService;

@ExtendWith(MockitoExtension.class)
class Test09 {

	@InjectMocks
	private BookingService bookingService;

	@Mock
	private PaymentService paymentServiceMock;
	@Mock
	private RoomService roomServiceMock;
	@Spy
	private BookingDAO bookingDAOMock;
	@Mock
	private MailSender mailSenderMock;

/*
 	어노테이션을 통해 보다 간소화된 세팅
	@BeforeEach
	void setup() {
		this.paymentServiceMock = mock(PaymentService.class);
		this.roomServiceMock = mock(RoomService.class);
		this.bookingDAOMock = spy(BookingDAO.class);
		this.mailSenderMock = mock(MailSender.class);

		this.bookingService = new BookingService(paymentServiceMock, roomServiceMock, bookingDAOMock, mailSenderMock);
	}
*/


	@Test // makeBooking() 내에 bookingDAO.save()가 호출되었는지
	@Disabled
	void should_MakeBooking_When_InputOK() {
		// Given
		BookingRequest bookingRequest = BookingRequest.builder()
			.userId("1")
			.dateFrom(LocalDate.of(2025, Month.JANUARY, 1))
			.dateTo(LocalDate.of(2025, Month.JANUARY, 5))
			.guestCount(2)
			.prepaid(false)
			.build();

		// When
		String bookingId = bookingService.makeBooking(bookingRequest);
		System.out.println(bookingId); // 반환값으로 검증에 사용해야 할 경우,
		// 현재 bookingDAOMock는 mock()으로 감싸진 목 객체이기 때문에 기본값으로 null을 반환
		// spy()를 통해 객체를 감싸면 실제 반환 값을 받을 수 있음

	}

	@Test // cancelBooking()에 대해 테스트
	@Disabled
	void should_CancelBooking_When_InputOK() {
		// Given
		BookingRequest bookingRequest = BookingRequest.builder()
			.userId("1")
			.dateFrom(LocalDate.of(2025, Month.JANUARY, 1))
			.dateTo(LocalDate.of(2025, Month.JANUARY, 5))
			.guestCount(2)
			.prepaid(true)
			.build();

		bookingRequest.setRoomId("1.3");
		String bookingid = "1";

		// when
		bookingService.cancelBooking(bookingid);

		/*
		 * Cannot invoke "BookingRequest.getRoomId()" because request is null
		 * cancelBooking() 내부에서 실행되는 bookingDAOMock은 현재 spy()로 동작하기 때문에
		 *
		 * 다음의 코드도 실제로 수행됨
		 * BookingRequest request = bookingDAO.get(id);
		 *
		 * 그 결과 현재 DAO의 Map 객체에는 아무런 값도 없기 때문에
		 * request.getRoomId()에서 request가 null로 되어 예외가 발생하는 것
		 */
	}

	@Test // null 예외가 발생한 부분을 해결한 테스트 케이스
	void should_CancelBooking_When_InputOK2() {
		// Given
		BookingRequest bookingRequest = BookingRequest.builder()
			.userId("1")
			.dateFrom(LocalDate.of(2025, Month.JANUARY, 1))
			.dateTo(LocalDate.of(2025, Month.JANUARY, 5))
			.guestCount(2)
			.prepaid(true)
			.build();

		bookingRequest.setRoomId("1.3");
		String bookingid = "1";
		// String bookingid = bookingService.makeBooking(bookingRequest);

		// when
		doReturn(bookingRequest).when(bookingDAOMock).get(bookingid);

		bookingService.cancelBooking(bookingid);

		verify(bookingDAOMock).delete(bookingid);
	}
}








