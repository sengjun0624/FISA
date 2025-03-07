package thread_pool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;


public class ThreadPoolClient {
	private static final int REQUEST_COUNT = 10;
	private static final String SERVER_URL = "http://localhost:8080/thread-pool-test";
	private static final ExecutorService clientThreadPool = Executors.newFixedThreadPool(REQUEST_COUNT);

	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(5000);

		for (int i = 0; i < REQUEST_COUNT; i++) {
			int requestId = i;
			clientThreadPool.submit(() -> sendRequest(requestId));
		}

		clientThreadPool.shutdown();
		try {
			if (!clientThreadPool.awaitTermination(30, TimeUnit.SECONDS)) {
				System.out.println("일부 요청이 완료되지 않음. 강제 종료.");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("모든 요청 처리 완료 후 클라이언트 종료.");
	}

	private static void sendRequest(int requestId) {
		try {
			URL url = new URL(SERVER_URL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			// TCP_NODELAY 강제 실행 방지
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Connection", "close"); // Keep-Alive 제거

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String response;
			while ((response = in.readLine()) != null) {
				System.out.println("[요청 " + requestId + "] 응답: " + response);
			}
			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
