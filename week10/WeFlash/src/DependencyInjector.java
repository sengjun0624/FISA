import java.lang.reflect.Field;

public class DependencyInjector {
	public static void injectDependencies(Object bookRepository) {
		Class<?> clazz = bookRepository.getClass();
		for (Field field : clazz.getDeclaredFields()) {
			if (field.isAnnotationPresent(Inject.class)) {
				try {
					field.setAccessible(true);
					Object dependency = field.getType().getDeclaredConstructor().newInstance();
					field.set(bookRepository, dependency);
				} catch (Exception e) {
					throw new RuntimeException("Failed to inject dependencies", e);
				}
			}
		}
	}
}
