package dev.bank.model;

import java.util.ArrayList;
import java.util.List;

import dev.bank.model.enums.Drink;
import dev.bank.model.enums.OrderType;

public class Order {
	private List<Drink> drinkList = new ArrayList<>();
	private OrderType orderType;
	private long receivedAmount;

	public Order(List<Drink> drinkList, OrderType orderType, long receivedAmount) {
		this.drinkList = drinkList;
		this.orderType = orderType;
		this.receivedAmount = receivedAmount;
	}

	public List<Drink> getDrinkList() {
		return drinkList;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public long getReceivedAmount() {
		return receivedAmount;
	}
}
