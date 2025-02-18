import java.util.ArrayList;
import java.util.List;
import java.util.function.IntToLongFunction;

import model.Gender;
import model.Order;
import model.Person;

public class Main {
	private static final List<Order> orders = new ArrayList<>();

	public static void main(String[] args) {
		initialize();
		System.out.println("\n\n\n\n\n\n");
		System.out.println("2065년 클라우드 서비스반 회식비입니다. ");

		System.out.println();
		// 총 금액 조회
		long amount = totalAmountByOrder((unused) -> {
			long total = 0 ;
			for (Order order : orders) {
				if(order.getPerson().getGender() == Gender.MALE)
					total += order.getAmount();
			}
			return total;
		});

		System.out.println("남성분들의 결제금액은 " + formatAmount(amount) + "입니다.");

		amount = totalAmountByOrder((unused) -> {
			long total = 0 ;
			for (Order order : orders) {
				if(order.getPerson().getGender() == Gender.FEMALE)
					total += order.getAmount();
			}
			return total;
		});
		System.out.println("여성분들의 결제금액은 " + formatAmount(amount) + "입니다.");
		IntToLongFunction totalMoney = (unused) -> {
			long sum = 0L;
			for (Order order : orders) {
				sum += order.getAmount();
			}
			return sum;
		};

		System.out.println("총 금액은 " + formatAmount(totalMoney.applyAsLong(0)));
	}

	private static long totalAmountByOrder(IntToLongFunction intToLongFunction) {
		int unused = 0;
		long amount = intToLongFunction.applyAsLong(unused);

		return amount;
	}
	public static void initialize() {
		addOrder("이승준", Gender.MALE, 5000_0000);
		addOrder("윤예진", Gender.FEMALE, Integer.MAX_VALUE);
		addOrder("유정호", Gender.MALE, 1_0000_0000);
		addOrder("신희원", Gender.MALE, Integer.MAX_VALUE);
		addOrder("이서연", Gender.FEMALE, Integer.MAX_VALUE);
		addOrder("이정민", Gender.FEMALE, 3_0000_0000);
		addOrder("이한비", Gender.FEMALE, 20_0000_0000);
		addOrder("유승한", Gender.MALE, 2_0000_0000);
		addOrder("김지연", Gender.FEMALE, 17_0000_0000);
		addOrder("박찬진", Gender.MALE, 3_0000);
		addOrder("이소연", Gender.FEMALE, 3_0000_0000);
		addOrder("권민지", Gender.FEMALE, 19_0000_0000);
		addOrder("구본훈", Gender.MALE, 20_0000_0000);
		addOrder("서채연", Gender.FEMALE, 5_0000_0000);
		addOrder("남승현", Gender.MALE, 3_0000_000);
		addOrder("윤선영", Gender.FEMALE, 2_0000_000);
	}

	private static void addOrder(String name, Gender gender, int amount) {
		orders.add(new Order(new Person(name, gender), amount));

		// 금액 단위 변환
		String amountStr = formatAmount(amount);

		// 19억원 이상이면 "꺼억" 추가
		String message = amount >= 19_0000_0000
			? name + "님이 " + amountStr + " 드셨습니다. 꺼억"
			: name + "님이 " + amountStr + " 드셨습니다.";

		System.out.println(message);
	}

	private static String formatAmount(long amount) {
		if (amount >= 1_0000_0000) {
			return (amount / 1_0000_0000) + "억원";
		} else if (amount >= 1_0000_000) {
			return (amount / 1_0000_000) + "천만원";
		} else if (amount >= 10_000) {
			return (amount / 10_000) + "만원";
		} else {
			return amount + "원";
		}
	}

}


