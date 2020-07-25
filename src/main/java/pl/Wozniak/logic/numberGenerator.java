package pl.Wozniak.logic;

import pl.Wozniak.model.User;

public class numberGenerator {
    private int number = 0;

    public numberGenerator(User[] users) {
        for (User user : users) {
            if(user != null && user.getAccount().getNumber() > number) {
                number = user.getAccount().getNumber();
            }
        }
    }
    public int generateNumber() {
        return number ++;
    }
}