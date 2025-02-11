package dev.syntax.step10practice;

public abstract class Vehicle {
	private int vehicleNumber;
	private int numberOfPassengers;
	private int sales;

	public Vehicle(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public int getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public int getSales() {
		return sales;
	}

	public void take(int fee) {
		numberOfPassengers++;
		sales += fee;
	}


}
