package DN3.ObserverPattern;

import java.util.*;

public class StockMarket implements Stock {
	private List<Observer> observers = new ArrayList<>();
	private String stockName;
	private double stockPrice;

	public StockMarket(String stockName, double stockPrice) {
		this.stockName = stockName;
		this.stockPrice = stockPrice;
	}

	public void setStockPrice(double newPrice) {
		this.stockPrice = newPrice;
		notifyObservers();
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void deregisterObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(stockName, stockPrice);
		}
	}
}
