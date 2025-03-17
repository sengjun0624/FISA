public class Main {
	public static void main(String[] args) {
		BookService bookService = new BookService();
		DependencyInjector.injectDependencies(bookService); // 의존성 주입

		// 테스트 실행
		bookService.addBook("The Reflection API");
	}
}
