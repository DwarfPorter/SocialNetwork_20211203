package ru.geekbrains.socialnetwork.observe;

import java.util.ArrayList;
import java.util.List;

import ru.geekbrains.socialnetwork.data.CardData;

public class Publisher {
    private List<Observer> observers;

    public Publisher(){
        observers = new ArrayList<>();
    }

    public void subscribe(Observer observer){
        observers.add(observer);
    }

    public void unsubscribe(Observer observer){
        observers.remove(observer);
    }

    public void notifySingle(CardData cardData){
        for (Observer observer : observers){
            observer.updateCardData(cardData);
            unsubscribe(observer);
        }
    }
}
