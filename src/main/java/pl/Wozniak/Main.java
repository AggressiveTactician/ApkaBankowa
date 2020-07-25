package pl.Wozniak;

import pl.Wozniak.logic.Engine;
import pl.Wozniak.model.User;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.launch();
        engine.printUsers();

    }
}