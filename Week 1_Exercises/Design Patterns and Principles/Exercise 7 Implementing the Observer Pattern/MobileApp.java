package DN3.ObserverPattern;

public class MobileApp implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Mobile App: Stock " + stockName + " has a new price: " + stockPrice);
    }

}
