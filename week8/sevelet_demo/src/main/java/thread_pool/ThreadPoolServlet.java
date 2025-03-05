package thread_pool;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/thread-pool-test")
public class ThreadPoolServlet extends HttpServlet {
	private static final int THREAD_POOL_SIZE = 10;
	private final ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
	private static final Logger logger = Logger.getLogger(ThreadPoolServlet.class.getName());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		PrintWriter out = resp.getWriter();

		logger.info("새로운 요청이 도착했습니다: " + req.getRemoteAddr());

		threadPool.submit(() -> {
			try {
				logger.info("[" + Thread.currentThread().getName() + "] 요청 처리 시작...");
				Thread.sleep(5000); // 5초 동안 Sleep
				logger.info("[" + Thread.currentThread().getName() + "] 요청 처리 완료!");
			} catch (InterruptedException e) {
				logger.severe("쓰레드 인터럽트 오류: " + e.getMessage());
			}
		});

		out.println("요청이 스레드 풀에서 처리 중...");
		out.flush();
	}

	@Override
	public void destroy() {
		threadPool.shutdown();
		logger.info("서블릿 종료: 스레드 풀 종료됨.");
		super.destroy();
	}
}
