package DesignPattern.behavioral;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

    interface Observer {
        void update(String news);
    }

    interface Subject {
        void registerObserver(Observer observer);

        void removeObserver(Observer observer);

        void notifyObservers();
    }

    static class NewsAgency implements Subject {

        private final List<Observer> observers = new ArrayList<>();
        private String news;

        public void setNews(String news) {
            this.news = news;
            notifyObservers();
        }

        @Override
        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers() {

            for (Observer observer : observers) {
                observer.update(news);
            }
        }
    }

    static class NewsChannel implements Observer {

        private final String channelName;

        public NewsChannel(String channelName) {
            this.channelName = channelName;
        }

        @Override
        public void update(String news) {
            System.out.println(channelName + " received news: " + news);
        }
    }

    public static void main(String[] args) {

        NewsAgency agency = new NewsAgency();

        Observer channel1 = new NewsChannel("Channel 1");
        Observer channel2 = new NewsChannel("Channel 2");

        agency.registerObserver(channel1);
        agency.registerObserver(channel2);

        agency.setNews("New technology launched!");

        agency.removeObserver(channel2);

        agency.setNews("New software update released!");
    }
}