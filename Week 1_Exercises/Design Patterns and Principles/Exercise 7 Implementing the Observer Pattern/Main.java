package DN3.ObserverPattern;

public class Main {
    public static void main(String[] args) {
        // Creating a stock market
        StockMarket stockMarket = new StockMarket("TechCorp", 150.00);

        // Creating observers
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        // Registering observers
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Updating stock price
        stockMarket.setStockPrice(155.00);
        stockMarket.setStockPrice(160.00);
        // Deregistering an observer
        stockMarket.deregisterObserver(mobileApp);

        // Updating stock price
        stockMarket.setStockPrice(165.00);
    }

}
