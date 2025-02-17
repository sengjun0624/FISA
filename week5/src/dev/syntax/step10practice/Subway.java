package dev.syntax.step10practice;

public class Subway extends Vehicle {
	public Subway(int vehicleNumber) {
		super(vehicleNumber);
	}

	@Override
	public void take(int fee) {
		super.take(fee);
	}

	/*	@Override
		public void printInfo() {
			System.out.println(
				"지하철" + getVehicleNumber() + "번의 승객은 " + getNumberOfPassengers() + "이고, 수입은 " + getSales() + "입니다.");
		}*/
	@Override
	public String toString() {
		return String.format("현재 %d원 벌었습니다.", getSales());
	}
}
