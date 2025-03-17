public class BookService {
	@Inject
	private BookRepository bookRepository; // @Inject를 이용한 의존성 주입

	public void addBook(String book) {
		bookRepository.save(book);
	}
}

