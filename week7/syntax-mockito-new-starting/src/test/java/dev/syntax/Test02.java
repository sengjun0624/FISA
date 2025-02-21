package dev.syntax;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.syntax.data.BookingDAO;
import dev.syntax.service.BookingService;
import dev.syntax.service.MailSender;
import dev.syntax.service.PaymentService;
import dev.syntax.service.RoomService;

public class Test02 {
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
		//mock()만 사용하였을 경우, 목 객체는 기본값으로 기본형 타입의 값들을 반환함
		System.out.println(roomServiceMock.getAvailableRooms());
		System.out.println(roomServiceMock.findAvailableRoomId(null));
		System.out.println(roomServiceMock.getRoomCount());
	}

	@Test
	@DisplayName("현재 예약 가능한 방의 수를 확인할 수 있다.")
	void should_CountAvailablePlaces() {
		//given
		int expected = 0;
		//when
		int actual = bookingService.getAvailablePlaceCount();
		// 메서드를 호출했을 때, 실제 호출되는 역할을 수행하는 룸서비스뫀은 실제 룸서비스가 아니라 목 객체
		//then
		assertEquals(actual, expected);
	}
}
