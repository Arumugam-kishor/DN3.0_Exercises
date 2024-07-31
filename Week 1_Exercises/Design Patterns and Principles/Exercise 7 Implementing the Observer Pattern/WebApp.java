package DN3.ObserverPattern;

public class WebApp implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Web App: Stock " + stockName + " has a new price: " + stockPrice);
    }

}
