import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TennisCourtMacro {

	private static final String RESERVATION_URL = "http://localhost:8080/tennis/reserve";
	private static final String BACK_URL = "http://localhost:8080/courtList.jsp"; // 이전 페이지 URL

	public static void main(String[] args) {
		long currentTimeMillis = System.currentTimeMillis();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// 현재 시간 기준 10초 후 실행
		String targetTime = dateFormat.format(new Date(currentTimeMillis + 10000));

		System.out.println("⏳ 예약 실행 예정 시간: " + targetTime);
		scheduleReservation(targetTime);
	}

	/**
	 * 예약 요청을 특정 시간에 실행하는 스케줄러
	 */
	public static void scheduleReservation(String targetTime) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				try {
					System.out.println("🚀 예약 요청을 실행합니다! " + targetTime);
					sendReservationRequest();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};

		long delay = getDelayForTargetTime(targetTime);
		if (delay > 0) {
			System.out.println("✅ 예약 매크로가 " + targetTime + "에 실행됩니다.");
			timer.schedule(task, delay);
		} else {
			System.out.println("❌ 이미 시간이 지나 실행할 수 없습니다.");
		}
	}
	/**
	 * 예약 요청을 전송하고 결과 페이지에서 예매 번호를 추출 후 뒤로 가기
	 */
	public static void sendReservationRequest() throws IOException {
		System.out.println("📡 예약 요청을 보냅니다 (POST 요청)");

		// 예약 요청 (POST 방식, Body에 데이터 포함)
		Document doc = Jsoup.connect(RESERVATION_URL)
			.header("Content-Type", "application/x-www-form-urlencoded")  // 요청 헤더 설정
			.data("center", "YCS") // 테니스 구장
			.data("court", "2") // 2번 코트 선택
			.data("datetime", "2025-02-14T14:03") // 예약 날짜 & 시간
			.method(Connection.Method.POST)  // POST 방식으로 변경
			.post();

		// 예매 번호 추출
		// String reservationNumber = doc.select("b").first().text(); // <b> 태그 안의 예매 번호
		// System.out.println("✅ 예매 성공! 예매 번호: " + reservationNumber);

		// 일정 시간 후 자동으로 뒤로 가기 (재요청)
		goBackToPreviousPage();
	}

	/**
	 * 이전 페이지로 이동하는 기능 (실제 브라우저 동작처럼 동작)
	 */
	public static void goBackToPreviousPage() throws IOException {
		System.out.println("📌 일정 시간 후 예약 페이지로 이동...");
		try {
			Thread.sleep(3000); // 3초 후 실행
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Document backDoc = Jsoup.connect(BACK_URL).get();
		System.out.println("⬅️ 예약 페이지로 돌아왔습니다.");
	}

	/**
	 * 실행 시간을 설정한 시간에 맞추기 위해 딜레이를 계산하는 메서드
	 */
	public static long getDelayForTargetTime(String targetTime) {
		try {
			// targetTime 형식과 일치하는 SimpleDateFormat 패턴 지정
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date currentTime = new Date();
			Date targetDate = dateFormat.parse(targetTime); // 여기서 예외 발생했었음

			System.out.println("🕒 현재 시간: " + dateFormat.format(currentTime));
			System.out.println("🎯 목표 실행 시간: " + targetTime);

			long delay = targetDate.getTime() - currentTime.getTime();
			return (delay < 0) ? -1 : delay;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
